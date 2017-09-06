package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class OrderPreviewWareInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  	//sku
  	 private String sku;
  	//店铺id
 	 private Integer shopid;
 	//数量
  	 private Integer number;
 	//市场价
 	private double marketprice;
 	//世峰价
 	private double price;
	//商品名称
	private String pName;
	//商品颜色
	private String  colorName;
	//商品规格
	private String  specName;
	//商品颜色主图
	private String  colorPic;
	//商品主图
	private String  logo;
 	//开始时间
 	 private Date starttime;
	//结束时间
 	 private Date endtime;
	//活动类型
 	 private Integer activitytype;
	//活动价
 	 private Double activityprice;
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}
	public double getPrice() {
		if(activitytype != null && 0 != activitytype){//如果存在活动则返回活动价
			return activityprice;
		}
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
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
	public String getColorPic() {
		if(StringUtils.isBlank(colorPic)){
			return logo;
		}
		return colorPic;
	}
	public void setColorPic(String colorPic) {
		this.colorPic = colorPic;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getActivitytype() {
		return activitytype;
	}
	public void setActivitytype(Integer activitytype) {
		this.activitytype = activitytype;
	}
	public Double getActivityprice() {
		if(activitytype == null || 0 == activitytype){//如果不存在活动则返回世峰价
			return price;
		}
		return activityprice;
	}
	public void setActivityprice(Double activityprice) {
		this.activityprice = activityprice;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	@Override
	public String toString() {
		return "OrderPreviewWareInfoDTO [sku=" + sku + ", shopid=" + shopid + ", number=" + number + ", marketprice="
				+ marketprice + ", price=" + price + ", pName=" + pName + ", colorName=" + colorName + ", specName="
				+ specName + ", colorPic=" + colorPic + ", logo=" + logo + ", starttime=" + starttime + ", endtime="
				+ endtime + ", activitytype=" + activitytype + ", activityprice=" + activityprice + "]";
	}
	 
 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
}
