package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallUserLog;
import com.shifeng.plugin.page.Page;

/** 
 * 前台用户登录日志(mall_user_log)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */  
public interface MallUserLogService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUserLog> findAllMallUserLog(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallUserLog findMallUserLogById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param malluserlog
	 * @throws Exception
	 */
	public void updateMallUserLog(MallUserLog malluserlog) throws Exception;
	
	/**
	 * 新增
	 * @param malluserlog
	 * @throws Exception
	 */
	public void saveMallUserLog(MallUserLog malluserlog) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUserLog(String id) throws Exception;
	
}
