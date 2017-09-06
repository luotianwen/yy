package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单售后日志(o_orderInfo_service_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 17:45:44 
 */  
public class OrderInfoServiceLogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
 	//处理时间
  	 private Date ptime;
 	//类型
  	 private String type;
 	 
 
    /**
    *处理时间
	* @param ptime
    */ 
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
    public Date getPtime() {
		return ptime;
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

	@Override
	public String toString() {
		return "OrderInfoServiceLogDTO [ptime=" + ptime + ", type=" + type + "]";
	}
     
	
	
}
