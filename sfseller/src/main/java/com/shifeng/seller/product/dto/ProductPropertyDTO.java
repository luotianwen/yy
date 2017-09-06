package com.shifeng.seller.product.dto;

import com.shifeng.entity.product.ProductProperty;

public class ProductPropertyDTO extends ProductProperty{
	private String propertyValue;
	
	private String[] propertyValues;
	
	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String[] getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(String[] propertyValues) {
		this.propertyValues = propertyValues;
	}
	
	
}
