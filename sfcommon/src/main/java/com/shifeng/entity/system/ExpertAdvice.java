package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * 专家建议(s_expert_advice)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
public class ExpertAdvice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int id;
 	//发布者
  	 private String publisher;
 	//标题
  	 private String title;
 	//内容
  	 private String content;
 	//浏览量
  	 private int pv;
 	//发布状态
  	 private int state;
 	//发布时间
  	 private String submitTime;
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
    *发布者
	* @return
    */ 
	public String getPublisher() {
		return publisher;
	}
    /**
    *发布者
	* @param publisher
    */ 
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
    *浏览量
	* @return
    */ 
	public int getPv() {
		return pv;
	}
    /**
    *浏览量
	* @param pv
    */ 
	public void setPv(int pv) {
		this.pv = pv;
	}
    /**
    *发布状态
	* @return
    */ 
	public int getState() {
		return state;
	}
    /**
    *发布状态
	* @param state
    */ 
	public void setState(int state) {
		this.state = state;
	}
    /**
    *发布时间
	* @return
    */ 
	public String getSubmitTime() {
		return submitTime;
	}
    /**
    *发布时间
	* @param submitTime
    */ 
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
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
