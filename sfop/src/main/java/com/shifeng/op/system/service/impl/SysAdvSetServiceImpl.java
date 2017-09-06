package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysAdvSet;
import com.shifeng.op.system.service.SysAdvSetService;
import com.shifeng.plugin.page.Page;

/** 
 * 系统广告费用设置(sys_adv_set)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-01 09:57:51 
 */  
@Service("sysadvsetServiceImpl")
public class SysAdvSetServiceImpl implements SysAdvSetService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAdvSet> findAllSysAdvSet(Page page) throws Exception{
		return (List<SysAdvSet>) dao.findForList("sysadvsetMapper.findAllSysAdvSetPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysAdvSet findSysAdvSetById(String id) throws Exception{
		return (SysAdvSet) dao.findForObject("sysadvsetMapper.findSysAdvSetById", id);
	}
	
	/**
	 * 新增
	 * @param sysadvset
	 * @throws Exception
	 */
	public void saveSysAdvSet(SysAdvSet sysadvset) throws Exception{
		dao.save("sysadvsetMapper.saveSysAdvSet", sysadvset);
	}
	
	/**
	 * 修改
	 * @param sysadvset
	 * @throws Exception
	 */
	public void updateSysAdvSet(SysAdvSet sysadvset) throws Exception{
		dao.update("sysadvsetMapper.updateSysAdvSet", sysadvset);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAdvSet(String id) throws Exception{
		dao.delete("sysadvsetMapper.deleteSysAdvSet", id);
	}
	
}
