package com.shifeng.seller.shop.service;

import java.util.List;

import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.shop.ShopBrand;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.dto.ShopBrandDTO;

/** 
 * 品牌信息(s_shop_brand)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
public interface ShopBrandService {

	/**
	 * 查询店铺品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopBrandDTO> findMyShopBrand(Page page) throws Exception;
	
	/**
	 * 搜索品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Brand> searchBrand(Page page) throws Exception;
	
	/**
	 * 根据ID查询品牌
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Brand findBrandById(String id) throws Exception;
	
	/**
	 * 申请新品牌
	 * @param shopBrand
	 * @throws Exception
	 */
	public void saveApplyBrand(ShopBrand shopBrand,Integer shopId) throws Exception;
	
	/**
	 * 查询店铺可用品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopBrand> findShopBrand(String shopId) throws Exception;
	
	/**
	 * 根据ID查看店铺品牌
	 * @param id 品牌ID
	 * @param user 用户信息
	 * @return
	 * @throws Exception
	 */
	public ShopBrandDTO findShopBrandById(String id,Users user) throws Exception;
	
}
