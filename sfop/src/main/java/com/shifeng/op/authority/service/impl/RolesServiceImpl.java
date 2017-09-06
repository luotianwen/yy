package com.shifeng.op.authority.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.op.authority.service.RolesService;
import com.shifeng.util.Const;


@Service("rolesServiceImpl")
public class RolesServiceImpl implements RolesService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 方法描述：添加角色
	 * 实现接口：@see com.op.service.authority.RolesService#addRole(java.util.Map)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> addRole(Map<String, Object> map) throws Exception {
		dao.save("rolesMapper.addRole", map.get("role"));
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return map;
	}

	/**
	 * 方法描述：delete
	 * 实现接口：@see com.op.service.authority.RolesService#deleteRole(java.util.Map)
	 * @description
	 * 		check：判断是否与用户关联
	 * 		delete：角色表、权限表（角色对应菜单表集合）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> deleteRoleByRId(Map<String, Object> map) throws Exception {
		// 检索该角色之下是否拥有用户
		int num = (int) dao.findForObject("UsersMapper.deleteRoleFindUser", map.get("rId"));
		if(num > 0){
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "该角色已与用户关联，不可进行删除操作!");
			return map;
		}
		// 角色表
		dao.delete("rolesMapper.deleteRoleByRId", map.get("rId"));
		// 权限表（角色对应菜单表集合）
		dao.delete("authorizationMapper.deleteAuthorByRId", map.get("rId"));
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return null;
	}

	/**
	 * 方法描述：更新角色
	 * 实现接口：@see com.op.service.authority.RolesService#updateRole(java.util.Map)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> updateRole(Map<String, Object> map) throws Exception {
		dao.update("rolesMapper.updateRoleByRId", map.get("role"));
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return map;
	}

	/**
	 * 根据分组Id获取分组下的所有角色
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getSysUserRoleByaId(String aId) throws Exception{
		
		return (List<Map<String,Object>>) dao.findForList("rolesMapper.getSysUserRoleByaId", aId);
	}
}
