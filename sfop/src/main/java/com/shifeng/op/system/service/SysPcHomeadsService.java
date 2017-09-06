package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysPcHomeads;
import com.shifeng.plugin.page.Page;

/** 
 * pc首页广告(sys_pc_homeads)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */  
public interface SysPcHomeadsService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysPcHomeads> findAllSysPcHomeads(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysPcHomeads findSysPcHomeadsById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param syspchomeads
	 * @throws Exception
	 */
	public void updateSysPcHomeads(SysPcHomeads syspchomeads) throws Exception;
	
	/**
	 * 新增
	 * @param syspchomeads
	 * @throws Exception
	 */
	public void saveSysPcHomeads(SysPcHomeads syspchomeads) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysPcHomeads(String id) throws Exception;
	
}
