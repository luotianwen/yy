package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 我的银币日志(mall_users_silver_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
public class MallUsersSilverLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//uid
  	 private String uid;
 	//银币
  	 private Integer silver;
 	//兑换时间
  	 private Date lasttime;
 	//余额
  	 private Integer lastsilver;
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
    *银币
	* @return
    */ 
	public Integer getSilver() {
		return silver;
	}
    /**
    *银币
	* @param silver
    */ 
	public void setSilver(Integer silver) {
		this.silver = silver;
	}
    /**
    *兑换时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *兑换时间
	* @param lasttime
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *余额
	* @return
    */ 
	public Integer getLastsilver() {
		return lastsilver;
	}
    /**
    *余额
	* @param lastsilver
    */ 
	public void setLastsilver(Integer lastsilver) {
		this.lastsilver = lastsilver;
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
