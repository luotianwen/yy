package com.shifeng.seller.property.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Propertyvalue;
import com.shifeng.seller.property.service.PropertyvalueService; 

/** 
 * 属性值表(p_propertyvalue)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
@Service("propertyvalueServiceImpl")
public class PropertyvalueServiceImpl implements PropertyvalueService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据属性ID查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Propertyvalue> findAllPropertyvalue(String id) throws Exception{
		return (List<Propertyvalue>) dao.findForList("propertyvalueMapper.findAllPropertyvalue", id);
	}
	
	
}
