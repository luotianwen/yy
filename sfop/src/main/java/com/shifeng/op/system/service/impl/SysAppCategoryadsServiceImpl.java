package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysAppCategoryads;
import com.shifeng.op.system.service.SysAppCategoryadsService;
import com.shifeng.plugin.page.Page;

/** 
 * app类目广告(sys_app_categoryads)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-15 15:46:41 
 */  
@Service("sysappcategoryadsServiceImpl")
public class SysAppCategoryadsServiceImpl implements SysAppCategoryadsService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppCategoryads> findAllSysAppCategoryads(Page page) throws Exception{
		return (List<SysAppCategoryads>) dao.findForList("sysappcategoryadsMapper.findAllSysAppCategoryadsPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysAppCategoryads findSysAppCategoryadsById(String id) throws Exception{
		return (SysAppCategoryads) dao.findForObject("sysappcategoryadsMapper.findSysAppCategoryadsById", id);
	}
	
	/**
	 * 新增
	 * @param sysappcategoryads
	 * @throws Exception
	 */
	public void saveSysAppCategoryads(SysAppCategoryads sysappcategoryads) throws Exception{
		dao.save("sysappcategoryadsMapper.saveSysAppCategoryads", sysappcategoryads);
	}
	
	/**
	 * 修改
	 * @param sysappcategoryads
	 * @throws Exception
	 */
	public void updateSysAppCategoryads(SysAppCategoryads sysappcategoryads) throws Exception{
		dao.update("sysappcategoryadsMapper.updateSysAppCategoryads", sysappcategoryads);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppCategoryads(String id) throws Exception{
		dao.delete("sysappcategoryadsMapper.deleteSysAppCategoryads", id);
	}
	
}
