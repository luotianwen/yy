package com.shifeng.dto.ware;

import org.apache.solr.client.solrj.beans.Field;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 商品SKU信息
 * @author WinZhong
 *
 */
public class WareSkuDTO {
	
	
	//商品名称
	//@Field("pName")
	//private String pName;
	
	//商品sku ID
	//@Field("id")
	@JsonProperty("sku")
	@JSONField(name="sku")
	private String id;
	
	//商品编号
	//@Field("pid")
	private int pid;
	
	//库存
/*	@Field("stocks")
	private int stocks;*/
	
	//市场价
	//@Field("marketprice")
	private double marketprice;
	
	//世峰价
	//@Field("price")
	private double price;
	
	//颜色名称 
	//@Field("colorName")
	private String colorName;
	
	//规格名称
	//@Field("specName")
	private String specName;
	
	//颜色主图
	//@Field("colorPic")
	private String colorPic;

	/*@JSONField(serialize=false)
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JSONField(serialize=false)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
/*
	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}*/

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
		return colorPic;
	}

	public void setColorPic(String colorPic) {
		this.colorPic = colorPic;
	}

	@Override
	public String toString() {
		return "WareSkuDTO [id=" + id + ", pid=" + pid + ",  marketprice="
				+ marketprice + ", price=" + price + ", colorName=" + colorName + ", specName=" + specName
				+ ", colorPic=" + colorPic + "]";
	}
	

 	//商品名称关键字高亮
 	//private String highlightWareName;

	
	 

}
