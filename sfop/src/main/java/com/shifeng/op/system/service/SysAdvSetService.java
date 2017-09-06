package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysAdvSet;
import com.shifeng.plugin.page.Page;

/** 
 * 系统广告费用设置(sys_adv_set)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-01 09:57:51 
 */  
public interface SysAdvSetService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAdvSet> findAllSysAdvSet(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysAdvSet findSysAdvSetById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param sysadvset
	 * @throws Exception
	 */
	public void updateSysAdvSet(SysAdvSet sysadvset) throws Exception;
	
	/**
	 * 新增
	 * @param sysadvset
	 * @throws Exception
	 */
	public void saveSysAdvSet(SysAdvSet sysadvset) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAdvSet(String id) throws Exception;
	
}
