package com.shifeng.entity.shop;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺续费表(s_shopinfo_pay)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:44:58 
 */  
public class ShopinfoPay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//入驻id
  	 private int s_merchants_id;
	//店铺名称
	private String shopname;
	//公司名称
	private String name;
 	//用户id
  	 private int userid;
 	//订单id
  	 private String orderId;
 	//支付码
  	 private String pay_serial_number;
 	//支付金额
  	 private double payAmount;
 	//说明
  	 private String note;
 	//状态
  	 private int status;
  	 //方式
  	 private String method;
 	//提交时间
  	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	 private Date subTime;
 	//备注
  	 private String remark;
 	//最后修改时间
  	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
  	 //变更原因
  	 private String reason;

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
    *入驻id
	* @return
    */ 
	public int getS_merchants_id() {
		return s_merchants_id;
	}
    /**
    *入驻id
	* @param s_merchants_id
    */ 
	public void setS_merchants_id(int s_merchants_id) {
		this.s_merchants_id = s_merchants_id;
	}
    /**
    *用户id
	* @return
    */ 
	public int getUserid() {
		return userid;
	}
    /**
    *用户id
	* @param userid
    */ 
	public void setUserid(int userid) {
		this.userid = userid;
	}
    /**
    *订单id
	* @return
    */ 
	public String getOrderId() {
		return orderId;
	}
    /**
    *订单id
	* @param orderId
    */ 
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
    *支付金额
	* @return
    */ 
	public double getPayAmount() {
		return payAmount;
	}
    /**
    *支付金额
	* @param payAmount
    */ 
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
    /**
    *说明
	* @return
    */ 
	public String getNote() {
		return note;
	}
    /**
    *说明
	* @param note
    */ 
	public void setNote(String note) {
		this.note = note;
	}
	/**
    *状态
	* @return
    */ 
	public int getStatus() {
		return status;
	}
    /**
    *状态
	* @param status
    */ 
	public void setStatus(int status) {
		this.status = status;
	}
	/**
    *方式
	* @return
    */ 
	public String getMethod() {
		return method;
	}
    /**
    *方式
	* @param method
    */ 
	public void setMethod(String method) {
		this.method = method;
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
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后修改时间
	* @param lasttime
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *最后修改人
	* @return
    */ 
	public String getUpdatename() {
		return updatename;
	}
    /**
    *最后修改人
	* @param updatename
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
	/**
	 * 变更原因
	 * @return
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 变更原因
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
