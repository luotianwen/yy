package com.shifeng.webapi.dto;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.shifeng.entity.user.SysUser;

public class UserDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	// id
	@JSONField(serialize=false)
	private int id;
	// 用户登录名
	private String account;
	// 用户姓名
	private String name;
	// 照片
	private String portrait;
	// 性别
	private String sex;
	// 积分
	private int integral;
	// 硬币
	private int coin;
 	//出生日期
 	 private String birthday;
 	// token
 	private String token;
	// phone 注册登录时有返回
	private String phone; 	
	//第三方平台授权用户身份唯一标识
 	 private String openid;
	//平台类型（QQ；weixin）
 	 private String loginType;

	/**
	 * 用户登录名
	 * 
	 * @return
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 用户登录名
	 * 
	 * @param type
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 用户姓名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 用户姓名
	 * 
	 * @param type
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 照片
	 * 
	 * @return
	 */
	public String getPortrait() {
		return portrait;
	}

	/**
	 * 照片
	 * 
	 * @param type
	 */
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	/**
	 * 性别
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 性别
	 * 
	 * @param type
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 积分
	 * 
	 * @return
	 */
	public int getIntegral() {
		return integral;
	}

	/**
	 * 积分
	 * 
	 * @param type
	 */
	public void setIntegral(int integral) {
		this.integral = integral;
	}

	/**
	 * 硬币
	 * 
	 * @return
	 */
	public int getCoin() {
		return coin;
	}

	/**
	 * 硬币
	 * 
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

 

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", account=" + account + ", name=" + name + ", portrait=" + portrait + ", sex="
				+ sex + ", integral=" + integral + ", coin=" + coin + ", birthday=" + birthday + ", token=" + token
				+ "]";
	}

	public UserDTO(SysUser user) {
		this.id = user.getId();
		this.account = user.getAccount();
		this.name = user.getName();
		this.portrait = user.getPortrait();
		this.sex = user.getSex();
		this.integral = user.getIntegral();
		this.coin = user.getCoin();
		this.birthday = user.getBirthday();
		this.phone = user.getPhone();
	}

	public UserDTO() {
		
	}

	/**
	 * id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * id
	 * 
	 * @param type
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * token
	 * 
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * token
	 * 
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * phone 注册登录时有返回
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * phone 注册登录时有返回
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	   /**
	    *第三方平台授权用户身份唯一标识
		* @return
	    */ 
		public String getOpenid() {
			return openid;
		}
	    /**
	    *第三方平台授权用户身份唯一标识
		* @param type
	    */ 
		public void setOpenid(String openid) {
			this.openid = openid;
		}
	    /**
	    *平台类型（QQ；weixin）
		* @return
	    */ 
		public String getLoginType() {
			return loginType;
		}
	    /**
	    *平台类型（QQ；weixin）
		* @param type
	    */ 
		public void setLoginType(String loginType) {
			this.loginType = loginType;
		}

}
