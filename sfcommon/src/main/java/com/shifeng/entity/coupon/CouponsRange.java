package com.shifeng.entity.coupon;

import java.io.Serializable;
import java.util.Date;
/** 
 * 优惠券使用范围(c_coupons_range)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-01 14:57:04 
 */  
public class CouponsRange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//优惠券id
  	 private Integer coupons_id;
 	//范围（1：商品2：店铺3：分类）
  	 private Integer type;
 	//值
  	 private Integer number;



	 
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
    *优惠券id
	* @return
    */ 
	public Integer getCoupons_id() {
		return coupons_id;
	}
    /**
    *优惠券id
	* @param coupons_id
    */ 
	public void setCoupons_id(Integer coupons_id) {
		this.coupons_id = coupons_id;
	}
    /**
    *范围（1：商品2：店铺3：分类）
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *范围（1：商品2：店铺3：分类）
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *值
	* @return
    */ 
	public Integer getNumber() {
		return number;
	}
    /**
    *值
	* @param number
    */ 
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
