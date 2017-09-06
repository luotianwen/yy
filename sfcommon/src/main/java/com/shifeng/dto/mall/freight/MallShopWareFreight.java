package com.shifeng.dto.mall.freight;

import java.io.Serializable;

/**
 * 快递店铺商品运费
 * @author Win
 *
 */
public class MallShopWareFreight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
 	//店铺id
 	 private Integer shopid;
 	/*//商品sku
  	 private String sku;
 	//数量
  	 private Integer pcount;*/
 	//运费
  	 private double freight;
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	 
	public double getFreight() {
		return freight;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	@Override
	public String toString() {
		return "MallFreightWare [shopid=" + shopid + ", freight=" + freight + "]";
	}
	 
	 
	
	
	

}
