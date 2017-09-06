package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysAppHomeadWare;
import com.shifeng.plugin.page.Page;

/** 
 * app首页广告商品(sys_app_homead_ware)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-16 18:50:00 
 */  
public interface SysAppHomeadWareService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppHomeadWare> findAllSysAppHomeadWare(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysAppHomeadWare findSysAppHomeadWareById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param sysapphomeadware
	 * @throws Exception
	 */
	public void updateSysAppHomeadWare(SysAppHomeadWare sysapphomeadware) throws Exception;
	
	/**
	 * 新增
	 * @param sysapphomeadware
	 * @throws Exception
	 */
	public void saveSysAppHomeadWare(SysAppHomeadWare sysapphomeadware) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppHomeadWare(String id) throws Exception;
	
}
