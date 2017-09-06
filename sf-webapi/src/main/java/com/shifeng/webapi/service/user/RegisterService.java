package com.shifeng.webapi.service.user;

/**
 * 用户注册
 * @author WinZhong
 *
 */
public interface RegisterService {
	
	/**
	 * 检测账号（账户名/手机号/邮箱）是否存在
	 * @param account  账号
	 * @return 验证结果  存在 false  不存在 true
	 */
	boolean checkAccountExists(String account);
	
	/**
	 * 发送短信验证码
	 * @param phone 手机号
	 * @param code	验证码
	 * @return	返回发送结果
	 */
	boolean sendMobileCode(String phone,int code);
	
	/**
	 * 注册用户
	 * @param phone 手机号
	 * @param password	密码
	 * @return	返回注册结果
	 */
	boolean regUser(String phone,String password);

}
