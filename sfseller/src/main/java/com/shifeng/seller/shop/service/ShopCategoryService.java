package com.shifeng.seller.shop.service;

import java.util.List;

import com.shifeng.seller.shop.dto.ShopCategoryDTO;

/** 
 * 店铺经营类目(s_shop_category)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
public interface ShopCategoryService {
	
	/**
	 * 根据店铺ID查询
	 * @param id 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findShopCategoryByMid(String id) throws Exception;
	
	/**
	 * 查询店铺类目
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findAllParentCategoryByShopId(String shopId) throws Exception;
	
	
	/**
	 * 根据父ID查询
	 * @param id 父ID
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findShopCategoryByPid(String id,String shopId) throws Exception;
}
