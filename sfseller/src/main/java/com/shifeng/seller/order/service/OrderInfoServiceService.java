package com.shifeng.seller.order.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.order.OrderInfoService;
import com.shifeng.plugin.page.Page;

/** 
 * 订单售后(o_orderInfo_service)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 19:08:54 
 */  
public interface OrderInfoServiceService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoService> findAllOrderInfoService(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoService findOrderInfoServiceById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param orderInfoservice
	 * @throws Exception
	 */
	public void updateOrderInfoService(OrderInfoService orderInfoservice) throws Exception;
	
	/**
	 * 新增
	 * @param orderInfoservice
	 * @throws Exception
	 */
	public void saveOrderInfoService(OrderInfoService orderInfoservice) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfoService(String id) throws Exception;
	
	/**
	 * 修改发货信息
	 */
	public void updateShipments(Map<String,String> map) throws Exception;
	
}
