package com.shifeng.seller.shop.service;

import java.util.List;
import com.shifeng.entity.shop.ShippingAddress;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺发货地址(s_shipping_address)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:22:45 
 */  
public interface ShippingAddressService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShippingAddress> findAllShippingAddress(Page page) throws Exception;
	
	/**
	 * 根据店铺ID查询
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShippingAddress> findShippingAddressByShopId(String shopid) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ShippingAddress findShippingAddressById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shippingaddress
	 * @throws Exception
	 */
	public void shippingAddressEdit(ShippingAddress shippingaddress) throws Exception;
	
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShippingAddress(String id) throws Exception;
	
}
