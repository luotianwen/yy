package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysAppleadpic;
import com.shifeng.op.system.service.SysAppleadpicService;
import com.shifeng.plugin.page.Page;

/** 
 * app引导页(sys_appleadpic)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:50 
 */  
@Service("sysappleadpicServiceImpl")
public class SysAppleadpicServiceImpl implements SysAppleadpicService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysAppleadpic> findAllSysAppleadpic(Page page) throws Exception{
		return (List<SysAppleadpic>) dao.findForList("sysappleadpicMapper.findAllSysAppleadpicPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysAppleadpic findSysAppleadpicById(String id) throws Exception{
		return (SysAppleadpic) dao.findForObject("sysappleadpicMapper.findSysAppleadpicById", id);
	}
	
	/**
	 * 新增
	 * @param sysappleadpic
	 * @throws Exception
	 */
	public void saveSysAppleadpic(SysAppleadpic sysappleadpic) throws Exception{
		dao.save("sysappleadpicMapper.saveSysAppleadpic", sysappleadpic);
	}
	
	/**
	 * 修改
	 * @param sysappleadpic
	 * @throws Exception
	 */
	public void updateSysAppleadpic(SysAppleadpic sysappleadpic) throws Exception{
		dao.update("sysappleadpicMapper.updateSysAppleadpic", sysappleadpic);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysAppleadpic(String id) throws Exception{
		dao.delete("sysappleadpicMapper.deleteSysAppleadpic", id);
	}
	
}
