package com.shifeng.entity.user;

import java.io.Serializable;
import java.util.Date;
/** 
 * 用户浏览(mall_user_browse)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-20 16:16:04 
 */  
public class MallUserBrowse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id 
  	 private Integer id;
 	//用户id 
  	 private String uid;
 	//产品id 
  	 private String pid;
 	//访问时间 
  	 private Date visttime;



	 
    /**
    *id 
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id 
	* @param type
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *用户id 
	* @return
    */ 
	public String getUid() {
		return uid;
	}
    /**
    *用户id 
	* @param type
    */ 
	public void setUid(String uid) {
		this.uid = uid;
	}
    /**
    *产品id 
	* @return
    */ 
	public String getPid() {
		return pid;
	}
    /**
    *产品id 
	* @param type
    */ 
	public void setPid(String pid) {
		this.pid = pid;
	}
    /**
    *访问时间 
	* @return
    */ 
	public Date getVisttime() {
		return visttime;
	}
    /**
    *访问时间 
	* @param type
    */ 
	public void setVisttime(Date visttime) {
		this.visttime = visttime;
	}
	
}
