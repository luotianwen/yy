package com.shifeng.op.dto.card;

import java.io.Serializable;

public class Orderby implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//开始时间
	private String sdate;
	//结束时间
	private String edate;
	//创建时间
	private String cdate;
	//卡号
	private String number;
	
	
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
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
