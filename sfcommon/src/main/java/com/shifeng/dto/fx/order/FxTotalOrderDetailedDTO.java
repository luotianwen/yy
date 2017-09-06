package com.shifeng.dto.fx.order;

import java.io.Serializable;

/**
 * 分销订单收入统计
 * 
 * @author Win
 *
 */
public class FxTotalOrderDetailedDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 订单数量
	private int order_quantity;
	// 收入金额
	private double income_amount;
	// 日期范围
	private String range;
	
	/**
	 * 订单数量
	 * @return
	 */
	public int getOrder_quantity() {
		return order_quantity;
	}
	/**
	 * 订单数量
	 * @param order_quantity
	 */
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	/**
	 * 收入金额
	 * @return
	 */
	public double getIncome_amount() {
		return income_amount;
	}
	/**
	 * 收入金额
	 * @param income_amount
	 */
	public void setIncome_amount(double income_amount) {
		this.income_amount = income_amount;
	}
	
	/**
	 * 日期范围
	 * @return
	 */
	public String getRange() {
		return range;
	}
	
	/**
	 * 日期范围
	 * @param range
	 */
	public void setRange(String range) {
		this.range = range;
	}
	@Override
	public String toString() {
		return "FxTotalOrderDetailedDTO [order_quantity=" + order_quantity + ", income_amount=" + income_amount
				+ ", range=" + range + "]";
	}
	 
	
 
}
