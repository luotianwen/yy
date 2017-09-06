package com.shifeng.dto.fx.order;

import java.io.Serializable;

/**
 * 分销订单收入统计
 * 
 * @author Win
 *
 */
public class FxTotalOrderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 
	// 今天收入
	private FxTotalOrderDetailedDTO day;
	// 昨天收入
	private FxTotalOrderDetailedDTO yesterday;
	// 本周收入
	private FxTotalOrderDetailedDTO week;
	public FxTotalOrderDetailedDTO getDay() {
		return day;
	}
	public void setDay(FxTotalOrderDetailedDTO day) {
		this.day = day;
	}
	public FxTotalOrderDetailedDTO getYesterday() {
		return yesterday;
	}
	public void setYesterday(FxTotalOrderDetailedDTO yesterday) {
		this.yesterday = yesterday;
	}
	public FxTotalOrderDetailedDTO getWeek() {
		return week;
	}
	public void setWeek(FxTotalOrderDetailedDTO week) {
		this.week = week;
	}
	@Override
	public String toString() {
		return "FxTotaltOrderDTO [day=" + day + ", yesterday=" + yesterday + ", week=" + week + "]";
	}
	
	

	 
}
