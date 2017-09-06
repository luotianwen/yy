package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * 商城说明表(s_explain)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
public class Explain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int id;
 	//标题
  	 private String title;
 	//名称
  	 private String name;
 	//内容
  	 private String content;
 	//类型
  	 private int type;
 	//发布日期
  	 private String releaseDate;
 	//最后修改时间
  	 private String lasttime;
 	//最后修改人
  	 private String updatename;



	 
    /**
    *id
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *标题
	* @return
    */ 
	public String getTitle() {
		return title;
	}
    /**
    *标题
	* @param title
    */ 
	public void setTitle(String title) {
		this.title = title;
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
    *内容
	* @return
    */ 
	public String getContent() {
		return content;
	}
    /**
    *内容
	* @param content
    */ 
	public void setContent(String content) {
		this.content = content;
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
    *发布日期
	* @return
    */ 
	public String getReleaseDate() {
		return releaseDate;
	}
    /**
    *发布日期
	* @param releaseDate
    */ 
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public String getLasttime() {
		return lasttime;
	}
    /**
    *最后修改时间
	* @param lasttime
    */ 
	public void setLasttime(String lasttime) {
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
	
}
