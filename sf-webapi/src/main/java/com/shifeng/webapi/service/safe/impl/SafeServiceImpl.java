package com.shifeng.webapi.service.safe.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.safe.SafeService;

/**
 * 安全中心
 * @author WinZhong
 *
 */
@Service("safeServiceImpl")
public class SafeServiceImpl implements SafeService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "sysUserService")
	protected SysUserService userService;
	
	/**
	 * 根据用户手机号修改密码
	 * @param phone  手机号
	 * @param password  密码
	 * @return true 修改成功  false 修改失败
	 */
	public boolean updatePasswordByPhone(String phone, String password) {
		try {
			ReqResponse<String> result = userService.updatePasswordByPhone(phone,password);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【根据用户手机号修改密码】出错：", e);
		}
		return false;
	}

	
	/**
	 * 用户绑定手机号
	 * @param user_id  用户ID
	 * @param phone  手机号
	 * @return true 修改成功  false 修改失败
	 */
	public boolean bindPhone(String user_id, String phone) {
		try {
			ReqResponse<String> result = userService.bindPhone(user_id,phone);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【用户绑定手机号】出错：", e);
		}
		return false;
	}
	

}
