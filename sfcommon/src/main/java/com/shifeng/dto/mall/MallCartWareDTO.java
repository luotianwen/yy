package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.beans.Field;

import com.alibaba.fastjson.annotation.JSONField;
/** 
 * 购物车商品
 * @author WinZhong
 *
 */
public class MallCartWareDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//sku
  	 private String sku;
 	//数量
  	 private Integer number;
 	//店铺id
  	 private Integer shopid;
 	//店铺名称
  	 private String shopName;
 	//价格
  	 private String price;
 	//添加购物车时价格
  	 private Double cartPrice;
	//商品名称
	private String pName;
	//商品颜色
	private String  colorName;
	//商品规格
	private String  specName;
	//商品颜色主图
	private String  colorPic;
 	//商品状态(1在售2下架3删除)
  	private int pState;
  	//活动价
  	private String activityprice;
  	
	//商品logo
	@Field("logo")
	@JSONField(serialize=false)
	private String logo;


  	//app 接口使用，无意义
  	private boolean selected = false;
  	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPrice() {
		if(!StringUtils.isBlank(activityprice) && !Objects.equals("0.0", activityprice)){
			return activityprice;
		}
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Double getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getColorPic() {
		return colorPic == null ?logo :colorPic;
	}
	public void setColorPic(String colorPic) {
		this.colorPic = colorPic;
	}
	public int getpState() {
		return pState;
	}
	public void setpState(int pState) {
		this.pState = pState;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String getActivityprice() {
		return activityprice;
	}
	public void setActivityprice(String activityprice) {
		this.activityprice = activityprice;
	}
	@Override
	public String toString() {
		return "MallCartWareDTO [id=" + id + ", sku=" + sku + ", number=" + number + ", shopid=" + shopid
				+ ", shopName=" + shopName + ", price=" + price + ", cartPrice=" + cartPrice + ", pName=" + pName
				+ ", colorName=" + colorName + ", specName=" + specName + ", colorPic=" + colorPic + ", pState="
				+ pState + ", selected=" + selected + "]";
	}
	
	 

 
	
}
