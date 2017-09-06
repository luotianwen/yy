package com.shifeng.seller.shop.service;

import com.shifeng.entity.shop.Shopinfo;

/** 
 * 店铺表(s_shopinfo)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
public interface ShopinfoService {

	/**
	 * 根据ID查询
	 */
	public Shopinfo findShopinfoByMid(String id) throws Exception;
	
	/**
	 * 根据用户ID查询
	 */
	public Shopinfo findShopinfoByUid(String id) throws Exception;
	
}
