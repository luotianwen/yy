package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 支付表(o_paymentInfo)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:31 
 */  
public class PaymentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private int id;
 	//支付码
  	 private String pay_serial_number;
 	//支付方式
  	 private int paymentType;
 	//支付方式名称
  	 private String businessName;
 	//金额
  	 private double totalMoney;
 	//购买者编号
  	 private int userId;
 	//支付流水号
  	 private String tradeNo;
 	//支付时间
  	 private Date notifyTime;
 	//提交时间
  	 private Date subTime;
 	//支付状态
  	 private int tradeStatus;



	 
    /**
    *主键
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *主键
	* @param id
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *支付码
	* @return
    */ 
	public String getPay_serial_number() {
		return pay_serial_number;
	}
    /**
    *支付码
	* @param pay_serial_number
    */ 
	public void setPay_serial_number(String pay_serial_number) {
		this.pay_serial_number = pay_serial_number;
	}
    /**
    *支付方式
	* @return
    */ 
	public int getPaymentType() {
		return paymentType;
	}
    /**
    *支付方式
	* @param paymentType
    */ 
	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}
    /**
    *支付方式名称
	* @return
    */ 
	public String getBusinessName() {
		return businessName;
	}
    /**
    *支付方式名称
	* @param businessName
    */ 
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
    /**
    *金额
	* @return
    */ 
	public double getTotalMoney() {
		return totalMoney;
	}
    /**
    *金额
	* @param totalMoney
    */ 
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
    /**
    *购买者编号
	* @return
    */ 
	public int getUserId() {
		return userId;
	}
    /**
    *购买者编号
	* @param userId
    */ 
	public void setUserId(int userId) {
		this.userId = userId;
	}
    /**
    *支付流水号
	* @return
    */ 
	public String getTradeNo() {
		return tradeNo;
	}
    /**
    *支付流水号
	* @param tradeNo
    */ 
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
    /**
    *支付时间
	* @return
    */ 
	public Date getNotifyTime() {
		return notifyTime;
	}
    /**
    *支付时间
	* @param notifyTime
    */ 
	public void setNotifyTime(Date notifyTime) {
		this.notifyTime = notifyTime;
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
    *支付状态
	* @return
    */ 
	public int getTradeStatus() {
		return tradeStatus;
	}
    /**
    *支付状态
	* @param tradeStatus
    */ 
	public void setTradeStatus(int tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
}
