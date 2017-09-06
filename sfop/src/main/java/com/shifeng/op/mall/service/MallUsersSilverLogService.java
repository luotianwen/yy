package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallUsersSilverLog;
import com.shifeng.plugin.page.Page;

/** 
 * 我的银币日志(mall_users_silver_log)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
public interface MallUsersSilverLogService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUsersSilverLog> findAllMallUsersSilverLog(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallUsersSilverLog findMallUsersSilverLogById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param malluserssilverlog
	 * @throws Exception
	 */
	public void updateMallUsersSilverLog(MallUsersSilverLog malluserssilverlog) throws Exception;
	
	/**
	 * 新增
	 * @param malluserssilverlog
	 * @throws Exception
	 */
	public void saveMallUsersSilverLog(MallUsersSilverLog malluserssilverlog) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUsersSilverLog(String id) throws Exception;
	
}
