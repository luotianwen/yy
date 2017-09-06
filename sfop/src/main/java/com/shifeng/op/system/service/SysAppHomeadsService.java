package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysAppHomeads;
import com.shifeng.plugin.page.Page;

/** 
 * app首页广告(sys_app_homeads)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-16 18:49:59 
 */  
public interface SysAppHomeadsService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppHomeads> findAllSysAppHomeads(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysAppHomeads findSysAppHomeadsById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param sysapphomeads
	 * @throws Exception
	 */
	public void updateSysAppHomeads(SysAppHomeads sysapphomeads) throws Exception;
	
	/**
	 * 新增
	 * @param sysapphomeads
	 * @throws Exception
	 */
	public void saveSysAppHomeads(SysAppHomeads sysapphomeads) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppHomeads(String id) throws Exception;
	
}
