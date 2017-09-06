package com.shifeng.dto.ware;

import java.util.List;

/**
 * 商品
 * @author WinZhong
 *
 */
public class WareDTO {
	
	//商品名称
	private String pName;
	//商品sku列表
	private List<WareSkuDTO> skuList;
	
	/**
	 * 商品名称
	 * @return
	 */
	public String getpName() {
		return pName;
	}
	/**
	 * 商品名称
	 * @param pName
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * 商品sku列表
	 * @return
	 */
	public List<WareSkuDTO> getSkuList() {
		return skuList;
	}
	/**
	 * 商品sku列表
	 * @param skuList
	 */
	public void setSkuList(List<WareSkuDTO> skuList) {
		this.skuList = skuList;
	}
	@Override
	public String toString() {
		return "WareDTO [pName=" + pName + ", skuList=" + skuList + "]";
	}
	
	
	
	

}
