package com.shifeng.op.authority.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shifeng.op.entity.authority.Arrays;
import com.shifeng.op.entity.users.Users;


/**
 * 项目名：compass-data
 * 类描述：角色分组
 * 创建人：sen
 */
@Service("arraysService")
public interface ArraysService {
	
	/**
	 * 方法描述：获取所有分组集合
	 * 返回类型：List<Arrays>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Arrays> getArrayList(Users user) throws Exception; 
	
	/**
	 * 方法描述：添加分组
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> insertArray(Map<String,Object> map) throws Exception;
	
	/**
	 * 方法描述：删除分组
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> deleteArray(Map<String,Object> map) throws Exception ;
	
	/**
	 * 方法描述：根据分组ID获取分组
	 * 返回类型：Arrays
	 * @param aId
	 * @return
	 * @throws Exception
	 */
	public Arrays getArrayById(String aId) throws Exception;
	
	/**
	 * 方法描述：更新分组
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> updateArray(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取系统管理分组
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getSysArrayList() throws Exception; 
}
