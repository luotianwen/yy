package com.shifeng.mall.service;

import java.util.Map;

public interface YzmService {
	/**
	 * 发送验证码
	 * @param map
	 * @param userId 用户ID
	 * @param phone 手机号
	 */
	public void validateYzmTime(Map<String,String> map,String userId,String phone);
	
	/**
	 * 验证验证码
	 * @param map
	 * @param userId 用户ID
	 * @param phone 手机号
	 * @param yzm 验证码
	 */
	public void verifyYzm(Map<String,String> map,String userId,String phone,String yzm);
	
	/**
	 * 注册/找回密码发送验证码
	 * @param map
	 * @param phone 手机号
	 * @param type 类型(1:注册;2:找回密码;3:修改密码;4:修改手机[旧手机号];5:修改手机[新手机号])
	 */
	public void postYzmTime(Map<String,String> map,String phone,int type);
	
	/**
	 * 注册/找回密码验证验证码
	 * @param phone 手机号
	 * @param yzm 验证码
	 * @param type 类型(1:注册;2:找回密码;3:修改密码;4:修改手机[旧手机号];5:修改手机[新手机号])
	 */
	public boolean postYzm(String phone,String yzm,int type);
	
	/**
	 * 是否通过旧手机验证
	 * @param phone
	 */
	public boolean check_oldphone(String phone);
	
	/**
	 * 缓存记录两次手机号码
	 * @param phone
	 * @param newPhone
	 */
	public void setPhone(String phone,String newPhone);
	
	/**
	 * 验证新手机号码是否一致
	 * @param phone
	 * @param newPhone
	 */
	public boolean verifyPhone(String phone,String newPhone);
	
	/**
	 * 入驻信息保存，删除验证码缓存
	 */
	public void delSettled(String userId);
	
}
