package com.shifeng.seller.product.dto;

import com.shifeng.entity.product.ProductConsultation;
import com.shifeng.entity.product.ProductConsultationReplay;

public class ProductConsultationDTO extends ProductConsultation{
	
	//咨询回复
	private ProductConsultationReplay productConsultationReplay;

	public ProductConsultationReplay getProductConsultationReplay() {
		return productConsultationReplay;
	}

	public void setProductConsultationReplay(ProductConsultationReplay productConsultationReplay) {
		this.productConsultationReplay = productConsultationReplay;
	}
	
	
}
