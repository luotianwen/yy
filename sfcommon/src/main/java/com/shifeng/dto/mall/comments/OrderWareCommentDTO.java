package com.shifeng.dto.mall.comments;

import java.io.Serializable;
import java.util.List;

/**
 * 订单商品评论DTO
 * @author Win
 *
 */
public class OrderWareCommentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


 	//商品评论id
  	 private Integer id;
 	//sku
  	 private Integer sku;
 	//内容
  	 private String content;
 	//用户编号
  	 private String userId;
 	//买家姓名
  	 private String receiveName;
 	//订单id
  	 private String orderid;
 	//店铺编号
  	 private Integer shopid;
  	//商品评分 (默认5分)
  	 private Integer score = 5;
  	 //评价商品图片
  	 private List<OrderWareCommentImgDTO> imgs;
  	 
	public Integer getSku() {
		return sku;
	}
	public void setSku(Integer sku) {
		this.sku = sku;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "OrderWareCommentDTO [id=" + id + ", sku=" + sku + ", content=" + content + ", userId=" + userId
				+ ", receiveName=" + receiveName + ", orderid=" + orderid + ", shopid=" + shopid + ", score=" + score
				+ ", imgs=" + imgs + "]";
	}
	public List<OrderWareCommentImgDTO> getImgs() {
		return imgs;
	}
	public void setImgs(List<OrderWareCommentImgDTO> imgs) {
		this.imgs = imgs;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}


	/**
	 * 商品评分
	 * @return
	 */
    public Integer getScore() {
    	if(score > 0 && score <= 5){
    		return score;
    	}
		return 5;
	}
    /**
     * 商品评分
     * @param score
     */
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
  	 

}
