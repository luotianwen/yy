package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.SysAppleadpic;
import com.shifeng.plugin.page.Page;

/** 
 * app引导页(sys_appleadpic)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:50 
 */  
public interface SysAppleadpicService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppleadpic> findAllSysAppleadpic(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SysAppleadpic findSysAppleadpicById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param sysappleadpic
	 * @throws Exception
	 */
	public void updateSysAppleadpic(SysAppleadpic sysappleadpic) throws Exception;
	
	/**
	 * 新增
	 * @param sysappleadpic
	 * @throws Exception
	 */
	public void saveSysAppleadpic(SysAppleadpic sysappleadpic) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppleadpic(String id) throws Exception;
	
}
