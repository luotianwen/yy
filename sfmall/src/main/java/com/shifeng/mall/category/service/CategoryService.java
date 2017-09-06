package com.shifeng.mall.category.service;

import java.util.List;

import com.shifeng.entity.category.Category;  
public interface CategoryService {

	/**
	 * 查询所有父分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllParentCategory(String name) throws Exception;
	
	/**
	 * 根据父类ID查询
	 */
	public List<Category> findCategoryByPid(String id) throws Exception;
	
}
