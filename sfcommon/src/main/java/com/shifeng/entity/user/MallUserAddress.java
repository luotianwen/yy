package com.shifeng.entity.user;

import java.io.Serializable;
import java.util.Date;
/** 
 * 用户收货地址(mall_user_address)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-20 16:16:04 
 */  
public class MallUserAddress implements Serializable {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;

 	//id 
	protected Integer id;
 	//用户id 
  	protected String uid;
 	//联系人 
  	 protected String contacts;
 	//联系电话 
  	 protected String phone;
 	//省 
  	 protected Integer province;
 	//市 
  	 protected Integer city;
 	//区 
  	 protected Integer area;
 	//详细地址 
  	 protected String address;
 	//默认 1是2否
  	 protected Integer first;
 	//状态 1正常2删除
  	 protected Integer state;
 	//最后更新时间 
  	 protected Date lasttime;



	 
    /**
    *id 
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id 
	* @param type
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *用户id 
	* @return
    */ 
	public String getUid() {
		return uid;
	}
    /**
    *用户id 
	* @param type
    */ 
	public void setUid(String uid) {
		this.uid = uid;
	}
    /**
    *联系人 
	* @return
    */ 
	public String getContacts() {
		return contacts;
	}
    /**
    *联系人 
	* @param type
    */ 
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
    /**
    *联系电话 
	* @return
    */ 
	public String getPhone() {
		return phone;
	}
    /**
    *联系电话 
	* @param type
    */ 
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *省 
	* @return
    */ 
	public Integer getProvince() {
		return province;
	}
    /**
    *省 
	* @param type
    */ 
	public void setProvince(Integer province) {
		this.province = province;
	}
    /**
    *市 
	* @return
    */ 
	public Integer getCity() {
		return city;
	}
    /**
    *市 
	* @param type
    */ 
	public void setCity(Integer city) {
		this.city = city;
	}
    /**
    *区 
	* @return
    */ 
	public Integer getArea() {
		return area;
	}
    /**
    *区 
	* @param type
    */ 
	public void setArea(Integer area) {
		this.area = area;
	}
    /**
    *详细地址 
	* @return
    */ 
	public String getAddress() {
		return address;
	}
    /**
    *详细地址 
	* @param type
    */ 
	public void setAddress(String address) {
		this.address = address;
	}
    /**
    *默认 1是2否
	* @return
    */ 
	public Integer getFirst() {
		return first;
	}
    /**
    *默认 1是2否
	* @param type
    */ 
	public void setFirst(Integer first) {
		this.first = first;
	}
    /**
    *状态 1正常2删除
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态 1正常2删除
	* @param type
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *最后更新时间 
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后更新时间 
	* @param type
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "MallUserAddress [id=" + id + ", uid=" + uid + ", contacts=" + contacts + ", phone=" + phone
				+ ", province=" + province + ", city=" + city + ", area=" + area + ", address=" + address + ", first="
				+ first + ", state=" + state + ", lasttime=" + lasttime + "]";
	}
	
	
	
}
