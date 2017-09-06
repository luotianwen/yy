package com.shifeng.op.category.service;

import java.util.List;

import com.shifeng.entity.category.Propertyvalue;
import com.shifeng.plugin.page.Page;
/** 
 * 属性值表(p_propertyvalue)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
public interface PropertyvalueService {

	/**
	 * 查询所有属性值
	 * @param id 属性ID
	 * @return
	 * @throws Exception
	 */
	public List<Propertyvalue> findAllPropertyvalue(String id) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Propertyvalue findPropertyvalueById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param propertyvalue
	 * @throws Exception
	 */
	public void updatePropertyvalue(Propertyvalue propertyvalue) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void savePropertyvalue(Propertyvalue propertyvalue) throws Exception;
    
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePropertyvalue(String id) throws Exception;
	
}
