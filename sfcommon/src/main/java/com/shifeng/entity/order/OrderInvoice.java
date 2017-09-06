package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单发票(o_orderInvoice)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-25 10:35:10 
 */  
public class OrderInvoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//订单编号
  	 private String orderId;
 	//发票编号
  	 private Integer invoiceId;
 	//发票抬头
  	 private String paymentsUnit;
 	//发票内容
  	 private String content;
 	//发票类型（1：普通发票；2：增值发票）
  	 private String type;
 	//单位名称
  	 private String vat_companyName;
 	//纳税人识别码
  	 private String vat_code;
 	//注册地址
  	 private String vat_address;
 	//注册电话
  	 private String vat_phone;
 	//开户银行
  	 private String vat_bankName;
 	//银行账户
  	 private String vat_bankAccount;
 	//发票金额
  	 private Double totalMoneyLower;
 	//开票人
  	 private String drawer;
 	//时间
  	 private Date subTime;
 	//备注
  	 private String remark;
 	//用户编号
  	 private Integer userId;
 	//邮寄地址
  	 private String postAddress;
 	//收件人姓名
  	 private String postName;
 	//收件人电话
  	 private String postPhone;
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
    *发票编号
	* @return
    */ 
	public Integer getInvoiceId() {
		return invoiceId;
	}
    /**
    *发票编号
	* @param invoiceId
    */ 
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
    /**
    *发票抬头
	* @return
    */ 
	public String getPaymentsUnit() {
		return paymentsUnit;
	}
    /**
    *发票抬头
	* @param paymentsUnit
    */ 
	public void setPaymentsUnit(String paymentsUnit) {
		this.paymentsUnit = paymentsUnit;
	}
    /**
    *发票内容
	* @return
    */ 
	public String getContent() {
		return content;
	}
    /**
    *发票内容
	* @param content
    */ 
	public void setContent(String content) {
		this.content = content;
	}
    /**
    *发票类型（1：普通发票；2：增值发票）
	* @return
    */ 
	public String getType() {
		return type;
	}
    /**
    *发票类型（1：普通发票；2：增值发票）
	* @param type
    */ 
	public void setType(String type) {
		this.type = type;
	}
    /**
    *单位名称
	* @return
    */ 
	public String getVat_companyName() {
		return vat_companyName;
	}
    /**
    *单位名称
	* @param vat_companyName
    */ 
	public void setVat_companyName(String vat_companyName) {
		this.vat_companyName = vat_companyName;
	}
    /**
    *纳税人识别码
	* @return
    */ 
	public String getVat_code() {
		return vat_code;
	}
    /**
    *纳税人识别码
	* @param vat_code
    */ 
	public void setVat_code(String vat_code) {
		this.vat_code = vat_code;
	}
    /**
    *注册地址
	* @return
    */ 
	public String getVat_address() {
		return vat_address;
	}
    /**
    *注册地址
	* @param vat_address
    */ 
	public void setVat_address(String vat_address) {
		this.vat_address = vat_address;
	}
    /**
    *注册电话
	* @return
    */ 
	public String getVat_phone() {
		return vat_phone;
	}
    /**
    *注册电话
	* @param vat_phone
    */ 
	public void setVat_phone(String vat_phone) {
		this.vat_phone = vat_phone;
	}
    /**
    *开户银行
	* @return
    */ 
	public String getVat_bankName() {
		return vat_bankName;
	}
    /**
    *开户银行
	* @param vat_bankName
    */ 
	public void setVat_bankName(String vat_bankName) {
		this.vat_bankName = vat_bankName;
	}
    /**
    *银行账户
	* @return
    */ 
	public String getVat_bankAccount() {
		return vat_bankAccount;
	}
    /**
    *银行账户
	* @param vat_bankAccount
    */ 
	public void setVat_bankAccount(String vat_bankAccount) {
		this.vat_bankAccount = vat_bankAccount;
	}
    /**
    *发票金额
	* @return
    */ 
	public Double getTotalMoneyLower() {
		return totalMoneyLower;
	}
    /**
    *发票金额
	* @param totalMoneyLower
    */ 
	public void setTotalMoneyLower(Double totalMoneyLower) {
		this.totalMoneyLower = totalMoneyLower;
	}
    /**
    *开票人
	* @return
    */ 
	public String getDrawer() {
		return drawer;
	}
    /**
    *开票人
	* @param drawer
    */ 
	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}
    /**
    *时间
	* @return
    */ 
	public Date getSubTime() {
		return subTime;
	}
    /**
    *时间
	* @param subTime
    */ 
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
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
    *用户编号
	* @return
    */ 
	public Integer getUserId() {
		return userId;
	}
    /**
    *用户编号
	* @param userId
    */ 
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    /**
    *邮寄地址
	* @return
    */ 
	public String getPostAddress() {
		return postAddress;
	}
    /**
    *邮寄地址
	* @param postAddress
    */ 
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
    /**
    *收件人姓名
	* @return
    */ 
	public String getPostName() {
		return postName;
	}
    /**
    *收件人姓名
	* @param postName
    */ 
	public void setPostName(String postName) {
		this.postName = postName;
	}
    /**
    *收件人电话
	* @return
    */ 
	public String getPostPhone() {
		return postPhone;
	}
    /**
    *收件人电话
	* @param postPhone
    */ 
	public void setPostPhone(String postPhone) {
		this.postPhone = postPhone;
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
