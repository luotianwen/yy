package com.shifeng.seller.order.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.shifeng.entity.order.ExpressOrder;

public class ExpressOrderDTO extends ExpressOrder{
	//商品信息
	private String name;
	//下单时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date subTime;
	//订单状态
	private Integer orderStatus;
	//订单总金额.
	private Double order_total_price;
	//默认支付方式
	private Integer defaultPayment;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getSubTime() {
		return subTime;
	}
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Double getOrder_total_price() {
		return order_total_price;
	}
	public void setOrder_total_price(Double order_total_price) {
		this.order_total_price = order_total_price;
	}
	public Integer getDefaultPayment() {
		return defaultPayment;
	}
	public void setDefaultPayment(Integer defaultPayment) {
		this.defaultPayment = defaultPayment;
	}
	
	
	
}
