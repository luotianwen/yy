package com.shifeng.op.shop.service;

import java.util.List;
import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺审核日志(s_shopinfo_log)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
public interface ShopinfoLogService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoLog> findAllShopinfoLog(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ShopinfoLog findShopinfoLogById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopinfolog
	 * @throws Exception
	 */
	public void updateShopinfoLog(ShopinfoLog shopinfolog) throws Exception;
	
	/**
	 * 新增
	 * @param shopinfolog
	 * @throws Exception
	 */
	public void saveShopinfoLog(ShopinfoLog shopinfolog) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopinfoLog(String id) throws Exception;
	
}
