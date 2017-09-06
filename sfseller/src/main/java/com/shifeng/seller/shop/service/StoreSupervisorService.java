package com.shifeng.seller.shop.service;

import java.util.List;

import com.shifeng.entity.shop.StoreSupervisor;

/** 
 * 店铺负责人员(s_store_supervisor)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
public interface StoreSupervisorService {
	/**
	 * 根据ID查询
	 */
	public List<StoreSupervisor> findStoreSupervisorByMid(String id) throws Exception;
	
}
