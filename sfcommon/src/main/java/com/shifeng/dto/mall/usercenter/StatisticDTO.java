package com.shifeng.dto.mall.usercenter;

import java.io.Serializable;

public class StatisticDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//积分
	private Integer point = 0;
	//关注商品
	private Integer followWare = 0;
	//关注店铺
	private Integer followVender = 0;
	
	//订单状态
	private OrderStatusStatisticDTO order;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getFollowWare() {
		return followWare;
	}

	public void setFollowWare(int followWare) {
		this.followWare = followWare;
	}

	public int getFollowVender() {
		return followVender;
	}

	public void setFollowVender(int followVender) {
		this.followVender = followVender;
	}

	public OrderStatusStatisticDTO getOrder() {
		return order;
	}

	public void setOrder(OrderStatusStatisticDTO order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "StatisticDTO [point=" + point + ", followWare=" + followWare + ", followVender=" + followVender
				+ ", order=" + order + "]";
	}
	
	
	

}
