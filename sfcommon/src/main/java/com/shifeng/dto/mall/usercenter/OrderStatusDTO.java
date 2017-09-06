package com.shifeng.dto.mall.usercenter;

import java.io.Serializable;

/**
 * 订单状态DTO
 * @author Win
 *
 */
public class OrderStatusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//订单状态
	private int orderStatus;	
	
	//统计值
	private int num;

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "OrderStatusDTO [orderStatus=" + orderStatus + ", num=" + num + "]";
	}	
	 
	
	

}
