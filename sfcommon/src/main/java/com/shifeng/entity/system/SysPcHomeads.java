package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * pc首页广告(sys_pc_homeads)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */  
public class SysPcHomeads implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//广告id
  	 private Integer id;
 	//类型
  	 private Integer module;
 	//第1张图片地址
  	 private String fimg1;
 	//第1张链接
  	 private String flink1;
 	//第1张广告价格
  	 private Double fprice1;
 	//第2张图片地址
  	 private String fimg2;
 	//第2张链接
  	 private String flink2;
 	//第2张广告价格
  	 private Double fprice2;
 	//第3张图片地址
  	 private String fimg3;
 	//第3张链接
  	 private String flink3;
 	//第3张广告价格
  	 private Double fprice3;
 	//状态
  	 private Integer state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;
  	//备注
  	 private String remark2;


	 
    /**
    *广告id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *广告id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *类型
	* @return
    */ 
	public Integer getModule() {
		return module;
	}
    /**
    *类型
	* @param module
    */ 
	public void setModule(Integer module) {
		this.module = module;
	}
    /**
    *第1张图片地址
	* @return
    */ 
	public String getFimg1() {
		return fimg1;
	}
    /**
    *第1张图片地址
	* @param fimg1
    */ 
	public void setFimg1(String fimg1) {
		this.fimg1 = fimg1;
	}
    /**
    *第1张链接
	* @return
    */ 
	public String getFlink1() {
		return flink1;
	}
    /**
    *第1张链接
	* @param flink1
    */ 
	public void setFlink1(String flink1) {
		this.flink1 = flink1;
	}
    /**
    *第1张广告价格
	* @return
    */ 
	public Double getFprice1() {
		return fprice1;
	}
    /**
    *第1张广告价格
	* @param fprice1
    */ 
	public void setFprice1(Double fprice1) {
		this.fprice1 = fprice1;
	}
    /**
    *第2张图片地址
	* @return
    */ 
	public String getFimg2() {
		return fimg2;
	}
    /**
    *第2张图片地址
	* @param fimg2
    */ 
	public void setFimg2(String fimg2) {
		this.fimg2 = fimg2;
	}
    /**
    *第2张链接
	* @return
    */ 
	public String getFlink2() {
		return flink2;
	}
    /**
    *第2张链接
	* @param flink2
    */ 
	public void setFlink2(String flink2) {
		this.flink2 = flink2;
	}
    /**
    *第2张广告价格
	* @return
    */ 
	public Double getFprice2() {
		return fprice2;
	}
    /**
    *第2张广告价格
	* @param fprice2
    */ 
	public void setFprice2(Double fprice2) {
		this.fprice2 = fprice2;
	}
    /**
    *第3张图片地址
	* @return
    */ 
	public String getFimg3() {
		return fimg3;
	}
    /**
    *第3张图片地址
	* @param fimg3
    */ 
	public void setFimg3(String fimg3) {
		this.fimg3 = fimg3;
	}
    /**
    *第3张链接
	* @return
    */ 
	public String getFlink3() {
		return flink3;
	}
    /**
    *第3张链接
	* @param flink3
    */ 
	public void setFlink3(String flink3) {
		this.flink3 = flink3;
	}
    /**
    *第3张广告价格
	* @return
    */ 
	public Double getFprice3() {
		return fprice3;
	}
    /**
    *第3张广告价格
	* @param fprice3
    */ 
	public void setFprice3(Double fprice3) {
		this.fprice3 = fprice3;
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
	/**
    *备注
	* @return
    */ 
	public String getRemark2() {
		return remark2;
	}
    /**
    *备注
	* @param remark
    */ 
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	
}
