package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 父订单折扣表(o_porderInfo_discount)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:30 
 */  
public class PorderInfoDiscount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//父订单编号
  	 private int perentId;
 	//折扣类型（1为优惠券2世峰e卡）
  	 private int type;
 	//序号（者优惠券id或卡号）
  	 private String number;
 	//金额
  	 private double discountMoney;



	 
    /**
    *父订单编号
	* @return
    */ 
	public int getPerentId() {
		return perentId;
	}
    /**
    *父订单编号
	* @param perentId
    */ 
	public void setPerentId(int perentId) {
		this.perentId = perentId;
	}
    /**
    *折扣类型（1为优惠券2世峰e卡）
	* @return
    */ 
	public int getType() {
		return type;
	}
    /**
    *折扣类型（1为优惠券2世峰e卡）
	* @param type
    */ 
	public void setType(int type) {
		this.type = type;
	}
    /**
    *序号（者优惠券id或卡号）
	* @return
    */ 
	public String getNumber() {
		return number;
	}
    /**
    *序号（者优惠券id或卡号）
	* @param number
    */ 
	public void setNumber(String number) {
		this.number = number;
	}
    /**
    *金额
	* @return
    */ 
	public double getDiscountMoney() {
		return discountMoney;
	}
    /**
    *金额
	* @param discountMoney
    */ 
	public void setDiscountMoney(double discountMoney) {
		this.discountMoney = discountMoney;
	}
	
}
