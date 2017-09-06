package com.shifeng.entity.card;

import java.io.Serializable;
import java.util.Date;
/** 
 * 用户世峰e卡(c_user_card)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 13:38:19 
 */  
public class UserCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//用户id
  	 private int userid;
 	//世峰卡号
  	 private String cardnumber;
 	//余额
  	 private double money;
 	//最后更新时间
  	 private Date lasttime;
 	//开始时间
  	 private Date sdate;
 	//结束时间
  	 private Date edate;
 	//状态（1未绑定2未使用3部分使用4已用完5已作废6已过期）
  	 private int status;
 	//用户绑定e卡时间
  	 private Date bindingtime;



	 
    /**
    *用户id
	* @return
    */ 
	public int getUserid() {
		return userid;
	}
    /**
    *用户id
	* @param userid
    */ 
	public void setUserid(int userid) {
		this.userid = userid;
	}
    /**
    *世峰卡号
	* @return
    */ 
	public String getCardnumber() {
		return cardnumber;
	}
    /**
    *世峰卡号
	* @param cardnumber
    */ 
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
    /**
    *余额
	* @return
    */ 
	public double getMoney() {
		return money;
	}
    /**
    *余额
	* @param money
    */ 
	public void setMoney(double money) {
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
    *开始时间
	* @return
    */ 
	public Date getSdate() {
		return sdate;
	}
    /**
    *开始时间
	* @param sdate
    */ 
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
    /**
    *结束时间
	* @return
    */ 
	public Date getEdate() {
		return edate;
	}
    /**
    *结束时间
	* @param edate
    */ 
	public void setEdate(Date edate) {
		this.edate = edate;
	}
    /**
    *状态（1未绑定2未使用3部分使用4已用完5已作废6已过期）
	* @return
    */ 
	public int getStatus() {
		return status;
	}
    /**
    *状态（1未绑定2未使用3部分使用4已用完5已作废6已过期）
	* @param status
    */ 
	public void setStatus(int status) {
		this.status = status;
	}
    /**
    *用户绑定e卡时间
	* @return
    */ 
	public Date getBindingtime() {
		return bindingtime;
	}
    /**
    *用户绑定e卡时间
	* @param bindingtime
    */ 
	public void setBindingtime(Date bindingtime) {
		this.bindingtime = bindingtime;
	}
	
}
