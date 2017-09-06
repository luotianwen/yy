package com.shifeng.entity.user;

import java.io.Serializable;
import java.util.Date;
/** 
 * 第三方平台账号联合登录(jointLogin)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-01 14:14:22 
 */  
public class JointLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//第三方平台授权用户身份唯一标识
  	 private String openid;
 	//平台类型（QQ；weixin）
  	 private String loginType;
 	//系统用户id
  	 private String userId;
 	//第三方平台授权码
  	 private String accessToken;
 	//刷新access_token授权码
  	 private String refreshToken;
 	//授权码到期时间（单位：秒）
  	 private String expiresIn;
 	//授权的作用域，使用逗号（,）分隔
  	 private String scope;
 	//授权创建时间
  	 private Date createTime;
 	//授权刷新时间
  	 private Date updateTime;
  	 //unionid(多个应用同一用户unionid相同)  unionid来区分用户的唯一性，因为同一用户，对同一个微信开放平台下的不同应用（移动应用、网站应用和公众帐号），unionid是相同的。
  	 private String unionid;



	 
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
    /**
    *系统用户id
	* @return
    */ 
	public String getUserId() {
		return userId;
	}
    /**
    *系统用户id
	* @param type
    */ 
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
    *第三方平台授权码
	* @return
    */ 
	public String getAccessToken() {
		return accessToken;
	}
    /**
    *第三方平台授权码
	* @param type
    */ 
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
    /**
    *刷新access_token授权码
	* @return
    */ 
	public String getRefreshToken() {
		return refreshToken;
	}
    /**
    *刷新access_token授权码
	* @param type
    */ 
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
    /**
    *授权码到期时间（单位：秒）
	* @return
    */ 
	public String getExpiresIn() {
		return expiresIn;
	}
    /**
    *授权码到期时间（单位：秒）
	* @param type
    */ 
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
    /**
    *授权的作用域，使用逗号（,）分隔
	* @return
    */ 
	public String getScope() {
		return scope;
	}
    /**
    *授权的作用域，使用逗号（,）分隔
	* @param type
    */ 
	public void setScope(String scope) {
		this.scope = scope;
	}
    /**
    *授权创建时间
	* @return
    */ 
	public Date getCreateTime() {
		return createTime;
	}
    /**
    *授权创建时间
	* @param type
    */ 
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    /**
    *授权刷新时间
	* @return
    */ 
	public Date getUpdateTime() {
		return updateTime;
	}
    /**
    *授权刷新时间
	* @param type
    */ 
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * unionid(多个应用同一用户unionid相同)  unionid来区分用户的唯一性，因为同一用户，对同一个微信开放平台下的不同应用（移动应用、网站应用和公众帐号），unionid是相同的。
	 * @return
	 */
	public String getUnionid() {
		return unionid;
	}
	/**
	 * unionid(多个应用同一用户unionid相同)  unionid来区分用户的唯一性，因为同一用户，对同一个微信开放平台下的不同应用（移动应用、网站应用和公众帐号），unionid是相同的。
	 * @param unionid
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	@Override
	public String toString() {
		return "JointLogin [openid=" + openid + ", loginType=" + loginType + ", userId=" + userId + ", accessToken="
				+ accessToken + ", refreshToken=" + refreshToken + ", expiresIn=" + expiresIn + ", scope=" + scope
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", unionid=" + unionid + "]";
	}
	
	 
	
	
	
}
