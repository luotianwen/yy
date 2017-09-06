package com.shifeng.op.shop.service;

import java.util.List;
import com.shifeng.entity.shop.ShopinfoPay;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺续费表(s_shopinfo_pay)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
public interface ShopinfoPayService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoPay> findAllShopinfoPay(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ShopinfoPay findShopinfoPayById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopinfopay
	 * @throws Exception
	 */
	public void updateShopinfoPay(ShopinfoPay shopinfopay) throws Exception;
	
	/**
	 * 新增
	 * @param shopinfopay
	 * @throws Exception
	 */
	public void saveShopinfoPay(ShopinfoPay shopinfopay) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopinfoPay(String id) throws Exception;
	
}
