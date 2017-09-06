package com.shifeng.dto.mall.order.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderServiceWareDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//订单ID
	private String orderId;
	//下单时间
	private Date subTime;
	//商品列表
	private List<OrderServiceWareDetailDTO> wareList;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getSubTime() {
		return subTime;
	}
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
	
	public List<OrderServiceWareDetailDTO> getWareList() {
		return wareList;
	}
	public void setWareList(List<OrderServiceWareDetailDTO> wareList) {
		this.wareList = wareList;
	}
	@Override
	public String toString() {
		return "OrderServiceWareDTO [orderId=" + orderId + ", subTime=" + subTime + ", wareList=" + wareList + "]";
	}
  	 
 
	 

	
	
	
}
