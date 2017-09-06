package com.shifeng.seller.entity.users;

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

	protected int shopid;

	// 创建时间
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

	
	/*---------------------------------------------*/

	public int getIsFroZen() {
		return isFroZen;
	}

	public void setIsFroZen(int isFroZen) {
		this.isFroZen = isFroZen;
	}



	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
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
	
}
