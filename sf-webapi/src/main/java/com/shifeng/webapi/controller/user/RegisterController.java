package com.shifeng.webapi.controller.user;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shifeng.entity.user.SysUser;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.MD5Util;
import com.shifeng.util.Tools;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.dto.UserDTO;
import com.shifeng.webapi.service.user.RegisterService;
import com.shifeng.webapi.util.VerifiersUtil;

@Controller
@RequestMapping(value = "/reg")
public class RegisterController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "registerServiceImpl")
	protected RegisterService registerService;
	
	@Resource(name = "sysUserService")
	protected SysUserService userService;
	
	
	/**
	 * 验证手机号是否存在
	 * @param version	版本号
	 * @param ticket	
	 * @param phone	手机号
	 * @param sign	md5(version+ ticket + phone)
	 * @return
	 */
	@RequestMapping(value = "/checkPhoneExists")
	@ResponseBody
	public ReqResponse<String> checkPhoneExists(String version,String ticket,String phone,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}

		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "reg/checkPhoneExists", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ ticket + phone,req)){
					boolean bl = VerifiersUtil.validatePhone(phone);
					if(bl){
						bl = registerService.checkAccountExists(phone);
						if(bl){
							/////记录注册进度/////
							String reg_progress_key = String.format(Constant.REG_PROGRESS_KEY, ticket);
							RedisTool.set(reg_progress_key, 1+"");//注册第一步
							//注册进度三十分钟后失效
							RedisTool.expire(reg_progress_key, 1*60*30);
							
							req.setCode(0);
						}else{
							req.setCode(10002);
							req.setMsg("账户已存在");
						}
					}else{
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("手机号格式不正确");
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		return req;
	}
	
	/**
	 * 发送短信验证码
	 * @param version	版本号
	 * @param ticket	
	 * @param phone	手机号
	 * @param sign	md5(version+ ticket + phone)
	 * @return
	 */
	@RequestMapping(value = "/notifyuser/mobileCode")
	@ResponseBody
	public ReqResponse<String> mobileCode(String version,String ticket,String phone,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}

		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "reg/mobileCode", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ ticket + phone,req)){
					/////记录注册进度/////
					String reg_progress_key = String.format(Constant.REG_PROGRESS_KEY, ticket);
					String progress = RedisTool.get(reg_progress_key);
					if(Objects.equals("1", progress)){//验证是否正常流程注册
						String m_key = String.format(Constant.NOTICE_MOBILECODE_MINUTE_COUNT_KEY, phone);
						//获取手机号一分钟内是否发送过短信
						String m_val = RedisTool.get(m_key);
						if(m_val == null){//没有发送
							String d_key = String.format(Constant.NOTICE_MOBILECODE_DAY_COUNT_KEY, phone);
							//获取手机号每天短信发送次数
							String d_val = RedisTool.get(d_key);
							int count =0;
							try {
								count = Integer.valueOf(d_val);
							} catch (NumberFormatException e) {
							}
							if(count >= Constant.DAY_MAX_SEND_MOBILECODE_COUNT){
								req.setCode(103);
								req.setMsg("短信发送失败");
							}else{
								int code= Tools.getRandomNum();
								boolean isSend = registerService.sendMobileCode(phone, code);
								if(isSend){//短信发送成功
									logger.info("手机号："+phone+"\t注册验证码为："+code);
									RedisTool.incrBy(d_key, 1);
									//计算当天到24点还剩下多少秒
									Long s = DateUtil.currentDayResidueTime()/1000;
									//设置过期时间 单位：秒
									RedisTool.expire(d_key, s.intValue());
									String mobilecode_key = String.format(Constant.REG_MOBILECODE_KEY, phone);
									RedisTool.set(mobilecode_key, code+"");
									//验证码十分钟内有效
									RedisTool.expire(mobilecode_key, Constant.AUTHCODE_VALID_TIME);

									/////记录注册手机号/////
									String reg_phone_key = String.format(Constant.REG_PHONE_KEY, ticket);
									RedisTool.set(reg_phone_key, phone);
									//注册手机号十分钟内有效
									RedisTool.expire(reg_phone_key, s.intValue());

									RedisTool.set(reg_progress_key, 2+"");//注册第二步
									//注册进度三十分钟后失效
									RedisTool.expire(reg_progress_key, 1*60*30);
									

									req.setData("0");
									req.setCode(0);
								}else{
									req.setCode(103);
									req.setMsg("短信发送失败");
								}
								RedisTool.set(m_key, "1");
								RedisTool.expire(m_key, 60);
							}		
						}
						
					}else{//非正常
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("请按照正常流程注册");
					}	

					
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		return req;
	}
	
	
	/**
	 * 验证手机验证码是否正确
	 * @param version	版本号
	 * @param ticket	
	 * @param authcode 验证码
	 * @param sign	md5(version+ ticket + authcode)
	 * @return
	 */
	@RequestMapping(value = "/checkMobileCode")
	@ResponseBody
	public ReqResponse<String> checkMobileCode(String version,String ticket,String authcode,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}

		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "reg/checkMobileCode", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ ticket + authcode,req)){
					/////记录注册进度/////
					String reg_progress_key = String.format(Constant.REG_PROGRESS_KEY, ticket);
					String progress = RedisTool.get(reg_progress_key);
					if(Objects.equals("2", progress)){//验证是否正常流程注册
						/////注册手机号/////
						String reg_phone_key = String.format(Constant.REG_PHONE_KEY, ticket);
						String phone = RedisTool.get(reg_phone_key);
						String mobilecode_key = String.format(Constant.REG_MOBILECODE_KEY, phone);
						String mobilecode = RedisTool.get(mobilecode_key);
						if(Objects.equals(mobilecode, authcode)){//验证手机验证码
							RedisTool.set(reg_progress_key, 3+"");//注册第三步
							//注册进度三十分钟后失效
							RedisTool.expire(reg_progress_key, 1*60*30);
							//删除已验证验证码
							RedisTool.del(mobilecode_key);
							req.setCode(0);
						}else{
							req.setCode(ErrorMsg.AUTHCODE_ERROR.getCode());
							req.setMsg(ErrorMsg.AUTHCODE_ERROR.getMsg());
						}
						
					}else{//非正常
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("请按照正常流程注册");
					}
					
					
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		return req;
	}
	
	
	/**
	 * 用户注册
	 * @param version	版本号
	 * @param ticket	
	 * @param phone	手机号
	 * @param password	密码
	 * @param sign	md5(version+ ticket + password)
	 * @return
	 */
	@RequestMapping(value = "/register")
	@ResponseBody
	public ReqResponse<Object> register(String version,String ticket,String password,String sign){
		ReqResponse<Object> req = new ReqResponse<Object>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}
		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "register", req)){
			return req;
		}

		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+password,req)){
					if(VerifiersUtil.passwordVerifiers(password, req)){
						/////记录注册进度/////
						String reg_progress_key = String.format(Constant.REG_PROGRESS_KEY, ticket);
						String progress = RedisTool.get(reg_progress_key);
						if(Objects.equals("3", progress)){//验证是否正常流程注册

							/////注册手机号/////
							String reg_phone_key = String.format(Constant.REG_PHONE_KEY, ticket);
							String phone = RedisTool.get(reg_phone_key);
							boolean bl = registerService.regUser(phone, password);
							if(bl){
								//自动登录
								login(phone, password, req);
								req.setCode(0);
							}else{//修改失败
								req.setCode(ErrorMsg.FAIL.getCode());
								req.setMsg(ErrorMsg.FAIL.getMsg());
							}
							
						}else{//非正常
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg("请按照正常流程注册");
						}
					}
					 
				}
				
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		/*try {
			
			//String key = String.format(Constant.AUTHCODE_KEY,ticket, "reg");
			 
			String mobilecode_key = String.format(Constant.MOBILECODE_KEY, phone);
			//验证码
		    String mobilecode = RedisTool.get(mobilecode_key);
		} catch (Exception e) {
			logger.info("用户注册出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}*/
		
		return req;
	}
	
	/**
	 * 登录
	 * @param phone
	 * @param password
	 */
	private void login(String phone, String password,ReqResponse<Object> req){
		
		try {
			ReqResponse<SysUser> result = userService.checkPassword(phone, password);
			if(result.getCode() == 0){
				SysUser u = result.getData();
				UserDTO user = new UserDTO(u);
				String token = MD5Util.hexSALT(user.getId()+"");
				user.setToken(token);
				user.setPhone(phone);
				String key = String.format(Constant.USER_ID_TOKEN_KEY, token);
				//计算当天到24点还剩下多少秒
				Long s = DateUtil.currentDayResidueTime()/1000;
				//token写入redis缓存
				RedisTool.set(key, user.getId()+"");
				//设置过期时间
				RedisTool.expire(key, s.intValue());
				
				key = String.format(Constant.USER_TOKEN_KEY, token);
				//token写入redis缓存
				RedisTool.set(key, JSON.toJSONString(user));
				//设置过期时间
				RedisTool.expire(key, s.intValue());
				 
				req.setData(user);
			}else{
			}
		} catch (Exception e) {
			logger.error("注册成功调用自动登录接口出错：", e);
		}
		
	}
	 
	
	
	//https://reg.jd.com/notifyuser/mobileCode?state=&mobile=%2B008617701058520&_=1488246979434
	

	
}
