package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 特卖商品(mall_special_sale_sku)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:48 
 */  
public class MallSpecialSaleSkuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 
 	//sku
  	 private String sku;
 	//开始时间
  	 private Date starttime;
 	//结束时间
  	 private Date endtime;
 	//活动类型
  	 private Integer activitytype;
 	//活动价
  	 private Double activityprice;
 	//活动数量
  	 private Double activitystocks;
 	//折扣
  	 private Double discount;
  	 
 	//商品名称
 	private String pName;
  	//市场价
  	 private Double marketprice;
 	//商品主图
  	 private String logo;


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
    *开始时间
	* @return
    */ 
	public Date getStarttime() {
		return starttime;
	}
    /**
    *开始时间
	* @param starttime
    */ 
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
    /**
    *结束时间
	* @return
    */ 
	public Date getEndtime() {
		return endtime;
	}
    /**
    *结束时间
	* @param endtime
    */ 
	public void setEndtime(Date endtime) {
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
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "MallSpecialSaleSkuDTO [sku=" + sku + ", starttime=" + starttime + ", endtime="
				+ endtime + ", activitytype=" + activitytype + ", activityprice=" + activityprice + ", activitystocks="
				+ activitystocks + ", discount=" + discount + ", pName=" + pName + ", marketprice=" + marketprice
				+ ", logo=" + logo + "]";
	}
	
	
}
