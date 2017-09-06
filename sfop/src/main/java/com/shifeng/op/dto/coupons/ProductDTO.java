package com.shifeng.op.dto.coupons;

import java.io.Serializable;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//商品ID
	private String id;
	//sku
	private String sku;
	//商品货号
	private String number;
	//商品名称
	private String name;
	//属性
	private String porperty;
	//状态
	private String state;
	//市场价
	private String marketprice;
	//世峰价
	private String price;
	//库存
	private String stocks;
	//商品图片
	private String image;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPorperty() {
		return porperty;
	}
	public void setPorperty(String porperty) {
		this.porperty = porperty;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(String marketprice) {
		this.marketprice = marketprice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStocks() {
		return stocks;
	}
	public void setStocks(String stocks) {
		this.stocks = stocks;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
