package com.shifeng.entity.category;

import java.io.Serializable;
import java.util.Date;
/** 
 * 分类属性关联表(p_propertycategory)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-11 15:42:20 
 */  
public class Propertycategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private int id;
 	//属性id
  	 private int pid;
 	//分类id
  	 private int cid;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;



	 
    /**
    *主键
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *主键
	* @param type
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *属性id
	* @return
    */ 
	public int getPid() {
		return pid;
	}
    /**
    *属性id
	* @param type
    */ 
	public void setPid(int pid) {
		this.pid = pid;
	}
    /**
    *分类id
	* @return
    */ 
	public int getCid() {
		return cid;
	}
    /**
    *分类id
	* @param type
    */ 
	public void setCid(int cid) {
		this.cid = cid;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后修改时间
	* @param type
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *最后修改人
	* @return
    */ 
	public String getUpdatename() {
		return updatename;
	}
    /**
    *最后修改人
	* @param type
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
	
}
