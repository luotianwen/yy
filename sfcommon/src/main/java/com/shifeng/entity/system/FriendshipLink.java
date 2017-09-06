package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * 友情链接(s_friendship_link)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-23 13:31:48 
 */  
public class FriendshipLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int id;
 	//名称
  	 private String name;
 	//发布状态
  	 private int state;
 	//备注
  	 private String note;
 	//链接
  	 private String link;
 	//发布日期
  	 private String releaseDate;
 	//最后修改时间
  	 private String lasttime;
 	//最后修改人
  	 private String updatename;
 	//联系人
  	 private String contacts;
 	//联系人电话
  	 private String phone;
 	//联系人邮箱
  	 private String email;



	 
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
    *备注
	* @return
    */ 
	public String getNote() {
		return note;
	}
    /**
    *备注
	* @param note
    */ 
	public void setNote(String note) {
		this.note = note;
	}
    /**
    *链接
	* @return
    */ 
	public String getLink() {
		return link;
	}
    /**
    *链接
	* @param link
    */ 
	public void setLink(String link) {
		this.link = link;
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
    /**
    *联系人
	* @return
    */ 
	public String getContacts() {
		return contacts;
	}
    /**
    *联系人
	* @param contacts
    */ 
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
    /**
    *联系人电话
	* @return
    */ 
	public String getPhone() {
		return phone;
	}
    /**
    *联系人电话
	* @param phone
    */ 
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *联系人邮箱
	* @return
    */ 
	public String getEmail() {
		return email;
	}
    /**
    *联系人邮箱
	* @param email
    */ 
	public void setEmail(String email) {
		this.email = email;
	}
	
}
