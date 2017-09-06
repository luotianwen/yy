package com.shifeng.entity.card;

import java.io.Serializable;
/** 
 * 世峰e卡(c_card)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 13:38:19 
 */  
public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//卡号
  	 private String number;
 	//密码
  	 private String password;
 	//开始时间
  	 private String sdate;
 	//结束时间
  	 private String edate;
 	//状态（1未绑定2未使用3部分使用4已用完5已作废6已过期）
  	 private int status;
 	//创建时间
  	 private String cdate;
 	//创建人
  	 private String userid;
 	//金额
  	 private double money;
 	//修改人
  	 private String updateuser;
 	//修改时间
  	 private String udate;
 	//生成批次
  	 private int batch;
 	//备注
  	 private String remark;
 	//手机号
  	 private String phone;
 	//发送状态（1：未发送；2：已发送；3：发送失败）
  	 private int sendstatus;
 	//短信备注
  	 private String sendremark;
  	//生成数量
  	 private int count;


	 
    /**
    *卡号
	* @return
    */ 
	public String getNumber() {
		return number;
	}
    /**
    *卡号
	* @param number
    */ 
	public void setNumber(String number) {
		this.number = number;
	}
    /**
    *密码
	* @return
    */ 
	public String getPassword() {
		return password;
	}
    /**
    *密码
	* @param password
    */ 
	public void setPassword(String password) {
		this.password = password;
	}
    /**
    *开始时间
	* @return
    */ 
	public String getSdate() {
		return sdate;
	}
    /**
    *开始时间
	* @param sdate
    */ 
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
    /**
    *结束时间
	* @return
    */ 
	public String getEdate() {
		return edate;
	}
    /**
    *结束时间
	* @param edate
    */ 
	public void setEdate(String edate) {
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
    *创建时间
	* @return
    */ 
	public String getCdate() {
		return cdate;
	}
    /**
    *创建时间
	* @param cdate
    */ 
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
    /**
    *创建人
	* @return
    */ 
	public String getUserid() {
		return userid;
	}
    /**
    *创建人
	* @param UserName
    */ 
	public void setUserid(String userid) {
		this.userid = userid;
	}
    /**
    *金额
	* @return
    */ 
	public double getMoney() {
		return money;
	}
    /**
    *金额
	* @param money
    */ 
	public void setMoney(double money) {
		this.money = money;
	}
    /**
    *修改人
	* @return
    */ 
	public String getUpdateuser() {
		return updateuser;
	}
    /**
    *修改人
	* @param updateuser
    */ 
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
    /**
    *修改时间
	* @return
    */ 
	public String getUdate() {
		return udate;
	}
    /**
    *修改时间
	* @param udate
    */ 
	public void setUdate(String udate) {
		this.udate = udate;
	}
    /**
    *生成批次
	* @return
    */ 
	public int getBatch() {
		return batch;
	}
    /**
    *生成批次
	* @param batch
    */ 
	public void setBatch(int batch) {
		this.batch = batch;
	}
    /**
    *备注
	* @return
    */ 
	public String getRemark() {
		return remark;
	}
    /**
    *备注
	* @param remark
    */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
    *手机号
	* @return
    */ 
	public String getPhone() {
		return phone;
	}
    /**
    *手机号
	* @param phone
    */ 
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *发送状态（1：未发送；2：已发送；3：发送失败）
	* @return
    */ 
	public int getSendstatus() {
		return sendstatus;
	}
    /**
    *发送状态（1：未发送；2：已发送；3：发送失败）
	* @param sendstatus
    */ 
	public void setSendstatus(int sendstatus) {
		this.sendstatus = sendstatus;
	}
    /**
    *短信备注
	* @return
    */ 
	public String getSendremark() {
		return sendremark;
	}
    /**
    *短信备注
	* @param sendremark
    */ 
	public void setSendremark(String sendremark) {
		this.sendremark = sendremark;
	}
	/**
	 * 生成数量
	 * @return
	 */
	public int getCount() {
		return count;
	}
	/**
	 * 生成数量
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
}
