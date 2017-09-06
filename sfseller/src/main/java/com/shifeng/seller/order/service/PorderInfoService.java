package com.shifeng.seller.order.service;

import java.util.List;
import com.shifeng.entity.order.PorderInfo;
import com.shifeng.plugin.page.Page;

/** 
 * 订单父表(o_porderInfo)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
public interface PorderInfoService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PorderInfo> findAllPorderInfo(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public PorderInfo findPorderInfoById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param porderInfo
	 * @throws Exception
	 */
	public void updatePorderInfo(PorderInfo porderInfo) throws Exception;
	
	/**
	 * 新增
	 * @param porderInfo
	 * @throws Exception
	 */
	public void savePorderInfo(PorderInfo porderInfo) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePorderInfo(String id) throws Exception;
	
}
