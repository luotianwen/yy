package com.shifeng.op.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.StoreSupervisor;
import com.shifeng.op.shop.service.StoreSupervisorService;
import com.shifeng.plugin.page.Page;

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
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<StoreSupervisor> findAllStoreSupervisor(Page page) throws Exception{
		return (List<StoreSupervisor>) dao.findForList("storesupervisorMapper.findAllStoreSupervisorPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public StoreSupervisor findStoreSupervisorById(String id) throws Exception{
		return (StoreSupervisor) dao.findForObject("storesupervisorMapper.findStoreSupervisorById", id);
	}
	
	/**
	 * 新增
	 * @param storesupervisor
	 * @throws Exception
	 */
	public void saveStoreSupervisor(StoreSupervisor storesupervisor) throws Exception{
		dao.save("storesupervisorMapper.saveStoreSupervisor", storesupervisor);
	}
	
	/**
	 * 修改
	 * @param storesupervisor
	 * @throws Exception
	 */
	public void updateStoreSupervisor(StoreSupervisor storesupervisor) throws Exception{
		dao.update("storesupervisorMapper.updateStoreSupervisor", storesupervisor);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteStoreSupervisor(String id) throws Exception{
		dao.delete("storesupervisorMapper.deleteStoreSupervisor", id);
	}
	
}
