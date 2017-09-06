package com.shifeng.dto.mall.property;

import java.io.Serializable;

public class PropertyValueDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//属性值ID
	private String id;
	
	//属性值内容
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PropertyValueDTO [id=" + id + ", content=" + content + "]";
	}
	
	
	

}
