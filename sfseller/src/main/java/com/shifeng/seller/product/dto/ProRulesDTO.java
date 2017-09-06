package com.shifeng.seller.product.dto;

import com.shifeng.entity.product.ProRules;

public class ProRulesDTO extends ProRules{
	//分类规格
	private Integer categoryspecid;
	//分类颜色
	private Integer categorycolorid;
	//颜色名
	private String colorname;
	//规格名
	private String specname;
	//SKU总数
	private int count;
	//商品名
	private String name;
	//商品状态
	private String state;
	//店铺ID
	private String shopid;
	
	public String getColorname() {
		return colorname;
	}
	public void setColorname(String colorname) {
		this.colorname = colorname;
	}
	public String getSpecname() {
		return specname;
	}
	public void setSpecname(String specname) {
		this.specname = specname;
	}
	public Integer getCategoryspecid() {
		return categoryspecid;
	}
	public void setCategoryspecid(Integer categoryspecid) {
		this.categoryspecid = categoryspecid;
	}
	public Integer getCategorycolorid() {
		return categorycolorid;
	}
	public void setCategorycolorid(Integer categorycolorid) {
		this.categorycolorid = categorycolorid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	
	
}
