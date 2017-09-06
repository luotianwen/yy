package com.shifeng.op.order.service;

import java.util.List;

import com.shifeng.entity.order.OrderInfo;
import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.op.dto.order.OrderInfoDTO;
import com.shifeng.op.dto.order.OrderInfoDetailDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;

/** 
 * 订单表(o_orderInfo)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
public interface OrderInfoService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoDTO> findAllOrderInfo(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoDetailDTO findOrderInfoById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param orderInfo
	 * @throws Exception
	 */
	public void updateOrderInfo(OrderInfo orderInfo) throws Exception;
	
	/**
	 * 新增
	 * @param orderInfo
	 * @throws Exception
	 */
	public void saveOrderInfo(OrderInfo orderInfo) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfo(String id) throws Exception;
	
	/**
	 * 订单日志
	 */
	public List<OrderInfoLog> findOrderInfoLog(String id) throws Exception;
	
	/**
	 * 退款成功
	 */
	public void updateOrderRefund(Users user,String orderId) throws Exception;
	
}
