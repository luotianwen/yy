package com.shifeng.op.dto.product;

import com.shifeng.entity.product.ProductConsultation;
import com.shifeng.entity.product.ProductConsultationReplay;

public class ProductConsultationDTO extends ProductConsultation{
	
	//咨询回复
	private ProductConsultationReplay productConsultationReplay;

	//店铺名称
	private String shopName;
	
	public ProductConsultationReplay getProductConsultationReplay() {
		return productConsultationReplay;
	}

	public void setProductConsultationReplay(ProductConsultationReplay productConsultationReplay) {
		this.productConsultationReplay = productConsultationReplay;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
}
