package com.shifeng.entity.mall;

import java.io.Serializable;
/** 
 * 购物车(mall_cart)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:03:30 
 */  
public class MallCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//用户id
  	 private String userid;
 	//sku
  	 private String sku;
 	//数量
  	 private Integer number;
 	//店铺id
  	 private Integer shopid;
 	//创建时间
  	 private String cdate;
	//创建时间
	private String edate;
 	//当时价格
  	 private Double price;
	private String  uname;


	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
    *id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *用户id
	* @return
    */ 
	public String getUserid() {
		return userid;
	}
    /**
    *用户id
	* @param userid
    */ 
	public void setUserid(String userid) {
		this.userid = userid;
	}
    /**
    *sku
	* @return
    */ 
	public String getSku() {
		return sku;
	}
    /**
    *sku
	* @param sku
    */ 
	public void setSku(String sku) {
		this.sku = sku;
	}
    /**
    *数量
	* @return
    */ 
	public Integer getNumber() {
		return number;
	}
    /**
    *数量
	* @param number
    */ 
	public void setNumber(Integer number) {
		this.number = number;
	}
    /**
    *店铺id
	* @return
    */ 
	public Integer getShopid() {
		return shopid;
	}
    /**
    *店铺id
	* @param shopid
    */ 
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public String getCdate() {
		return cdate;
	}

	/**
    *当时价格
	* @return
    */ 
	public Double getPrice() {
		return price;
	}
    /**
    *当时价格
	* @param price
    */ 
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
