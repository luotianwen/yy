package com.shifeng.provide.weixin.service.impl;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shifeng.dto.login.JointLoginDTO;
import com.shifeng.entity.user.JointLogin;
import com.shifeng.entity.user.SysUser;
import com.shifeng.provide.util.Constant;
import com.shifeng.provide.util.HttpUtil;
import com.shifeng.provide.util.JointLoginType;
import com.shifeng.provide.weixin.dao.WeiXinDao;
import com.shifeng.provide.weixin.service.WeiXinService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.UuidUtil;
import com.shifeng.util.redis.RedisTool;

@Service("weiXinServiceImpl")
public class WeiXinServiceImpl implements WeiXinService{
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "weiXinDao")
	private WeiXinDao dao;
	
	//@Value("#{properties['weixin.appid']}")
	private String appid;
	//@Value("#{properties['weixin.secret']}")
	private String secret;
	
	/**
	 * 获取微信公众号access_token
	 * @return
	 */
	private String getAccessToken(){
		String access_token = RedisTool.get(Constant.WEIXIN_ACCESS_TOKEN_KEY);
		if(access_token == null){
			try {
				/*HttpClient httpclient = HttpClients.createDefault();
				HttpGet httpGet = new HttpGet(new URI("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid
						+"&secret="+secret));
				//执行Get请求，  
				HttpResponse httpresponse = httpclient.execute(httpGet);
				HttpEntity entity = httpresponse.getEntity();
				String body = EntityUtils.toString(entity);*/
				String body = HttpUtil.httpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid
						+"&secret="+secret);
				//System.out.println(body);
				JSONObject json = JSON.parseObject(body);
				access_token = json.getString("access_token");
				if(access_token != null){
					//System.out.println(json.getString("expires_in"));
					//access_token写入redis缓存
					RedisTool.set(Constant.WEIXIN_ACCESS_TOKEN_KEY, access_token);
					//设置过期时间
					RedisTool.expire(Constant.WEIXIN_ACCESS_TOKEN_KEY, Constant.WEIXIN_KEY_CACHE_TIME);
				}else{
					logger.error("获取微信公众号access_token出错："+ body);
				}
			} catch (Exception e) {
				logger.error("获取微信公众号access_token出错：", e);
			}
		}
		return access_token;
	}
	
	/**
	 * 获取微信jsapi_ticket
	 * @return
	 */
	private String getJsApiTicket(){
		String jsapi_ticket = RedisTool.get(Constant.WEIXIN_JSAPI_TICKET_KEY);
		if(jsapi_ticket == null){
			try {
				String access_token = getAccessToken();
				String body = HttpUtil.httpGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi");
				JSONObject json = JSON.parseObject(body);
				jsapi_ticket = json.getString("ticket");
				if(jsapi_ticket != null){
					//jsapi_ticket写入redis缓存
					RedisTool.set(Constant.WEIXIN_JSAPI_TICKET_KEY, jsapi_ticket);
					//设置过期时间
					RedisTool.expire(Constant.WEIXIN_JSAPI_TICKET_KEY, Constant.WEIXIN_KEY_CACHE_TIME);
				}else{
					logger.error("获取微信公众号jsapi_ticket出错："+ body);
				}
			} catch (Exception e) {
				logger.error("获取微信公众号jsapi_ticket出错：", e);
			}
		}
		return jsapi_ticket;
	}
	
	/**
	 * 根据code获取微信用户的access_token
	 * @param code
	 * @return
	 */
	private JointLogin getUserAccessToken(String code){
		JointLogin jl = null;
		try {
			/*HttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(new URI("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid
					+"&secret="+secret+"&code="+code+"&grant_type=authorization_code"));
			//执行Get请求，  
			HttpResponse httpresponse = httpclient.execute(httpGet);
			HttpEntity entity = httpresponse.getEntity();
			String body = EntityUtils.toString(entity);*/
			String body = HttpUtil.httpGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid
					+"&secret="+secret+"&code="+code+"&grant_type=authorization_code");
			//System.out.println(body);
			JSONObject json = JSON.parseObject(body);
			String access_token = json.getString("access_token");
			if(access_token != null){
				jl = new JointLogin();
				jl.setLoginType(JointLoginType.WEIXIN);
				jl.setAccessToken(access_token);
				jl.setExpiresIn(json.getString("expires_in"));
				jl.setRefreshToken(json.getString("refresh_token"));
				jl.setOpenid(json.getString("openid"));
				jl.setScope(json.getString("scope"));
			}else{
				logger.error("根据code获取微信用户的access_token出错："+ body);
			}
		} catch (Exception e) {
			logger.error("根据code获取微信用户的access_token出错：", e);
		}
		return jl;
	}
	
	/**
	 * 根据微信用户的access_token 、openid获取用户信息
	 */
	private SysUser getUserInfo(JointLogin jointLogin){
		 SysUser user = null;
		try {
			String body = HttpUtil.httpGet("https://api.weixin.qq.com/sns/userinfo?access_token="+jointLogin.getAccessToken()
					+"&openid="+jointLogin.getOpenid()+"&lang=zh_CN");
			JSONObject json = JSON.parseObject(body);
			//用户昵称
			String nickname = json.getString("nickname");
			if(nickname != null){
				 user = new SysUser();
				 user.setName(nickname);
				 //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
				 user.setSex(json.getString("sex"));
				 //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像）
				 //，用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
				 user.setPortrait(json.getString("headimgurl"));
				 //province	用户个人资料填写的省份
				 //city	普通用户个人资料填写的城市
				 //country	国家，如中国为CN
				 jointLogin.setUnionid(json.getString("unionid"));
				 
			}else{
				logger.error("根据微信用户的access_token 、openid获取用户信息出错："+ body);
			}
		} catch (Exception e) {
			logger.error("根据微信用户的access_token 、openid获取用户信息：", e);
		}
		return user;
	}

	/**
	 * 微信用户登录
	 * @param appid	公众号的唯一标识
	 * @param secret	公众号的唯一凭证密钥，即appsecret
	 * @param code 用户的code
	 * @return
	 */
	public ReqResponse<JointLoginDTO> login(String appid,String secret,String code) {
		ReqResponse<JointLoginDTO> req = new ReqResponse<JointLoginDTO>();
		this.appid = appid;
		this.secret = secret;
		try {
			JointLogin jointLogin = this.getUserAccessToken(code);
			if(jointLogin != null){
				SysUser user = this.getUserInfo(jointLogin);
				if(user != null){
					dao.updateLoginInfo(jointLogin, user);
					JointLoginDTO jointLoginDTO = new JointLoginDTO();
					jointLoginDTO.setJointLogin(jointLogin);
					jointLoginDTO.setUser(user);
					req.setData(jointLoginDTO);
				}else{
					req.setCode(1);
					req.setMsg("登录出错");
				}
			}else{
				req.setCode(1);
				req.setMsg("登录出错");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("微信用户登录出错：",e);
			req.setCode(1);
			req.setMsg("登录出错");
		}
		return req;
	}
	


	
	/**
	 * 微信分享签名
	 * @param appid	公众号的唯一标识
	 * @param secret	公众号的唯一凭证密钥，即appsecret
	 * @param url 分享的链接地址,不包含#及其后面部分(必须是调用JS接口页面的完整URL)
	 * @return
	 */
	public ReqResponse<Map<String,String>> getShareSignature(String appid,String secret,String url) {
		this.appid = appid;
		this.secret = secret;
		ReqResponse<Map<String,String>> req = new ReqResponse<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();  
		//随机字符串
		String noncestr = UuidUtil.get32UUID();
		String jsapi_ticket = getJsApiTicket();
		// 时间戳  
		String timestamp = new Date().getTime()/1000+"";
        // 将jsapi_ticket、nonce、timestamp、url四个参数进行字典序排序  
       // String[] params = new String[] { jsapi_ticket,noncestr, timestamp, url };  
        //Arrays.sort(params);  
		//url = "http://192.168.1.39:8080/goods/19148";
        StringBuffer sb = new StringBuffer();
        sb.append("jsapi_ticket=");
        sb.append(jsapi_ticket);
        sb.append("&noncestr=");
        sb.append(noncestr);
        sb.append("&timestamp=");
        sb.append(timestamp);
        sb.append("&url=");
        sb.append(url);
        //sb.append(url.indexOf("#") >= 0 ? url.substring(0, url.indexOf("#")) : url);
        //System.out.println(sb.toString());
        try {//signature(sb.toString());
        	//getSignature(jsapi_ticket, timestamp, noncestr, url);
			String signature = 
					new String(  
			Hex.encodeHex(MessageDigest.getInstance(Constant.WEIXIN_SIGN_ALGORITHMm).digest((sb.toString()).getBytes()), true));
			map.put("url", url);  
			map.put("appid", appid);  
			map.put("noncestr", noncestr);  
			map.put("timestamp", timestamp);  
			map.put("signature", signature);  
			req.setData(map);
			//System.out.println(map);
			logger.info("微信分享签名结果："+map);
			//System.out.println(signature(sb.toString()));
			/*try {
				System.out.println(getSignature(jsapi_ticket, timestamp, noncestr, url));
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		} catch (NoSuchAlgorithmException e) {
			logger.error("微信分享签名出错：", e);
			req.setCode(1);
			req.setMsg("微信分享签名出错");
		}
		return req;
	}
	 
	/**
	 * 微信分享签名
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private String signature(String str) throws NoSuchAlgorithmException {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(Constant.WEIXIN_SIGN_ALGORITHMm); //如果是SHA加密只需要将"SHA-1"改成"SHA"即可
            //digest.update(str.getBytes());
            byte[] messageDigest = digest.digest(str.getBytes());
            // Create Hex String
            StringBuffer hexStr = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(shaHex);
            }
            return hexStr.toString();

    }
 
	// 获得js signature
		public String getSignature(String jsapi_ticket, String timestamp,
				String nonce, String jsurl) throws IOException {
			/****
			 * 对 jsapi_ticket、 timestamp 和 nonce 按字典排序 对所有待签名参数按照字段名的 ASCII
			 * 码从小到大排序（字典序）后，使用 URL 键值对的格式（即key1=value1&key2=value2…）拼接成字符串
			 * string1。这里需要注意的是所有参数名均为小写字符。 接下来对 string1 作 sha1 加密，字段名和字段值都采用原始值，不进行
			 * URL 转义。即 signature=sha1(string1)。
			 * **如果没有按照生成的key1=value&key2=value拼接的话会报错
			 */
			String[] paramArr = new String[] { "jsapi_ticket=" + jsapi_ticket,
					"timestamp=" + timestamp, "noncestr=" + nonce, "url=" + jsurl };
			Arrays.sort(paramArr);
			// 将排序后的结果拼接成一个字符串
			String content = paramArr[0].concat("&"+paramArr[1]).concat("&"+paramArr[2])
					.concat("&"+paramArr[3]);
			System.out.println("拼接之后的content为:"+content);
			String gensignature = null;
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				// 对拼接后的字符串进行 sha1 加密
				byte[] digest = md.digest(content.toString().getBytes());
				gensignature = byteToStr(digest);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			// 将 sha1 加密后的字符串与 signature 进行对比
			if (gensignature != null) {
				return gensignature;// 返回signature
			} else {
				return "false";
			}
			// return (String) (ciphertext != null ? ciphertext: false);
		}

		/**
		 * 将字节数组转换为十六进制字符串
		 *
		 * @param byteArray
		 * @return
		 */
		private String byteToStr(byte[] byteArray) {
			String strDigest = "";
			for (int i = 0; i < byteArray.length; i++) {
				strDigest += byteToHexStr(byteArray[i]);
			}
			return strDigest;
		}

		/**
		 * 将字节转换为十六进制字符串
		 *
		 * @param mByte
		 * @return
		 */
		private String byteToHexStr(byte mByte) {
			char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
					'B', 'C', 'D', 'E', 'F' };
			char[] tempArr = new char[2];
			tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
			tempArr[1] = Digit[mByte & 0X0F];
			String s = new String(tempArr);
			return s;
		}
	
}
