package com.shifeng.mall.search.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/** 
 * 搜索记录(SearchRecord)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-07-26 15:26:00 
 */  
@Alias("searchRecord")
public class SearchRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int sr_id;
 	//用户id
  	 private int user_id;
 	//关键字
  	 private String keyword;
 	//客户端ip
  	 private String ip;
 	//搜索时间
  	 private Date search_time;
 	//请求客户端类型（Req Type）（1：PC；2：Android APP； 3：IOS APP；4：QQ；5：weixin；）
  	 private int req_type;



	 
    /**
    *id
	* @return
    */ 
	public int getSr_id() {
		return sr_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
    /**
    *用户id
	* @return
    */ 
	public int getUser_id() {
		return user_id;
	}
    /**
    *用户id
	* @param type
    */ 
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
    /**
    *关键字
	* @return
    */ 
	public String getKeyword() {
		return keyword;
	}
    /**
    *关键字
	* @param type
    */ 
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    /**
    *客户端ip
	* @return
    */ 
	public String getIp() {
		return ip;
	}
    /**
    *客户端ip
	* @param type
    */ 
	public void setIp(String ip) {
		this.ip = ip;
	}
    /**
    *搜索时间
	* @return
    */ 
	public Date getSearch_time() {
		return search_time;
	}
    /**
    *搜索时间
	* @param type
    */ 
	public void setSearch_time(Date search_time) {
		this.search_time = search_time;
	}
    /**
    *请求客户端类型（Req Type）（1：PC；2：Android APP； 3：IOS APP；4：QQ；5：weixin；）
	* @return
    */ 
	public int getReq_type() {
		return req_type;
	}
    /**
    *请求客户端类型（Req Type）（1：PC；2：Android APP； 3：IOS APP；4：QQ；5：weixin；）
	* @param type
    */ 
	public void setReq_type(int req_type) {
		this.req_type = req_type;
	}
	
}
