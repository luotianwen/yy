package com.shifeng.op.dto.shop;

import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.shop.ShopBrand;

public class AuditBrandDTO extends ShopBrand{
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
}
