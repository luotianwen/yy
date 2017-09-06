package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单售后日志(o_orderInfo_service_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 17:45:44 
 */  
public class OrderInfoServiceLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//订单售后id
  	 private Integer oosid;
 	//处理时间
  	 private Date ptime;
 	//处理信息
  	 private String info;
 	//类型
  	 private String type;
 	//操作人账号
  	 private String opid;
 	//操作人姓名
  	 private String opname;



	 
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
    *订单售后id
	* @return
    */ 
	public Integer getOosid() {
		return oosid;
	}
    /**
    *订单售后id
	* @param oosid
    */ 
	public void setOosid(Integer oosid) {
		this.oosid = oosid;
	}
    /**
    *处理时间
	* @return
    */ 
	public Date getPtime() {
		return ptime;
	}
    /**
    *处理时间
	* @param ptime
    */ 
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
    /**
    *处理信息
	* @return
    */ 
	public String getInfo() {
		return info;
	}
    /**
    *处理信息
	* @param info
    */ 
	public void setInfo(String info) {
		this.info = info;
	}
    /**
    *类型
	* @return
    */ 
	public String getType() {
		return type;
	}
    /**
    *类型
	* @param type
    */ 
	public void setType(String type) {
		this.type = type;
	}
    /**
    *操作人账号
	* @return
    */ 
	public String getOpid() {
		return opid;
	}
    /**
    *操作人账号
	* @param opid
    */ 
	public void setOpid(String opid) {
		this.opid = opid;
	}
    /**
    *操作人姓名
	* @return
    */ 
	public String getOpname() {
		return opname;
	}
    /**
    *操作人姓名
	* @param opname
    */ 
	public void setOpname(String opname) {
		this.opname = opname;
	}
	
}
