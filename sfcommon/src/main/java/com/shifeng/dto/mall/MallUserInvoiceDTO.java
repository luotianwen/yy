package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.alibaba.fastjson.annotation.JSONField;
import com.shifeng.entity.mall.MallUserInvoice;

/**
 * Created by yongshi on 2017/4/21.
 */
public class MallUserInvoiceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	private Integer id;
	// 发票抬头
	private String paymentsUnit;
	// 发票内容  1:普通发票 只能开明细
	private String content = "明细";
	// 发票类型 (1:普通发票；2：增值发票)
	private String type;
	// 单位名称
	private String vat_companyName;
	// 用户编号
	@JSONField(serialize=false)
	private String userId;
	// 纳税人识别码
	private String vat_code;
	// 注册地址
	private String vat_address;
	// 注册电话
	private String vat_phone;
	// 开户银行
	private String vat_bankName;
	// 银行账户
	private String vat_bankAccount;
	//最后修改时间
	private Date lasttime;
	
	/**
	 * 返回需要签名的内容
	 * @return
	 */
	public String getSignContent(){
		if(Objects.equals("1", type)){
			return paymentsUnit;
		}else{
			return vat_companyName+vat_code+vat_address+vat_phone+vat_phone+vat_bankName+vat_bankAccount;
		}
	}
	

	/**
	 * id
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 发票抬头
	 * 
	 * @return
	 */
	public String getPaymentsUnit() {
		return paymentsUnit;
	}

	/**
	 * 发票抬头
	 * 
	 * @param paymentsUnit
	 */
	public void setPaymentsUnit(String paymentsUnit) {
		this.paymentsUnit = paymentsUnit;
	}

	/**
	 * 发票内容
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 发票内容
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 发票类型发票类型 (1:普通发票；2：增值发票)
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 发票类型发票类型 (1:普通发票；2：增值发票)
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 单位名称
	 * 
	 * @return
	 */
	public String getVat_companyName() {
		return vat_companyName;
	}

	/**
	 * 单位名称
	 * 
	 * @param vat_companyName
	 */
	public void setVat_companyName(String vat_companyName) {
		this.vat_companyName = vat_companyName;
	}

	/**
	 * 用户编号
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户编号
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 纳税人识别码
	 * 
	 * @return
	 */
	public String getVat_code() {
		return vat_code;
	}

	/**
	 * 纳税人识别码
	 * 
	 * @param vat_code
	 */
	public void setVat_code(String vat_code) {
		this.vat_code = vat_code;
	}

	/**
	 * 注册地址
	 * 
	 * @return
	 */
	public String getVat_address() {
		return vat_address;
	}

	/**
	 * 注册地址
	 * 
	 * @param vat_address
	 */
	public void setVat_address(String vat_address) {
		this.vat_address = vat_address;
	}

	/**
	 * 注册电话
	 * 
	 * @return
	 */
	public String getVat_phone() {
		return vat_phone;
	}

	/**
	 * 注册电话
	 * 
	 * @param vat_phone
	 */
	public void setVat_phone(String vat_phone) {
		this.vat_phone = vat_phone;
	}

	/**
	 * 开户银行
	 * 
	 * @return
	 */
	public String getVat_bankName() {
		return vat_bankName;
	}

	/**
	 * 开户银行
	 * 
	 * @param vat_bankName
	 */
	public void setVat_bankName(String vat_bankName) {
		this.vat_bankName = vat_bankName;
	}

	/**
	 * 银行账户
	 * 
	 * @return
	 */
	public String getVat_bankAccount() {
		return vat_bankAccount;
	}

	/**
	 * 银行账户
	 * 
	 * @param vat_bankAccount
	 */
	public void setVat_bankAccount(String vat_bankAccount) {
		this.vat_bankAccount = vat_bankAccount;
	}

	/**
	 * 最后修改时间
	 * @return
	 */
	public Date getLasttime() {
		return lasttime;
	}

	/**
	 * 最后修改时间
	 * @param lasttime
	 */
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}


	@Override
	public String toString() {
		return "MallUserInvoiceDTO [id=" + id + ", paymentsUnit=" + paymentsUnit + ", content=" + content + ", type="
				+ type + ", vat_companyName=" + vat_companyName + ", userId=" + userId + ", vat_code=" + vat_code
				+ ", vat_address=" + vat_address + ", vat_phone=" + vat_phone + ", vat_bankName=" + vat_bankName
				+ ", vat_bankAccount=" + vat_bankAccount + "]";
	}

	 

}
