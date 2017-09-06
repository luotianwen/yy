package com.shifeng.dto.fx;

import java.io.Serializable;

/**
 * 分销总计
 * 
 * @author Win
 *
 */
public class FxTotalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 总订单数量
	private int total_order;
	// 总订单总金额
	private Double total_amount = 0.00;
	// 可提现金额
	private Double total_exchange = 0.00;
/*	// 待提现金额
	private Double pending_exchange;*/

	/**
	 * 总订单数量
	 * 
	 * @return
	 */
	public int getTotal_order() {
		return total_order;
	}

	/**
	 * 总订单数量
	 * 
	 * @param total_order
	 */
	public void setTotal_order(int total_order) {
		this.total_order = total_order;
	}

	/**
	 * 总订单总金额
	 * 
	 * @return
	 */
	public Double getTotal_amount() {
		return total_amount;
	}

	/**
	 * 总订单总金额
	 * 
	 * @param total_amount
	 */
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	/**
	 * 可提现金额
	 * 
	 * @return
	 */
	public Double getTotal_exchange() {
		return total_exchange;
	}

	/**
	 * 可提现金额
	 * 
	 * @param total_exchange
	 */
	public void setTotal_exchange(Double total_exchange) {
		this.total_exchange = total_exchange;
	}

	/**
	 * 待提现金额
	 * 
	 * @return
	 */
/*	public Double getPending_exchange() {
		return pending_exchange;
	}*/

	/**
	 * 待提现金额
	 * 
	 * @param pending_exchange
	 */
/*	public void setPending_exchange(Double pending_exchange) {
		this.pending_exchange = pending_exchange;
	}*/

	@Override
	public String toString() {
		return "FxTotaltDTO [total_order=" + total_order + ", total_amount=" + total_amount + ", total_exchange="
				+ total_exchange /*+ ", pending_exchange=" + pending_exchange*/ + "]";
	}

}
