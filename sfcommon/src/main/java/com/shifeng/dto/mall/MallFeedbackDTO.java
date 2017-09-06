package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.Date;

/**
 * 意见反馈DTO
 * 
 * @author Win Zhong
 * @version Revision: 1.00 Date: 2017-03-30 09:52:01
 */
public class MallFeedbackDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ID
	private Integer feedback_id;
	// 反馈问题类型
	private Integer feedback_type;
	// 内容
	private String feedback_content;
	// 反馈用户ID
	private String user_id;
	// 反馈时间
	private Date feedback_time;
	// 反馈来源
	private Integer source;
	// 图片地址
	private String[] img_url;

	/**
	 * ID
	 * 
	 * @return
	 */
	public Integer getFeedback_id() {
		return feedback_id;
	}

	/**
	 * ID
	 * 
	 * @param feedback_id
	 */
	public void setFeedback_id(Integer feedback_id) {
		this.feedback_id = feedback_id;
	}

	/**
	 * 反馈问题类型
	 * 
	 * @return
	 */
	public Integer getFeedback_type() {
		return feedback_type;
	}

	/**
	 * 反馈问题类型
	 * 
	 * @param feedback_type
	 */
	public void setFeedback_type(Integer feedback_type) {
		this.feedback_type = feedback_type;
	}

	/**
	 * 内容
	 * 
	 * @return
	 */
	public String getFeedback_content() {
		return feedback_content;
	}

	/**
	 * 内容
	 * 
	 * @param feedback_content
	 */
	public void setFeedback_content(String feedback_content) {
		this.feedback_content = feedback_content;
	}

	/**
	 * 反馈用户ID
	 * 
	 * @return
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * 反馈用户ID
	 * 
	 * @param user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * 反馈时间
	 * 
	 * @return
	 */
	public Date getFeedback_time() {
		return feedback_time;
	}

	/**
	 * 反馈时间
	 * 
	 * @param feedback_time
	 */
	public void setFeedback_time(Date feedback_time) {
		this.feedback_time = feedback_time;
	}

	/**
	 * 反馈来源
	 * 
	 * @return
	 */
	public Integer getSource() {
		return source;
	}

	/**
	 * 反馈来源
	 * 
	 * @param source
	 */
	public void setSource(Integer source) {
		this.source = source;
	}

	/**
	 * 图片地址
	 * 
	 * @return
	 */
	public String[] getImg_url() {
		return img_url;
	}

	/**
	 * 图片地址
	 * 
	 * @param img_url
	 */
	public void setImg_url(String[] img_url) {
		this.img_url = img_url;
	}

}
