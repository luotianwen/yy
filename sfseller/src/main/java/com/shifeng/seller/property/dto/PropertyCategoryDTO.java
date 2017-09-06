package com.shifeng.seller.property.dto;

import java.util.List;

import com.shifeng.entity.category.Propertycategory;
import com.shifeng.entity.category.Propertyvalue;

public class PropertyCategoryDTO extends Propertycategory{
	
	//属性值
	private List<Propertyvalue> propertyvalue;
	//属性名
	private String name;
	//是否多选
	private String ismultiple;
	
	
	public List<Propertyvalue> getPropertyvalue() {
		return propertyvalue;
	}
	public void setPropertyvalue(List<Propertyvalue> propertyvalue) {
		this.propertyvalue = propertyvalue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsmultiple() {
		return ismultiple;
	}
	public void setIsmultiple(String ismultiple) {
		this.ismultiple = ismultiple;
	}
	
	
}
