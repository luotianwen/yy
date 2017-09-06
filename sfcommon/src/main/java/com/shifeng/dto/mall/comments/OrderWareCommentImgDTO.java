package com.shifeng.dto.mall.comments;

import java.io.Serializable;

/**
 * 订单商品评论图片DTO
 * @author Win
 *
 */
public class OrderWareCommentImgDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

 	//图片地址
  	 private String imgpath;


	@Override
	public String toString() {
		return "OrderWareCommentImgDTO [imgpath=" + imgpath + "]";
	}


	public String getImgpath() {
		return imgpath;
	}


	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
  	 
  	 

}
