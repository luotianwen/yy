package com.shifeng.seller.shop.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.shop.ShopCategorySpec;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺分类规格属性(p_shop_category_spec)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-28 13:20:44 
 */  
public interface ShopCategorySpecService {

	/**
	 * 查询所有
	 * @param page
	 * @param id 分类ID
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategorySpec> findAllShopCategorySpecPage(Page page,String cid,String shopId) throws Exception;
	
	/**
	 * 查询所有
	 * @param id 分类ID
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategorySpec> findAllShopCategorySpec(String cid,String shopId) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ShopCategorySpec findShopCategorySpecById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopcategoryspec
	 * @throws Exception
	 */
	public void updateShopCategorySpec(ShopCategorySpec shopcategoryspec) throws Exception;
	
	/**
	 * 新增
	 * @param shopcategoryspec
	 * @throws Exception
	 */
	public void saveShopCategorySpec(ShopCategorySpec shopcategoryspec,Map<String,Object> map) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopCategorySpec(String id) throws Exception;
    
}
