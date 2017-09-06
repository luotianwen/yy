package com.shifeng.op.dto.product;

import java.util.List;

import com.shifeng.entity.product.ProductEvaluate;
import com.shifeng.entity.product.ProductEvaluateReplay;

public class ProductEvaluateDTO extends ProductEvaluate{
	
	//评论回复
	private List<ProductEvaluateReplay> productEvaluateReplays;

	//店铺名称
	private String shopName;
	
	public List<ProductEvaluateReplay> getProductEvaluateReplays() {
		return productEvaluateReplays;
	}

	public void setProductEvaluateReplays(List<ProductEvaluateReplay> productEvaluateReplays) {
		this.productEvaluateReplays = productEvaluateReplays;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
}
