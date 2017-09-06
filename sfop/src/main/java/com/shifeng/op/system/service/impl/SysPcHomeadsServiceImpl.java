package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysPcHomeads;
import com.shifeng.op.system.service.SysPcHomeadsService;
import com.shifeng.plugin.page.Page;

/** 
 * pc首页广告(sys_pc_homeads)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */  
@Service("syspchomeadsServiceImpl")
public class SysPcHomeadsServiceImpl implements SysPcHomeadsService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysPcHomeads> findAllSysPcHomeads(Page page) throws Exception{
		return (List<SysPcHomeads>) dao.findForList("syspchomeadsMapper.findAllSysPcHomeadsPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysPcHomeads findSysPcHomeadsById(String id) throws Exception{
		return (SysPcHomeads) dao.findForObject("syspchomeadsMapper.findSysPcHomeadsById", id);
	}
	
	/**
	 * 新增
	 * @param syspchomeads
	 * @throws Exception
	 */
	public void saveSysPcHomeads(SysPcHomeads syspchomeads) throws Exception{
		dao.save("syspchomeadsMapper.saveSysPcHomeads", syspchomeads);
	}
	
	/**
	 * 修改
	 * @param syspchomeads
	 * @throws Exception
	 */
	public void updateSysPcHomeads(SysPcHomeads syspchomeads) throws Exception{
		dao.update("syspchomeadsMapper.updateSysPcHomeads", syspchomeads);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysPcHomeads(String id) throws Exception{
		dao.delete("syspchomeadsMapper.deleteSysPcHomeads", id);
	}
	
}
