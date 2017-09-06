package com.shifeng.op.dto.card;

import java.io.Serializable;

public class SearchCardDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//用户id
  	 private String userid;
 	//世峰卡号
  	 private String cardnumber;
 	//开始时间
  	 private String sdate;
 	//结束时间
  	 private String edate;
  	 //end开始时间
  	 private String sdateend;
  	//end结束时间
  	 private String edateend;
  	//手机号
  	 private String phone;
  	 //发送状态（1：未发送；2：未发送）
  	 private Integer sendstatus;
  	 
  	 
 	//状态（1未绑定2未使用3部分使用4已用完5已作废6已过期）
  	 private Integer status;
  	 //订单ID
  	 private String orderid;
  	 //排列顺序
  	 private Orderby orderby;
  	 //生成批次
  	 private Integer batch;
  	 
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getSdateend() {
		return sdateend;
	}
	public void setSdateend(String sdateend) {
		this.sdateend = sdateend;
	}
	public String getEdateend() {
		return edateend;
	}
	public void setEdateend(String edateend) {
		this.edateend = edateend;
	}
	public Orderby getOrderby() {
		return orderby;
	}
	public void setOrderby(Orderby orderby) {
		this.orderby = orderby;
	}
	public Integer getBatch() {
		return batch;
	}
	public void setBatch(Integer batch) {
		this.batch = batch;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSendstatus() {
		return sendstatus;
	}
	public void setSendstatus(Integer sendstatus) {
		this.sendstatus = sendstatus;
	}
	 
    
	
}
