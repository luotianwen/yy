package com.shifeng.dto.fx;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
/** 
 * 分销用户余额(fx_user_money)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-27 17:08:07 
 */  
public class FxUserMoneyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


 	//uid
	@JsonIgnore
	@JSONField(serialize=false)
  	 private String uid;
 	//金额
  	 private Double money = 0.00;
 	//所有佣金
  	 private Double allmoney = 0.00;
 	//已提现佣金
  	 private Double costmoney = 0.00;
 	//待收益佣金  (此字段已弃用)
  	 private Double pending_income = 0.00;
 



	 
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
    *所有佣金
	* @return
    */ 
	public Double getAllmoney() {
		return allmoney;
	}
    /**
    *所有佣金
	* @param allmoney
    */ 
	public void setAllmoney(Double allmoney) {
		this.allmoney = allmoney;
	}
    /**
    *已提现佣金
	* @return
    */ 
	public Double getCostmoney() {
		return costmoney;
	}
    /**
    *已提现佣金
	* @param costmoney
    */ 
	public void setCostmoney(Double costmoney) {
		this.costmoney = costmoney;
	}
    /**
    *待收益佣金
	* @return
    */ 
	public Double getPending_income() {
		return pending_income;
	}
    /**
    *待收益佣金
	* @param pending_income
    */ 
	public void setPending_income(Double pending_income) {
		this.pending_income = pending_income;
	}
    
	
}
