package com.shifeng.entity.fx;

import java.io.Serializable;
import java.util.Date;
/** 
 * 商品分销价格(fx_product)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-27 11:06:20 
 */  
public class FxProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//sku
  	 private Integer sku;
 	//商品名称
  	 private String name;
 	//进货价
  	 private Double costprice;
 	//世峰价
  	 private Double price;
 	//毛利
  	 private Double margin;
 	//毛利率
  	 private Double marginrate;
 	//分销率
  	 private Double distributionrate;
 	//佣金
  	 private Double commission;
 	//净毛利率
  	 private Double lastmarginrate;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//款号/货号
  	 private String snumber;


	//sku2 验证分销sku是否存在
	private Integer sku2;
	private Integer  shopid;

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getSku2() {
		return sku2;
	}

	public void setSku2(Integer sku2) {
		this.sku2 = sku2;
	}

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
    *商品名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *商品名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
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
    *毛利
	* @return
    */ 
	public Double getMargin() {
		return margin;
	}
    /**
    *毛利
	* @param margin
    */ 
	public void setMargin(Double margin) {
		this.margin = margin;
	}
    /**
    *毛利率
	* @return
    */ 
	public Double getMarginrate() {
		return marginrate;
	}
    /**
    *毛利率
	* @param marginrate
    */ 
	public void setMarginrate(Double marginrate) {
		this.marginrate = marginrate;
	}
    /**
    *分销率
	* @return
    */ 
	public Double getDistributionrate() {
		return distributionrate;
	}
    /**
    *分销率
	* @param distributionrate
    */ 
	public void setDistributionrate(Double distributionrate) {
		this.distributionrate = distributionrate;
	}
    /**
    *佣金
	* @return
    */ 
	public Double getCommission() {
		return commission;
	}
    /**
    *佣金
	* @param commission
    */ 
	public void setCommission(Double commission) {
		this.commission = commission;
	}
    /**
    *净毛利率
	* @return
    */ 
	public Double getLastmarginrate() {
		return lastmarginrate;
	}
    /**
    *净毛利率
	* @param lastmarginrate
    */ 
	public void setLastmarginrate(Double lastmarginrate) {
		this.lastmarginrate = lastmarginrate;
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
    *款号/货号
	* @return
    */ 
	public String getSnumber() {
		return snumber;
	}
    /**
    *款号/货号
	* @param snumber
    */ 
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	
}
