package com.shifeng.op.category.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Propertycategory;
import com.shifeng.op.category.service.PropertycategoryService;
import com.shifeng.plugin.page.Page; 

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
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Propertycategory> findAllPropertycategory(Page page) throws Exception{
		return (List<Propertycategory>) dao.findForList("propertycategoryMapper.findAllPropertycategoryPage", page);
	}
	
	/**
	 * 根据分类查询所有分类属性
	 * @param id 分类ID
	 * @return
	 * @throws Exception
	 */
	public List<Propertycategory> findAllPropertycategoryByCid(String id,String parentid) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("parentid", parentid);
		return (List<Propertycategory>) dao.findForList("propertycategoryMapper.findAllPropertycategoryByCid", map);
	}
	
	/**
	 * 根据ID查询品牌
	 */
	public Propertycategory findPropertycategoryById(String id) throws Exception{
		return (Propertycategory) dao.findForObject("propertycategoryMapper.findPropertycategoryById", id);
	}
	
	/**
	 * 新增品牌
	 * @param dto
	 * @throws Exception
	 */
	public void savePropertycategory(Propertycategory propertycategory) throws Exception{
		dao.save("propertycategoryMapper.savePropertycategory", propertycategory);
	}
	
	/**
	 * 修改品牌
	 * @param propertycategory
	 * @throws Exception
	 */
	public void updatePropertycategory(Propertycategory propertycategory) throws Exception{
		dao.update("propertycategoryMapper.updatePropertycategory", propertycategory);
	}
	
	/**
	 * 删除
	 * @param id
	 * @param uname
	 * @throws Exception
	 */
	public void deletePropertycategory(String id) throws Exception{
		dao.delete("propertycategoryMapper.deletePropertycategory", id);
	}
	
}
