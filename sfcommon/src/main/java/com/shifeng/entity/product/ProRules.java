package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * SKU表(p_pro_rules)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-15 15:49:02 
 */  
public class ProRules implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer sku;
 	//商品编号
  	 private Integer pid;
 	//库存
  	 private Integer stocks;
 	//重量
  	 private Double weight;
 	//进货价
  	 private Double costprice;
 	//市场价
  	 private Double marketprice;
 	//世峰价
  	 private Double price;
 	//商品货号
  	 private String number;
 	//图片编号
  	 private Integer imageid;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;
 	//颜色
  	 private Integer colorid;
 	//规格
  	 private Integer specid;
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


	 
    /**
    *sku
	* @return
    */ 
	public Integer getSku() {
		return sku;
	}
    /**
    *sku
	* @param sku
    */ 
	public void setSku(Integer sku) {
		this.sku = sku;
	}
    /**
    *商品编号
	* @return
    */ 
	public Integer getPid() {
		return pid;
	}
    /**
    *商品编号
	* @param pid
    */ 
	public void setPid(Integer pid) {
		this.pid = pid;
	}
    /**
    *库存
	* @return
    */ 
	public Integer getStocks() {
		return stocks;
	}
    /**
    *库存
	* @param stocks
    */ 
	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}
    /**
    *重量
	* @return
    */ 
	public Double getWeight() {
		return weight;
	}
    /**
    *重量
	* @param weight
    */ 
	public void setWeight(Double weight) {
		this.weight = weight;
	}
    /**
    *进货价
	* @return
    */ 
	public Double getCostprice() {
		return costprice;
	}
    /**
    *进货价
	* @param costprice
    */ 
	public void setCostprice(Double costprice) {
		this.costprice = costprice;
	}
    /**
    *市场价
	* @return
    */ 
	public Double getMarketprice() {
		return marketprice;
	}
    /**
    *市场价
	* @param marketprice
    */ 
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}
    /**
    *世峰价
	* @return
    */ 
	public Double getPrice() {
		return price;
	}
    /**
    *世峰价
	* @param price
    */ 
	public void setPrice(Double price) {
		this.price = price;
	}
    /**
    *商品货号
	* @return
    */ 
	public String getNumber() {
		return number;
	}
    /**
    *商品货号
	* @param number
    */ 
	public void setNumber(String number) {
		this.number = number;
	}
    /**
    *图片编号
	* @return
    */ 
	public Integer getImageid() {
		return imageid;
	}
    /**
    *图片编号
	* @param imageid
    */ 
	public void setImageid(Integer imageid) {
		this.imageid = imageid;
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
    *颜色
	* @return
    */ 
	public Integer getColorid() {
		return colorid;
	}
    /**
    *颜色
	* @param colorid
    */ 
	public void setColorid(Integer colorid) {
		this.colorid = colorid;
	}
    /**
    *规格
	* @return
    */ 
	public Integer getSpecid() {
		return specid;
	}
    /**
    *规格
	* @param specid
    */ 
	public void setSpecid(Integer specid) {
		this.specid = specid;
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
	 * 折扣
	 * @return
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * 折扣
	 * @param discount
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
}
