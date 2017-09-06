package com.shifeng.mall.entity.user;


import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable{

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	
	// 用户ID
	protected String uId;
	// 用户昵称
	protected String uName;
	
	protected Date uCreateTime;
	// 最后修改时间
	protected Date uLastUpdateTime;

	// 账户是否被冻结（1：是；2：否）
	private int isFroZen;

	// 最后一次登录Ip
	private String uLoginIp;
	// 最后一次登录时间
	private Date uLoginDate;
	// 登录次数
	private int uLoginCount;

	//用户头像
	protected String portrait;
	//用户手机
	protected String phone;
	//邮箱
	protected String email;
	//省
	protected String province;
	//市
	protected String city;
	//区
	protected String region;
	//详细地址
	protected String address;
	//性别
	protected String sex;
	//积分
	protected Integer integral;
	//银币
	protected Integer coin;
	//生日
	protected String birthday;
	
	
	/*---------------------------------------------*/

	public int getIsFroZen() {
		return isFroZen;
	}

	public void setIsFroZen(int isFroZen) {
		this.isFroZen = isFroZen;
	}


	public String getuLoginIp() {
		return uLoginIp;
	}

	public void setuLoginIp(String uLoginIp) {
		this.uLoginIp = uLoginIp;
	}

	public Date getuLoginDate() {
		return uLoginDate;
	}

	public void setuLoginDate(Date uLoginDate) {
		this.uLoginDate = uLoginDate;
	}


	public int getuLoginCount() {
		return uLoginCount;
	}

	public void setuLoginCount(int uLoginCount) {
		this.uLoginCount = uLoginCount;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}




	public Date getuCreateTime() {
		return uCreateTime;
	}

	public void setuCreateTime(Date uCreateTime) {
		this.uCreateTime = uCreateTime;
	}

	public Date getuLastUpdateTime() {
		return uLastUpdateTime;
	}

	public void setuLastUpdateTime(Date uLastUpdateTime) {
		this.uLastUpdateTime = uLastUpdateTime;
	}

	public Users() {

	}
	
	public Users(String uId) {
		this.uId = uId;

	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
