package com.shifeng.seller.product.dto;

import java.util.List;

import com.shifeng.entity.product.SkuImages;

public class SkuImagesDTO extends SkuImages{
	String[] imageurl;
	List<SkuImages> skuImages;
	
	public String[] getImageurl() {
		return imageurl;
	}

	public void setImageurl(String[] imageurl) {
		this.imageurl = imageurl;
	}

	public List<SkuImages> getSkuImages() {
		return skuImages;
	}

	public void setSkuImages(List<SkuImages> skuImages) {
		this.skuImages = skuImages;
	}
	
	
}
