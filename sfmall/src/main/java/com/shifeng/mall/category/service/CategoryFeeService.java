package com.shifeng.mall.category.service;

import com.shifeng.entity.category.CategoryFee;

/** 
 * 分类费用(c_category_fee)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 17:44:46 
 */  
public interface CategoryFeeService {
	
	/**
	 * 根据ID查询
	 */
	public CategoryFee findCategoryFeeById(String id) throws Exception;
	
}
