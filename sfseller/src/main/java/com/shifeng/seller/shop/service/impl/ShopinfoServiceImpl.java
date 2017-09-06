package com.shifeng.seller.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.seller.shop.service.ShopinfoService;

/** 
 * 店铺表(s_shopinfo)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
@Service("shopinfoServiceImpl")
public class ShopinfoServiceImpl implements ShopinfoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 根据ID查询
	 */
	public Shopinfo findShopinfoByMid(String id) throws Exception{
		return (Shopinfo) dao.findForObject("shopinfoMapper.findShopinfoByMid", id);
	}
	
	/**
	 * 根据用户ID查询
	 */
	public Shopinfo findShopinfoByUid(String id) throws Exception{
		return (Shopinfo) dao.findForObject("shopinfoMapper.findShopinfoByUid", id);
	}
	
}
