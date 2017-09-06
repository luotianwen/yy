package com.shifeng.seller.property.service;

import java.util.List;

import com.shifeng.entity.category.Propertycategory;
import com.shifeng.seller.property.dto.PropertyCategoryDTO;
/** 
 * 分类属性关联表(p_propertycategory)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
public interface PropertycategoryService {
	
	/**
	 * 根据分类查询所有分类属性
	 * @param id 分类ID
	 * @return
	 * @throws Exception
	 */
	public List<PropertyCategoryDTO> findAllPropertycategoryByCid(String id,String parentid) throws Exception;
	
	
}
