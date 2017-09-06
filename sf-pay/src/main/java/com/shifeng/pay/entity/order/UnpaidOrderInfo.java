package com.shifeng.pay.entity.order;

import java.io.Serializable;

/**
 * 待支付订单信息
 * @author WinZhong
 *
 */
public class UnpaidOrderInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//订单号
	private String order_id;
	
	//订单名称
	private String order_name;
	
	//订单描述
	private String order_body;
	
	//订单付款总金额
	private double total_fee;
	
	//订单类型
	private String order_type;
	
	//订单状态
	private String orderStatus;

	/**
	 * 订单号
	 * @return
	 */
	public String getOrder_id() {
		return order_id;
	}

	/**
	 * 订单号
	 * @param order_id
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	/**
	 * 订单名称
	 * @return
	 */
	public String getOrder_name() {
		return order_name;
	}

	/**
	 * 订单名称
	 * @param order_name
	 */
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	/**
	 * 订单描述
	 * @return
	 */
	public String getOrder_body() {
		return order_body;
	}

	/**
	 * 订单描述
	 * @param order_body
	 */
	public void setOrder_body(String order_body) {
		this.order_body = order_body;
	}

	/**
	 * 订单付款总金额
	 * @return
	 */
	public double getTotal_fee() {
		return total_fee;
	}

	/**
	 * 订单付款总金额
	 * @param total_fee
	 */
	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 订单类型
	 * @return
	 */
	public String getOrder_type() {
		return order_type;
	}

	/**
	 * 订单类型
	 * @param order_type
	 */
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	
	
	/**
	 * 订单状态
	 * @return
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 订单状态
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "UnpaidOrderInfo [order_id=" + order_id + ", order_name=" + order_name + ", order_body=" + order_body
				+ ", total_fee=" + total_fee + ", order_type=" + order_type + ", orderStatus=" + orderStatus + "]";
	}

	
	 
	 

}
