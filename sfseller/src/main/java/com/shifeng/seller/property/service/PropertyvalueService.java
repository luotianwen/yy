package com.shifeng.seller.property.service;

import java.util.List;

import com.shifeng.entity.category.Propertyvalue;
/** 
 * 属性值表(p_propertyvalue)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
public interface PropertyvalueService {

	/**
	 * 根据属性ID查询所有属性值
	 * @param id 属性ID
	 * @return
	 * @throws Exception
	 */
	public List<Propertyvalue> findAllPropertyvalue(String id) throws Exception;
	
}
