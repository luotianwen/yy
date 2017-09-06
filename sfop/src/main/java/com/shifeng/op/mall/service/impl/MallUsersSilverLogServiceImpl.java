package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallUsersSilverLog;
import com.shifeng.op.mall.service.MallUsersSilverLogService;
import com.shifeng.plugin.page.Page;

/** 
 * 我的银币日志(mall_users_silver_log)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
@Service("malluserssilverlogServiceImpl")
public class MallUsersSilverLogServiceImpl implements MallUsersSilverLogService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUsersSilverLog> findAllMallUsersSilverLog(Page page) throws Exception{
		return (List<MallUsersSilverLog>) dao.findForList("malluserssilverlogMapper.findAllMallUsersSilverLogPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallUsersSilverLog findMallUsersSilverLogById(String id) throws Exception{
		return (MallUsersSilverLog) dao.findForObject("malluserssilverlogMapper.findMallUsersSilverLogById", id);
	}
	
	/**
	 * 新增
	 * @param malluserssilverlog
	 * @throws Exception
	 */
	public void saveMallUsersSilverLog(MallUsersSilverLog malluserssilverlog) throws Exception{
		dao.save("malluserssilverlogMapper.saveMallUsersSilverLog", malluserssilverlog);
	}
	
	/**
	 * 修改
	 * @param malluserssilverlog
	 * @throws Exception
	 */
	public void updateMallUsersSilverLog(MallUsersSilverLog malluserssilverlog) throws Exception{
		dao.update("malluserssilverlogMapper.updateMallUsersSilverLog", malluserssilverlog);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUsersSilverLog(String id) throws Exception{
		dao.delete("malluserssilverlogMapper.deleteMallUsersSilverLog", id);
	}
	
}
