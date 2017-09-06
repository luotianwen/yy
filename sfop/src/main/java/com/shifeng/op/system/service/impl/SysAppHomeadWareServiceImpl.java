package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysAppHomeadWare;
import com.shifeng.op.system.service.SysAppHomeadWareService;
import com.shifeng.plugin.page.Page;

/** 
 * app首页广告商品(sys_app_homead_ware)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-16 18:50:00 
 */  
@Service("sysapphomeadwareServiceImpl")
public class SysAppHomeadWareServiceImpl implements SysAppHomeadWareService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppHomeadWare> findAllSysAppHomeadWare(Page page) throws Exception{
		return (List<SysAppHomeadWare>) dao.findForList("sysapphomeadwareMapper.findAllSysAppHomeadWarePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysAppHomeadWare findSysAppHomeadWareById(String id) throws Exception{
		return (SysAppHomeadWare) dao.findForObject("sysapphomeadwareMapper.findSysAppHomeadWareById", id);
	}
	
	/**
	 * 新增
	 * @param sysapphomeadware
	 * @throws Exception
	 */
	public void saveSysAppHomeadWare(SysAppHomeadWare sysapphomeadware) throws Exception{
		dao.save("sysapphomeadwareMapper.saveSysAppHomeadWare", sysapphomeadware);
	}
	
	/**
	 * 修改
	 * @param sysapphomeadware
	 * @throws Exception
	 */
	public void updateSysAppHomeadWare(SysAppHomeadWare sysapphomeadware) throws Exception{
		dao.update("sysapphomeadwareMapper.updateSysAppHomeadWare", sysapphomeadware);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppHomeadWare(String id) throws Exception{
		dao.delete("sysapphomeadwareMapper.deleteSysAppHomeadWare", id);
	}
	
}
