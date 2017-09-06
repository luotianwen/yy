package com.shifeng.dto.ware;

import org.apache.solr.client.solrj.beans.Field;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 热销商品信息
 * @author WinZhong
 *
 */
public class HotWareDTO {
	
	
	//商品名称
	@Field("pName")
	private String pName;
	
	//商品名称
	@Field("logo")
	@JSONField(serialize=false)
	private String logo;
	
	//商品主图
	@Field("id")
	private String sku;
	
	//商品编号
	@Field("pid")
	private int pid;
	
	//市场价
	@Field("marketprice")
	private double marketprice;
	
	//世峰价
	@Field("price")
	private double price;
	
	//颜色名称 
	@Field("colorName")
	private String colorName;
	
	//规格名称
	@Field("specName")
	private String specName;
	
	//颜色主图
	@Field("colorPic")
	private String colorPic;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public double getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
		return colorPic == null ?logo :colorPic;
	}

	public void setColorPic(String colorPic) {
		this.colorPic = colorPic;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "HotWareDTO [pName=" + pName + ", logo=" + logo + ", sku=" + sku + ", pid=" + pid + ", marketprice="
				+ marketprice + ", price=" + price + ", colorName=" + colorName + ", specName=" + specName
				+ ", colorPic=" + colorPic + "]";
	}

 

	 
	

 	//商品名称关键字高亮
 	//private String highlightWareName;

	
	 

}
