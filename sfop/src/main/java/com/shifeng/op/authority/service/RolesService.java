package com.shifeng.op.authority.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 项目名：compass-data
 * 类描述：角色Service
 * 创建人：sen
 */
@Service("rolesService")
public interface RolesService {
	
	/**
	 * 方法描述：添加角色
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> addRole(Map<String,Object> map)throws Exception;
	
	/**
	 * 方法描述：根据角色ID删除角色
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> deleteRoleByRId(Map<String,Object> map)throws Exception;
	
	/**
	 * 方法描述：更新角色
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> updateRole(Map<String,Object> map)throws Exception;
	
	/**
	 * 根据分组Id获取分组下的所有角色
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getSysUserRoleByaId(String aId) throws Exception;
}
