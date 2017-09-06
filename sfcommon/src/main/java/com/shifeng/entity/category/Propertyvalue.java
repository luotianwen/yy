package com.shifeng.entity.category;

import java.io.Serializable;
import java.util.Date;
/** 
 * 属性值表(p_propertyvalue)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-11 15:42:20 
 */  
public class Propertyvalue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private int id;
 	//属性编号
  	 private int pid;
 	//属性值
  	 private String content;
 	//排序
  	 private int sort;
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
    *属性编号
	* @return
    */ 
	public int getPid() {
		return pid;
	}
    /**
    *属性编号
	* @param type
    */ 
	public void setPid(int pid) {
		this.pid = pid;
	}
    /**
    *属性值
	* @return
    */ 
	public String getContent() {
		return content;
	}
    /**
    *属性值
	* @param type
    */ 
	public void setContent(String content) {
		this.content = content;
	}
    /**
    *排序
	* @return
    */ 
	public int getSort() {
		return sort;
	}
    /**
    *排序
	* @param type
    */ 
	public void setSort(int sort) {
		this.sort = sort;
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
