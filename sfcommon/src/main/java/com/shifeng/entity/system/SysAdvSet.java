package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * 系统广告费用设置(sys_adv_set)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-01 09:57:51 
 */  
public class SysAdvSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//行
  	 private Integer row;
 	//列
  	 private Integer column;
 	//周
  	 private Integer period;
 	//费用
  	 private Double cost;
 	//创建时间
  	 private Date cdate;
 	//最后修改人
  	 private String updatename;
 	//最后修改时间
  	 private Date lasttime;



	 
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
    *行
	* @return
    */ 
	public Integer getRow() {
		return row;
	}
    /**
    *行
	* @param row
    */ 
	public void setRow(Integer row) {
		this.row = row;
	}
    /**
    *列
	* @return
    */ 
	public Integer getColumn() {
		return column;
	}
    /**
    *列
	* @param column
    */ 
	public void setColumn(Integer column) {
		this.column = column;
	}
    /**
    *周
	* @return
    */ 
	public Integer getPeriod() {
		return period;
	}
    /**
    *周
	* @param period
    */ 
	public void setPeriod(Integer period) {
		this.period = period;
	}
    /**
    *费用
	* @return
    */ 
	public Double getCost() {
		return cost;
	}
    /**
    *费用
	* @param cost
    */ 
	public void setCost(Double cost) {
		this.cost = cost;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getCdate() {
		return cdate;
	}
    /**
    *创建时间
	* @param cdate
    */ 
	public void setCdate(Date cdate) {
		this.cdate = cdate;
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
	
}
