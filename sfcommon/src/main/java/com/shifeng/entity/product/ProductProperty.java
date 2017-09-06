package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * 产品属性表(p_product_property)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:43:10 
 */  
public class ProductProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private int id;
 	//产品ID
  	 private int productId;
 	//属性值ID
  	 private int propertyValueId;
 	//属性ID
  	 private int propertyId;
 	//分类ID
  	 private int categoryId;



	 
    /**
    *主键
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *主键
	* @param id
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *产品ID
	* @return
    */ 
	public int getProductId() {
		return productId;
	}
    /**
    *产品ID
	* @param productId
    */ 
	public void setProductId(int productId) {
		this.productId = productId;
	}
    /**
    *属性值ID
	* @return
    */ 
	public int getPropertyValueId() {
		return propertyValueId;
	}
    /**
    *属性值ID
	* @param propertyValueId
    */ 
	public void setPropertyValueId(int propertyValueId) {
		this.propertyValueId = propertyValueId;
	}
    /**
    *属性ID
	* @return
    */ 
	public int getPropertyId() {
		return propertyId;
	}
    /**
    *属性ID
	* @param propertyId
    */ 
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
    /**
    *分类ID
	* @return
    */ 
	public int getCategoryId() {
		return categoryId;
	}
    /**
    *分类ID
	* @param categoryId
    */ 
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
