package com.shifeng.dto.mall;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shifeng.entity.user.MallUserAddress;

public class MallUserAddressDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
 	//省 
  	 protected String provinceName;
 	//市 
  	 protected String cityName;
 	//区 
  	 protected String areaName;
 	//详细地址 
  	 protected String address;
 	//默认 1是2否
  	 protected Integer first = 2;
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
	
 
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
	@Override
	public String toString() {
		return "MallUserAddressDTO [id=" + id + ", uid=" + uid + ", contacts=" + contacts + ", phone=" + phone
				+ ", province=" + province + ", city=" + city + ", area=" + area + ", provinceName=" + provinceName
				+ ", cityName=" + cityName + ", areaName=" + areaName + ", address=" + address + ", first=" + first
				+ ", state=" + state + ", lasttime=" + lasttime + "]";
	}
	/**
	 * 获取带签名内容
	 * @return
	 */
 	@JsonIgnore
 	@JSONField(serialize=false)
	public String getSignContent(){
		
		return contacts+province+city+area+address+phone+first;
	}
	
	
	
	
	
	

}
