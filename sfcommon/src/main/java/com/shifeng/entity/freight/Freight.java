package com.shifeng.entity.freight;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 运费模板管理(o_freight)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:53 
 */  
public class Freight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//模板id
  	 private Integer id;
 	//店铺id
  	 private Integer shopid;
 	//模板名称
  	 private String ffreightName;
 	//是否包邮1是2否
  	 private Integer isFree;
 	//计费规则(1按件数;2按重量)
  	 private Integer ruleType;
 	//默认首重
  	 private Double defaultFirstUnit;
 	//首重金额
  	 private Double defaultFirstMoney;
 	//每增加重量
  	 private Double defaultLastUnit;
 	//每增加重量金额
  	 private Double defaultLastMoney;
 	//创建时间
  	 private Date createTime;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
     private List<FreightDetail> details;

	public List<FreightDetail> getDetails() {
		return details;
	}

	public void setDetails(List<FreightDetail> details) {
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	/**
    *模板名称
	* @return
    */ 
	public String getFfreightName() {
		return ffreightName;
	}
    /**
    *模板名称
	* @param ffreightName
    */ 
	public void setFfreightName(String ffreightName) {
		this.ffreightName = ffreightName;
	}
    /**
    *是否包邮1是2否
	* @return
    */ 
	public Integer getIsFree() {
		return isFree;
	}
    /**
    *是否包邮1是2否
	* @param isFree
    */ 
	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}
    /**
    *计费规则(1按件数;2按重量)
	* @return
    */ 
	public Integer getRuleType() {
		return ruleType;
	}
    /**
    *计费规则(1按件数;2按重量)
	* @param ruleType
    */ 
	public void setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
	}
    /**
    *默认首重
	* @return
    */ 
	public Double getDefaultFirstUnit() {
		return defaultFirstUnit;
	}
    /**
    *默认首重
	* @param defaultFirstUnit
    */ 
	public void setDefaultFirstUnit(Double defaultFirstUnit) {
		this.defaultFirstUnit = defaultFirstUnit;
	}
    /**
    *首重金额
	* @return
    */ 
	public Double getDefaultFirstMoney() {
		return defaultFirstMoney;
	}
    /**
    *首重金额
	* @param defaultFirstMoney
    */ 
	public void setDefaultFirstMoney(Double defaultFirstMoney) {
		this.defaultFirstMoney = defaultFirstMoney;
	}
    /**
    *每增加重量
	* @return
    */ 
	public Double getDefaultLastUnit() {
		return defaultLastUnit;
	}
    /**
    *每增加重量
	* @param defaultLastUnit
    */ 
	public void setDefaultLastUnit(Double defaultLastUnit) {
		this.defaultLastUnit = defaultLastUnit;
	}
    /**
    *每增加重量金额
	* @return
    */ 
	public Double getDefaultLastMoney() {
		return defaultLastMoney;
	}
    /**
    *每增加重量金额
	* @param defaultLastMoney
    */ 
	public void setDefaultLastMoney(Double defaultLastMoney) {
		this.defaultLastMoney = defaultLastMoney;
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
