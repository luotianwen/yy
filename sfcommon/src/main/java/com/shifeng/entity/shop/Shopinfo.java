package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/** 
 * 店铺表(s_shopinfo)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
public class Shopinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//入驻id
  	 private Integer s_merchants_id;
 	//用户id
  	 private Integer uid;
 	//登录帐号
  	 private String account;
 	//登录密码
  	 private String password;
 	//店铺类型
  	 private Integer grade;
 	//店铺名称
  	 private String name;
 	//客服电话
  	 private String fax;
 	//邮箱
  	 private String email;
 	//邮编
  	 private String postcode;
 	//在线客服
  	 private String qq;
 	//注册日期
  	@DateTimeFormat(pattern="yyyy-MM-dd")
  	 private Date rtime;
 	//状态
  	 private Integer sstate;
 	//推荐状态
  	 private Integer rstate;
 	//结束时间
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date endtime;
 	//销售状态
  	 private Integer state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;
 	//复审状态
  	 private Integer fstate;
  	 //店铺logo
  	 private String logo;
  	 

	 
    /**
    *入驻id
	* @return
    */ 
	public Integer getS_merchants_id() {
		return s_merchants_id;
	}
    /**
    *入驻id
	* @param s_merchants_id
    */ 
	public void setS_merchants_id(Integer s_merchants_id) {
		this.s_merchants_id = s_merchants_id;
	}
    /**
    *用户id
	* @return
    */ 
	public Integer getUid() {
		return uid;
	}
    /**
    *用户id
	* @param uid
    */ 
	public void setUid(Integer uid) {
		this.uid = uid;
	}
    /**
    *登录帐号
	* @return
    */ 
	public String getAccount() {
		return account;
	}
    /**
    *登录帐号
	* @param account
    */ 
	public void setAccount(String account) {
		this.account = account;
	}
    /**
    *登录密码
	* @return
    */ 
	public String getPassword() {
		return password;
	}
    /**
    *登录密码
	* @param password
    */ 
	public void setPassword(String password) {
		this.password = password;
	}
    /**
    *店铺类型
	* @return
    */ 
	public Integer getGrade() {
		return grade;
	}
    /**
    *店铺类型
	* @param grade
    */ 
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
    /**
    *店铺名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *店铺名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *客服电话
	* @return
    */ 
	public String getFax() {
		return fax;
	}
    /**
    *客服电话
	* @param fax
    */ 
	public void setFax(String fax) {
		this.fax = fax;
	}
    /**
    *邮箱
	* @return
    */ 
	public String getEmail() {
		return email;
	}
    /**
    *邮箱
	* @param email
    */ 
	public void setEmail(String email) {
		this.email = email;
	}
    /**
    *邮编
	* @return
    */ 
	public String getPostcode() {
		return postcode;
	}
    /**
    *邮编
	* @param postcode
    */ 
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
    /**
    *在线客服
	* @return
    */ 
	public String getQq() {
		return qq;
	}
    /**
    *在线客服
	* @param qq
    */ 
	public void setQq(String qq) {
		this.qq = qq;
	}
    /**
    *注册日期
	* @return
    */ 
	public Date getRtime() {
		return rtime;
	}
    /**
    *注册日期
	* @param rtime
    */ 
	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
    /**
    *状态
	* @return
    */ 
	public Integer getSstate() {
		return sstate;
	}
    /**
    *状态
	* @param sstate
    */ 
	public void setSstate(Integer sstate) {
		this.sstate = sstate;
	}
    /**
    *推荐状态
	* @return
    */ 
	public Integer getRstate() {
		return rstate;
	}
    /**
    *推荐状态
	* @param rstate
    */ 
	public void setRstate(Integer rstate) {
		this.rstate = rstate;
	}
    /**
    *结束时间
	* @return
    */ 
	public Date getEndtime() {
		return endtime;
	}
    /**
    *结束时间
	* @param endtime
    */ 
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
    /**
    *销售状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *销售状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
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
    *复审状态
	* @return
    */ 
	public Integer getFstate() {
		return fstate;
	}
    /**
    *复审状态
	* @param fstate
    */ 
	public void setFstate(Integer fstate) {
		this.fstate = fstate;
	}
	/**
	 * 店铺logo
	 * @return
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 店铺logo
	 * @param logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
