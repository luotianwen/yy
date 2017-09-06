package com.shifeng.op.category.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Propertyvalue;
import com.shifeng.op.category.service.PropertyvalueService;
import com.shifeng.plugin.page.Page; 

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
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Propertyvalue> findAllPropertyvalue(String id) throws Exception{
		return (List<Propertyvalue>) dao.findForList("propertyvalueMapper.findAllPropertyvalue", id);
	}
	
	/**
	 * 根据ID查询品牌
	 */
	public Propertyvalue findPropertyvalueById(String id) throws Exception{
		return (Propertyvalue) dao.findForObject("propertyvalueMapper.findPropertyvalueById", id);
	}
	
	/**
	 * 新增品牌
	 * @param dto
	 * @throws Exception
	 */
	public void savePropertyvalue(Propertyvalue propertyvalue) throws Exception{
		dao.save("propertyvalueMapper.savePropertyvalue", propertyvalue);
	}
	
	/**
	 * 修改品牌
	 * @param propertyvalue
	 * @throws Exception
	 */
	public void updatePropertyvalue(Propertyvalue propertyvalue) throws Exception{
		dao.update("propertyvalueMapper.updatePropertyvalue", propertyvalue);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePropertyvalue(String id) throws Exception{
		dao.delete("propertyvalueMapper.deletePropertyvalue", id);
	}
	
}
