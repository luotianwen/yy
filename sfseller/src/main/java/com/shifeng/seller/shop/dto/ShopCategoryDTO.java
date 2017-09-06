package com.shifeng.seller.shop.dto;

import com.shifeng.entity.shop.ShopCategory;

public class ShopCategoryDTO extends ShopCategory {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 父级编号
	private int parentid;
	// 父类名称
	private String parentname;
	
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	
}
