package com.shifeng.webapi.controller.safe;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.entity.user.SysUser;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Tools;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.notice.NoticeService;
import com.shifeng.webapi.service.safe.SafeService;
import com.shifeng.webapi.service.user.RegisterService;
import com.shifeng.webapi.util.VerifiersUtil;
/**
 * 安全中心绑定API接口
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/safe/bind")
public class BindController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "registerServiceImpl")
	protected RegisterService registerService;
	
	@Resource(name = "safeServiceImpl")
	protected SafeService safeService;
	
	@Resource(name = "noticeServiceImpl")
	protected NoticeService noticeService;
	
	
	/**
	 * 验证手机号是否存在
	 * @param version	版本号
	 * @param token	
	 * @param phone	手机号
	 * @param sign	md5(version+ token + phone)
	 * @return
	 */
	@RequestMapping(value = "/checkPhoneExists")
	@ResponseBody
	public ReqResponse<String> checkPhoneExists(String version,String token,String phone,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "safe/bind/checkPhoneExists", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + phone,req)){
					boolean bl = VerifiersUtil.validatePhone(phone);
					if(bl){
						bl = registerService.checkAccountExists(phone);
						if(!bl){
							req.setCode(10006);
							req.setMsg("该手机号已被使用");
						}else{
							/////记录绑定手机号进度/////
							String bindPhone_progress_key = String.format(Constant.BIND_PHONE_PROGRESS_KEY, token);
							RedisTool.set(bindPhone_progress_key, 1+"");//绑定手机号第一步
							//绑定手机号进度三十分钟后失效
							RedisTool.expire(bindPhone_progress_key, 1*60*30);
							req.setCode(0);
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
	 * @param token	
	 * @param phone	手机号
	 * @param sign	md5(version+ token + phone)
	 * @return
	 */
	@RequestMapping(value = "/notifyuser/mobileCode")
	@ResponseBody
	public ReqResponse<String> mobileCode(String version,String token,String phone,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "safe/bind/mobileCode", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + phone,req)){
					/////记录绑定手机号进度/////
					String bindPhone_progress_key = String.format(Constant.BIND_PHONE_PROGRESS_KEY, token);
					String progress = RedisTool.get(bindPhone_progress_key);
					if(Objects.equals("1", progress)){//验证是否正常流程绑定手机号
						int code= Tools.getRandomNum();
						boolean isSend = noticeService.sendMobileCode(phone, code,"绑定手机号",req);
						if(isSend){
							String mobilecode_key = String.format(Constant.BIND_PHONE_MOBILECODE_KEY, phone);
							RedisTool.set(mobilecode_key, code+"");
							//验证码十分钟内有效
							RedisTool.expire(mobilecode_key, Constant.AUTHCODE_VALID_TIME);
							
							RedisTool.set(bindPhone_progress_key, 2+"");//绑定手机号第二步
							//绑定手机号进度三十分钟后失效
							RedisTool.expire(bindPhone_progress_key, 1*60*30);
							
							/////记录绑定手机号/////
							String bindPhone_key = String.format(Constant.BIND_PHONE_KEY, token);
							RedisTool.set(bindPhone_key, phone);
							//找回密码手机号十分钟内有效
							RedisTool.expire(bindPhone_key, 1*60*10);
							
							req.setData("0");
							req.setCode(0);
						}
					}else{//非正常
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("请按照正常流程绑定手机号");
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
	 * 绑定手机号
	 * @param version	版本号
	 * @param token	
	 * @param authcode 验证码
	 * @param sign	md5(version+ token + authcode)
	 * @return
	 */
	@RequestMapping(value = "/bindPhone")
	@ResponseBody
	public ReqResponse<String> bindPhone(String version,String token,String authcode,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "safe/bind/bindPhone", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + authcode,req)){
					/////记录绑定手机号进度/////
					String bindPhone_progress_key = String.format(Constant.BIND_PHONE_PROGRESS_KEY, token);
					String progress = RedisTool.get(bindPhone_progress_key);
					if(Objects.equals("2", progress)){//验证是否正常流程绑定手机号
						/////绑定手机号手机号/////
						String bindPhone_key = String.format(Constant.BIND_PHONE_KEY, token);
						String phone = RedisTool.get(bindPhone_key);
						String mobilecode_key = String.format(Constant.BIND_PHONE_MOBILECODE_KEY, phone);
						String mobilecode = RedisTool.get(mobilecode_key);
						if(Objects.equals(mobilecode, authcode)){//验证手机验证码
							//删除已验证验证码
							RedisTool.del(mobilecode_key);
							
							boolean bl = safeService.bindPhone(user_id, phone);
							if(bl){
								req.setCode(0);
							}else{//修改失败
								req.setCode(ErrorMsg.FAIL.getCode());
								req.setMsg(ErrorMsg.FAIL.getMsg());
							}
							
						}else{
							req.setCode(ErrorMsg.AUTHCODE_ERROR.getCode());
							req.setMsg(ErrorMsg.AUTHCODE_ERROR.getMsg());
						}
						
					}else{//非正常
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("请按照正常流程绑定手机号");
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
	 * 获取要修改密码的账户信息
	 * @param version	版本号
	 * @param token
	 * @param sign	md5(version+ token)
	 * @return
	 */
	@RequestMapping(value = "/account")
	@ResponseBody
	public ReqResponse<String> account(String version,String token,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "safe/password/account", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token,req)){
					SysUser user = this.getUser(token, req);
					String phone = user.getPhone();
					if(StringUtils.isNotBlank(phone)){
						phone = phone.replaceAll("(?<=\\w{3})\\w(?=\\w{3})", "*");
						req.setData(phone);
						/////记录绑定手机号进度/////
						String bindPhone_progress_key = String.format(Constant.BIND_PHONE_PROGRESS_KEY, token);
						RedisTool.set(bindPhone_progress_key, 1+"");//绑定手机号第一步
						//绑定手机号进度三十分钟后失效
						RedisTool.expire(bindPhone_progress_key, 1*60*30);
					}else{
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("账户未绑定手机号");
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
