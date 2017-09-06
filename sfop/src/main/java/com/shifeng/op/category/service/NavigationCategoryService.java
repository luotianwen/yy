package com.shifeng.op.category.service;

import java.util.List;
import com.shifeng.entity.category.NavigationCategory;
import com.shifeng.op.dto.category.NavigationCategoryDTO;
import com.shifeng.plugin.page.Page;
/** 
 * 分类导航关联表(p_navigation_category)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 14:37:55 
 */  
public interface NavigationCategoryService {

	/**
	 * 查询所有导航分类
	 * @return
	 * @throws Exception
	 */
	public List<NavigationCategoryDTO> findAllNavigationCategoryByNid(String id) throws Exception;
	
	/**
	 * 根据父分类查询所有子分类
	 * @return
	 * @throws Exception
	 */
	public List<NavigationCategoryDTO> findAllNavigationCategoryByPid(String id,String nid) throws Exception;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<NavigationCategory> findAllNavigationCategory(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public NavigationCategory findNavigationCategoryById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param navigationcategory
	 * @throws Exception
	 */
	public void updateNavigationCategory(NavigationCategory navigationcategory) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveNavigationCategory(String id,String ids,String uName) throws Exception;
    
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteNavigationcategory(String id) throws Exception;
	
}
