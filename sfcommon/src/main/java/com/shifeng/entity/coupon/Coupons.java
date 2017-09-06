package com.shifeng.entity.coupon;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/** 
 * 优惠券(c_coupons)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-01 14:57:04 
 */  
public class Coupons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String id;
 	//名称
  	 private String name;
 	//类型
  	 private Integer type;
 	//适用范围
  	 private Integer scope;
 	//使用分类
  	 private Integer category;
 	//店铺
  	 private Integer sellerId;
 	//发券数量
  	 private Integer number;
 	//剩余数量
  	 private Integer surplusNumber;
 	//已领取数量
  	 private Integer receiveCount;
 	//已使用数量
  	 private Integer useCount;
 	//优惠券面值(满)
  	 private double full;
 	//优惠券面值(减)
  	 private double minus;
 	//优惠券有效期
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date startDate;
 	//优惠券有效期结束
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date endDate;
 	//优惠券说明
  	 private String note;
 	//领取地址
  	 private String url;
 	//是否套餐
  	 private Integer isPackage;
 	//状态(1：正常；2：过期；3：待发放； 4：暂停发放；5：领取完毕；6：过期)
  	 private Integer state;
 	//创建人
  	 private Integer user_id;
 	//创建时间
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date createTime;
 	//最后修改时间
  	@DateTimeFormat(pattern="yyyy-MM-dd") 
  	 private Date lastTime;
 	//最后修改人
  	 private String updateName;
 	//备注
  	 private String remark;



	 
    /**
    *id
	* @return
    */ 
	public String getId() {
		return id;
	}
    /**
    *id
	* @param id
    */ 
	public void setId(String id) {
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
    *类型
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *类型
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *适用范围
	* @return
    */ 
	public Integer getScope() {
		return scope;
	}
    /**
    *适用范围
	* @param scope
    */ 
	public void setScope(Integer scope) {
		this.scope = scope;
	}
    /**
    *使用分类
	* @return
    */ 
	public Integer getCategory() {
		return category;
	}
    /**
    *使用分类
	* @param category
    */ 
	public void setCategory(Integer category) {
		this.category = category;
	}
    /**
    *店铺
	* @return
    */ 
	public Integer getSellerId() {
		return sellerId;
	}
    /**
    *店铺
	* @param sellerId
    */ 
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
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
    *剩余数量
	* @return
    */ 
	public Integer getSurplusNumber() {
		return surplusNumber;
	}
    /**
    *剩余数量
	* @param surplusNumber
    */ 
	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}
    /**
    *已领取数量
	* @return
    */ 
	public Integer getReceiveCount() {
		return receiveCount;
	}
    /**
    *已领取数量
	* @param receiveCount
    */ 
	public void setReceiveCount(Integer receiveCount) {
		this.receiveCount = receiveCount;
	}
    /**
    *已使用数量
	* @return
    */ 
	public Integer getUseCount() {
		return useCount;
	}
    /**
    *已使用数量
	* @param useCount
    */ 
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}
    /**
    *优惠券面值(满)
	* @return
    */ 
	public double getFull() {
		return full;
	}
    /**
    *优惠券面值(满)
	* @param full
    */ 
	public void setFull(double full) {
		this.full = full;
	}
    /**
    *优惠券面值(减)
	* @return
    */ 
	public double getMinus() {
		return minus;
	}
    /**
    *优惠券面值(减)
	* @param minus
    */ 
	public void setMinus(double minus) {
		this.minus = minus;
	}
    /**
    *优惠券有效期
	* @return
    */ 
	public Date getStartDate() {
		return startDate;
	}
    /**
    *优惠券有效期
	* @param startDate
    */ 
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    /**
    *优惠券有效期结束
	* @return
    */ 
	public Date getEndDate() {
		return endDate;
	}
    /**
    *优惠券有效期结束
	* @param endDate
    */ 
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
    *是否套餐
	* @return
    */ 
	public Integer getIsPackage() {
		return isPackage;
	}
    /**
    *是否套餐
	* @param isPackage
    */ 
	public void setIsPackage(Integer isPackage) {
		this.isPackage = isPackage;
	}
    /**
    *状态(1：正常；2：过期；3：待发放； 4：暂停发放；5：领取完毕；6：过期)
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态(1：正常；2：过期；3：待发放； 4：暂停发放；5：领取完毕；6：过期)
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *创建人
	* @return
    */ 
	public Integer getUser_id() {
		return user_id;
	}
    /**
    *创建人
	* @param user_id
    */ 
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getCreateTime() {
		return createTime;
	}
    /**
    *创建时间
	* @param createTime
    */ 
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public Date getLastTime() {
		return lastTime;
	}
    /**
    *最后修改时间
	* @param lastTime
    */ 
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
    /**
    *最后修改人
	* @return
    */ 
	public String getUpdateName() {
		return updateName;
	}
    /**
    *最后修改人
	* @param updateName
    */ 
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
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
	
}
