package com.shifeng.seller.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.MerchantsSettled;
import com.shifeng.seller.shop.service.MerchantsSettledService;

/** 
 * 入驻基本信息填写(s_merchants_settled)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */  
@Service("merchantssettledServiceImpl")
public class MerchantsSettledServiceImpl implements MerchantsSettledService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据用户ID查询
	 */
	public MerchantsSettled findMerchantsSettledByShopId(String shopId) throws Exception{
		return (MerchantsSettled) dao.findForObject("merchantssettledMapper.findMerchantsSettledByShopId", shopId);
	}
	
	
}
