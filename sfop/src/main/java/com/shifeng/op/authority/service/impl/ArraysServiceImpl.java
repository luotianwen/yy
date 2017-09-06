package com.shifeng.op.authority.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.op.entity.authority.Arrays;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.authority.service.ArraysService;
import com.shifeng.util.Const;


@Service("arraysServiceImpl")
public class ArraysServiceImpl implements ArraysService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 方法描述：查询分组
	 * 实现接口：@see com.op.service.authority.ArraysService#getArrayList(java.lang.String)
	 * @param uId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Arrays> getArrayList(Users user) throws Exception {
		// TODO Auto-generated method stub
		return (List<Arrays>) dao.findForList("arraysMapper.getArrayList", user);
	}

	/**
	 * 方法描述：添加分组数据
	 * 实现接口：@see com.op.service.authority.ArraysService#insertArray()
	 * @return
	 */
	@Override
	public Map<String, Object> insertArray(Map<String,Object> map)  throws Exception{
		dao.save("arraysMapper.insertArray", map.get("array"));
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return map;
	}

	/**
	 * 方法描述：删除分组
	 * 实现接口：@see com.op.service.authority.ArraysService#deleteArray(java.util.Map)
	 * @description
	 * 	check：判断该分组所包含角色是否与用户关联
	 * 	delete：对应的所有角色、角色对应的所有权限、分组
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> deleteArray(Map<String, Object> map) throws Exception {
		// 查询该分组所包含角色是否关联用户
		int num = (int) dao.findForObject("arraysMapper.findArrayRolesUsersNum", map.get("aId"));
		if(num > 0){
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "改分组所包含角色已经关联至用户，请解除用户与该分组包含的所有角色的绑定，再进行删除操作!");
			return map;
		}
		// 删除分组
		dao.delete("arraysMapper.deleteArray", map.get("aId"));
		// 查询该分组对应的角色ID集合（删除角色对应的权限）
		List<String> ids = (List<String>) dao.findForList("rolesMapper.selectRoleIdByAId", map.get("aId"));
		if(ids.size()>0){
			dao.delete("authorizationMapper.deleteAuthorByRIds", ids);
			// 删除角色
			dao.delete("rolesMapper.deleteRoleByAid", map.get("aId"));
		}
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return map;
	}

	/**
	 * 方法描述：根据AID查询分组
	 * 实现接口：@see com.op.service.authority.ArraysService#getArrayById()
	 * @return
	 * @throws Exception
	 */
	@Override
	public Arrays getArrayById(String aId) throws Exception {
		
		return (Arrays) dao.findForObject("arraysMapper.getArrayById", aId);
	}

	/**
	 * 方法描述：更新
	 * 实现接口：@see com.op.service.authority.ArraysService#updateArray(java.util.Map)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> updateArray(Map<String, Object> map) throws Exception {
		dao.update("arraysMapper.updateArray", map.get("array"));
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return map;
	}
 
	
	/**
	 * 获取系统管理分组
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getSysArrayList() throws Exception{
		return (List<Map<String,Object>>) dao.findForList("arraysMapper.getSysArrayList", null);
	}

	
	
	
}
