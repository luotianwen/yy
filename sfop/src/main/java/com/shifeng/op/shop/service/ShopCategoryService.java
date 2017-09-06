package com.shifeng.op.shop.service;

import java.util.List;
import com.shifeng.entity.shop.ShopCategory;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺经营类目(s_shop_category)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
public interface ShopCategoryService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategory> findAllShopCategory(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ShopCategory findShopCategoryById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopcategory
	 * @throws Exception
	 */
	public void updateShopCategory(ShopCategory shopcategory) throws Exception;
	
	/**
	 * 新增
	 * @param shopcategory
	 * @throws Exception
	 */
	public void saveShopCategory(ShopCategory shopcategory) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopCategory(String id) throws Exception;
	
}
