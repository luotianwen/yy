package com.shifeng.op.category.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.CategoryFee;
import com.shifeng.op.category.service.CategoryFeeService;
import com.shifeng.plugin.page.Page;

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
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CategoryFee> findAllCategoryFee(Page page) throws Exception{
		return (List<CategoryFee>) dao.findForList("categoryfeeMapper.findAllCategoryFeePage", page);
	}
	
	/**
	 * 根据ID查询品牌
	 */
	public CategoryFee findCategoryFeeById(String id) throws Exception{
		return (CategoryFee) dao.findForObject("categoryfeeMapper.findCategoryFeeById", id);
	}
	
	/**
	 * 新增品牌
	 * @param dto
	 * @throws Exception
	 */
	public void saveCategoryFee(CategoryFee categoryfee) throws Exception{
		dao.save("categoryfeeMapper.saveCategoryFee", categoryfee);
	}
	
	/**
	 * 修改品牌
	 * @param categoryfee
	 * @throws Exception
	 */
	public void updateCategoryFee(CategoryFee categoryfee) throws Exception{
		int count = (int) dao.update("categoryfeeMapper.updateCategoryFee", categoryfee);
		if(count==0){
			saveCategoryFee(categoryfee);
		}
	}
	
	
}
