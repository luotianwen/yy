package com.shifeng.entity.mall;

import java.io.Serializable;
import java.util.Date;
/** 
 * 意见反馈(mall_feedback)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:52:01 
 */  
public class MallFeedback implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//ID
  	 private Integer feedback_id;
 	//反馈问题类型
  	 private Integer feedback_type;
 	//内容
  	 private String feedback_content;
 	//反馈用户ID
  	 private String user_id;
 	//反馈时间
  	 private Date feedback_time;
 	//反馈来源
  	 private Integer source;
 	//处理人
  	 private String operator_name;
 	//处理时间
  	 private Date operate_time;
 	//处理意见
  	 private String opinion;
 	//处理状态
  	 private Integer operate_type;



	 
    /**
    *ID
	* @return
    */ 
	public Integer getFeedback_id() {
		return feedback_id;
	}
    /**
    *ID
	* @param feedback_id
    */ 
	public void setFeedback_id(Integer feedback_id) {
		this.feedback_id = feedback_id;
	}
    /**
    *反馈问题类型
	* @return
    */ 
	public Integer getFeedback_type() {
		return feedback_type;
	}
    /**
    *反馈问题类型
	* @param feedback_type
    */ 
	public void setFeedback_type(Integer feedback_type) {
		this.feedback_type = feedback_type;
	}
    /**
    *内容
	* @return
    */ 
	public String getFeedback_content() {
		return feedback_content;
	}
    /**
    *内容
	* @param feedback_content
    */ 
	public void setFeedback_content(String feedback_content) {
		this.feedback_content = feedback_content;
	}
    /**
    *反馈用户ID
	* @return
    */ 
	public String getUser_id() {
		return user_id;
	}
    /**
    *反馈用户ID
	* @param user_id
    */ 
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
    /**
    *反馈时间
	* @return
    */ 
	public Date getFeedback_time() {
		return feedback_time;
	}
    /**
    *反馈时间
	* @param feedback_time
    */ 
	public void setFeedback_time(Date feedback_time) {
		this.feedback_time = feedback_time;
	}
    /**
    *反馈来源
	* @return
    */ 
	public Integer getSource() {
		return source;
	}
    /**
    *反馈来源
	* @param source
    */ 
	public void setSource(Integer source) {
		this.source = source;
	}
    /**
    *处理人
	* @return
    */ 
	public String getOperator_name() {
		return operator_name;
	}
    /**
    *处理人
	* @param operator_name
    */ 
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
    /**
    *处理时间
	* @return
    */ 
	public Date getOperate_time() {
		return operate_time;
	}
    /**
    *处理时间
	* @param operate_time
    */ 
	public void setOperate_time(Date operate_time) {
		this.operate_time = operate_time;
	}
    /**
    *处理意见
	* @return
    */ 
	public String getOpinion() {
		return opinion;
	}
    /**
    *处理意见
	* @param opinion
    */ 
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
    /**
    *处理状态
	* @return
    */ 
	public Integer getOperate_type() {
		return operate_type;
	}
    /**
    *处理状态
	* @param operate_type
    */ 
	public void setOperate_type(Integer operate_type) {
		this.operate_type = operate_type;
	}
	
}
