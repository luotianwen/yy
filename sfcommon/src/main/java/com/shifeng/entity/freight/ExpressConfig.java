package com.shifeng.entity.freight;

import java.io.Serializable;
import java.util.Date;
/** 
 * 快递配置(o_expressConfig)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:53 
 */  
public class ExpressConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//编号
  	 private int id;
 	//名称
  	 private String name;
  	//code
  	 private String code;
  	//客服电话
  	 private String phone;
 	//状态（1正常2冻结）
  	 private int state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;



	 
    /**
    *编号
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *编号
	* @param id
    */ 
	public void setId(int id) {
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
	 * code
	 * @return
	 */
    public String getCode() {
		return code;
	}
    /**
     * code
     * @param code
     */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 客服电话
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 客服电话
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
    *状态（1正常2冻结）
	* @return
    */ 
	public int getState() {
		return state;
	}
    /**
    *状态（1正常2冻结）
	* @param state
    */ 
	public void setState(int state) {
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
	
}
