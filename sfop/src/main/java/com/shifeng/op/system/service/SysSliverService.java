package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysSliver;
import com.shifeng.plugin.page.Page;

/** 
 * 银币设置(sys_sliver)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 19:10:30 
 */  
public interface SysSliverService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysSliver> findAllSysSliver(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysSliver findSysSliverById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param syssliver
	 * @throws Exception
	 */
	public void updateSysSliver(SysSliver syssliver) throws Exception;
	
	/**
	 * 新增
	 * @param syssliver
	 * @throws Exception
	 */
	public void saveSysSliver(SysSliver syssliver) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysSliver(String id) throws Exception;
	
}
