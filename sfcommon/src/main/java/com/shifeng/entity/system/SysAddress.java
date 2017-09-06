package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * 系统地址（省市区）(sys_address)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-23 17:54:23 
 */  
public class SysAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id 
  	 private String id;
 	//名称 
  	 private String name;
 	//父ID 
  	 private String parentId;



	 
    /**
    *id 
	* @return
    */ 
	public String getId() {
		return id;
	}
    /**
    *id 
	* @param type
    */ 
	public void setId(String id) {
		this.id = id;
	}
    /**
    *名称 
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *名称 
	* @param type
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *父ID 
	* @return
    */ 
	public String getParentId() {
		return parentId;
	}
    /**
    *父ID 
	* @param type
    */ 
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
