package com.shifeng.op.authority.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.user.SysUser;
import com.shifeng.op.authority.service.UsersService;
import com.shifeng.op.entity.users.UserInfo;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.MD5Util;


@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	@Resource(name = "sysUserService")
	private SysUserService sysUserService;
	
	
	
	/**
	 * 方法描述：利用手机号或者邮箱登录
	 * 实现接口：@see com.shifeng.op.authority.service.UsersService#loginUserByPhoneOrEmail(com.op.entity.users.Users)
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
	 * 获取用户列表
	 * @param page
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<Users> getUsersListPage(Page<?> page) throws Exception{
		return  (List<Users>) dao.findForList("UsersMapper.getUsersListPage", page);
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
	 * 添加系统管理用户
	 * @param map
	 * @param user2
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> saveSysUser(Map<String, Object> map, Users user2) throws Exception{
		Users user = (Users)map.get("user");
		//新增用户
		if(StringUtils.isEmpty(user.getuId())){
			SysUser sysUser=new SysUser();
			sysUser.setName(user.getuName());
			sysUser.setAccount(user.getuName());
			sysUser.setPassword(user.getuPassword());
			sysUser.setUpdatename(user2.getuName());
			ReqResponse<Integer> response = sysUserService.addUser(sysUser);
			if(0==response.getCode())
			{
				user.setuId(response.getData().toString());
				user.setuCreateTime(new Date());// 用户创建时间
				//设置用户身份
				user.setuType(4);
				//设置登录次数
				user.setuLoginCount(0);
				user.setuCreateTime(new Date());
				user.setuPassword(MD5Util.hex(user.getuPassword()));
				try {
					dao.save("UsersMapper.saveSysUser", user);
					map.clear();
					map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
				}catch (Exception e){
					map.clear();
					map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
				}

			}
			else{
				map.clear();
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
				map.put(Const.ERROR_INFO, response.getMsg());
			}
		}else{
			if(!StringUtils.isEmpty(map.get("newPassword"))){
				//设置新密码
				user.setuPassword(MD5Util.hex(map.get("newPassword").toString()));
			}
			dao.update("UsersMapper.updateSysUser", user);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}


		return map;
	}

	
	/**
	 * 更改用户冻结 解冻状态
	 * @return
	 * @throws Exception
	 */
	public void updateUserFrozenTypeByUid(String uId, Users user2) throws Exception{

		dao.update("UsersMapper.updateUserFrozenTypeByUid", uId);
	}
	

	/**
	 * 方法描述：更新用户角色
	 * 实现接口：@see com.shifeng.op.service.authority.RolesService#updateUserRole(java.util.Map)
	 * @param map {uId:'用户ID',rId:'角色ID'}
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updateUserRole(Map<String, Object> map) throws Exception {
		// 判断当前用户是否冻结
		int isFroZen = (int) dao.findForObject("UsersMapper.checkUserIsFroZen", map.get("uId")+"");
		if(isFroZen == 1){
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "该用户已冻结，不可操作!");
		}
		dao.update("UsersMapper.updateUserRoleByUid", map);
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}
	
	/**
	 * 删除系统用户
	 * @param userId
	 * @param user
	 */
	@Override
	public void deleteSysUser(String userId, Users user) throws Exception {

		sysUserService.updateUserState(Integer.parseInt(userId),2,user.getuName());

		dao.delete("UsersMapper.deleteSysUser", userId);

	}


	/**
	 * 方法描述： 改变用户登录信息（IP、最后登录时间、登录次数）
	 * 实现接口：@see com.shifeng.op.authority.service.UsersService#updateUsersLoginInfo(com.op.entity.users.Users)
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
	 * @param uPassword
	 * @param newPassword
	 * @param user @throws Exception
	 */
	@Override
	public void updateSysUserPassword(Map<String, Object> map, String uPassword, String newPassword, Users user) throws Exception{
	    sysUserService.updatePassword(user.getuName(),uPassword,newPassword,user.getuName());
		dao.update("UsersMapper.updateSysUserPassword", map);
	}

	
}
