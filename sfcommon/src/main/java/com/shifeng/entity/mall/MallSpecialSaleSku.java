package com.shifeng.entity.mall;

import java.io.Serializable;
/** 
 * 特卖商品(mall_special_sale_sku)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  String: 2017-05-22 16:46:48 
 */  
public class MallSpecialSaleSku implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//pid
  	 private Integer pid;
 	//sku
  	 private String sku;
 	//序号
  	 private Integer sort;
 	//开始时间
  	 private String starttime;
 	//结束时间
  	 private String endtime;
 	//活动类型
  	 private Integer activitytype;
 	//活动价
  	 private Double activityprice;
 	//活动数量
  	 private Double activitystocks;
 	//折扣
  	 private Double discount;



	 
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
    *pid
	* @return
    */ 
	public Integer getPid() {
		return pid;
	}
    /**
    *pid
	* @param pid
    */ 
	public void setPid(Integer pid) {
		this.pid = pid;
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
    *序号
	* @return
    */ 
	public Integer getSort() {
		return sort;
	}
    /**
    *序号
	* @param sort
    */ 
	public void setSort(Integer sort) {
		this.sort = sort;
	}
    /**
    *开始时间
	* @return
    */ 
	public String getStarttime() {
		return starttime;
	}
    /**
    *开始时间
	* @param starttime
    */ 
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
    /**
    *结束时间
	* @return
    */ 
	public String getEndtime() {
		return endtime;
	}
    /**
    *结束时间
	* @param endtime
    */ 
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
    /**
    *活动类型
	* @return
    */ 
	public Integer getActivitytype() {
		return activitytype;
	}
    /**
    *活动类型
	* @param activitytype
    */ 
	public void setActivitytype(Integer activitytype) {
		this.activitytype = activitytype;
	}
    /**
    *活动价
	* @return
    */ 
	public Double getActivityprice() {
		return activityprice;
	}
    /**
    *活动价
	* @param activityprice
    */ 
	public void setActivityprice(Double activityprice) {
		this.activityprice = activityprice;
	}
    /**
    *活动数量
	* @return
    */ 
	public Double getActivitystocks() {
		return activitystocks;
	}
    /**
    *活动数量
	* @param activitystocks
    */ 
	public void setActivitystocks(Double activitystocks) {
		this.activitystocks = activitystocks;
	}
    /**
    *折扣
	* @return
    */ 
	public Double getDiscount() {
		return discount;
	}
    /**
    *折扣
	* @param discount
    */ 
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
}
