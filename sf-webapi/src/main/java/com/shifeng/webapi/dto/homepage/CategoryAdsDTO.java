package com.shifeng.webapi.dto.homepage;

import java.io.Serializable;
import java.util.Date;
/** 
 * app类目广告(sys_app_categoryads)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public class CategoryAdsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 
 	//名称
  	 private String name;
 	//图片地址
  	 private String imgPath;
 	//链接
  	 private String imgLink;
  	 //是否活动
  	 private Integer isactivity;
 	//类型
  	 private Integer module;
 	//位置
  	 private Integer position;
 	//标题
  	 private String title;
 	//价格
  	 private double price;
 	//序号
  	 private Integer sort;
 
 	 



	 
    /**
    *名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
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
    *类型
	* @return
    */ 
	public Integer getModule() {
		return module;
	}
    /**
    *类型
	* @param module
    */ 
	public void setModule(Integer module) {
		this.module = module;
	}
    /**
    *位置
	* @return
    */ 
	public Integer getPosition() {
		return position;
	}
    /**
    *位置
	* @param position
    */ 
	public void setPosition(Integer position) {
		this.position = position;
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
    *标题
	* @return
    */ 
	public String getTitle() {
		return title;
	}
    /**
    *标题
	* @param title
    */ 
	public void setTitle(String title) {
		this.title = title;
	}
    /**
    *价格
	* @return
    */ 
	public double getPrice() {
		return price;
	}
    /**
    *价格
	* @param price
    */ 
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 是否活动
	 * @return
	 */
	public Integer getIsactivity() {
		return isactivity;
	}
	/**
	 * 是否活动
	 * @param isactivity
	 */
	public void setIsactivity(Integer isactivity) {
		this.isactivity = isactivity;
	}
   
	
}
