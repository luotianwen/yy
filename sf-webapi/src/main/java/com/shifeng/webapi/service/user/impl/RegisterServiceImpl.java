package com.shifeng.webapi.service.user.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.entity.user.SysUser;
import com.shifeng.provide.ali.service.AliService;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.Tools;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.service.user.RegisterService;

/**
 * 用户注册
 * @author WinZhong
 *
 */
@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "sysUserService")
	protected SysUserService userService;
	
	@Resource(name = "aliService")
	protected AliService aliService;
	
	/**
	 * 检测账号（账户名/手机号/邮箱）是否存在
	 * @param account  账号
	 * @return 存在 false  不存在 true
	 */
	public boolean checkAccountExists(String account) {
		try {
			ReqResponse<String> result = userService.checkAccountExists(account);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【检测账号（账户名/手机号/邮箱）是否存在】出错：", e);
		}
		return false;
	}
	
	/**
	 * 发送短信验证码
	 * @param phone 手机号
	 * @param code	验证码
	 * @return	返回发送结果
	 */
	public boolean sendMobileCode(String phone,int code) {
		try {
			ReqResponse<Integer> result = aliService.sendSMS(phone, "{\"code\":\""+code+"\",\"product\":\"手机号\"}","SMS_16340212");
			if(result.getCode() == 0){//短信发送成功
				return true;
			}
		} catch (Exception e) {
			logger.error("【发送短信验证码】出错：", e);
		}
		 
		return false;
	}
	
	/**
	 * 注册用户
	 * @param phone 手机号
	 * @param password	密码
	 * @return	返回注册结果
	 */
	public boolean regUser(String phone,String password) {
		try {
			SysUser sysUser = new SysUser();
			sysUser.setPhone(phone);
			sysUser.setAccount(phone);
			sysUser.setPassword(password);
			sysUser.setName(phone.substring(0, 3)+"*****"+phone.substring(8));
			ReqResponse<Integer> result = userService.addUser(sysUser);
			if(result.getCode() == 0){//短信发送成功
				return true;
			}
		} catch (Exception e) {
			logger.error("【发送短信验证码】出错：", e);
		}
		return false;
	}

}
