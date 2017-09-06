package com.shifeng.seller.order.service;

import java.util.List;
import com.shifeng.entity.order.OrderInfoServiceLog;
import com.shifeng.plugin.page.Page;

/** 
 * 订单售后日志(o_orderInfo_service_log)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 19:08:55 
 */  
public interface OrderInfoServiceLogService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoServiceLog> findOrderInfoServiceLogByOosId(String id) throws Exception;
	
}
