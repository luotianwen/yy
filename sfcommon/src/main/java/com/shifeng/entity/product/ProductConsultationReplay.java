package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * 商品咨询回复(p_product_consultation_replay)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 20:31:56 
 */  
public class ProductConsultationReplay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//商品评价
  	 private Integer ppcid;
 	//回复时间
  	 private Date rdate;
 	//回复人id
  	 private String ruserId;
 	//回复人名称
  	 private String rName;
 	//回复内容
  	 private String rcontent;



	 
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
    *商品评价
	* @return
    */ 
	public Integer getPpcid() {
		return ppcid;
	}
    /**
    *商品评价
	* @param ppcid
    */ 
	public void setPpcid(Integer ppcid) {
		this.ppcid = ppcid;
	}
    /**
    *回复时间
	* @return
    */ 
	public Date getRdate() {
		return rdate;
	}
    /**
    *回复时间
	* @param rdate
    */ 
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
    /**
    *回复人id
	* @return
    */ 
	public String getRuserId() {
		return ruserId;
	}
    /**
    *回复人id
	* @param ruserId
    */ 
	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}
    /**
    *回复人名称
	* @return
    */ 
	public String getrName() {
		return rName;
	}
    /**
    *回复人名称
	* @param rName
    */ 
	public void setrName(String rName) {
		this.rName = rName;
	}
    /**
    *回复内容
	* @return
    */ 
	public String getRcontent() {
		return rcontent;
	}
    /**
    *回复内容
	* @param rcontent
    */ 
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	
}
