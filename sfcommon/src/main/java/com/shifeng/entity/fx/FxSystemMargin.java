package com.shifeng.entity.fx;

import java.io.Serializable;
import java.util.Date;
/** 
 * 系统分销利率设置(fx_system_margin)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-27 11:06:20 
 */  
public class FxSystemMargin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//开始毛利率
  	 private Double smarginrate;
 	//结束毛利率
  	 private Double emarginrate;
 	//佣金比率
  	 private Double commissionrate;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updateName;



	 
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
    *开始毛利率
	* @return
    */ 
	public Double getSmarginrate() {
		return smarginrate;
	}
    /**
    *开始毛利率
	* @param smarginrate
    */ 
	public void setSmarginrate(Double smarginrate) {
		this.smarginrate = smarginrate;
	}
    /**
    *结束毛利率
	* @return
    */ 
	public Double getEmarginrate() {
		return emarginrate;
	}
    /**
    *结束毛利率
	* @param emarginrate
    */ 
	public void setEmarginrate(Double emarginrate) {
		this.emarginrate = emarginrate;
	}
    /**
    *佣金比率
	* @return
    */ 
	public Double getCommissionrate() {
		return commissionrate;
	}
    /**
    *佣金比率
	* @param commissionrate
    */ 
	public void setCommissionrate(Double commissionrate) {
		this.commissionrate = commissionrate;
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
	
}
