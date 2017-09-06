package com.shifeng.op.category.service;

import java.util.List;
import com.shifeng.entity.category.CategoryFee;
import com.shifeng.plugin.page.Page;

/** 
 * 分类费用(c_category_fee)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 17:44:46 
 */  
public interface CategoryFeeService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CategoryFee> findAllCategoryFee(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public CategoryFee findCategoryFeeById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param categoryfee
	 * @throws Exception
	 */
	public void updateCategoryFee(CategoryFee categoryfee) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveCategoryFee(CategoryFee categoryfee) throws Exception;
    

	
}
