package com.shifeng.op.shop.service;

import java.util.List;
import com.shifeng.entity.shop.StoreSupervisor;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺负责人员(s_store_supervisor)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
public interface StoreSupervisorService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<StoreSupervisor> findAllStoreSupervisor(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public StoreSupervisor findStoreSupervisorById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param storesupervisor
	 * @throws Exception
	 */
	public void updateStoreSupervisor(StoreSupervisor storesupervisor) throws Exception;
	
	/**
	 * 新增
	 * @param storesupervisor
	 * @throws Exception
	 */
	public void saveStoreSupervisor(StoreSupervisor storesupervisor) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteStoreSupervisor(String id) throws Exception;
	
}
