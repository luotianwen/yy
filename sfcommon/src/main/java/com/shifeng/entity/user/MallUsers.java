package com.shifeng.entity.user;

import java.io.Serializable;
import java.util.Date;
/** 
 * 前台用户表(mall_users)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-20 16:16:04 
 */  
public class MallUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id id
  	 private Integer id;
 	//最后更新时间 
  	 private Date lasttime;
 	//等级 
  	 private Integer grade;
 	//状态 1正常2冻结3禁用
  	 private Integer state;
	private String uname;


	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
    *id id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id id
    */
	public void setId(Integer id) {
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
    */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
    /**
    *状态 1正常2冻结3禁用
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态 1正常2冻结3禁用
    */
	public void setState(Integer state) {
		this.state = state;
	}
	
}
