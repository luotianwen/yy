package com.shifeng.entity.category;

import java.io.Serializable;
import java.util.Date;
/** 
 * 分类导航关联表(p_navigation_category)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 15:50:37 
 */  
public class NavigationCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private int id;
 	//导航id
  	 private int nid;
 	//分类id
  	 private int cid;
 	//父分类id
  	 private int parentid;
 	//url
  	 private String url;
 	//排序
  	 private int sort;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;



	 
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
    *导航id
	* @return
    */ 
	public int getNid() {
		return nid;
	}
    /**
    *导航id
	* @param nid
    */ 
	public void setNid(int nid) {
		this.nid = nid;
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
	* @param cid
    */ 
	public void setCid(int cid) {
		this.cid = cid;
	}
    /**
    *父分类id
	* @return
    */ 
	public int getParentid() {
		return parentid;
	}
    /**
    *父分类id
	* @param parentid
    */ 
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
    /**
    *url
	* @return
    */ 
	public String getUrl() {
		return url;
	}
    /**
    *url
	* @param url
    */ 
	public void setUrl(String url) {
		this.url = url;
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
