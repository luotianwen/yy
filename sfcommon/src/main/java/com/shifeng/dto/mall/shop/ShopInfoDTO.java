package com.shifeng.dto.mall.shop;

import java.io.Serializable;

/**
 * 店铺基本信息
 * @author Win
 *
 */
public class ShopInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//店铺ID
	private Integer shopId;
 	//店铺名称
 	 private String shopName;
  	 //店铺logo
  	 private String logo;
 	//店铺类型
  	 private Integer grade;
 	//客服电话
  	 private String fax;
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	@Override
	public String toString() {
		return "ShopInfoDTO [shopId=" + shopId + ", shopName=" + shopName + ", logo=" + logo + ", grade=" + grade
				+ ", fax=" + fax + "]";
	}
	
	

}
