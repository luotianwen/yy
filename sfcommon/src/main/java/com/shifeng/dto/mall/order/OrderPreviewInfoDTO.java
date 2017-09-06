package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.List;

/**
 * 订单预览信息DTO
 * @author WinZhong
 *
 */
public class OrderPreviewInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
 	//店铺id
 	 private Integer shopid;
	//店铺名称
 	 private String shopName;
	//订单预览商品信息
 	 private List<OrderPreviewWareInfoDTO> wareList;
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
	public List<OrderPreviewWareInfoDTO> getWareList() {
		return wareList;
	}
	public void setWareList(List<OrderPreviewWareInfoDTO> wareList) {
		this.wareList = wareList;
	}
	@Override
	public String toString() {
		return "OrderPreviewInfoDTO [shopid=" + shopid + ", shopName=" + shopName + ", wareList=" + wareList + "]";
	}
	
	

}
