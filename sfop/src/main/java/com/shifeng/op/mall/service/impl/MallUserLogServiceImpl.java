package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallUserLog;
import com.shifeng.op.mall.service.MallUserLogService;
import com.shifeng.plugin.page.Page;

/** 
 * 前台用户登录日志(mall_user_log)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */  
@Service("malluserlogServiceImpl")
public class MallUserLogServiceImpl implements MallUserLogService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUserLog> findAllMallUserLog(Page page) throws Exception{
		return (List<MallUserLog>) dao.findForList("malluserlogMapper.findAllMallUserLogPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallUserLog findMallUserLogById(String id) throws Exception{
		return (MallUserLog) dao.findForObject("malluserlogMapper.findMallUserLogById", id);
	}
	
	/**
	 * 新增
	 * @param malluserlog
	 * @throws Exception
	 */
	public void saveMallUserLog(MallUserLog malluserlog) throws Exception{
		dao.save("malluserlogMapper.saveMallUserLog", malluserlog);
	}
	
	/**
	 * 修改
	 * @param malluserlog
	 * @throws Exception
	 */
	public void updateMallUserLog(MallUserLog malluserlog) throws Exception{
		dao.update("malluserlogMapper.updateMallUserLog", malluserlog);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUserLog(String id) throws Exception{
		dao.delete("malluserlogMapper.deleteMallUserLog", id);
	}
	
}
