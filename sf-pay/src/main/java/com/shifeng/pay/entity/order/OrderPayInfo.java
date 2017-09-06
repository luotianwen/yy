package com.shifeng.pay.entity.order;

/**
 * 订单支付信息
 * @author WinZhong
 *
 */
public class OrderPayInfo {
	
	//订单号
	private String order_id;
	
	//订单付款总金额
	private double total_fee;
	
	//订单类型
	private String order_type;
	
	//交易状态（0：成功；1：失败）
	private String trade_status;
	
	//返回地址
	private String return_url;
	
	//token
	private String token;

	/**
	 * 订单号
	 * @return
	 */
	public String getOrder_id() {
		return order_id;
	}

	/**
	 * 订单号
	 * @param order_id
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	/**
	 * 订单付款总金额
	 * @return
	 */
	public double getTotal_fee() {
		return total_fee;
	}

	/**
	 * 订单付款总金额
	 * @param total_fee
	 */
	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 订单类型
	 * @return
	 */
	public String getOrder_type() {
		return order_type;
	}

	/**
	 * 订单类型
	 * @param order_type
	 */
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	
	
	 
	/**
	 * 交易状态（0：成功；1：失败）
	 * @return
	 */
	public String getTrade_status() {
		return trade_status;
	}

	/**
	 * 交易状态（0：成功；1：失败）
	 * @param trade_status
	 */
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	
	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "OrderPayInfo [order_id=" + order_id + ", total_fee=" + total_fee + ", order_type=" + order_type
				+ ", trade_status=" + trade_status + ", return_url=" + return_url + "]";
	}

	
	 
	 

}
