package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * 银币设置(sys_sliver)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-23 15:25:23 
 */  
public class SysSliver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//激活送银币
  	 private Integer activate;
 	//银币兑换E卡比例
  	 private Integer exchange;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;



	 
    /**
    *id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *激活送银币
	* @return
    */ 
	public Integer getActivate() {
		return activate;
	}
    /**
    *激活送银币
	* @param activate
    */ 
	public void setActivate(Integer activate) {
		this.activate = activate;
	}
    /**
    *银币兑换E卡比例
	* @return
    */ 
	public Integer getExchange() {
		return exchange;
	}
    /**
    *银币兑换E卡比例
	* @param exchange
    */ 
	public void setExchange(Integer exchange) {
		this.exchange = exchange;
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
	
}
