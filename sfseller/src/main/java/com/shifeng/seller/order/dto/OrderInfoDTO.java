package com.shifeng.seller.order.dto;

import java.util.List;

import com.shifeng.entity.order.ExpressOrder;
import com.shifeng.entity.order.OrderDetailInfo;
import com.shifeng.entity.order.OrderInfo;
import com.shifeng.entity.order.OrderInfoDiscount;

public class OrderInfoDTO extends OrderInfo{
  	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//折扣表
  	 private List<OrderInfoDiscount> orderInfodiscounts;
  	 
  	 //订单明细
  	 private List<OrderDetailInfo> orderDetailInfos;
  	 
  	 //订单编号
  	 private List<ExpressDTO> expresss;
  	 
  	 //快递单号
  	 private String expressNumber;
  	 //快递名
  	 private String expressName;
	 
	
	public List<OrderDetailInfo> getOrderDetailInfos() {
		return orderDetailInfos;
	}
	public void setOrderDetailInfos(List<OrderDetailInfo> orderDetailInfos) {
		this.orderDetailInfos = orderDetailInfos;
	}
	public List<OrderInfoDiscount> getOrderInfodiscounts() {
		return orderInfodiscounts;
	}
	public void setOrderInfodiscounts(List<OrderInfoDiscount> orderInfodiscounts) {
		this.orderInfodiscounts = orderInfodiscounts;
	}
	public String getExpressNumber() {
		return expressNumber;
	}
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	public String getExpressName() {
		return expressName;
	}
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
	public List<ExpressDTO> getExpresss() {
		return expresss;
	}
	public void setExpresss(List<ExpressDTO> expresss) {
		this.expresss = expresss;
	}
	
	
	
}
