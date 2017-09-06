package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//订单ID
	private String orderId;
	//店铺ID
	private String shopId;
	//店铺名称
	private String shopName;
	//商品数量
	private Integer wareNum;
	//订单应付金额（包含运费）
	private Double order_payment;
	//运费
	private Double freight_price;
	//下单时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date subTime;
	//订单状态
	private Integer orderStatus;
	//订单商品明细
	private List<OrderDetailInfoDTO> wares;
	
	

	//收件人
	private String addressee;
	//电话
	private String phone;
	//收货地址
	private String address;
	
	

	//订单快递
	private List<OrderExpressDTO> express;
	

 	//评价状态(1:已评价，2：未评价)
  	 private Integer estatus;
 	//售后状态
  	 private Integer sstatus;
	
  	 //订单发票
  	 private OrderInvoiceDTO invoice;
  	 
  	//支付方式
  	 private String paymentMethod;
  	 
  	//支付时间
  	 private String paytime;
  	 
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	 
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Date getSubTime() {
		return subTime;
	}
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getWareNum() {
		return wareNum;
	}
	public void setWareNum(Integer wareNum) {
		this.wareNum = wareNum;
	}
	public Double getOrder_payment() {
		return order_payment;
	}
	public void setOrder_payment(Double order_payment) {
		this.order_payment = order_payment;
	}
	public Double getFreight_price() {
		return freight_price;
	}
	public void setFreight_price(Double freight_price) {
		this.freight_price = freight_price;
	}
	
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	public List<OrderDetailInfoDTO> getWares() {
		return wares;
	}
	public void setWares(List<OrderDetailInfoDTO> wares) {
		this.wares = wares;
	}
	
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public List<OrderExpressDTO> getExpress() {
		return express;
	}
	public void setExpress(List<OrderExpressDTO> express) {
		this.express = express;
	}
	

    /**
    *评价状态(1:未评价，2：已评价)
	* @return
    */ 
	public Integer getEstatus() {
		return estatus;
	}
    /**
    *评价状态(1:未评价，2：已评价)
	* @param estatus
    */ 
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
    /**
    *售后状态
	* @return
    */ 
	public Integer getSstatus() {
		return sstatus;
	}
    /**
    *售后状态
	* @param sstatus
    */ 
	public void setSstatus(Integer sstatus) {
		this.sstatus = sstatus;
	}
	
	
	public OrderInvoiceDTO getInvoice() {
		return invoice;
	}
	public void setInvoice(OrderInvoiceDTO invoice) {
		this.invoice = invoice;
	}
	
	public String getPaymentMethod() {
		if(orderStatus != null){
			//订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；；6：退货中；7：退款中）
			if(orderStatus > 1 && orderStatus < 4){
				return "在线支付";
			}else if(orderStatus > 4 && orderStatus <= 7){
				return "在线支付";
			}
		}
		return null;
		//return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	@Override
	public String toString() {
		return "OrderInfoDTO [orderId=" + orderId + ", shopId=" + shopId + ", shopName=" + shopName + ", wareNum="
				+ wareNum + ", order_payment=" + order_payment + ", freight_price=" + freight_price + ", subTime="
				+ subTime + ", orderStatus=" + orderStatus + ", wares=" + wares + ", addressee=" + addressee
				+ ", phone=" + phone + ", address=" + address + ", express=" + express + ", estatus=" + estatus
				+ ", sstatus=" + sstatus + ", invoice=" + invoice + ", paymentMethod=" + paymentMethod + ", paytime="
				+ paytime + "]";
	}

	
	
	
}
