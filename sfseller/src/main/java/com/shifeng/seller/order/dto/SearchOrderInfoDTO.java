package com.shifeng.seller.order.dto;

import java.io.Serializable;

public class SearchOrderInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//订单ID
	private String orderId;
	//订单状态
	private Integer orderStatus;
	//下单时间
	private String subTime;
	//快递编号
	private String expressNumber;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getExpressNumber() {
		return expressNumber;
	}
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	public String getSubTime() {
		return subTime;
	}
	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}
	
	
}
