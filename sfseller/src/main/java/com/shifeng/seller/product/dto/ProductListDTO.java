package com.shifeng.seller.product.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductListDTO {
	//编号
	private String id;
	//一级类目
	private String cName;
	//二级类目
	private String pcName;
	//商品名称
	private String name;
	//世峰价
	private String price;
	//总库存
	private String stocks;
	//总销量
	private String salecount;
	//创建时间
	private Date submit_time;
	//商品主图
	private String logo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getPcName() {
		return pcName;
	}
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getSalecount() {
		return salecount;
	}
	public void setSalecount(String salecount) {
		this.salecount = salecount;
	}
	public Date getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
