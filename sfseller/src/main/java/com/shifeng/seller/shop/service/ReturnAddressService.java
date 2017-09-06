package com.shifeng.seller.shop.service;

import java.util.List;
import com.shifeng.entity.shop.ReturnAddress;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺退货地址(s_return_address)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:22:45 
 */  
public interface ReturnAddressService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ReturnAddress> findAllReturnAddress(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ReturnAddress findReturnAddressById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param returnaddress
	 * @throws Exception
	 */
	public void returnAddressEdit(ReturnAddress returnaddress) throws Exception;
	
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteReturnAddress(String id) throws Exception;
	
}
