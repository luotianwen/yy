package com.shifeng.seller.shop.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.shop.ShopCategoryColor;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺分类颜色属性(p_shop_category_color)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-28 13:20:44 
 */  
public interface ShopCategoryColorService {

	/**
	 * 查询所有
	 * @param page
	 * @param id 分类ID
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryColor> findAllShopCategoryColorPage(Page page ,String cid,String shopId) throws Exception;
	
	/**
	 * 查询所有
	 * @param id 分类ID
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryColor> findAllShopCategoryColor(String cid,String shopId) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ShopCategoryColor findShopCategoryColorById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopcategorycolor
	 * @throws Exception
	 */
	public void updateShopCategoryColor(ShopCategoryColor shopcategorycolor) throws Exception;
	
	/**
	 * 新增
	 * @param shopcategorycolor
	 * @throws Exception
	 */
	public void saveShopCategoryColor(ShopCategoryColor shopcategorycolor,Map<String,Object> map) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopCategoryColor(String id) throws Exception;
    
}
