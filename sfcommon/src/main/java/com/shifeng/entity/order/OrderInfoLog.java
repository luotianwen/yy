package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单日志(o_orderInfo_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 11:22:32 
 */  
public class OrderInfoLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//日志id
  	 private Integer log_id;
 	//订单id
  	 private String order_id;
 	//操作时间
  	 private Date create_time;
 	//日志内容
  	 private String log_content;
 	//操作人id
  	 private String create_user_id;
 	//操作人
  	 private String create_user_name;
 	//日志级别（1：普通用户可看；2：系统用户（包含普通用户））
  	 private Integer log_level;
 	//修改后状态
  	 private Integer after_status;
 	//修改前状态
  	 private Integer before_status;



	 
    /**
    *日志id
	* @return
    */ 
	public Integer getLog_id() {
		return log_id;
	}
    /**
    *日志id
	* @param log_id
    */ 
	public void setLog_id(Integer log_id) {
		this.log_id = log_id;
	}
    /**
    *订单id
	* @return
    */ 
	public String getOrder_id() {
		return order_id;
	}
    /**
    *订单id
	* @param order_id
    */ 
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
    /**
    *操作时间
	* @return
    */ 
	public Date getCreate_time() {
		return create_time;
	}
    /**
    *操作时间
	* @param create_time
    */ 
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
    /**
    *日志内容
	* @return
    */ 
	public String getLog_content() {
		return log_content;
	}
    /**
    *日志内容
	* @param log_content
    */ 
	public void setLog_content(String log_content) {
		this.log_content = log_content;
	}
    /**
    *操作人id
	* @return
    */ 
	public String getCreate_user_id() {
		return create_user_id;
	}
    /**
    *操作人id
	* @param create_user_id
    */ 
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
    /**
    *操作人
	* @return
    */ 
	public String getCreate_user_name() {
		return create_user_name;
	}
    /**
    *操作人
	* @param create_user_name
    */ 
	public void setCreate_user_name(String create_user_name) {
		this.create_user_name = create_user_name;
	}
    /**
    *日志级别（1：普通用户可看；2：系统用户（包含普通用户））
	* @return
    */ 
	public Integer getLog_level() {
		return log_level;
	}
    /**
    *日志级别（1：普通用户可看；2：系统用户（包含普通用户））
	* @param log_level
    */ 
	public void setLog_level(Integer log_level) {
		this.log_level = log_level;
	}
    /**
    *修改后状态
	* @return
    */ 
	public Integer getAfter_status() {
		return after_status;
	}
    /**
    *修改后状态
	* @param after_status
    */ 
	public void setAfter_status(Integer after_status) {
		this.after_status = after_status;
	}
    /**
    *修改前状态
	* @return
    */ 
	public Integer getBefore_status() {
		return before_status;
	}
    /**
    *修改前状态
	* @param before_status
    */ 
	public void setBefore_status(Integer before_status) {
		this.before_status = before_status;
	}
	
}
