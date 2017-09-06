package com.shifeng.provide.sysuser.service;

import com.shifeng.entity.user.SysUser;
import com.shifeng.response.ReqResponse;
/** 
 * 用户表(SysUser)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-07 17:13:02 
 */  
public interface SysUserService {

	/**
	 * 根据用户id修改用户状态
	 * @param userId  用户id
	 * @param state  状态(1正常 2冻结)
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> updateUserState(int userId,int state,String operatorName);
	
	/**
	 * 根据用户账号（账户名/手机号/邮箱）验证密码
	 * @param account  账号
	 * @param password  密码
	 * @return
	 */
	ReqResponse<SysUser> checkPassword(String account,String password);
	
	/**
	 * 检测账号（账户名/手机号/邮箱）是否存在
	 * @param account  账号
	 * @return
	 */
	ReqResponse<String> checkAccountExists(String account);
	
	/**
	 * 根据用户账号（账户名/手机号/邮箱）修改密码
	 * @param account  账号
	 * @param password  密码
	 * @param newPassword  新密码
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> updatePassword(String account,String password,String newPassword,String operatorName);
	
	/**
	 * 添加用户
	 * @param sysUser  用户实体
	 * @return 
	 */
	ReqResponse<Integer> addUser(SysUser sysUser);

	/**
	 * 根据用户账号（账户名）修改密码
	 * @param account  账号
	 * @param password  密码
	 * @return
	 */
	ReqResponse<String> updatePasswordByAccount(String account, String password,String operatorName);

	/**
	 * 根据用户手机号修改密码
	 * @param phone  手机号
	 * @param password  密码
	 * @return
	 */
	ReqResponse<String> updatePasswordByPhone(String phone, String password);


	/**
	 * 根据用户id修改用户头像
	 * @param user_id 用户id
	 * @param headimgurl 头像URL地址
	 * @return
	 */
	ReqResponse<String> updateHeadImg(String user_id, String headimgurl);


	/**
	 * 根据用户id修改用户基本信息（该接口仅支持修改昵称、性别、生日登基本用户信息，不支持修改用户密码 、头像操作）
	 * @param sysUser  用户实体
	 * @return
	 */
	ReqResponse<String> updateUserInfo(SysUser sysUser);

	/**
	 * 用户绑定手机号
	 * @param user_id  用户ID
	 * @param phone  手机号
	 * @return true 修改成功  false 修改失败
	 */
	ReqResponse<String> bindPhone(String user_id, String phone);
	
	/**
	 * 用户更换手机号
	 * @param phone  手机号
	 * @param newPhone  新手机号
	 * @return
	 */
	ReqResponse<String> updatePhone(String phone, String newPhone);
	
	
}
