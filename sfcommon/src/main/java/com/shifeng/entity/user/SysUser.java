package com.shifeng.entity.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
/** 
 * 用户表(SysUser)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-07 17:13:02 
 */  
public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int id;
 	//用户登录名
  	 private String account;
 	//密码
  	@JsonIgnore
  	 private String password;
 	//用户姓名
  	 private String name;
 	//手机号
  	 private String phone;
 	//省份
  	 private String province;
 	//城市
  	 private String city;
 	//区
  	 private String region;
 	//地址
  	 private String address;
 	//邮编
  	 private String postcode;
 	//照片
  	 private String portrait;
 	//性别
  	 private String sex;
 	//邮箱
  	 private String email;
 	//积分
  	 private int integral;
 	//硬币
  	 private int coin;
 	//出生日期
  	 private String birthday;
 	//状态(1正常 2冻结)
  	 private int state;
 	//注册时间
  	 private Date rtime;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;



	 
    /**
    *id
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *id
	* @param type
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *用户登录名
	* @return
    */ 
	public String getAccount() {
		return account;
	}
    /**
    *用户登录名
	* @param type
    */ 
	public void setAccount(String account) {
		this.account = account;
	}
    /**
    *密码
	* @return
    */ 
	public String getPassword() {
		return password;
	}
    /**
    *密码
	* @param type
    */ 
	public void setPassword(String password) {
		this.password = password;
	}
    /**
    *用户姓名
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *用户姓名
	* @param type
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *手机号
	* @return
    */ 
	public String getPhone() {
		return phone;
	}
    /**
    *手机号
	* @param type
    */ 
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *省份
	* @return
    */ 
	public String getProvince() {
		return province;
	}
    /**
    *省份
	* @param type
    */ 
	public void setProvince(String province) {
		this.province = province;
	}
    /**
    *城市
	* @return
    */ 
	public String getCity() {
		return city;
	}
    /**
    *城市
	* @param type
    */ 
	public void setCity(String city) {
		this.city = city;
	}
    /**
    *区
	* @return
    */ 
	public String getRegion() {
		return region;
	}
    /**
    *区
	* @param type
    */ 
	public void setRegion(String region) {
		this.region = region;
	}
    /**
    *地址
	* @return
    */ 
	public String getAddress() {
		return address;
	}
    /**
    *地址
	* @param type
    */ 
	public void setAddress(String address) {
		this.address = address;
	}
    /**
    *邮编
	* @return
    */ 
	public String getPostcode() {
		return postcode;
	}
    /**
    *邮编
	* @param type
    */ 
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
    /**
    *照片
	* @return
    */ 
	public String getPortrait() {
		return portrait;
	}
    /**
    *照片
	* @param type
    */ 
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
    /**
    *性别
	* @return
    */ 
	public String getSex() {
		return sex;
	}
    /**
    *性别
	* @param type
    */ 
	public void setSex(String sex) {
		this.sex = sex;
	}
    /**
    *邮箱
	* @return
    */ 
	public String getEmail() {
		return email;
	}
    /**
    *邮箱
	* @param type
    */ 
	public void setEmail(String email) {
		this.email = email;
	}
    /**
    *积分
	* @return
    */ 
	public int getIntegral() {
		return integral;
	}
    /**
    *积分
	* @param type
    */ 
	public void setIntegral(int integral) {
		this.integral = integral;
	}
    /**
    *硬币
	* @return
    */ 
	public int getCoin() {
		return coin;
	}
    /**
    *硬币
	* @param type
    */ 
	public void setCoin(int coin) {
		this.coin = coin;
	}
    /**
    *出生日期
	* @return
    */ 
	public String getBirthday() {
		return birthday;
	}
    /**
    *出生日期
	* @param type
    */ 
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
    /**
    *状态(1正常 2冻结)
	* @return
    */ 
	public int getState() {
		return state;
	}
    /**
    *状态(1正常 2冻结)
	* @param type
    */ 
	public void setState(int state) {
		this.state = state;
	}
    /**
    *注册时间
	* @return
    */ 
	public Date getRtime() {
		return rtime;
	}
    /**
    *注册时间
	* @param type
    */ 
	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后修改时间
	* @param type
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *最后修改人
	* @return
    */ 
	public String getUpdatename() {
		return updatename;
	}
    /**
    *最后修改人
	* @param type
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
	
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", province=" + province + ", city=" + city + ", region=" + region + ", address=" + address
				+ ", postcode=" + postcode + ", portrait=" + portrait + ", sex=" + sex + ", email=" + email
				+ ", integral=" + integral + ", coin=" + coin + ", birthday=" + birthday + ", state=" + state
				+ ", rtime=" + rtime + ", lasttime=" + lasttime + ", updatename=" + updatename + "]";
	}
	
	
	
}
