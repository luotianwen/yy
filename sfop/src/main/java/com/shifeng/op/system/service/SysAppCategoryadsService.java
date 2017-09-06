package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysAppCategoryads;
import com.shifeng.plugin.page.Page;

/** 
 * app类目广告(sys_app_categoryads)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-15 15:46:41 
 */  
public interface SysAppCategoryadsService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppCategoryads> findAllSysAppCategoryads(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysAppCategoryads findSysAppCategoryadsById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param sysappcategoryads
	 * @throws Exception
	 */
	public void updateSysAppCategoryads(SysAppCategoryads sysappcategoryads) throws Exception;
	
	/**
	 * 新增
	 * @param sysappcategoryads
	 * @throws Exception
	 */
	public void saveSysAppCategoryads(SysAppCategoryads sysappcategoryads) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppCategoryads(String id) throws Exception;
	
}
