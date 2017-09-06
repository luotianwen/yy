package com.shifeng.mall.settled.dto;

import java.io.Serializable;
import java.util.Date;

public class YzmDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 新手机号码
	private String phone;
	// 旧手机号
	private String oldPhone;
	// 用户ID
	private String userId;
	// 验证码
	private int yzm;
	// 发送时间
	private Date postDate;
	// 手机发送次数
	private int count;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getYzm() {
		return yzm;
	}
	public void setYzm(int yzm) {
		this.yzm = yzm;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getOldPhone() {
		return oldPhone;
	}
	public void setOldPhone(String oldPhone) {
		this.oldPhone = oldPhone;
	}

}
