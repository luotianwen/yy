package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单售后图片(o_orderInfo_service_img)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-21 14:37:32 
 */  
public class OrderInfoServiceImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//服务单号
  	 private String ois_id;
 	//图片路径
  	 private String path;



	 
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
    *服务单号
	* @return
    */ 
	public String getOis_id() {
		return ois_id;
	}
    /**
    *服务单号
	* @param ois_id
    */ 
	public void setOis_id(String ois_id) {
		this.ois_id = ois_id;
	}
    /**
    *图片路径
	* @return
    */ 
	public String getPath() {
		return path;
	}
    /**
    *图片路径
	* @param path
    */ 
	public void setPath(String path) {
		this.path = path;
	}
	
}
