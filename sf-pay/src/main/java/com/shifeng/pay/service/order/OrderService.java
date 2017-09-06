package com.shifeng.pay.service.order;

import com.shifeng.pay.entity.order.OrderPayInfo;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;

/**
 * 订单
 * @author WinZhong
 *
 */
public interface OrderService {
	
	/**
	 * 获取未处理的支付订单
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @return
	 */
	UnpaidOrderInfo isOrderNoDeal(String order_id,String order_type) throws Exception;

	/**
	 * 更新订单支付状态
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @param paymentRecord	订单支付流水信息
	 */
	void updateOrderState(String order_id,String order_type,Object paymentRecord) throws Exception;
	

	
	/**
	 * 获取订单支付信息
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @return
	 */
	OrderPayInfo getPayOrderInfo(String order_id,String order_type) throws Exception;

}
