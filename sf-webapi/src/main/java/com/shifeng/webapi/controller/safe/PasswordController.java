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
import com.shifeng.util.DateUtil;
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
 * 安全中心修改登录密码API接口
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/safe/password")
public class PasswordController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "registerServiceImpl")
	protected RegisterService registerService;
	
	@Resource(name = "safeServiceImpl")
	protected SafeService safeService;
	
	@Resource(name = "noticeServiceImpl")
	protected NoticeService noticeService;
	
	
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
					}else{
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("账户未绑定手机号，暂不支持通过手机号修改密码");
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
	 * @param sign	md5(version+ token)
	 * @return
	 */
	@RequestMapping(value = "/mobileCode")
	@ResponseBody
	public ReqResponse<String> mobileCode(String version,String token,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "safe/password/mobileCode", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token,req)){
					SysUser user = this.getUser(token, req);
					String phone = user.getPhone();
					int code= Tools.getRandomNum();
					boolean isSend = noticeService.sendMobileCode(phone, code,"修改密码",req);
					if(isSend){
						String mobilecode_key = String.format(Constant.UPDATEPWD_MOBILECODE_KEY, phone);
						RedisTool.set(mobilecode_key, code+"");
						//验证码十分钟内有效
						RedisTool.expire(mobilecode_key, Constant.AUTHCODE_VALID_TIME);
						/////记录修改密码进度/////
						String updatePwd_progress_key = String.format(Constant.UPDATEPWD_PROGRESS_KEY, token);
						//修改密码第一步
						RedisTool.set(updatePwd_progress_key, 1+"");
						//修改密码进度三十分钟后失效
						RedisTool.expire(updatePwd_progress_key, 1*60*30);
						req.setData("0");
						req.setCode(0);
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
	 * @param token	
	 * @param authcode 验证码
	 * @param sign	md5(version+ token + authcode)
	 * @return
	 */
	@RequestMapping(value = "/checkMobileCode")
	@ResponseBody
	public ReqResponse<String> checkMobileCode(String version,String token,String authcode,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "safe/password/checkMobileCode", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + authcode,req)){
					SysUser user = this.getUser(token, req);
					String phone = user.getPhone();
					/////记录修改密码进度/////
					String updatePwd_progress_key = String.format(Constant.UPDATEPWD_PROGRESS_KEY, token);
					String progress = RedisTool.get(updatePwd_progress_key);
					if(Objects.equals("1", progress)){//验证是否正常流程修改密码
				 
						String mobilecode_key = String.format(Constant.UPDATEPWD_MOBILECODE_KEY, phone);
						String mobilecode = RedisTool.get(mobilecode_key);
						if(Objects.equals(mobilecode, authcode)){//验证手机验证码
							//修改密码第二步
							RedisTool.set(updatePwd_progress_key, 2+"");
							//修改密码进度三十分钟后失效
							RedisTool.expire(updatePwd_progress_key, 1*60*30);
							//删除已验证验证码
							RedisTool.del(mobilecode_key);
							req.setCode(0);
						}else{
							req.setCode(ErrorMsg.AUTHCODE_ERROR.getCode());
							req.setMsg(ErrorMsg.AUTHCODE_ERROR.getMsg());
						}
						
					}else{//非正常
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("请按照正常流程修改密码");
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
	 * 修改密码
	 * @param version	版本号
	 * @param token	
	 * @param newPassword	新密码
	 * @param sign	md5(version+ token + newPassword)
	 * @return
	 */
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public ReqResponse<String> updatePassword(String version,String token,String newPassword,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "safe/password/updatePassword", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+newPassword,req)){
					SysUser user = this.getUser(token, req);
					String phone = user.getPhone();

					if(VerifiersUtil.passwordVerifiers(newPassword, req)){

						/////记录修改密码进度/////
						String updatePwd_progress_key = String.format(Constant.UPDATEPWD_PROGRESS_KEY, token);
						String progress = RedisTool.get(updatePwd_progress_key);
						if(Objects.equals("2", progress)){//验证是否正常流程修改密码
							 
							boolean bl = safeService.updatePasswordByPhone(phone, newPassword);
							if(bl){
								req.setCode(0);
							}else{//修改失败
								req.setCode(ErrorMsg.FAIL.getCode());
								req.setMsg(ErrorMsg.FAIL.getMsg());
							}
							
						}else{//非正常
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg("请按照正常流程修改密码");
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
