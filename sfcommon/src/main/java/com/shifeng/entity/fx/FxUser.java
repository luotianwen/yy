package com.shifeng.entity.fx;

import java.io.Serializable;
import java.util.Date;
/** 
 * 分销用户(fx_user)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-27 11:06:20 
 */  
public class FxUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//推荐用户id
  	 private String recommend_userid;
 	//被推荐用户id
  	 private String recommended_userid;
	//会员名称
	private String uname;

 	//被推荐用户名称
  	 private String name;
 	//推荐时间
  	 private Date stime;
 	//备注
  	 private String remark;
 	//状态
  	 private Integer state;


	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
    *推荐用户id
	* @return
    */ 
	public String getRecommend_userid() {
		return recommend_userid;
	}
    /**
    *推荐用户id
	* @param recommend_userid
    */ 
	public void setRecommend_userid(String recommend_userid) {
		this.recommend_userid = recommend_userid;
	}
    /**
    *被推荐用户id
	* @return
    */ 
	public String getRecommended_userid() {
		return recommended_userid;
	}
    /**
    *被推荐用户id
	* @param recommended_userid
    */ 
	public void setRecommended_userid(String recommended_userid) {
		this.recommended_userid = recommended_userid;
	}
    /**
    *被推荐用户名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *被推荐用户名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *推荐时间
	* @return
    */ 
	public Date getStime() {
		return stime;
	}
    /**
    *推荐时间
	* @param stime
    */ 
	public void setStime(Date stime) {
		this.stime = stime;
	}
    /**
    *备注
	* @return
    */ 
	public String getRemark() {
		return remark;
	}
    /**
    *备注
	* @param remark
    */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
    *状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
	
}
