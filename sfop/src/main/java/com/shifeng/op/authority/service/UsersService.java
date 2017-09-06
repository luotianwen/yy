package com.shifeng.op.authority.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shifeng.op.entity.users.UserInfo;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;


@Service("usersService")
public interface UsersService {
	
	/**
	 * 检查用户名密码是否正确     用户登录
	 * @param user
	 * @return
	 */
	public Users loginUserByPhoneOrEmail(Users user);
	
	/**
	 * 获取用户列表
	 * @param page
	 * @return
	 */
	List<Users> getUsersListPage(Page<?> page) throws Exception;
	/**
	 * 根据用户ID获取用户详细信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	UserInfo findUserById(String userId) throws Exception;
	

	
/*******************************系统用户********************************************************/	
	
	
	/**
	 * 获取后台管理用户列表
	 * @param page
	 * @return
	 */
	List<Users> getSysListPage(Page<?> page) throws Exception;	
	
	/**
	 * 根据用户ID获取系统用户详细信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	UserInfo findSysUserById(String userId) throws Exception;
	

	
	/**
	 * 添加系统管理用户
	 * @param map
	 * @param user2
     * @return
	 * @throws Exception
	 */
	Map<String,Object> saveSysUser(Map<String, Object> map, Users user2) throws Exception;

	
	/**
	 * 更改用户冻结 解冻状态

	 * @return
	 * @throws Exception
	 */
	void updateUserFrozenTypeByUid(String uId, Users user2) throws Exception;

	/**
	 * 方法描述：更新用户角色
	 * 返回类型：void
	 * @param map
	 * @throws Exception
	 */
	public void updateUserRole(Map<String,Object> map) throws Exception;
	
	/**
	 * 删除系统用户
     * @param userId
     * @param user
     */
	void deleteSysUser(String userId, Users user)throws Exception;
	
	/**
	 * 方法描述：更新用户登录状态
	 * 返回类型：void
	 * @param user
	 * @throws Exception
	 */
	void updateUserLoginInfo(Users user) throws Exception;


	/**
	 * 修改系统用户密码
	 * @param map
	 * @param uPassword
	 * @param newPassword
	 * @param user @throws Exception
	 */
	void updateSysUserPassword(Map<String, Object> map, String uPassword, String newPassword, Users user) throws Exception;

	
}
