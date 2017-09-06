package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysBanner;
import com.shifeng.op.system.service.SysBannerService;
import com.shifeng.plugin.page.Page;

/** 
 * 系统banner(sys_banner)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
@Service("sysbannerServiceImpl")
public class SysBannerServiceImpl implements SysBannerService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysBanner> findAllSysBanner(Page page) throws Exception{
		return (List<SysBanner>) dao.findForList("sysbannerMapper.findAllSysBannerPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysBanner findSysBannerById(String id) throws Exception{
		return (SysBanner) dao.findForObject("sysbannerMapper.findSysBannerById", id);
	}
	
	/**
	 * 新增
	 * @param sysbanner
	 * @throws Exception
	 */
	public void saveSysBanner(SysBanner sysbanner) throws Exception{
		dao.save("sysbannerMapper.saveSysBanner", sysbanner);
	}
	
	/**
	 * 修改
	 * @param sysbanner
	 * @throws Exception
	 */
	public void updateSysBanner(SysBanner sysbanner) throws Exception{
		dao.update("sysbannerMapper.updateSysBanner", sysbanner);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysBanner(String id) throws Exception{
		dao.delete("sysbannerMapper.deleteSysBanner", id);
	}
	
}
