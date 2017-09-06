package com.shifeng.entity.fx;

import java.io.Serializable;
import java.util.Date;
/** 
 * 分销用户余额日志(fx_user_money_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-27 17:08:07 
 */  
public class FxUserMoneyLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//uid
  	 private String uid;
 	//金额
  	 private Double money;
 	//最后更新时间
  	 private Date lasttime;
 	//余额
  	 private Double lastmoney;
 	//类型
  	 private Integer log_type;
 	//备注
  	 private String remarks;



	 
    /**
    *uid
	* @return
    */ 
	public String getUid() {
		return uid;
	}
    /**
    *uid
	* @param uid
    */ 
	public void setUid(String uid) {
		this.uid = uid;
	}
    /**
    *金额
	* @return
    */ 
	public Double getMoney() {
		return money;
	}
    /**
    *金额
	* @param money
    */ 
	public void setMoney(Double money) {
		this.money = money;
	}
    /**
    *最后更新时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后更新时间
	* @param lasttime
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *余额
	* @return
    */ 
	public Double getLastmoney() {
		return lastmoney;
	}
    /**
    *余额
	* @param lastmoney
    */ 
	public void setLastmoney(Double lastmoney) {
		this.lastmoney = lastmoney;
	}
    /**
    *类型
	* @return
    */ 
	public Integer getLog_type() {
		return log_type;
	}
    /**
    *类型
	* @param log_type
    */ 
	public void setLog_type(Integer log_type) {
		this.log_type = log_type;
	}
    /**
    *备注
	* @return
    */ 
	public String getRemarks() {
		return remarks;
	}
    /**
    *备注
	* @param remarks
    */ 
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
