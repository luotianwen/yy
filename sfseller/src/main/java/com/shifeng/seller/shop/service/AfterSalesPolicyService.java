package com.shifeng.seller.shop.service;

import java.util.List;

import com.shifeng.entity.shop.AfterSalesPolicy;
import com.shifeng.plugin.page.Page;

/** 
 * 售后政策(s_after_sales_policy)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:24 
 */  
public interface AfterSalesPolicyService {

	/**
	 * 根据店铺ID查询所有
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<AfterSalesPolicy> findAllAfterSalesPolicyByShopId(String shopId) throws Exception;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<AfterSalesPolicy> findAllAfterSalesPolicy(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public AfterSalesPolicy findAfterSalesPolicyById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param aftersalespolicy
	 * @throws Exception
	 */
	public void afterSalesPolicyEdit(AfterSalesPolicy aftersalespolicy) throws Exception;
	
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteAfterSalesPolicy(String id) throws Exception;
	
}
