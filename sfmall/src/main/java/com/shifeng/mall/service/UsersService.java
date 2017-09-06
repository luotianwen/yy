package com.shifeng.mall.service;

import com.shifeng.mall.entity.user.Users;
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
	 * 方法描述：更新用户登录状态
	 * 返回类型：void
	 * @param user
	 * @throws Exception
	 */
	void updateUserLoginInfo(Users user) throws Exception;

	

}
