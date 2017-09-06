package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/** 
 * 订单表(o_orderInfo)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-02 18:15:20 
 */  
public class OrderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//订单编号
  	 private String orderId;
 	//提交时间
  	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	 private Date subTime;
 	//卖家编号
  	 private Integer sellerId;
 	//用户编号
  	 private String userId;
 	//买家姓名
  	 private String receiveName;
 	//电话
  	 private String phoneNumber;
 	//地址
  	 private String address;
 	//邮编
  	 private String zipCode;
 	//积分
  	 private Integer giftPoints;
 	//发票抬头
  	 private String invoiceType;
 	//发票编号
  	 private String invoiceNumber;
 	//是否结算(1：是；2：否)
  	 private Integer isSettlement;
 	//结算时间
  	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	 private Date settlementTime;
 	//用户确认收货时间
  	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	 private Date userConfirmTime;
 	//订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货中；7：退款中）
  	 private Integer orderStatus;
 	//订单类型
  	 private Integer orderType;
 	//备注
  	 private String remark;
 	//最后修改时间
  	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	 private Date lastModifiedTime;
 	//默认支付方式
  	 private Integer defaultPayment;
 	//卖家备注
  	 private String sellerRemark;
 	//Ip
  	 private String ip;
 	//支付流水号
  	 private String pay_serial_number;
 	//在线支付金额
  	 private Double onlinepayfee;
 	//父订单号
  	 private String perentId;
 	//订单总金额.
  	 private Double order_total_price;
 	//商家优惠金额
  	 private Double seller_discount;
 	//订单货款金额（订单总金额-商家优惠金额）
  	 private Double order_seller_price;
 	//商品总金额
  	 private Double totalMoney;
 	//用户应付金额
  	 private Double order_payment;
 	//商品的运费
  	 private Double freight_price;
 	//付款确认时间
  	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	 private Date payment_confirm_time;
 	//退款金额
  	 private Double refundMoney;
 	//支付金额
  	 private Double paidMoney;
 	//未支付金额
  	 private Double unPaidMoney;
 	//评价状态(1:未评价，2：已评价)
  	 private Integer estatus;
 	//售后状态（0正常 1换货 2退款3退款退货 4维修9售后关闭）
  	 private Integer sstatus;
 	//取消原因(1：我不想买了；2：填写信息错误，重拍；3：卖家缺货；4：其他原因)
  	 private Integer reason;



	 
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
    *提交时间
	* @return
    */ 
	public Date getSubTime() {
		return subTime;
	}
    /**
    *提交时间
	* @param subTime
    */ 
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
    /**
    *卖家编号
	* @return
    */ 
	public Integer getSellerId() {
		return sellerId;
	}
    /**
    *卖家编号
	* @param sellerId
    */ 
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
    /**
    *用户编号
	* @return
    */ 
	public String getUserId() {
		return userId;
	}
    /**
    *用户编号
	* @param userId
    */ 
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
    *买家姓名
	* @return
    */ 
	public String getReceiveName() {
		return receiveName;
	}
    /**
    *买家姓名
	* @param receiveName
    */ 
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
    /**
    *电话
	* @return
    */ 
	public String getPhoneNumber() {
		return phoneNumber;
	}
    /**
    *电话
	* @param phoneNumber
    */ 
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    /**
    *地址
	* @return
    */ 
	public String getAddress() {
		return address;
	}
    /**
    *地址
	* @param address
    */ 
	public void setAddress(String address) {
		this.address = address;
	}
    /**
    *邮编
	* @return
    */ 
	public String getZipCode() {
		return zipCode;
	}
    /**
    *邮编
	* @param zipCode
    */ 
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
    /**
    *积分
	* @return
    */ 
	public Integer getGiftPoints() {
		return giftPoints;
	}
    /**
    *积分
	* @param giftPoints
    */ 
	public void setGiftPoints(Integer giftPoints) {
		this.giftPoints = giftPoints;
	}
    /**
    *发票抬头
	* @return
    */ 
	public String getInvoiceType() {
		return invoiceType;
	}
    /**
    *发票抬头
	* @param invoiceType
    */ 
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
    /**
    *发票编号
	* @return
    */ 
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
    /**
    *发票编号
	* @param invoiceNumber
    */ 
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
    /**
    *是否结算(1：是；2：否)
	* @return
    */ 
	public Integer getIsSettlement() {
		return isSettlement;
	}
    /**
    *是否结算(1：是；2：否)
	* @param isSettlement
    */ 
	public void setIsSettlement(Integer isSettlement) {
		this.isSettlement = isSettlement;
	}
    /**
    *结算时间
	* @return
    */ 
	public Date getSettlementTime() {
		return settlementTime;
	}
    /**
    *结算时间
	* @param settlementTime
    */ 
	public void setSettlementTime(Date settlementTime) {
		this.settlementTime = settlementTime;
	}
    /**
    *用户确认收货时间
	* @return
    */ 
	public Date getUserConfirmTime() {
		return userConfirmTime;
	}
    /**
    *用户确认收货时间
	* @param userConfirmTime
    */ 
	public void setUserConfirmTime(Date userConfirmTime) {
		this.userConfirmTime = userConfirmTime;
	}
    /**
    *订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货中；7：退款中）
	* @return
    */ 
	public Integer getOrderStatus() {
		return orderStatus;
	}
    /**
    *订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货中；7：退款中）
	* @param orderStatus
    */ 
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
    /**
    *订单类型
	* @return
    */ 
	public Integer getOrderType() {
		return orderType;
	}
    /**
    *订单类型
	* @param orderType
    */ 
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
    /**
    *备注
	* @return
    */ 
	public String getRemark() {
		return remark;
	}
    /**
    *备注
	* @param remark
    */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
    /**
    *最后修改时间
	* @param lastModifiedTime
    */ 
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
    /**
    *默认支付方式
	* @return
    */ 
	public Integer getDefaultPayment() {
		return defaultPayment;
	}
    /**
    *默认支付方式
	* @param defaultPayment
    */ 
	public void setDefaultPayment(Integer defaultPayment) {
		this.defaultPayment = defaultPayment;
	}
    /**
    *卖家备注
	* @return
    */ 
	public String getSellerRemark() {
		return sellerRemark;
	}
    /**
    *卖家备注
	* @param sellerRemark
    */ 
	public void setSellerRemark(String sellerRemark) {
		this.sellerRemark = sellerRemark;
	}
    /**
    *Ip
	* @return
    */ 
	public String getIp() {
		return ip;
	}
    /**
    *Ip
	* @param ip
    */ 
	public void setIp(String ip) {
		this.ip = ip;
	}
    /**
    *支付流水号
	* @return
    */ 
	public String getPay_serial_number() {
		return pay_serial_number;
	}
    /**
    *支付流水号
	* @param pay_serial_number
    */ 
	public void setPay_serial_number(String pay_serial_number) {
		this.pay_serial_number = pay_serial_number;
	}
    /**
    *在线支付金额
	* @return
    */ 
	public Double getOnlinepayfee() {
		return onlinepayfee;
	}
    /**
    *在线支付金额
	* @param onlinepayfee
    */ 
	public void setOnlinepayfee(Double onlinepayfee) {
		this.onlinepayfee = onlinepayfee;
	}
    /**
    *父订单号
	* @return
    */ 
	public String getPerentId() {
		return perentId;
	}
    /**
    *父订单号
	* @param perentId
    */ 
	public void setPerentId(String perentId) {
		this.perentId = perentId;
	}
    /**
    *订单总金额.
	* @return
    */ 
	public Double getOrder_total_price() {
		return order_total_price;
	}
    /**
    *订单总金额.
	* @param order_total_price
    */ 
	public void setOrder_total_price(Double order_total_price) {
		this.order_total_price = order_total_price;
	}
    /**
    *商家优惠金额
	* @return
    */ 
	public Double getSeller_discount() {
		return seller_discount;
	}
    /**
    *商家优惠金额
	* @param seller_discount
    */ 
	public void setSeller_discount(Double seller_discount) {
		this.seller_discount = seller_discount;
	}
    /**
    *订单货款金额（订单总金额-商家优惠金额）
	* @return
    */ 
	public Double getOrder_seller_price() {
		return order_seller_price;
	}
    /**
    *订单货款金额（订单总金额-商家优惠金额）
	* @param order_seller_price
    */ 
	public void setOrder_seller_price(Double order_seller_price) {
		this.order_seller_price = order_seller_price;
	}
    /**
    *商品总金额
	* @return
    */ 
	public Double getTotalMoney() {
		return totalMoney;
	}
    /**
    *商品总金额
	* @param totalMoney
    */ 
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
    /**
    *用户应付金额
	* @return
    */ 
	public Double getOrder_payment() {
		return order_payment;
	}
    /**
    *用户应付金额
	* @param order_payment
    */ 
	public void setOrder_payment(Double order_payment) {
		this.order_payment = order_payment;
	}
    /**
    *商品的运费
	* @return
    */ 
	public Double getFreight_price() {
		return freight_price;
	}
    /**
    *商品的运费
	* @param freight_price
    */ 
	public void setFreight_price(Double freight_price) {
		this.freight_price = freight_price;
	}
    /**
    *付款确认时间
	* @return
    */ 
	public Date getPayment_confirm_time() {
		return payment_confirm_time;
	}
    /**
    *付款确认时间
	* @param payment_confirm_time
    */ 
	public void setPayment_confirm_time(Date payment_confirm_time) {
		this.payment_confirm_time = payment_confirm_time;
	}
    /**
    *退款金额
	* @return
    */ 
	public Double getRefundMoney() {
		return refundMoney;
	}
    /**
    *退款金额
	* @param refundMoney
    */ 
	public void setRefundMoney(Double refundMoney) {
		this.refundMoney = refundMoney;
	}
    /**
    *支付金额
	* @return
    */ 
	public Double getPaidMoney() {
		return paidMoney;
	}
    /**
    *支付金额
	* @param paidMoney
    */ 
	public void setPaidMoney(Double paidMoney) {
		this.paidMoney = paidMoney;
	}
    /**
    *未支付金额
	* @return
    */ 
	public Double getUnPaidMoney() {
		return unPaidMoney;
	}
    /**
    *未支付金额
	* @param unPaidMoney
    */ 
	public void setUnPaidMoney(Double unPaidMoney) {
		this.unPaidMoney = unPaidMoney;
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
    *售后状态（0正常 1退货2换货3维修9售后关闭）
	* @return
    */ 
	public Integer getSstatus() {
		return sstatus;
	}
    /**
    *售后状态（0正常 1退货2换货3维修9售后关闭）
	* @param sstatus
    */ 
	public void setSstatus(Integer sstatus) {
		this.sstatus = sstatus;
	}
    /**
    *取消原因(1：我不想买了；2：填写信息错误，重拍；3：卖家缺货；4：其他原因)
	* @return
    */ 
	public Integer getReason() {
		return reason;
	}
    /**
    *取消原因(1：我不想买了；2：填写信息错误，重拍；3：卖家缺货；4：其他原因)
	* @param reason
    */ 
	public void setReason(Integer reason) {
		this.reason = reason;
	}
	
}
