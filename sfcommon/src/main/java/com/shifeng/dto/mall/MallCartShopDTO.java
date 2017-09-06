package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
/** 
 * 购物车商品店铺
 * @author WinZhong
 *
 */
public class MallCartShopDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//店铺id
  	 private Integer shopid;
 	//店铺名称
  	 private String shopName;
 	//用户id
 	@JsonIgnore
 	@JSONField(serialize=false)
  	 private String userid;
  	 //店铺商品
  	 private List<MallCartWareDTO> wareList;
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

    /**
    *用户id
	* @return
    */ 
	@JSONField(serialize=false)
	public String getUserid() {
		return userid;
	}
    /**
    *用户id
	* @param userid
    */ 
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<MallCartWareDTO> getWareList() {
		return wareList;
	}
	public void setWareList(List<MallCartWareDTO> wareList) {
		this.wareList = wareList;
	}
	@Override
	public String toString() {
		return "MallCartShopDTO [shopid=" + shopid + ", shopName=" + shopName + ", userid=" + userid + ", wareList="
				+ wareList + "]";
	}
	 

	
	 

 
	
}
