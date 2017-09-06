package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysAppHomeads;
import com.shifeng.op.system.service.SysAppHomeadsService;
import com.shifeng.plugin.page.Page;

/** 
 * app首页广告(sys_app_homeads)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-16 18:49:59 
 */  
@Service("sysapphomeadsServiceImpl")
public class SysAppHomeadsServiceImpl implements SysAppHomeadsService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppHomeads> findAllSysAppHomeads(Page page) throws Exception{
		return (List<SysAppHomeads>) dao.findForList("sysapphomeadsMapper.findAllSysAppHomeadsPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysAppHomeads findSysAppHomeadsById(String id) throws Exception{
		return (SysAppHomeads) dao.findForObject("sysapphomeadsMapper.findSysAppHomeadsById", id);
	}
	
	/**
	 * 新增
	 * @param sysapphomeads
	 * @throws Exception
	 */
	public void saveSysAppHomeads(SysAppHomeads sysapphomeads) throws Exception{
		dao.save("sysapphomeadsMapper.saveSysAppHomeads", sysapphomeads);
	}
	
	/**
	 * 修改
	 * @param sysapphomeads
	 * @throws Exception
	 */
	public void updateSysAppHomeads(SysAppHomeads sysapphomeads) throws Exception{
		dao.update("sysapphomeadsMapper.updateSysAppHomeads", sysapphomeads);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppHomeads(String id) throws Exception{
		dao.delete("sysapphomeadsMapper.deleteSysAppHomeads", id);
	}
	
}
