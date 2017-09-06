package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺审核日志(s_shopinfo_log)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
public class ShopinfoLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//入驻id
  	 private Integer s_merchants_id;
 	//审核阶段
  	 private Integer type;
 	//审核状态
  	 private Integer state;
 	//说明
  	 private String note;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;



	 
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
    *审核阶段
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *审核阶段
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *审核状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *审核状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *说明
	* @return
    */ 
	public String getNote() {
		return note;
	}
    /**
    *说明
	* @param note
    */ 
	public void setNote(String note) {
		this.note = note;
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
	
}
