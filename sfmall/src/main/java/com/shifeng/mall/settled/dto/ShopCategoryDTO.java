package com.shifeng.mall.settled.dto;

import com.shifeng.entity.shop.ShopCategory;

public class ShopCategoryDTO extends ShopCategory{
	//父分类id
	private String parentid;
	//父分类名称
	private String parentname;
	//合作模式
	private Integer cooperation;
	
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	public Integer getCooperation() {
		return cooperation;
	}
	public void setCooperation(Integer cooperation) {
		this.cooperation = cooperation;
	}
	
	
}
