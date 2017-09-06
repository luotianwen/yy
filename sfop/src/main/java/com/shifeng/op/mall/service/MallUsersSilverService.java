package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.plugin.page.Page;

/** 
 * 我的银币(mall_users_silver)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
public interface MallUsersSilverService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUsersSilver> findAllMallUsersSilver(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallUsersSilver findMallUsersSilverById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param malluserssilver
	 * @throws Exception
	 */
	public void updateMallUsersSilver(MallUsersSilver malluserssilver) throws Exception;
	
	/**
	 * 新增
	 * @param malluserssilver
	 * @throws Exception
	 */
	public void saveMallUsersSilver(MallUsersSilver malluserssilver) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUsersSilver(String id) throws Exception;
	
}
