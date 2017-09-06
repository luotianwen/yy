package com.shifeng.seller.shop.service;

import com.shifeng.entity.freight.Freight;
import com.shifeng.plugin.page.Page;

import java.util.List;

/** 
 * 运费模板管理(o_freight)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:40:52 
 */  
public interface FreightService {

	/**
	 * 根据店铺ID查询所有
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<Freight> findAllFreightByShopId(String shopId) throws Exception;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Freight> findAllFreight(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Freight findFreightById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param freight
	 * @throws Exception
	 */
	public void updateFreight(Freight freight) throws Exception;
	
	/**
	 * 新增
	 * @param freight
	 * @throws Exception
	 */
	public void saveFreight(Freight freight) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFreight(String id) throws Exception;
	
}
