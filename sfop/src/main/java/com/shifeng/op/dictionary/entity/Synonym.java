package com.shifeng.op.dictionary.entity;

import java.io.Serializable;
import java.util.Date;
/** 
 * 同义词字典表(synonymDic)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-12-15 15:51:09 
 */  
public class Synonym implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int id;
 	//同义词
  	 private String synonym;
 	//转义词
  	 private String escape;
 	//词
  	 private String word;
 	//添加/更新时间
  	 private Date update_time;
 	//是否启用（0：是；1：否）
  	 private int is_enable;



	 
    /**
    *id
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *id
	* @param type
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *同义词
	* @return
    */ 
	public String getSynonym() {
		return synonym;
	}
    /**
    *同义词
	* @param type
    */ 
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
    /**
    *转义词
	* @return
    */ 
	public String getEscape() {
		return escape;
	}
    /**
    *转义词
	* @param type
    */ 
	public void setEscape(String escape) {
		this.escape = escape;
	}
    /**
    *词
	* @return
    */ 
	public String getWord() {
		return word;
	}
    /**
    *词
	* @param type
    */ 
	public void setWord(String word) {
		this.word = word;
	}
    /**
    *添加/更新时间
	* @return
    */ 
	public Date getUpdate_time() {
		return update_time;
	}
    /**
    *添加/更新时间
	* @param type
    */ 
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
    /**
    *是否启用（0：是；1：否）
	* @return
    */ 
	public int getIs_enable() {
		return is_enable;
	}
    /**
    *是否启用（0：是；1：否）
	* @param type
    */ 
	public void setIs_enable(int is_enable) {
		this.is_enable = is_enable;
	}
	
}
