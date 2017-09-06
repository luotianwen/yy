package com.shifeng.dto.mall.order;

import java.io.Serializable;

/**
 * 订单确认商品信息
 * @author WinZhong
 *
 */
public class OrderWareDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//购物车id
	private Integer cartId;
	//商品sku
	private String sku;
	//商品数量
	private int pcount;
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	@Override
	public String toString() {
		return "OrderWareDTO [cartId=" + cartId + ", sku=" + sku + ", pcount=" + pcount + "]";
	}
 
	 
	
	
	
	
}
