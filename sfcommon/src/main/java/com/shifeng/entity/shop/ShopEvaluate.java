package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺评价(p_shop_evaluate)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 15:37:29 
 */  
public class ShopEvaluate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//用户编号
  	 private String userId;
 	//买家姓名
  	 private String receiveName;
 	//订单id
  	 private String orderid;
 	//店铺编号
  	 private Integer shopid;
  	//商品描述评分
  	 private Integer describe_score;
 	//物流服务
  	 private Integer lservice;
 	//店铺服务
  	 private Integer sservice;
 	//审核状态（1：未审核；2：审核成功；3：审核失败）
  	 private Integer state;
 	//创建时间
  	 private Date cdate;



	 
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
    *店铺编号
	* @return
    */ 
	public Integer getShopid() {
		return shopid;
	}
    /**
    *店铺编号
	* @param shopid
    */ 
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	/**
	 * 商品描述评分
	 * @return
	 */
	public Integer getDescribe_score() {
		return describe_score;
	}
	/**
	 * 商品描述评分
	 * @param describe_score
	 */
	public void setDescribe_score(Integer describe_score) {
		this.describe_score = describe_score;
	}
    /**
    *物流服务
	* @return
    */ 
	public Integer getLservice() {
		return lservice;
	}
    /**
    *物流服务
	* @param lservice
    */ 
	public void setLservice(Integer lservice) {
		this.lservice = lservice;
	}
    /**
    *店铺服务
	* @return
    */ 
	public Integer getSservice() {
		return sservice;
	}
    /**
    *店铺服务
	* @param sservice
    */ 
	public void setSservice(Integer sservice) {
		this.sservice = sservice;
	}
    /**
    *审核状态（1：未审核；2：审核成功；3：审核失败）
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *审核状态（1：未审核；2：审核成功；3：审核失败）
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getCdate() {
		return cdate;
	}
    /**
    *创建时间
	* @param cdate
    */ 
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
}
