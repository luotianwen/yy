package com.shifeng.dto.mall.brand;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class BrandDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//品牌ID
	@Field("id")
	private String id;

	//品牌名称
	@Field("brandName")
	private String brandName;

	//品牌logo
	@Field("logo")
	private String logo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "BrandDTO [id=" + id + ", brandName=" + brandName + ", logo=" + logo + "]";
	}
	
	
	
}
