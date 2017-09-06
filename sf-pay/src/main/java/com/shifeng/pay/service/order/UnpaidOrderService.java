package com.shifeng.pay.service.order;

import com.shifeng.pay.entity.order.UnpaidOrderInfo;

/**
 * 未支付订单Service
 * @author WinZhong
 *
 */
public interface UnpaidOrderService {
	
	/**
	 * 获取待支付订单信息
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @return
	 */
	UnpaidOrderInfo getUnpaidOrderInfo(String order_id,String order_type);

}
