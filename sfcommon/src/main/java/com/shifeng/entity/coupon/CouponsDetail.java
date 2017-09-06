package com.shifeng.entity.coupon;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/** 
 * 优惠券明细表(c_couponsDetail)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-01 14:57:04 
 */  
public class CouponsDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String id;
 	//优惠券id
  	 private String couponsId;
 	//用户id
  	 private Integer user_id;
 	//密钥
  	 private String passwords;
 	//面值
  	 private double money;
 	//使用面值
  	 private double useMoney;
 	//优惠券有效期
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date startDate;
 	//优惠券有效期结束
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date endDate;
 	//状态（1：待绑定；2：未使用（已绑定）；3：已使用；4：已作废；5：已过期）
  	 private Integer state;



	 
    /**
    *id
	* @return
    */ 
	public String getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(String id) {
		this.id = id;
	}
    /**
    *优惠券id
	* @return
    */ 
	public String getCouponsId() {
		return couponsId;
	}
    /**
    *优惠券id
	* @param couponsId
    */ 
	public void setCouponsId(String couponsId) {
		this.couponsId = couponsId;
	}
    /**
    *用户id
	* @return
    */ 
	public Integer getUser_id() {
		return user_id;
	}
    /**
    *用户id
	* @param user_id
    */ 
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
    /**
    *密钥
	* @return
    */ 
	public String getPasswords() {
		return passwords;
	}
    /**
    *密钥
	* @param passwords
    */ 
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
    /**
    *面值
	* @return
    */ 
	public double getMoney() {
		return money;
	}
    /**
    *面值
	* @param money
    */ 
	public void setMoney(double money) {
		this.money = money;
	}
    /**
    *使用面值
	* @return
    */ 
	public double getUseMoney() {
		return useMoney;
	}
    /**
    *使用面值
	* @param useMoney
    */ 
	public void setUseMoney(double useMoney) {
		this.useMoney = useMoney;
	}
    /**
    *优惠券有效期
	* @return
    */ 
	public Date getStartDate() {
		return startDate;
	}
    /**
    *优惠券有效期
	* @param startDate
    */ 
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    /**
    *优惠券有效期结束
	* @return
    */ 
	public Date getEndDate() {
		return endDate;
	}
    /**
    *优惠券有效期结束
	* @param endDate
    */ 
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    /**
    *状态（1：待绑定；2：未使用（已绑定）；3：已使用；4：已作废；5：已过期）
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态（1：待绑定；2：未使用（已绑定）；3：已使用；4：已作废；5：已过期）
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
	
}
