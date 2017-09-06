package com.shifeng.dto.mall.property;

import java.io.Serializable;
import java.util.List;

public class PropertyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//属性名称
	private String propertyName;
	
	//属性值列表
	private List<PropertyValueDTO> PropertyValueList;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public List<PropertyValueDTO> getPropertyValueList() {
		return PropertyValueList;
	}

	public void setPropertyValueList(List<PropertyValueDTO> propertyValueList) {
		PropertyValueList = propertyValueList;
	}

	@Override
	public String toString() {
		return "PropertyDTO [propertyName=" + propertyName + ", PropertyValueList=" + PropertyValueList + "]";
	}
	
	

}
