package com.shifeng.seller.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.StoreSupervisor;
import com.shifeng.seller.shop.service.StoreSupervisorService;

/** 
 * 店铺负责人员(s_store_supervisor)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
@Service("storesupervisorServiceImpl")
public class StoreSupervisorServiceImpl implements StoreSupervisorService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据ID查询
	 */
	public List<StoreSupervisor> findStoreSupervisorByMid(String id) throws Exception{
		return (List<StoreSupervisor>) dao.findForList("storesupervisorMapper.findStoreSupervisorByMid", id);
	}
	
}
