package com.shifeng.op.category.service;

import java.util.List;

import com.shifeng.entity.category.Propertycategory;
import com.shifeng.plugin.page.Page;
/** 
 * 分类属性关联表(p_propertycategory)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */  
public interface PropertycategoryService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Propertycategory> findAllPropertycategory(Page page) throws Exception;
	
	/**
	 * 根据分类查询所有分类属性
	 * @param id 分类ID
	 * @return
	 * @throws Exception
	 */
	public List<Propertycategory> findAllPropertycategoryByCid(String id,String parentid) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Propertycategory findPropertycategoryById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param propertycategory
	 * @throws Exception
	 */
	public void updatePropertycategory(Propertycategory propertycategory) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void savePropertycategory(Propertycategory propertycategory) throws Exception;
    
	/**
	 * 删除
	 * @param id
	 * @param uname
	 * @throws Exception
	 */
	public void deletePropertycategory(String id) throws Exception;
	
}
