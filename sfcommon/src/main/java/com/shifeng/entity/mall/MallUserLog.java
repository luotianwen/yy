package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 前台用户登录日志(mall_user_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:03:30 
 */  
public class MallUserLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//uid
  	 private String uid;
 	//ip
  	 private String ip;
 	//最后登录时间
  	 private Date lasttime;
 	//浏览器
  	 private String browser;
 	//类型
  	 private Integer type;



	 
    /**
    *uid
	* @return
    */ 
	public String getUid() {
		return uid;
	}
    /**
    *uid
	* @param uid
    */ 
	public void setUid(String uid) {
		this.uid = uid;
	}
    /**
    *ip
	* @return
    */ 
	public String getIp() {
		return ip;
	}
    /**
    *ip
	* @param ip
    */ 
	public void setIp(String ip) {
		this.ip = ip;
	}
    /**
    *最后登录时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后登录时间
	* @param lasttime
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *浏览器
	* @return
    */ 
	public String getBrowser() {
		return browser;
	}
    /**
    *浏览器
	* @param browser
    */ 
	public void setBrowser(String browser) {
		this.browser = browser;
	}
    /**
    *类型
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *类型
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
	
}
