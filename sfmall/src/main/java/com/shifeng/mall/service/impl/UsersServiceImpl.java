package com.shifeng.mall.service.impl;

import com.shifeng.dao.BaseDao;

import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.service.UsersService;
import com.shifeng.provide.sysuser.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	@Resource(name = "sysUserService")
	private SysUserService sysUserService;
	
	
	
	/**
	 * 方法描述：利用手机号或者邮箱登录
	 * @param user
	 * @return
	 */
	@Override
	public Users loginUserByPhoneOrEmail(Users user){
		try {
			user = (Users) dao.findForObject("UsersMapper.loginUserByPhoneOrEmail", user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	/**
	 * 方法描述： 改变用户登录信息（IP、最后登录时间、登录次数）
	 * @param user
	 * @throws Exception
	 */
	@Override
	public void updateUserLoginInfo(Users user) throws Exception {
		user.setuLoginDate(new Date());// 最后登录时间
		user.setuLoginCount(user.getuLoginCount()+1);// 登录次数
		dao.update("UsersMapper.updateUserLoginInfo", user);
	}
}
