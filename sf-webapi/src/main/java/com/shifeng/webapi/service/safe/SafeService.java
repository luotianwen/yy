package com.shifeng.webapi.service.safe;

/**
 * 安全中心
 * @author WinZhong
 *
 */
public interface SafeService {
	
	/**
	 * 根据用户手机号修改密码
	 * @param phone  手机号
	 * @param password  密码
	 * @return true 修改成功  false 修改失败
	 */
	boolean updatePasswordByPhone(String phone, String password);
	
	/**
	 * 用户绑定手机号
	 * @param user_id  用户ID
	 * @param phone  手机号
	 * @return true 修改成功  false 修改失败
	 */
	boolean bindPhone(String user_id, String phone);
	
	
	

}
