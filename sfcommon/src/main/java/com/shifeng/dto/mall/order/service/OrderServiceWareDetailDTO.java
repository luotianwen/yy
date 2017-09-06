package com.shifeng.dto.mall.order.service;

import java.io.Serializable;
import java.util.Date;
  
public class OrderServiceWareDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//订单ID
	private String orderId;
 	//商品id
  	 private Integer pid;
 	//Sku
  	 private String sku;
 	//商品名称
  	 private String productName;
 	//商品图片
  	 private String productImage;
 	//购买数量
  	 private Integer quantity;
 	//颜色
  	 private String color;
 	//规格
  	 private String specification;
 	//售后状态（ 0正常 1换货 2退款3退款退货 4维修9售后关闭）
  	 private Integer sstatus;
  	 
  	 
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Integer getSstatus() {
		return sstatus;
	}
	public void setSstatus(Integer sstatus) {
		this.sstatus = sstatus;
	}
	@Override
	public String toString() {
		return "OrderServiceWareDetailDTO [orderId=" + orderId + ", pid=" + pid + ", sku=" + sku + ", productName="
				+ productName + ", productImage=" + productImage + ", quantity=" + quantity + ", color=" + color
				+ ", specification=" + specification + ", sstatus=" + sstatus + "]";
	}
	 



    
	
	
	
}
