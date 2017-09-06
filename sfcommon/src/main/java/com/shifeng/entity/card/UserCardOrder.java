package com.shifeng.entity.card;

import java.io.Serializable;
import java.util.Date;
/** 
 * 用户世峰卡消费(c_user_card_order)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-01 14:57:04 
 */  
public class UserCardOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//用户id
  	 private Integer userid;
 	//订单id
  	 private String orderid;
 	//消费时间
  	 private Date ordertime;
 	//备注
  	 private String note;
 	//金额
  	 private double money;
 	//世峰卡号
  	 private String cardnumber;
 	//消费前金额
  	 private double before_money;
 	//消费后金额
  	 private double after_money;



	 
    /**
    *用户id
	* @return
    */ 
	public Integer getUserid() {
		return userid;
	}
    /**
    *用户id
	* @param userid
    */ 
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
    /**
    *订单id
	* @return
    */ 
	public String getOrderid() {
		return orderid;
	}
    /**
    *订单id
	* @param orderid
    */ 
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
    /**
    *消费时间
	* @return
    */ 
	public Date getOrdertime() {
		return ordertime;
	}
    /**
    *消费时间
	* @param ordertime
    */ 
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
    /**
    *备注
	* @return
    */ 
	public String getNote() {
		return note;
	}
    /**
    *备注
	* @param note
    */ 
	public void setNote(String note) {
		this.note = note;
	}
    /**
    *金额
	* @return
    */ 
	public double getMoney() {
		return money;
	}
    /**
    *金额
	* @param money
    */ 
	public void setMoney(double money) {
		this.money = money;
	}
    /**
    *世峰卡号
	* @return
    */ 
	public String getCardnumber() {
		return cardnumber;
	}
    /**
    *世峰卡号
	* @param cardnumber
    */ 
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
    /**
    *消费前金额
	* @return
    */ 
	public double getBefore_money() {
		return before_money;
	}
    /**
    *消费前金额
	* @param before_money
    */ 
	public void setBefore_money(double before_money) {
		this.before_money = before_money;
	}
    /**
    *消费后金额
	* @return
    */ 
	public double getAfter_money() {
		return after_money;
	}
    /**
    *消费后金额
	* @param after_money
    */ 
	public void setAfter_money(double after_money) {
		this.after_money = after_money;
	}
	
}
