package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 关注的商品(mall_followWare)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
public class MallFollowWare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//关注ID 
  	 private Integer fid;
 	//用户ID 
  	 private String userId;
 	//商品ID 
  	 private Integer pid;
 	//商品sku 
  	 private Integer sku;
 	//关注时商品价格 
  	 private double price;
 	//关注时间 
  	 private Date followTime;



	 
    /**
    *关注ID 
	* @return
    */ 
	public Integer getFid() {
		return fid;
	}
    /**
    *关注ID 
	* @param type
    */ 
	public void setFid(Integer fid) {
		this.fid = fid;
	}
    /**
    *用户ID 
	* @return
    */ 
	public String getUserId() {
		return userId;
	}
    /**
    *用户ID 
	* @param type
    */ 
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
    *商品ID 
	* @return
    */ 
	public Integer getPid() {
		return pid;
	}
    /**
    *商品ID 
	* @param type
    */ 
	public void setPid(Integer pid) {
		this.pid = pid;
	}
    /**
    *商品sku 
	* @return
    */ 
	public Integer getSku() {
		return sku;
	}
    /**
    *商品sku 
	* @param type
    */ 
	public void setSku(Integer sku) {
		this.sku = sku;
	}
    /**
    *关注时商品价格 
	* @return
    */ 
	public double getPrice() {
		return price;
	}
    /**
    *关注时商品价格 
	* @param type
    */ 
	public void setPrice(double price) {
		this.price = price;
	}
    /**
    *关注时间 
	* @return
    */ 
	public Date getFollowTime() {
		return followTime;
	}
    /**
    *关注时间 
	* @param type
    */ 
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	
}
