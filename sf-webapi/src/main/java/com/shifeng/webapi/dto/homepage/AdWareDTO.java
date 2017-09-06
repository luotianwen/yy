package com.shifeng.webapi.dto.homepage;

import java.io.Serializable;
/** 
 * app首页广告商品(sys_app_homead_ware)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public class AdWareDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



 	//广告明细id
  	 private Integer id;
 	//商品名称
  	 private String pname;
 	//商品图片地址
  	 private String imgPath;
 	//链接
  	 private String imgLink;
 	//顶部图标
  	 private String top_pic;
 	//序号
  	 private Integer sort;
 	//sku
  	 private String sku;
 	//活动价
  	 private Double activityprice;
 	//活动类型
 	 private Integer activitytype;
  	//市场价
   	 private Double marketprice;
  	//世峰价
   	 private Double price;


	 
    /**
    *广告明细id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *广告明细id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *名称
	* @return
    */ 
	public String getPname() {
		return pname;
	}
    /**
    *名称
	* @param pname
    */ 
	public void setPname(String pname) {
		this.pname = pname;
	}
    /**
    *图片地址
	* @return
    */ 
	public String getImgPath() {
		return imgPath;
	}
    /**
    *图片地址
	* @param imgPath
    */ 
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
    /**
    *链接
	* @return
    */ 
	public String getImgLink() {
		return imgLink;
	}
    /**
    *链接
	* @param imgLink
    */ 
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
    /**
    *顶部图标
	* @return
    */ 
	public String getTop_pic() {
		return top_pic;
	}
    /**
    *顶部图标
	* @param top_pic
    */ 
	public void setTop_pic(String top_pic) {
		this.top_pic = top_pic;
	}
    /**
    *序号
	* @return
    */ 
	public Integer getSort() {
		return sort;
	}
    /**
    *序号
	* @param sort
    */ 
	public void setSort(Integer sort) {
		this.sort = sort;
	}
    /**
    *sku
	* @return
    */ 
	public String getSku() {
		return sku;
	}
    /**
    *sku
	* @param sku
    */ 
	public void setSku(String sku) {
		this.sku = sku;
	}
    /**
    *活动价
	* @return
    */ 
	public Double getActivityprice() {
		return activityprice;
	}
    /**
    *活动价
	* @param activityprice
    */ 
	public void setActivityprice(Double activityprice) {
		this.activityprice = activityprice;
	}

    /**
    *市场价
	* @return
    */ 
	public Double getMarketprice() {
		return marketprice;
	}
    /**
    *市场价
	* @param marketprice
    */ 
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}

    /**
    *活动类型
	* @return
    */ 
	public Integer getActivitytype() {
		return activitytype;
	}
    /**
    *活动类型
	* @param activitytype
    */ 
	public void setActivitytype(Integer activitytype) {
		this.activitytype = activitytype;
		/*//如果有活动则设置活动价
		if(activitytype != null && activitytype != 0){
			this.price =  activityprice;
		}*/
	}
	/**
	 * 市场价
	 * @return
	 */
	public Double getPrice() {
		//如果有活动则返回活动价
		if(activitytype != null && activitytype != 0){
			return activityprice;
		}else{
			return price;
		}
	}
	/**
	 * 市场价
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}

