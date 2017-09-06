package com.shifeng.webapi.controller.fx;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.Tools;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.fx.FxUserService;
import com.shifeng.webapi.service.user.RegisterService;
import com.shifeng.webapi.util.VerifiersUtil;

/**
 * 分销用户API接口
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/fx/user")
public class FxUserController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "fxUserServiceImpl")
	protected FxUserService fxUserService;
	
	@Resource(name = "registerServiceImpl")
	protected RegisterService registerService;

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
		if(!this.isGoOnVisit(ticket, "fx/checkPhoneExists", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ ticket + phone,req)){

					boolean bl = VerifiersUtil.validatePhone(phone);
					if(bl){
						bl = fxUserService.isPhoneExists(phone);
						if(bl){
							/////记录找回密码进度/////
							String findPwd_progress_key = String.format(Constant.FINDPWD_PROGRESS_KEY, ticket);
							RedisTool.set(findPwd_progress_key, 1+"");//找回密码第一步
							//找回密码进度三十分钟后失效
							RedisTool.expire(findPwd_progress_key, 1*60*30);
							
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
		if(!this.isGoOnVisit(ticket, "fx/mobileCode", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ ticket + phone,req)){
					/////记录找回密码进度/////
					String findPwd_progress_key = String.format(Constant.FINDPWD_PROGRESS_KEY, ticket);
					String progress = RedisTool.get(findPwd_progress_key);
					if(Objects.equals("1", progress)){//验证是否正常流程找回密码
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
									RedisTool.incrBy(d_key, 1);
									//计算当天到24点还剩下多少秒
									Long s = DateUtil.currentDayResidueTime()/1000;
									//设置过期时间 单位：秒
									RedisTool.expire(d_key, s.intValue());
									String mobilecode_key = String.format(Constant.FINDPWD_MOBILECODE_KEY, phone);
									RedisTool.set(mobilecode_key, code+"");
									//验证码十分钟内有效
									RedisTool.expire(mobilecode_key, Constant.AUTHCODE_VALID_TIME);

									/////记录找回密码手机号/////
									String findPwd_phone_key = String.format(Constant.FINDPWD_PHONE_KEY, ticket);
									RedisTool.set(findPwd_phone_key, phone);
									//找回密码手机号十分钟内有效
									RedisTool.expire(findPwd_phone_key, s.intValue());

									 
									RedisTool.set(findPwd_progress_key, 2+"");//找回密码第二步
									//找回密码进度三十分钟后失效
									RedisTool.expire(findPwd_progress_key, 1*60*30);
									
									
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
						req.setMsg("请按照正常流程激活账户");
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
		if(!this.isGoOnVisit(ticket, "fx/checkMobileCode", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ ticket + authcode,req)){
					/////记录找回密码进度/////
					String findPwd_progress_key = String.format(Constant.FINDPWD_PROGRESS_KEY, ticket);
					String progress = RedisTool.get(findPwd_progress_key);
					if(Objects.equals("2", progress)){//验证是否正常流程找回密码
						/////找回密码手机号/////
						String findPwd_phone_key = String.format(Constant.FINDPWD_PHONE_KEY, ticket);
						String phone = RedisTool.get(findPwd_phone_key);
						String mobilecode_key = String.format(Constant.FINDPWD_MOBILECODE_KEY, phone);
						String mobilecode = RedisTool.get(mobilecode_key);
						if(Objects.equals(mobilecode, authcode)){//验证手机验证码
							RedisTool.set(findPwd_progress_key, 3+"");//找回密码第三步
							//找回密码进度三十分钟后失效
							RedisTool.expire(findPwd_progress_key, 1*60*30);
							//删除已验证验证码
							RedisTool.del(mobilecode_key);
							req.setCode(0);
						}else{
							req.setCode(ErrorMsg.AUTHCODE_ERROR.getCode());
							req.setMsg(ErrorMsg.AUTHCODE_ERROR.getMsg());
						}
						
					}else{//非正常
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("请按照正常流程激活账户");
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
	 * 激活账户
	 * @param version	版本号
	 * @param ticket	
	 * @param password	密码
	 * @param sign	md5(version+ ticket + password)
	 * @return
	 */
	@RequestMapping(value = "/user/activation")
	@ResponseBody
	public ReqResponse<String> activation(String version,String ticket,String password,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}
		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "fx/activation", req)){
			return req;
		}

		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+password,req)){

					if(VerifiersUtil.passwordVerifiers(password, req)){
						
						/////记录找回密码进度/////
						String findPwd_progress_key = String.format(Constant.FINDPWD_PROGRESS_KEY, ticket);
						String progress = RedisTool.get(findPwd_progress_key);
						if(Objects.equals("3", progress)){//验证是否正常流程找回密码

							/////找回密码手机号/////
							String findPwd_phone_key = String.format(Constant.FINDPWD_PHONE_KEY, ticket);
							String phone = RedisTool.get(findPwd_phone_key);
							boolean bl = fxUserService.activation(phone, password);
							if(bl){
								req.setCode(0);
							}else{//修改失败
								req.setCode(ErrorMsg.FAIL.getCode());
								req.setMsg(ErrorMsg.FAIL.getMsg());
							}
							
						}else{//非正常
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg("请按照正常流程激活账户");
						}
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
	
	
	
	
	
	
	
	
	
	
	
	
}
