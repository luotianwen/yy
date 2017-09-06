package com.shifeng.op.dictionary.entity;

import java.io.Serializable;
import java.util.Date;
/** 
 * 字典词库(Dictionary)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-12-15 15:51:09 
 */  
public class Dictionary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int id;
 	//词
  	 private String word;
 	//词简拼
  	 private String jp;
 	//词全拼
  	 private String qp;
 	//词类型（1：基本词、2：停止词）
  	 private int dic_type;
 	//相关结果
  	 private int related_count;
 	//搜索指数
  	 private int search_count;
 	//权重
  	 private int weight;
 	//是否启用（0：是；1：否）
  	 private int is_enable;
 	//添加/更新时间
  	 private Date update_time;



	 
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
    *词简拼
	* @return
    */ 
	public String getJp() {
		return jp;
	}
    /**
    *词简拼
	* @param type
    */ 
	public void setJp(String jp) {
		this.jp = jp;
	}
    /**
    *词全拼
	* @return
    */ 
	public String getQp() {
		return qp;
	}
    /**
    *词全拼
	* @param type
    */ 
	public void setQp(String qp) {
		this.qp = qp;
	}
    /**
    *词类型（1：基本词、2：停止词）
	* @return
    */ 
	public int getDic_type() {
		return dic_type;
	}
    /**
    *词类型（1：基本词、2：停止词）
	* @param type
    */ 
	public void setDic_type(int dic_type) {
		this.dic_type = dic_type;
	}
    /**
    *相关结果
	* @return
    */ 
	public int getRelated_count() {
		return related_count;
	}
    /**
    *相关结果
	* @param type
    */ 
	public void setRelated_count(int related_count) {
		this.related_count = related_count;
	}
    /**
    *搜索指数
	* @return
    */ 
	public int getSearch_count() {
		return search_count;
	}
    /**
    *搜索指数
	* @param type
    */ 
	public void setSearch_count(int search_count) {
		this.search_count = search_count;
	}
    /**
    *权重
	* @return
    */ 
	public int getWeight() {
		return weight;
	}
    /**
    *权重
	* @param type
    */ 
	public void setWeight(int weight) {
		this.weight = weight;
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
	
}
