package com.shifeng.op.category.service;

import java.util.List;

import com.shifeng.entity.category.Navigation;
import com.shifeng.plugin.page.Page;
/** 
 * 导航表(p_navigation)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 14:37:55 
 */  
public interface NavigationService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Navigation> findAllNavigation(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Navigation findNavigationById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param navigation
	 * @throws Exception
	 */
	public void updateNavigation(Navigation navigation) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveNavigation(Navigation navigation) throws Exception;
    
	/**
	 * 删除
	 * @param id
	 * @param name
	 * @throws Exception
	 */
	public void deleteNavigation(String id,String name) throws Exception;
	
}
