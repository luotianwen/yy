package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 意见反馈图片(mall_feedback_img)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:52:01 
 */  
public class MallFeedbackImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//图片ID
  	 private Integer img_id;
 	//反馈ID
  	 private Integer feedback_id;
 	//图片地址
  	 private String img_url;



	 
    /**
    *图片ID
	* @return
    */ 
	public Integer getImg_id() {
		return img_id;
	}
    /**
    *图片ID
	* @param img_id
    */ 
	public void setImg_id(Integer img_id) {
		this.img_id = img_id;
	}
    /**
    *反馈ID
	* @return
    */ 
	public Integer getFeedback_id() {
		return feedback_id;
	}
    /**
    *反馈ID
	* @param feedback_id
    */ 
	public void setFeedback_id(Integer feedback_id) {
		this.feedback_id = feedback_id;
	}
    /**
    *图片地址
	* @return
    */ 
	public String getImg_url() {
		return img_url;
	}
    /**
    *图片地址
	* @param img_url
    */ 
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
}
