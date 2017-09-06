package com.shifeng.mall.category.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.CategoryFee;
import com.shifeng.mall.category.service.CategoryFeeService;

/** 
 * 分类费用(c_category_fee)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 17:44:46 
 */  
@Service("categoryfeeServiceImpl")
public class CategoryFeeServiceImpl implements CategoryFeeService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据ID查询品牌
	 */
	public CategoryFee findCategoryFeeById(String id) throws Exception{
		return (CategoryFee) dao.findForObject("categoryfeeMapper.findCategoryFeeById", id);
	}
	
}
