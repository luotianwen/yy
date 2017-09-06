package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 关注的店铺(mall_followVender)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
public class MallFollowVenderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//关注ID 
  	 private Integer fid;
 	//用户ID 
  	 private String userId;
 	//店铺ID 
  	 private Integer shopId;
 	//店铺名称 
  	 private String shopName;
 	//店铺Logo
  	 private String shopLogo;
 	//关注时间 
  	 private Date followTime;

  	 //app 接口使用，无意义
  	 private boolean selected = false;



	 
    /**
    *关注ID 
	* @return
    */ 
	public Integer getFid() {
		return fid;
	}
    /**
    *关注ID 
	* @param type
    */ 
	public void setFid(Integer fid) {
		this.fid = fid;
	}
    /**
    *用户ID 
	* @return
    */ 
	public String getUserId() {
		return userId;
	}
    /**
    *用户ID 
	* @param type
    */ 
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
    *店铺ID 
	* @return
    */ 
	public Integer getShopId() {
		return shopId;
	}
    /**
    *店铺ID 
	* @param type
    */ 
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
    /**
    *关注时间 
	* @return
    */ 
	public Date getFollowTime() {
		return followTime;
	}
    /**
    *关注时间 
	* @param type
    */ 
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	/**
	 * 店铺名称
	 * @return
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 店铺Logo
	 * @return
	 */
	public String getShopLogo() {
		return shopLogo;
	}
	/**
	 * 店铺名称
	 * @param shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 店铺Logo
	 * @param shopLogo
	 */
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	/**
	 * app 接口使用，无意义
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}
	/**
	 * app 接口使用，无意义
	 * @param selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
