package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 入驻基本信息填写(s_merchants_settled)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */  
public class MerchantsSettled implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//公司官网地址
  	 private String website;
 	//三方平台店铺网址
  	 private String onlinestore;
 	//通过哪种渠道知道世峰户外商城
  	 private Integer channel;
 	//负责人姓名
  	 private String head_name;
 	//负责人手机号
  	 private String head_phone;
 	//负责人邮箱
  	 private String head_email;
 	//id
  	 private Integer id;
 	//用户id
  	 private Integer userId;
	//用户名称
	private String userName;
 	//公司类型
  	 private Integer type;
 	//合作模式
  	 private Integer cooperation;

	//是否委托
  	 private Integer isEntrust;
 	//授权手机号
  	 private String phone;
 	//法定代表人姓名
  	 private String legalRepresentative;
 	//法定代表人手机号
  	 private String legalPersonPhone;
 	//身份证号
  	 private String id_number;
 	//公司名称
  	 private String name;
 	//公司所在地
  	 private String companyArea;
 	//公司详细地址
  	 private String companyAddress;
 	//公司电话号
  	 private String companyPhone;
 	//ERP类型
  	 private Integer erptype;
 	//法人身份证(正面)电子版
  	 private String corporate_front_card;
 	//法人身份证(反面)电子版
  	 private String corporate_back_card;
 	//银行开户许可证
  	 private String bank_image;
 	//三证合一
  	 private Integer isThree;
 	//三证合一电子版
  	 private String threeInOneImage;
 	//组织机构代码证电子版
  	 private String organizationImage;
 	//纳税登记证电子版
  	 private String taxImage;
 	//营业执照副本电子版
  	 private String licenseImage;
 	//银行开户名
  	 private String bankName;
 	//公司银行账号
  	 private String bankNum;
 	//开户银行支行名称
  	 private String bankBranchName;
 	//开户银行支行所在地
  	 private String locationBankbranch;
 	//纳税人类型
  	 private Integer taxpayerType;
 	//纳税类型税码
  	 private Integer taxpayerCoding;
 	//初审状态
  	 private Integer state;



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	 
    /**
    *公司官网地址
	* @return
    */ 
	public String getWebsite() {
		return website;
	}
    /**
    *公司官网地址
	* @param website
    */ 
	public void setWebsite(String website) {
		this.website = website;
	}
    /**
    *三方平台店铺网址
	* @return
    */ 
	public String getOnlinestore() {
		return onlinestore;
	}
    /**
    *三方平台店铺网址
	* @param onlinestore
    */ 
	public void setOnlinestore(String onlinestore) {
		this.onlinestore = onlinestore;
	}
    /**
    *通过哪种渠道知道世峰户外商城
	* @return
    */ 
	public Integer getChannel() {
		return channel;
	}
    /**
    *通过哪种渠道知道世峰户外商城
	* @param channel
    */ 
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
    /**
    *负责人姓名
	* @return
    */ 
	public String getHead_name() {
		return head_name;
	}
    /**
    *负责人姓名
	* @param head_name
    */ 
	public void setHead_name(String head_name) {
		this.head_name = head_name;
	}
    /**
    *负责人手机号
	* @return
    */ 
	public String getHead_phone() {
		return head_phone;
	}
    /**
    *负责人手机号
	* @param head_phone
    */ 
	public void setHead_phone(String head_phone) {
		this.head_phone = head_phone;
	}
    /**
    *负责人邮箱
	* @return
    */ 
	public String getHead_email() {
		return head_email;
	}
    /**
    *负责人邮箱
	* @param head_email
    */ 
	public void setHead_email(String head_email) {
		this.head_email = head_email;
	}
    /**
    *id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *用户id
	* @return
    */ 
	public Integer getUserId() {
		return userId;
	}
    /**
    *用户id
	* @param userId
    */ 
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    /**
    *公司类型
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *公司类型
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *合作模式
	* @return
    */ 
	public Integer getCooperation() {
		return cooperation;
	}
    /**
    *合作模式
	* @param cooperation
    */ 
	public void setCooperation(Integer cooperation) {
		this.cooperation = cooperation;
	}
    /**
    *是否委托
	* @return
    */ 
	public Integer getIsEntrust() {
		return isEntrust;
	}
    /**
    *是否委托
	* @param isEntrust
    */ 
	public void setIsEntrust(Integer isEntrust) {
		this.isEntrust = isEntrust;
	}
    /**
    *授权手机号
	* @return
    */ 
	public String getPhone() {
		return phone;
	}
    /**
    *授权手机号
	* @param phone
    */ 
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *法定代表人姓名
	* @return
    */ 
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
    /**
    *法定代表人姓名
	* @param legalRepresentative
    */ 
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
    /**
    *法定代表人手机号
	* @return
    */ 
	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}
    /**
    *法定代表人手机号
	* @param legalPersonPhone
    */ 
	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}
    /**
    *身份证号
	* @return
    */ 
	public String getId_number() {
		return id_number;
	}
    /**
    *身份证号
	* @param id_number
    */ 
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
    /**
    *公司名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *公司名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *公司所在地
	* @return
    */ 
	public String getCompanyArea() {
		return companyArea;
	}
    /**
    *公司所在地
	* @param companyArea
    */ 
	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}
    /**
    *公司详细地址
	* @return
    */ 
	public String getCompanyAddress() {
		return companyAddress;
	}
    /**
    *公司详细地址
	* @param companyAddress
    */ 
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
    /**
    *公司电话号
	* @return
    */ 
	public String getCompanyPhone() {
		return companyPhone;
	}
    /**
    *公司电话号
	* @param companyPhone
    */ 
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
    /**
    *ERP类型
	* @return
    */ 
	public Integer getErptype() {
		return erptype;
	}
    /**
    *ERP类型
	* @param erptype
    */ 
	public void setErptype(Integer erptype) {
		this.erptype = erptype;
	}
    /**
    *法人身份证(正面)电子版
	* @return
    */ 
	public String getCorporate_front_card() {
		return corporate_front_card;
	}
    /**
    *法人身份证(正面)电子版
	* @param corporate_front_card
    */ 
	public void setCorporate_front_card(String corporate_front_card) {
		this.corporate_front_card = corporate_front_card;
	}
    /**
    *法人身份证(反面)电子版
	* @return
    */ 
	public String getCorporate_back_card() {
		return corporate_back_card;
	}
    /**
    *法人身份证(反面)电子版
	* @param corporate_back_card
    */ 
	public void setCorporate_back_card(String corporate_back_card) {
		this.corporate_back_card = corporate_back_card;
	}
    /**
    *银行开户许可证
	* @return
    */ 
	public String getBank_image() {
		return bank_image;
	}
    /**
    *银行开户许可证
	* @param bank_image
    */ 
	public void setBank_image(String bank_image) {
		this.bank_image = bank_image;
	}
    /**
    *三证合一
	* @return
    */ 
	public Integer getIsThree() {
		return isThree;
	}
    /**
    *三证合一
	* @param isThree
    */ 
	public void setIsThree(Integer isThree) {
		this.isThree = isThree;
	}
    /**
    *三证合一电子版
	* @return
    */ 
	public String getThreeInOneImage() {
		return threeInOneImage;
	}
    /**
    *三证合一电子版
	* @param threeInOneImage
    */ 
	public void setThreeInOneImage(String threeInOneImage) {
		this.threeInOneImage = threeInOneImage;
	}
    /**
    *组织机构代码证电子版
	* @return
    */ 
	public String getOrganizationImage() {
		return organizationImage;
	}
    /**
    *组织机构代码证电子版
	* @param organizationImage
    */ 
	public void setOrganizationImage(String organizationImage) {
		this.organizationImage = organizationImage;
	}
    /**
    *纳税登记证电子版
	* @return
    */ 
	public String getTaxImage() {
		return taxImage;
	}
    /**
    *纳税登记证电子版
	* @param taxImage
    */ 
	public void setTaxImage(String taxImage) {
		this.taxImage = taxImage;
	}
    /**
    *营业执照副本电子版
	* @return
    */ 
	public String getLicenseImage() {
		return licenseImage;
	}
    /**
    *营业执照副本电子版
	* @param licenseImage
    */ 
	public void setLicenseImage(String licenseImage) {
		this.licenseImage = licenseImage;
	}
    /**
    *银行开户名
	* @return
    */ 
	public String getBankName() {
		return bankName;
	}
    /**
    *银行开户名
	* @param bankName
    */ 
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
    /**
    *公司银行账号
	* @return
    */ 
	public String getBankNum() {
		return bankNum;
	}
    /**
    *公司银行账号
	* @param bankNum
    */ 
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
    /**
    *开户银行支行名称
	* @return
    */ 
	public String getBankBranchName() {
		return bankBranchName;
	}
    /**
    *开户银行支行名称
	* @param bankBranchName
    */ 
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}
    /**
    *开户银行支行所在地
	* @return
    */ 
	public String getLocationBankbranch() {
		return locationBankbranch;
	}
    /**
    *开户银行支行所在地
	* @param locationBankbranch
    */ 
	public void setLocationBankbranch(String locationBankbranch) {
		this.locationBankbranch = locationBankbranch;
	}
    /**
    *纳税人类型
	* @return
    */ 
	public Integer getTaxpayerType() {
		return taxpayerType;
	}
    /**
    *纳税人类型
	* @param taxpayerType
    */ 
	public void setTaxpayerType(Integer taxpayerType) {
		this.taxpayerType = taxpayerType;
	}
    /**
    *纳税类型税码
	* @return
    */ 
	public Integer getTaxpayerCoding() {
		return taxpayerCoding;
	}
    /**
    *纳税类型税码
	* @param taxpayerCoding
    */ 
	public void setTaxpayerCoding(Integer taxpayerCoding) {
		this.taxpayerCoding = taxpayerCoding;
	}
    /**
    *初审状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *初审状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
	
}
