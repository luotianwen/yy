package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单日志(o_orderInfo_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 11:22:32 
 */  
public class OrderInfoLogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	 
 	//操作时间
  	 private Date create_time;
 	//日志内容
  	 private String log_content;
 	//操作人
  	 private String create_user_name;

 
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
     
	
}
