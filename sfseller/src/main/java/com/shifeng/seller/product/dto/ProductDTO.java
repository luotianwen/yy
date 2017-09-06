package com.shifeng.seller.product.dto;

import java.util.List;

import com.shifeng.entity.product.Color;
import com.shifeng.entity.product.Images;
import com.shifeng.entity.product.Product;
import com.shifeng.entity.product.SkuImages;
import com.shifeng.entity.product.Spec;

public class ProductDTO extends Product{
	//SKU集合
	private List<ProRulesDTO> prorules;
	//SKU图片
	private List<SkuImagesDTO> skuimages;
	//商品图片
	private List<Images> images;
	//商品属性
	private List<ProductPropertyDTO> productPropertys;
	//查询SKU颜色
	private List<SkuImages> skucolors;
	//产品颜色
	private List<Color> pcolors;
	//产品规格
	private List<Spec> pspecs;
	
	
	public List<ProRulesDTO> getProrules() {
		return prorules;
	}

	public void setProrules(List<ProRulesDTO> prorules) {
		this.prorules = prorules;
	}
	
	public List<SkuImagesDTO> getSkuimages() {
		return skuimages;
	}
	public void setSkuimages(List<SkuImagesDTO> skuimages) {
		this.skuimages = skuimages;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<ProductPropertyDTO> getProductPropertys() {
		return productPropertys;
	}

	public void setProductPropertys(List<ProductPropertyDTO> productPropertys) {
		this.productPropertys = productPropertys;
	}

	public List<SkuImages> getSkucolors() {
		return skucolors;
	}

	public void setSkucolors(List<SkuImages> skucolors) {
		this.skucolors = skucolors;
	}

	public List<Color> getPcolors() {
		return pcolors;
	}

	public void setPcolors(List<Color> pcolors) {
		this.pcolors = pcolors;
	}

	public List<Spec> getPspecs() {
		return pspecs;
	}

	public void setPspecs(List<Spec> pspecs) {
		this.pspecs = pspecs;
	}
	
}
