
package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 我的银币(mall_users_silver)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
public class MallUsersSilver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//uid
  	 private String uid;
	//name
	private String name;
 	//已兑换银币
  	 private Integer silver;
 	//剩余银币
  	 private Integer lastsilver;
 	//最后更新时间
  	 private Date lasttime;
 	//所有银币
  	 private Integer allsilver;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
    *已兑换银币
	* @return
    */ 
	public Integer getSilver() {
		return silver;
	}
    /**
    *已兑换银币
	* @param silver
    */ 
	public void setSilver(Integer silver) {
		this.silver = silver;
	}
    /**
    *剩余银币
	* @return
    */ 
	public Integer getLastsilver() {
		return lastsilver;
	}
    /**
    *剩余银币
	* @param lastsilver
    */ 
	public void setLastsilver(Integer lastsilver) {
		this.lastsilver = lastsilver;
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
	* @param lasttime
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *所有银币
	* @return
    */ 
	public Integer getAllsilver() {
		return allsilver;
	}
    /**
    *所有银币
	* @param allsilver
    */ 
	public void setAllsilver(Integer allsilver) {
		this.allsilver = allsilver;
	}
	
}
