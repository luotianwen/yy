package com.shifeng.seller.authority.service;

import com.shifeng.seller.entity.users.UserInfo;
import com.shifeng.seller.entity.users.Users;
import org.springframework.stereotype.Service;


@Service("usersService")
public interface UsersService {
	
	/**
	 * 检查用户名密码是否正确     用户登录
	 * @param user
	 * @return
	 */
	public Users loginUserByPhoneOrEmail(Users user);

	/**
	 * 根据用户ID获取用户详细信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	UserInfo findUserById(String userId) throws Exception;



/*******************************系统用户********************************************************/



	/**
	 * 根据用户ID获取系统用户详细信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	UserInfo findSysUserById(String userId) throws Exception;



	/**
	 * 更改用户冻结 解冻状态

	 * @return
	 * @throws Exception
	 */
	void updateUserFrozenTypeByUid(String uId) throws Exception;

	/**
	 * 方法描述：更新用户登录状态
	 * 返回类型：void
	 * @param user
	 * @throws Exception
	 */
	void updateUserLoginInfo(Users user) throws Exception;



}
