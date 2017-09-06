package com.shifeng.seller.shop.service;

import com.shifeng.entity.shop.MerchantsSettled;

/** 
 * 入驻基本信息填写(s_merchants_settled)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */  
public interface MerchantsSettledService {

	/**
	 * 根据用户ID查询
	 */
	public MerchantsSettled findMerchantsSettledByShopId(String shopId) throws Exception;
    
}
