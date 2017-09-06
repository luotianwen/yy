package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 特卖(mall_special_sale)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:47 
 */  
public class MallSpecialSale implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//开始时间
  	 private String starttime;
 	//结束时间
  	 private String endtime;
 	//名称
  	 private String name;
 	//说明
  	 private String note;
 	//状态
  	 private Integer state;
 	//创建人
  	 private String user_id;
 	//创建时间
  	 private Date createTime;
 	//最后修改时间
  	 private String lastTime;
 	//最后修改人
  	 private String updateName;
 	//备注
  	 private String remark;



	 
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
    *开始时间
	* @return
    */ 
	public String getStarttime() {
		return starttime;
	}
    /**
    *开始时间
	* @param starttime
    */ 
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
    /**
    *结束时间
	* @return
    */ 
	public String getEndtime() {
		return endtime;
	}
    /**
    *结束时间
	* @param endtime
    */ 
	public void setEndtime(String endtime) {
		this.endtime = endtime;
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
    *创建人
	* @return
    */ 
	public String getUser_id() {
		return user_id;
	}
    /**
    *创建人
	* @param user_id
    */ 
	public void setUser_id(String user_id) {
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
	public String getLastTime() {
		return lastTime;
	}
    /**
    *最后修改时间
	* @param lastTime
    */ 
	public void setLastTime(String lastTime) {
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
