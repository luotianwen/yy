package com.shifeng.op.category.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.category.Category;
/** 
 * 分类表(c_category)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-13 11:33:30 
 */
import com.shifeng.op.dto.category.CategoryDTO;
import com.shifeng.plugin.page.Page;  
public interface CategoryService {

	/**
	 * 查询所有分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllCategory(Page page) throws Exception;
	
	/**
	 * 查询所有父分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllParentCategory() throws Exception;
	
	/**
	 * 根据父类ID查询
	 */
	public List<Category> findCategoryByPid(String id) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Category findCategoryById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param category
	 * @throws Exception
	 */
	public void updateCategory(Category category) throws Exception;
	
	/**
	 * 新增
	 * @throws Exception
	 */
	public void saveCategory(Category category) throws Exception;
    
	/**
	 * 删除分类
	 * @param id

	 * @throws Exception
	 */
	public void deleteCategory(String id,String uname) throws Exception;
	
	/**
	 * 查询所有分类
	 * @return
	 * @throws Exception
	 */
	public List<CategoryDTO> findAllCategoryForNavigation(String id) throws Exception;
	/**
	 * 查询全部可用所有分类
	 * @return
	 * @throws Exception
	 */
	public List<CategoryDTO> findAllCategoryState() throws Exception;
}
