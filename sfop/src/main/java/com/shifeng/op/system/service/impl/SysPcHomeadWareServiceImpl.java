package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysPcHomeadWare;
import com.shifeng.op.system.service.SysPcHomeadWareService;
import com.shifeng.plugin.page.Page;

/** 
 * pc首页广告商品(sys_pc_homead_ware)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */  
@Service("syspchomeadwareServiceImpl")
public class SysPcHomeadWareServiceImpl implements SysPcHomeadWareService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysPcHomeadWare> findAllSysPcHomeadWare(Page page) throws Exception{
		return (List<SysPcHomeadWare>) dao.findForList("syspchomeadwareMapper.findAllSysPcHomeadWarePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysPcHomeadWare findSysPcHomeadWareById(String id) throws Exception{
		return (SysPcHomeadWare) dao.findForObject("syspchomeadwareMapper.findSysPcHomeadWareById", id);
	}
	
	/**
	 * 新增
	 * @param syspchomeadware
	 * @throws Exception
	 */
	public void saveSysPcHomeadWare(SysPcHomeadWare syspchomeadware) throws Exception{
		dao.save("syspchomeadwareMapper.saveSysPcHomeadWare", syspchomeadware);
	}
	
	/**
	 * 修改
	 * @param syspchomeadware
	 * @throws Exception
	 */
	public void updateSysPcHomeadWare(SysPcHomeadWare syspchomeadware) throws Exception{
		dao.update("syspchomeadwareMapper.updateSysPcHomeadWare", syspchomeadware);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysPcHomeadWare(String id) throws Exception{
		dao.delete("syspchomeadwareMapper.deleteSysPcHomeadWare", id);
	}
	
}
