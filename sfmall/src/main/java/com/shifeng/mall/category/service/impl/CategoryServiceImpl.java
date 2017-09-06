package com.shifeng.mall.category.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Category;
import com.shifeng.mall.category.service.CategoryService;

/** 
 * 分类表(c_category)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-13 11:33:30 
 */  
@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有父分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllParentCategory(String name) throws Exception{
		return (List<Category>) dao.findForList("categoryMapper.findAllParentCategory",name);
	}
	
	/**
	 * 根据父类ID查询
	 */
	public List<Category> findCategoryByPid(String id) throws Exception{
		return (List<Category>) dao.findForList("categoryMapper.findCategoryByPid", id);
	}

}
