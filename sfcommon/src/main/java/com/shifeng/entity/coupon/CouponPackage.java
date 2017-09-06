package com.shifeng.entity.coupon;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
/** 
 * 优惠券套餐(c_couponPackage)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-01 14:57:04 
 */  
public class CouponPackage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//名称
  	 private String name;
 	//发券数量
  	 private Integer number;
 	//发行金额
  	 private Integer money;
 	//优惠券有效期
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date startdate;
 	//优惠券有效期结束
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date enddate;
 	//优惠券说明
  	 private String note;
 	//优惠券id(多选)
  	 private String c_coupons;
 	//状态(1正常2过期)
  	 private Integer state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;
 	//领取地址
  	 private String url;
  	 
  	 //优惠券集合
  	 private List<Coupons> coupons;


	 
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
    *名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *发券数量
	* @return
    */ 
	public Integer getNumber() {
		return number;
	}
    /**
    *发券数量
	* @param number
    */ 
	public void setNumber(Integer number) {
		this.number = number;
	}
    /**
    *发行金额
	* @return
    */ 
	public Integer getMoney() {
		return money;
	}
    /**
    *发行金额
	* @param money
    */ 
	public void setMoney(Integer money) {
		this.money = money;
	}
    /**
    *优惠券有效期
	* @return
    */ 
	public Date getStartdate() {
		return startdate;
	}
    /**
    *优惠券有效期
	* @param startdate
    */ 
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
    /**
    *优惠券有效期结束
	* @return
    */ 
	public Date getEnddate() {
		return enddate;
	}
    /**
    *优惠券有效期结束
	* @param enddate
    */ 
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
    /**
    *优惠券说明
	* @return
    */ 
	public String getNote() {
		return note;
	}
    /**
    *优惠券说明
	* @param note
    */ 
	public void setNote(String note) {
		this.note = note;
	}
    /**
    *优惠券id(多选)
	* @return
    */ 
	public String getC_coupons() {
		return c_coupons;
	}
    /**
    *优惠券id(多选)
	* @param c_coupons
    */ 
	public void setC_coupons(String c_coupons) {
		this.c_coupons = c_coupons;
	}
    /**
    *状态(1正常2过期)
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态(1正常2过期)
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
    *领取地址
	* @return
    */ 
	public String getUrl() {
		return url;
	}
    /**
    *领取地址
	* @param url
    */ 
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 优惠券集合
	 * @return
	 */
	public List<Coupons> getCoupons() {
		return coupons;
	}
	/**
	 * 优惠券集合
	 * @param coupons
	 */
	public void setCoupons(List<Coupons> coupons) {
		this.coupons = coupons;
	}
	
}
