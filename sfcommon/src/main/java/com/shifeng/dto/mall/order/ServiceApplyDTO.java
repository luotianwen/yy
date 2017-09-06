package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.List;

/**
 * 申请售后DTO
 * 
 * @author Win
 *
 */
public class ServiceApplyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 	//id
 	 private Integer id;
	// 用户编号
	private String userId;
	// 订单id
	private String order_id;
	// 商品ID（sku）
	private int wareId;
	// 服务类型(1换货 2退款3退款退货 4维修 )
	private int applyType;
	// 问题描述
	private String questionDesc;
	// 图片地址
	private List<String> imgs;
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
	 * 用户编号
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户编号
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getWareId() {
		return wareId;
	}

	public void setWareId(int wareId) {
		this.wareId = wareId;
	}

	public int getApplyType() {
		return applyType;
	}

	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return "ServiceApplyDTO [userId=" + userId + ", order_id=" + order_id + ", wareId=" + wareId + ", applyType="
				+ applyType + ", questionDesc=" + questionDesc + ", imgs=" + imgs + "]";
	}

}
