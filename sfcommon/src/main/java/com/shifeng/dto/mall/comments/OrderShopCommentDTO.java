package com.shifeng.dto.mall.comments;

import java.io.Serializable;
import java.util.List;

/**
 * 订单店铺评论DTO
 * @author Win
 *
 */
public class OrderShopCommentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

 	//用户编号
  	 private String userId;
 	//买家姓名
  	 private String receiveName;
 	//订单id
  	 private String orderid;
 	//店铺编号
  	 private Integer shopid;
  	//描述相符评分 (默认5分)
  	 private Integer describe_score = 5;
 	//物流服务 (默认5分)
  	 private Integer lservice = 5;
 	//店铺服务 (默认5分)
  	 private Integer sservice = 5;
 	//匿名（1：是；2：否  默认1是）
  	 private Integer anonymous = 1;
	//店铺商品评论
	private List<OrderWareCommentDTO> wareComments;

	   /**
	    *用户编号
		* @return
	    */ 
		public String getUserId() {
			return userId;
		}
	    /**
	    *用户编号
		* @param userId
	    */ 
		public void setUserId(String userId) {
			this.userId = userId;
		}
	    /**
	    *买家姓名
		* @return
	    */ 
		public String getReceiveName() {
			return receiveName;
		}
	    /**
	    *买家姓名
		* @param receiveName
	    */ 
		public void setReceiveName(String receiveName) {
			this.receiveName = receiveName;
		}
	    /**
	    *订单id
		* @return
	    */ 
		public String getOrderid() {
			return orderid;
		}
	    /**
	    *订单id
		* @param orderid
	    */ 
		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}
	    /**
	    *店铺编号
		* @return
	    */ 
		public Integer getShopid() {
			return shopid;
		}
	    /**
	    *店铺编号
		* @param shopid
	    */ 
		public void setShopid(Integer shopid) {
			this.shopid = shopid;
		}
		/**
		 * 描述相符评分
		 * @return
		 */
	    public Integer getDescribe_score() {
	    	if(describe_score > 0 && describe_score <= 5){
	    		return describe_score;
	    	}
			return 5;
		}
	    /**
	     * 描述相符评分
	     * @param describe_score
	     */
		public void setDescribe_score(Integer describe_score) {
			this.describe_score = describe_score;
		}
		/**
	    *物流服务
		* @return
	    */ 
		public Integer getLservice() {
	    	if(lservice > 0 && lservice <= 5){
	    		return lservice;
	    	}
			return 5;
		}
	    /**
	    *物流服务
		* @param lservice
	    */ 
		public void setLservice(Integer lservice) {
			this.lservice = lservice;
		}
	    /**
	    *店铺服务
		* @return
	    */ 
		public Integer getSservice() {
	    	if(sservice > 0 && sservice <= 5){
	    		return sservice;
	    	}
			return 5;
		}
	    /**
	    *店铺服务
		* @param sservice
	    */ 
		public void setSservice(Integer sservice) {
			this.sservice = sservice;
		}
		@Override
		public String toString() {
			return "OrderShopCommentDTO [userId=" + userId + ", receiveName=" + receiveName + ", orderid=" + orderid
					+ ", shopid=" + shopid + ", describe_score=" + describe_score + ", lservice=" + lservice
					+ ", sservice=" + sservice + ", anonymous=" + anonymous + ", wareComments=" + wareComments + "]";
		}
		public List<OrderWareCommentDTO> getWareComments() {
			return wareComments;
		}
		public void setWareComments(List<OrderWareCommentDTO> wareComments) {
			this.wareComments = wareComments;
		}
		/**
		 * 匿名（1：是；2：否  默认1是）
		 * @return
		 */
		public Integer getAnonymous() {
			return anonymous;
		}
		/**
		 * 匿名（1：是；2：否  默认1是）
		 * @param anonymous
		 */
		public void setAnonymous(Integer anonymous) {
			this.anonymous = anonymous;
		}
	
}
