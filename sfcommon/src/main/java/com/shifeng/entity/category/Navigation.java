package com.shifeng.entity.category;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 导航表(p_navigation)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 15:50:37 
 */  
public class Navigation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private int id;
 	//名称
  	 private String name;
 	//url链接路径
  	 private String url;
 	//状态
  	 private int state;
 	//类型
  	 private int type;
 	//排序
  	 private int sort;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;

	private List<Category> child;

	public List<Category> getChild() {
		return child;
	}

	public void setChild(List<Category> child) {
		this.child = child;
	}

	/**
    *主键
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *主键
	* @param id
    */ 
	public void setId(int id) {
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
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *url链接路径
	* @return
    */ 
	public String getUrl() {
		return url;
	}
    /**
    *url链接路径
	* @param url
    */ 
	public void setUrl(String url) {
		this.url = url;
	}
    /**
    *状态
	* @return
    */ 
	public int getState() {
		return state;
	}
    /**
    *状态
	* @param state
    */ 
	public void setState(int state) {
		this.state = state;
	}
    /**
    *类型
	* @return
    */ 
	public int getType() {
		return type;
	}
    /**
    *类型
	* @param type
    */ 
	public void setType(int type) {
		this.type = type;
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
	* @param sort
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
	* @param lasttime
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
	* @param updatename
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
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
	
}
