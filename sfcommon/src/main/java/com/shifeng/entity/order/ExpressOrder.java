package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单快递(o_express_order)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:31 
 */  
public class ExpressOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//订单编号
  	 private String orderId;
 	//序号
  	 private String expressNumber;
 	//快递id
  	 private Integer expressId;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;



	 
    /**
    *订单编号
	* @return
    */ 
	public String getOrderId() {
		return orderId;
	}
    /**
    *订单编号
	* @param orderId
    */ 
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
    /**
    *序号
	* @return
    */ 
	public String getExpressNumber() {
		return expressNumber;
	}
    /**
    *序号
	* @param expressNumber
    */ 
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
    /**
    *快递id
	* @return
    */ 
	public Integer getExpressId() {
		return expressId;
	}
    /**
    *快递id
	* @param expressId
    */ 
	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
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
