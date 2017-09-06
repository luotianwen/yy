package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * 颜色表(p_color)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 18:40:23 
 */  
public class Color implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//编号
  	 private Integer id;
 	//颜色名称
  	 private String name;
 	//商品编号
  	 private Integer pid;
 	//分类颜色id
  	 private Integer categorycolorid;



	 
    /**
    *编号
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *编号
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
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
    /**
    *商品编号
	* @return
    */ 
	public Integer getPid() {
		return pid;
	}
    /**
    *商品编号
	* @param pid
    */ 
	public void setPid(Integer pid) {
		this.pid = pid;
	}
    /**
    *分类颜色id
	* @return
    */ 
	public Integer getCategorycolorid() {
		return categorycolorid;
	}
    /**
    *分类颜色id
	* @param categorycolorid
    */ 
	public void setCategorycolorid(Integer categorycolorid) {
		this.categorycolorid = categorycolorid;
	}
	
}
