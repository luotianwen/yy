package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺负责人员(s_store_supervisor)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:44:59 
 */  
public class StoreSupervisor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//入驻id
  	 private int s_merchants_id;
 	//负责人姓名
  	 private String name;
 	//负责人手机号
  	 private String phone;
 	//负责人座 机
  	 private String landline;
 	//负责人电子邮箱
  	 private String email;
 	//负责人QQ号码
  	 private String qq;
 	//类型
  	 private int type;



	 
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
    *负责人姓名
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *负责人姓名
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *负责人手机号
	* @return
    */ 
	public String getPhone() {
		return phone;
	}
    /**
    *负责人手机号
	* @param phone
    */ 
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *负责人座 机
	* @return
    */ 
	public String getLandline() {
		return landline;
	}
    /**
    *负责人座 机
	* @param landline
    */ 
	public void setLandline(String landline) {
		this.landline = landline;
	}
    /**
    *负责人电子邮箱
	* @return
    */ 
	public String getEmail() {
		return email;
	}
    /**
    *负责人电子邮箱
	* @param email
    */ 
	public void setEmail(String email) {
		this.email = email;
	}
    /**
    *负责人QQ号码
	* @return
    */ 
	public String getQq() {
		return qq;
	}
    /**
    *负责人QQ号码
	* @param qq
    */ 
	public void setQq(String qq) {
		this.qq = qq;
	}
    /**
    *类型
	* @return
    */ 
	public int getType() {
		return type;
	}
    /**
    *类型
	* @param type
    */ 
	public void setType(int type) {
		this.type = type;
	}
	
}
