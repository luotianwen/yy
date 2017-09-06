package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysSpecial;
import com.shifeng.plugin.page.Page;

/** 
 * 专题页名称(sys_special)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public interface SysSpecialService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysSpecial> findAllSysSpecial(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysSpecial findSysSpecialById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param sysspecial
	 * @throws Exception
	 */
	public void updateSysSpecial(SysSpecial sysspecial) throws Exception;
	
	/**
	 * 新增
	 * @param sysspecial
	 * @throws Exception
	 */
	public void saveSysSpecial(SysSpecial sysspecial) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysSpecial(String id) throws Exception;
	
}
