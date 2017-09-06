package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺售后政策(s_after_sales_policy)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:27:07 
 */  
public class AfterSalesPolicy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//编号
  	 private Integer id;
 	//售后标题
  	 private String title;
 	//描述
  	 private String descript;
 	//店铺id
  	 private Integer shopid;
 	//状态
  	 private Integer state;
 	//备注
  	 private String remark;



	 
    /**
    *编号
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *编号
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *售后标题
	* @return
    */ 
	public String getTitle() {
		return title;
	}
    /**
    *售后标题
	* @param title
    */ 
	public void setTitle(String title) {
		this.title = title;
	}
    /**
    *描述
	* @return
    */ 
	public String getDescript() {
		return descript;
	}
    /**
    *描述
	* @param descript
    */ 
	public void setDescript(String descript) {
		this.descript = descript;
	}
    /**
    *店铺id
	* @return
    */ 
	public Integer getShopid() {
		return shopid;
	}
    /**
    *店铺id
	* @param shopid
    */ 
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
    /**
    *状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
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
