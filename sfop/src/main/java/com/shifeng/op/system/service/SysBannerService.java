package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysBanner;
import com.shifeng.plugin.page.Page;

/** 
 * 系统banner(sys_banner)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public interface SysBannerService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysBanner> findAllSysBanner(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysBanner findSysBannerById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param sysbanner
	 * @throws Exception
	 */
	public void updateSysBanner(SysBanner sysbanner) throws Exception;
	
	/**
	 * 新增
	 * @param sysbanner
	 * @throws Exception
	 */
	public void saveSysBanner(SysBanner sysbanner) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysBanner(String id) throws Exception;
	
}
