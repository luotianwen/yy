package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysPcHomeadWare;
import com.shifeng.plugin.page.Page;

/** 
 * pc首页广告商品(sys_pc_homead_ware)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */  
public interface SysPcHomeadWareService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysPcHomeadWare> findAllSysPcHomeadWare(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysPcHomeadWare findSysPcHomeadWareById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param syspchomeadware
	 * @throws Exception
	 */
	public void updateSysPcHomeadWare(SysPcHomeadWare syspchomeadware) throws Exception;
	
	/**
	 * 新增
	 * @param syspchomeadware
	 * @throws Exception
	 */
	public void saveSysPcHomeadWare(SysPcHomeadWare syspchomeadware) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysPcHomeadWare(String id) throws Exception;
	
}
