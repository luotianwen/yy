package com.shifeng.entity.user;

import java.io.Serializable;
import java.util.Date;
/** 
 * 购物车(mall_cart)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-20 16:16:04 
 */  
public class MallCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id id
  	 private Integer id;
 	//用户id 用户id
  	 private String userid;
 	//sku sku
  	 private String sku;
 	//数量 数量
  	 private Integer number;
 	//店铺id 店铺id
  	 private Integer shopid;
 	//创建时间 创建时间
  	 private Date cdate;
 	//当时价格 当时价格
  	 private double price;



	 
    /**
    *id id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id id
	* @param type
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *用户id 用户id
	* @return
    */ 
	public String getUserid() {
		return userid;
	}
    /**
    *用户id 用户id
	* @param type
    */ 
	public void setUserid(String userid) {
		this.userid = userid;
	}
    /**
    *sku sku
	* @return
    */ 
	public String getSku() {
		return sku;
	}
    /**
    *sku sku
	* @param type
    */ 
	public void setSku(String sku) {
		this.sku = sku;
	}
    /**
    *数量 数量
	* @return
    */ 
	public Integer getNumber() {
		return number;
	}
    /**
    *数量 数量
	* @param type
    */ 
	public void setNumber(Integer number) {
		this.number = number;
	}
    /**
    *店铺id 店铺id
	* @return
    */ 
	public Integer getShopid() {
		return shopid;
	}
    /**
    *店铺id 店铺id
	* @param type
    */ 
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
    /**
    *创建时间 创建时间
	* @return
    */ 
	public Date getCdate() {
		return cdate;
	}
    /**
    *创建时间 创建时间
	* @param type
    */ 
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
    /**
    *当时价格 当时价格
	* @return
    */ 
	public double getPrice() {
		return price;
	}
    /**
    *当时价格 当时价格
	* @param type
    */ 
	public void setPrice(double price) {
		this.price = price;
	}
	
}
