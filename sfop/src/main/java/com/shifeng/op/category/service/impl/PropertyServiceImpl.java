package com.shifeng.op.category.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Property;
import com.shifeng.op.category.service.PropertyService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const; 

/** 
 * 属性表(p_property)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
@Service("propertyServiceImpl")
public class PropertyServiceImpl implements PropertyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Property> findAllProperty(String name) throws Exception{
		if(StringUtils.isEmpty(name)){
			name = "";
		}
		return (List<Property>) dao.findForList("propertyMapper.findAllProperty",name);
	}
	
	/**
	 * 根据ID查询品牌
	 */
	public Property findPropertyById(String id) throws Exception{
		return (Property) dao.findForObject("propertyMapper.findPropertyById", id);
	}
	
	/**
	 * 新增品牌
	 * @param dto
	 * @throws Exception
	 */
	public void saveProperty(Property property) throws Exception{
		dao.save("propertyMapper.saveProperty", property);
	}
	
	/**
	 * 修改品牌
	 * @param property
	 * @throws Exception
	 */
	public void updateProperty(Property property) throws Exception{
		dao.update("propertyMapper.updateProperty", property);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProperty(String id,Map<String,Object> map) throws Exception{
		int count = (int)dao.findForObject("propertycategoryMapper.findPropertyCountByPid", id);
		if(count==0){
			//删除属性
			dao.delete("propertyMapper.deleteProperty", id);
			//删除该属性所有属性值
			dao.delete("propertyvalueMapper.deletePropertyvalueByPid", id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.ERROR_INFO, "该属性已经关联了分类，请前往[分类管理]解除分类属性关联，再进行删除属性操作!");
		}
	}
	
}
