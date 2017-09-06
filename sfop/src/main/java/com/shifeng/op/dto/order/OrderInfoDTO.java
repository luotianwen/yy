package com.shifeng.op.dto.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.shifeng.entity.order.OrderDetailInfo;
import com.shifeng.entity.order.OrderInfo;
import com.shifeng.entity.order.PorderInfoDiscount;

public class OrderInfoDTO extends OrderInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  	 //折扣表
  	 private List<PorderInfoDiscount> porderInfodiscounts;
  	 
  	 //子订单
  	 private List<OrderInfoDTO> orderInfos;
  	 //订单明细
  	 private List<OrderDetailInfo> orderDetailInfos;
  	 
  	 //快递单号
  	 private String expressNumber;
  	 //快递名
  	 private String expressName;
	 
	
	public List<OrderInfoDTO> getOrderInfos() {
		return orderInfos;
	}
	public void setOrderInfos(List<OrderInfoDTO> orderInfos) {
		this.orderInfos = orderInfos;
	}
	public List<OrderDetailInfo> getOrderDetailInfos() {
		return orderDetailInfos;
	}
	public void setOrderDetailInfos(List<OrderDetailInfo> orderDetailInfos) {
		this.orderDetailInfos = orderDetailInfos;
	}
	public List<PorderInfoDiscount> getPorderInfodiscounts() {
		return porderInfodiscounts;
	}
	public void setPorderInfodiscounts(List<PorderInfoDiscount> porderInfodiscounts) {
		this.porderInfodiscounts = porderInfodiscounts;
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
	
	
	
}
