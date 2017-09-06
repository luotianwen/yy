package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shifeng.entity.user.SysUser;
import com.shifeng.provide.util.HttpUtil;

public class WXDemo {
	public static void main(String[] args) {
		String access_token = "0cLJdzefGqtPe91TrFuLShUwRVb0UBMCb03aQomvG9D8KkHqZDdI1H07-sSrZ3fNmUuCUMFsDoeM5W_jL-6zt8wnh8I8v90Z-AT_7PWN9VQ";
		String openid = "o6SDjswFKhDCwK5rz5GJnq8SmyAY";
		 SysUser user = null;
			try {
				/*String body1 = HttpUtil.httpGet("https://api.weixin.qq.com/sns/oauth2/refresh_token?"
						+ "appid=wx2e1deda16bcced1d&grant_type=refresh_token&refresh_token=cBKnNLAHhAXXMeutDpVcsyckzn05xrED7nCx1HZTdFoJ-KsTPrQ-ZaKRZ0varMPfWWXzqnMYczPAe8y68U_b4GLvHUd-kIqIUXXhz8PDb-M");
				System.out.println(body1);*/
				String body = HttpUtil.httpGet("https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
						+"&openid="+openid+"&lang=zh_CN");
				System.out.println(body);
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
					 System.out.println(user.toString());
					 
				}else{
					System.err.println("根据微信用户的access_token 、openid获取用户信息出错："+ body);
				}
			} catch (Exception e) {
				System.err.println("根据微信用户的access_token 、openid获取用户信息："+ e);
			}
	}

}
