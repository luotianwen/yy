package com.shifeng.seller.shop.dto;

import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.shop.ShopBrand;

public class ShopBrandDTO extends ShopBrand{
	//品牌管理
	private Brand brand;


	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
}
