package com.shifeng.dto.mall.order;

import java.io.Serializable;

/**
 * 订单结算信息
 * @author WinZhong
 *
 */
public class OrderSettlementWareDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//商品sku
	private String sku;
	//商品数量
	private int pcount;
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
		return "OrderWareDTO [sku=" + sku + ", pcount=" + pcount + "]";
	}
 
	 
	
	
	
	
}
