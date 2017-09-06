package com.shifeng.op.order.service;

import java.util.List;
import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.plugin.page.Page;

/** 
 * 订单日志(o_orderInfo_log)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 11:22:32 
 */  
public interface OrderInfoLogService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoLog> findAllOrderInfoLog(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoLog findOrderInfoLogById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param orderInfolog
	 * @throws Exception
	 */
	public void updateOrderInfoLog(OrderInfoLog orderInfolog) throws Exception;
	
	/**
	 * 新增
	 * @param orderInfolog
	 * @throws Exception
	 */
	public void saveOrderInfoLog(OrderInfoLog orderInfolog) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfoLog(String id) throws Exception;
	
}
