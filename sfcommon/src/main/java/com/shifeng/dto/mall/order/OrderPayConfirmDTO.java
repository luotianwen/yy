package com.shifeng.dto.mall.order;

import java.io.Serializable;

/**
 * 订单支付信息确认DTO
 * @author Win
 *
 */
public class OrderPayConfirmDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
 	//订单编号
 	 private String orderId;
 	//订单总金额.
  	 private double order_total_price;
 	//商家优惠金额
  	 private double seller_discount;
 	//订单货款金额（订单总金额-商家优惠金额）
  	 private double order_seller_price;
 	//商品总金额
  	 private double totalMoney;
 	//用户应付金额
  	 private double order_payment;
 	//商品的运费
  	 private double freight_price;
	
  	 
     /**
      *订单编号
  	* @return
      */ 
  	public String getOrderId() {
  		return orderId;
  	}
      /**
      *订单编号
  	* @param orderId
      */ 
  	public void setOrderId(String orderId) {
  		this.orderId = orderId;
  	}
     /**
     *订单总金额.
 	* @return
     */ 
 	public double getOrder_total_price() {
 		return order_total_price;
 	}
     /**
     *订单总金额.
 	* @param order_total_price
     */ 
 	public void setOrder_total_price(double order_total_price) {
 		this.order_total_price = order_total_price;
 	}
     /**
     *商家优惠金额
 	* @return
     */ 
 	public double getSeller_discount() {
 		return seller_discount;
 	}
     /**
     *商家优惠金额
 	* @param seller_discount
     */ 
 	public void setSeller_discount(double seller_discount) {
 		this.seller_discount = seller_discount;
 	}
     /**
     *订单货款金额（订单总金额-商家优惠金额）
 	* @return
     */ 
 	public double getOrder_seller_price() {
 		return order_seller_price;
 	}
     /**
     *订单货款金额（订单总金额-商家优惠金额）
 	* @param order_seller_price
     */ 
 	public void setOrder_seller_price(double order_seller_price) {
 		this.order_seller_price = order_seller_price;
 	}
     /**
     *商品总金额
 	* @return
     */ 
 	public double getTotalMoney() {
 		return totalMoney;
 	}
     /**
     *商品总金额
 	* @param totalMoney
     */ 
 	public void setTotalMoney(double totalMoney) {
 		this.totalMoney = totalMoney;
 	}
     /**
     *用户应付金额
 	* @return
     */ 
 	public double getOrder_payment() {
 		return order_payment;
 	}
     /**
     *用户应付金额
 	* @param order_payment
     */ 
 	public void setOrder_payment(double order_payment) {
 		this.order_payment = order_payment;
 	}
     /**
     *商品的运费
 	* @return
     */ 
 	public double getFreight_price() {
 		return freight_price;
 	}
     /**
     *商品的运费
 	* @param freight_price
     */ 
 	public void setFreight_price(double freight_price) {
 		this.freight_price = freight_price;
 	}
	@Override
	public String toString() {
		return "OrderPayConfirmDTO [orderId=" + orderId + ", order_total_price=" + order_total_price
				+ ", seller_discount=" + seller_discount + ", order_seller_price=" + order_seller_price
				+ ", totalMoney=" + totalMoney + ", order_payment=" + order_payment + ", freight_price=" + freight_price
				+ "]";
	}

 	
 	
}
