package com.shifeng.op.shop.service;

import java.util.List;

import com.shifeng.entity.shop.ShopEvaluate;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺评价(p_shop_evaluate)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 15:37:29 
 */  
public interface ShopEvaluateService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopEvaluate> findAllShopEvaluate(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ShopEvaluate findShopEvaluateById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopevaluate
	 * @throws Exception
	 */
	public void updateShopEvaluate(ShopEvaluate shopevaluate) throws Exception;
	
	/**
	 * 新增
	 * @param shopevaluate
	 * @throws Exception
	 */
	public void saveShopEvaluate(ShopEvaluate shopevaluate) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopEvaluate(String id) throws Exception;
	
}
