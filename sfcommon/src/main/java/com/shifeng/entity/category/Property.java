package com.shifeng.entity.category;

import java.io.Serializable;
import java.util.Date;
/** 
 * 属性表(p_property)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-11 15:42:20 
 */  
public class Property implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//属性编号
  	 private int id;
 	//属性名称
  	 private String name;
 	//排序
  	 private int sort;
 	//是否多选
  	 private int ismultiple;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
  	 //备注
  	 private String remark;
  	 //属性类型(1:关键属性;2:不变属性;3:可变属性;4:销售属性)
  	 private String state;
  	 
	 
    /**
    *属性编号
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *属性编号
	* @param type
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *属性名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *属性名称
	* @param type
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *排序
	* @return
    */ 
	public int getSort() {
		return sort;
	}
    /**
    *排序
	* @param type
    */ 
	public void setSort(int sort) {
		this.sort = sort;
	}
    /**
    *是否多选
	* @return
    */ 
	public int getIsmultiple() {
		return ismultiple;
	}
    /**
    *是否多选
	* @param type
    */ 
	public void setIsmultiple(int ismultiple) {
		this.ismultiple = ismultiple;
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
	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
