package com.shifeng.op.dto.category;

import java.io.Serializable;
import java.util.Date;
/** 
 * 分类费用(c_category_fee)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 17:44:46 
 */  
public class CategoryFeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//分类id
  	 private int id;
 	//代销店铺扣点
  	 private double consignmentpoints;
 	//类目保证金标准（元）
  	 private double deposit;
 	//平台使用费
  	 private double platformfee;
 	//扣点
  	 private double points;
  	 //分类名称
  	 private String name;
  	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;

	 
    /**
    *分类id
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *分类id
	* @param c_category_id
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *代销店铺扣点
	* @return
    */ 
	public double getConsignmentpoints() {
		return consignmentpoints;
	}
    /**
    *代销店铺扣点
	* @param consignmentpoints
    */ 
	public void setConsignmentpoints(double consignmentpoints) {
		this.consignmentpoints = consignmentpoints;
	}
    /**
    *类目保证金标准（元）
	* @return
    */ 
	public double getDeposit() {
		return deposit;
	}
    /**
    *类目保证金标准（元）
	* @param deposit
    */ 
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
    /**
    *平台使用费
	* @return
    */ 
	public double getPlatformfee() {
		return platformfee;
	}
    /**
    *平台使用费
	* @param platformfee
    */ 
	public void setPlatformfee(double platformfee) {
		this.platformfee = platformfee;
	}
    /**
    *扣点
	* @return
    */ 
	public double getPoints() {
		return points;
	}
    /**
    *扣点
	* @param points
    */ 
	public void setPoints(double points) {
		this.points = points;
	}
	/**
	 * 分类名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 分类名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
    *最后修改时间
	* return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
	/**
	    *最后修改时间
		* @param type
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
	* @param type
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
}
