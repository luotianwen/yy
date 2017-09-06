package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺经营类目(s_shop_category)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:44:59 
 */  
public class ShopCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//入驻id
  	 private int s_merchants_id;
 	//类目id
  	 private int c_category_id;
 	//类目名称
  	 private String categoryName;
 	//类目保证金标准（元）
  	 private double deposit;
 	//平台使用费
  	 private double platformfee;
 	//扣点
  	 private double points;
 	//代销店铺扣点
  	 private double consignmentpoints;



	 
    /**
    *入驻id
	* @return
    */ 
	public int getS_merchants_id() {
		return s_merchants_id;
	}
    /**
    *入驻id
	* @param s_merchants_id
    */ 
	public void setS_merchants_id(int s_merchants_id) {
		this.s_merchants_id = s_merchants_id;
	}
    /**
    *类目id
	* @return
    */ 
	public int getC_category_id() {
		return c_category_id;
	}
    /**
    *类目id
	* @param c_category_id
    */ 
	public void setC_category_id(int c_category_id) {
		this.c_category_id = c_category_id;
	}
    /**
    *类目名称
	* @return
    */ 
	public String getCategoryName() {
		return categoryName;
	}
    /**
    *类目名称
	* @param categoryName
    */ 
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    /**
    *类目保证金标准（元）
	* @return
    */ 
	public double getDeposit() {
		return deposit;
	}
    /**
    *类目保证金标准（元）
	* @param deposit
    */ 
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
    /**
    *平台使用费
	* @return
    */ 
	public double getPlatformfee() {
		return platformfee;
	}
    /**
    *平台使用费
	* @param platformfee
    */ 
	public void setPlatformfee(double platformfee) {
		this.platformfee = platformfee;
	}
    /**
    *扣点
	* @return
    */ 
	public double getPoints() {
		return points;
	}
    /**
    *扣点
	* @param points
    */ 
	public void setPoints(double points) {
		this.points = points;
	}
    /**
    *代销店铺扣点
	* @return
    */ 
	public double getConsignmentpoints() {
		return consignmentpoints;
	}
    /**
    *代销店铺扣点
	* @param consignmentpoints
    */ 
	public void setConsignmentpoints(double consignmentpoints) {
		this.consignmentpoints = consignmentpoints;
	}
	
}
