package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallUsers;
import com.shifeng.plugin.page.Page;

/** 
 * 前台用户表(mall_users)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */  
public interface MallUsersService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUsers> findAllMallUsers(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallUsers findMallUsersById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param mallusers
	 * @throws Exception
	 */
	public void updateMallUsers(MallUsers mallusers) throws Exception;
	
	/**
	 * 新增
	 * @param mallusers
	 * @throws Exception
	 */
	public void saveMallUsers(MallUsers mallusers) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUsers(String id) throws Exception;
	
}
