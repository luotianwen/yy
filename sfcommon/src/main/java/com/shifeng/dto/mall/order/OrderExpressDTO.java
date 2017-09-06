package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单快递(o_express_order)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:31 
 */  
public class OrderExpressDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 
 	//快递单号
  	 private String expressNumber;
 	//快递id
  	 private Integer expressId;
 	//快递名称
  	 private String expressName;
 	//快递电话
  	 private String expressPhone;
 	//快递Code
  	 private String expressCode;
 	//快递状态
  	 private String expressStatus;
  

 
    /**
    *快递单号
	* @return
    */ 
	public String getExpressNumber() {
		return expressNumber;
	}
    /**
    *快递单号
	* @param expressNumber
    */ 
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
    /**
    *快递id
	* @return
    */ 
	public Integer getExpressId() {
		return expressId;
	}
    /**
    *快递id
	* @param expressId
    */ 
	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}
    /**
    *快递名称
	* @return
    */ 
	public String getExpressName() {
		return expressName;
	}
    /**
    *快递名称
	* @param expressName
    */ 
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
    /**
    *快递Code
	* @return
    */ 
	public String getExpressCode() {
		return expressCode;
	}
    /**
    *快递Code
	* @param expressCode
    */ 
	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	
	/**
	 * 快递电话
	 * @return
	 */
	public String getExpressPhone() {
		return expressPhone;
	}
	/**
	 * 快递电话
	 */
	public void setExpressPhone(String expressPhone) {
		this.expressPhone = expressPhone;
	}
	
	/**
	 * 快递状态
	 * @return
	 */
	public String getExpressStatus() {
		return expressStatus;
	}
	/**
	 * 快递状态
	 * @param expressStatus
	 */
	public void setExpressStatus(String expressStatus) {
		this.expressStatus = expressStatus;
	}
	@Override
	public String toString() {
		return "OrderExpressDTO [expressNumber=" + expressNumber + ", expressId=" + expressId + ", expressName="
				+ expressName + ", expressPhone=" + expressPhone + ", expressCode=" + expressCode + "]";
	}
     
	
}
