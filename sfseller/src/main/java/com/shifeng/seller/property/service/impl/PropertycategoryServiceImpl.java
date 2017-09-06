package com.shifeng.seller.property.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.seller.property.dto.PropertyCategoryDTO;
import com.shifeng.seller.property.service.PropertycategoryService; 

/** 
 * 分类属性关联表(p_propertycategory)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
@Service("propertycategoryServiceImpl")
public class PropertycategoryServiceImpl implements PropertycategoryService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据分类查询所有分类属性
	 * @param id 分类ID
	 * @return
	 * @throws Exception
	 */
	public List<PropertyCategoryDTO> findAllPropertycategoryByCid(String id,String parentid) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("parentid", parentid);
		return (List<PropertyCategoryDTO>) dao.findForList("propertycategoryMapper.findAllPropertycategoryByCid", map);
	}
	
	
}
