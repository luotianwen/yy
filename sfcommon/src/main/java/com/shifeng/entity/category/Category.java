package com.shifeng.entity.category;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 分类表(c_category)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-11 15:42:20 
 */  
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private int id;
	//父级编号
  	 private int parentid;
  	 //父类名称
  	 private String parentname;
 	//名称
  	 private String descript;
 	//url链接路径
  	 private String url;
 	//状态
  	 private int state;
 	//图片
  	 private String image;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;

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
    */
	public void setId(int id) {
		this.id = id;
	}
    /**
    *父级编号
	* @return
    */ 
	public int getParentid() {
		return parentid;
	}
    /**
    *父级编号
	* @param type
    */ 
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	/**
    *父级名称
	* @return
    */ 
	public String getParentname() {
		return parentname;
	}
    /**
    *父级名称
	* @param type
    */ 
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
    /**
    *名称
	* @return
    */ 
	public String getDescript() {
		return descript;
	}
    /**
    *名称
	* @param type
    */ 
	public void setDescript(String descript) {
		this.descript = descript;
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
	* @param type
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
	* @param type
    */ 
	public void setState(int state) {
		this.state = state;
	}
    /**
    *图片
	* @return
    */ 
	public String getImage() {
		return image;
	}
    /**
    *图片
	* @param type
    */ 
	public void setImage(String image) {
		this.image = image;
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
