package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺分类颜色属性(p_shop_category_color)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-28 13:16:43 
 */  
public class ShopCategoryColor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//店铺编号
  	 private Integer shopid;
 	//分类属性编号
  	 private Integer cid;
 	//颜色名称
  	 private String name;



	 
    /**
    *id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *店铺编号
	* @return
    */ 
	public Integer getShopid() {
		return shopid;
	}
    /**
    *店铺编号
	* @param shopid
    */ 
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
    /**
    *分类属性编号
	* @return
    */ 
	public Integer getCid() {
		return cid;
	}
    /**
    *分类属性编号
	* @param cid
    */ 
	public void setCid(Integer cid) {
		this.cid = cid;
	}
    /**
    *颜色名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *颜色名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
	
}
