package com.shifeng.webapi.dto.homepage;

import java.io.Serializable;
import java.util.Date;
/** 
 * 系统banner(sys_banner)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public class BannerDTO implements Serializable {

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
	
}
