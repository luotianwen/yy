package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 前台用户表(mall_users)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:03:30 
 */  
public class MallUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String id;
 	//最后更新时间
  	 private Date lasttime;
 	//等级
  	 private Integer grade;
 	//状态
  	 private Integer state;
	private String  uname;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
    *id
	* @return
    */ 
	public String getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(String id) {
		this.id = id;
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
    *等级
	* @return
    */ 
	public Integer getGrade() {
		return grade;
	}
    /**
    *等级
	* @param grade
    */ 
	public void setGrade(Integer grade) {
		this.grade = grade;
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
