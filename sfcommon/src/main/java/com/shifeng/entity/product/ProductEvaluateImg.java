package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * 商品评价图片(p_product_evaluate_img)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 20:31:56 
 */  
public class ProductEvaluateImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//评价id
  	 private Integer ppeid;
 	//图片地址
  	 private String imgpath;
 	//创建时间
  	 private Date cdate;



	 
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
    *评价id
	* @return
    */ 
	public Integer getPpeid() {
		return ppeid;
	}
    /**
    *评价id
	* @param ppeid
    */ 
	public void setPpeid(Integer ppeid) {
		this.ppeid = ppeid;
	}
    /**
    *图片地址
	* @return
    */ 
	public String getImgpath() {
		return imgpath;
	}
    /**
    *图片地址
	* @param imgpath
    */ 
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
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
	
}
