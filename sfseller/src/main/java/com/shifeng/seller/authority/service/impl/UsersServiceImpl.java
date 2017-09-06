package com.shifeng.seller.authority.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.seller.entity.users.UserInfo;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.authority.service.UsersService;
import com.shifeng.util.Const;
import com.shifeng.util.MD5Util;


@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	
	
	
	/**
	 * 方法描述：利用手机号或者邮箱登录
	 * 实现接口：@see com.shifeng.seller.authority.service.UsersService#loginUserByPhoneOrEmail(com.op.entity.users.Users)
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
	 * 根据用户ID获取用户详细信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserInfo findUserById(String userId) throws Exception{
		return (UserInfo) dao.findForObject("UsersMapper.findUserById", userId);
	}
	
	
	/**
	 * 获取后台管理用户列表
	 * @param page
	 * @return
	 */
	public List<Users> getSysListPage(Page<?> page) throws Exception{
		return  (List<Users>) dao.findForList("UsersMapper.getSysListPage", page);
	}
	
	/**
	 * 根据用户ID获取系统用户详细信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserInfo findSysUserById(String userId) throws Exception{
		return (UserInfo) dao.findForObject("UsersMapper.findSysUserById", userId);
	}

	/**
	 * 更改用户冻结 解冻状态
	　
	 * @return
	 * @throws Exception
	 */
	public void updateUserFrozenTypeByUid(String uId) throws Exception{
		dao.update("UsersMapper.updateUserFrozenTypeByUid", uId);
	}
	



	/**
	 * 方法描述： 改变用户登录信息（IP、最后登录时间、登录次数）
	 * 实现接口：@see com.shifeng.seller.authority.service.UsersService#updateUsersLoginInfo(com.op.entity.users.Users)
	 * @param user
	 * @throws Exception
	 */
	@Override
	public void updateUserLoginInfo(Users user) throws Exception {
		user.setuLoginDate(new Date());// 最后登录时间
		user.setuLoginCount(user.getuLoginCount()+1);// 登录次数
		dao.update("UsersMapper.updateUserLoginInfo", user);
	}
	
	/**
	 * 修改系统用户密码
	 * @param map
	 * @throws Exception
	 */
	public void updateSysUserPassword(Map<String,Object> map) throws Exception{
		dao.update("UsersMapper.updateSysUserPassword", map);
	}

	
}
