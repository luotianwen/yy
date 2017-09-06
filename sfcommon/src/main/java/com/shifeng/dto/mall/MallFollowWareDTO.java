package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 关注的商品(mall_followWare)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
public class MallFollowWareDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//关注ID 
  	 private Integer fid;
 	//商品sku 
  	 private Integer sku;
 	//关注时商品价格 
  	 private double followPrice;
 	//商品价格 
  	 private double price;
 	//关注商品名称 
  	 private String wareName;
 	//关注商品图片
  	 private String wareImg;
 	//关注时间 
  	 private Date followTime;
 	//商品状态(1在售2下架3删除)
  	 private int pState;

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
    *商品sku 
	* @return
    */ 
	public Integer getSku() {
		return sku;
	}
    /**
    *商品sku 
	* @param type
    */ 
	public void setSku(Integer sku) {
		this.sku = sku;
	}
    /**
    *商品价格 
	* @return
    */ 
	public double getPrice() {
		return price;
	}
    /**
    *商品价格 
	* @param type
    */ 
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 关注时商品价格
	 * @return
	 */
	public double getFollowPrice() {
		return followPrice;
	}

	/**
	 * 关注商品名称 
	 * @return
	 */
	public String getWareName() {
		return wareName;
	}

	/**
	 * 关注商品图片
	 * @return
	 */
	public String getWareImg() {
		return wareImg;
	}
	/**
	 * 关注时商品价格
	 * @return
	 */
	public void setFollowPrice(double followPrice) {
		this.followPrice = followPrice;
	}
	/**
	 * 关注商品名称 
	 * @return
	 */
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	/**
	 * 关注商品图片
	 * @param wareImg
	 */
	public void setWareImg(String wareImg) {
		this.wareImg = wareImg;
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
	public int getpState() {
		return pState;
	}
	public void setpState(int pState) {
		this.pState = pState;
	}
	@Override
	public String toString() {
		return "MallFollowWareDTO [fid=" + fid + ", sku=" + sku + ", followPrice=" + followPrice + ", price=" + price
				+ ", wareName=" + wareName + ", wareImg=" + wareImg + ", followTime=" + followTime + ", pState="
				+ pState + ", selected=" + selected + "]";
	}
	
	
}
