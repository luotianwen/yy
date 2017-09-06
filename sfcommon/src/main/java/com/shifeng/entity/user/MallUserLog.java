package com.shifeng.entity.user;

import java.io.Serializable;
import java.util.Date;
/** 
 * 前台用户登录日志(mall_user_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-20 16:16:04 
 */  
public class MallUserLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//uid 用户id
  	 private Integer uid;
 	//ip ip
  	 private String ip;
 	//最后登录时间 最后修改时间
  	 private Date lasttime;
 	//浏览器 浏览器
  	 private String browser;
 	//类型 1微信2安卓3苹果4手机浏览器5pc
  	 private Integer type;



	 
    /**
    *uid 用户id
	* @return
    */ 
	public Integer getUid() {
		return uid;
	}
    /**
    *uid 用户id
	* @param type
    */ 
	public void setUid(Integer uid) {
		this.uid = uid;
	}
    /**
    *ip ip
	* @return
    */ 
	public String getIp() {
		return ip;
	}
    /**
    *ip ip
	* @param type
    */ 
	public void setIp(String ip) {
		this.ip = ip;
	}
    /**
    *最后登录时间 最后修改时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后登录时间 最后修改时间
	* @param type
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *浏览器 浏览器
	* @return
    */ 
	public String getBrowser() {
		return browser;
	}
    /**
    *浏览器 浏览器
	* @param type
    */ 
	public void setBrowser(String browser) {
		this.browser = browser;
	}
    /**
    *类型 1微信2安卓3苹果4手机浏览器5pc
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *类型 1微信2安卓3苹果4手机浏览器5pc
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
	
}
