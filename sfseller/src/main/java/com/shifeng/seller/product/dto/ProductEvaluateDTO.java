package com.shifeng.seller.product.dto;

import java.util.List;

import com.shifeng.entity.product.ProductEvaluate;
import com.shifeng.entity.product.ProductEvaluateReplay;

public class ProductEvaluateDTO extends ProductEvaluate{
	//回复信息
	private List<ProductEvaluateReplay> productEvaluateReplays;

	public List<ProductEvaluateReplay> getProductEvaluateReplays() {
		return productEvaluateReplays;
	}

	public void setProductEvaluateReplays(List<ProductEvaluateReplay> productEvaluateReplays) {
		this.productEvaluateReplays = productEvaluateReplays;
	}

	
}
