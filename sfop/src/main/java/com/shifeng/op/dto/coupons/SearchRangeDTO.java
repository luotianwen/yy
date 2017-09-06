package com.shifeng.op.dto.coupons;

import java.io.Serializable;

public class SearchRangeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//产品ID
	private String productId;
	//SKU
	private String sku;
	//产品名称
	private String productName;
	//一级分类
	private String category;
	//二级分类
	private String categoryc;
	//店铺名
	private String shopName;
	//店铺ID
	private String shopId;
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryc() {
		return categoryc;
	}
	public void setCategoryc(String categoryc) {
		this.categoryc = categoryc;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	
	
}
