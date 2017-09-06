package com.shifeng.op.shop.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.shop.ShopBrand;
import com.shifeng.op.dto.shop.AuditBrandDTO;
import com.shifeng.op.dto.shop.ShopBrandDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;

/** 
 * 品牌信息(s_shop_brand)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
public interface ShopBrandService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopBrand> findAllShopBrand(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public AuditBrandDTO findShopBrandById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopbrand
	 * @throws Exception
	 */
	public void updateShopBrand(ShopBrand shopbrand) throws Exception;
	
	/**
	 * 新增
	 * @param shopbrand
	 * @throws Exception
	 */
	public void saveShopBrand(ShopBrand shopbrand) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopBrand(String id) throws Exception;

    List<ShopBrandDTO> findAllShopBrandByShop(Page page)throws Exception;

    void saveALLShopBrand(int s_merchants_id, int[] b_brand_id, Users user)throws Exception;
    
    /**
     * 查询所有审核品牌
     * @param page
     * @return
     * @throws Exception
     */
    List<AuditBrandDTO> findAuditBrand(Page page)throws Exception;
    
    /**
     * 品牌审核
     * @param shopbrand
     * @throws Exception
     */
    void updateAuditShopBrand(ShopBrand shopbrand) throws Exception;
    
    
}
