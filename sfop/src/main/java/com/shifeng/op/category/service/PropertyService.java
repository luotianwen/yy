package com.shifeng.op.category.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.category.Property;
import com.shifeng.plugin.page.Page;
/** 
 * 属性表(p_property)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
public interface PropertyService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Property> findAllProperty(String name) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Property findPropertyById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param property
	 * @throws Exception
	 */
	public void updateProperty(Property property) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveProperty(Property property) throws Exception;
    
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProperty(String id,Map<String,Object> map) throws Exception;
	
}
