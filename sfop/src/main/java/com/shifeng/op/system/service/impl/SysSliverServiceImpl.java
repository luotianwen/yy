package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysSliver;
import com.shifeng.op.system.service.SysSliverService;
import com.shifeng.plugin.page.Page;

/** 
 * 银币设置(sys_sliver)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 19:10:30 
 */  
@Service("syssliverServiceImpl")
public class SysSliverServiceImpl implements SysSliverService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysSliver> findAllSysSliver(Page page) throws Exception{
		return (List<SysSliver>) dao.findForList("syssliverMapper.findAllSysSliverPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysSliver findSysSliverById(String id) throws Exception{
		return (SysSliver) dao.findForObject("syssliverMapper.findSysSliverById", id);
	}
	
	/**
	 * 新增
	 * @param syssliver
	 * @throws Exception
	 */
	public void saveSysSliver(SysSliver syssliver) throws Exception{
		dao.save("syssliverMapper.saveSysSliver", syssliver);
	}
	
	/**
	 * 修改
	 * @param syssliver
	 * @throws Exception
	 */
	public void updateSysSliver(SysSliver syssliver) throws Exception{
		dao.update("syssliverMapper.updateSysSliver", syssliver);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysSliver(String id) throws Exception{
		dao.delete("syssliverMapper.deleteSysSliver", id);
	}
	
}
