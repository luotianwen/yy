package com.shifeng.dto.mall.ware;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 商品sku基本信息 DTO
 * @author WinZhong
 *
 */
public class SkusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  	 
  	//商品 SKU 
  	 private Integer sku;
  	//库存
   	 private Integer stocks;
  	//重量
   	 private Integer weight;
  	//市场价
   	 private Double marketprice;
  	//世峰价
   	 private Double price;
 	//颜色
  	 private Integer colorid;
 	//颜色名称
  	 private String colorName;
 	//规格
  	 private Integer specid;
 	//规格名称
  	 private String specName;
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
  	 
  	 //sku商品图片
  	 private List<String> imgList;
  	 
	 
   
	
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
	public Integer getWeight() {
		return weight;
	}
    /**
    *重量
	* @param weight
    */ 
	public void setWeight(Integer weight) {
		this.weight = weight;
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
	 * 世峰价
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
    /**
    *世峰价
	* @return
    */ 
	public Double getPrice() {
		return price;
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
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	
}