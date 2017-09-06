package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * 规格表(p_spec)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 18:40:23 
 */  
public class Spec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//编号
  	 private Integer id;
 	//商品编号
  	 private Integer pid;
 	//规格名称
  	 private String name;
 	//分类规格属性id
  	 private Integer categoryspecid;



	 
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
    *规格名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *规格名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *分类规格属性id
	* @return
    */ 
	public Integer getCategoryspecid() {
		return categoryspecid;
	}
    /**
    *分类规格属性id
	* @param categoryspecid
    */ 
	public void setCategoryspecid(Integer categoryspecid) {
		this.categoryspecid = categoryspecid;
	}
	
}
