package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/** 
 * 订单售后(o_orderInfo_service)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-13 17:15:04 
 */  
public class OrderServiceDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//服务单号
 	 private Integer serviceNumber;
 	//商品名称
  	 private String productName;
 	//商品图片
  	 private String productImage;
 	//颜色
  	 private String color;
 	//规格
  	 private String spec;
 	//sku
  	 private String sku;
 	//状态 1：待审核；2：审核失败；3：等待买家发货；4：等待商家收货；5：等待商家发货/退款中；6：商家已发货/已退款；7：完成
  	 private Integer state;
 	//类型 1换货 2退款退货 3维修
  	 private Integer type;
 	//客户发货快递编号
  	 private String cexpressId;
 	//客户快递单号
  	 private String cnumber;
 	//客户发货备注
  	 private String cnote;
 	//客户退换货原因
  	 private String creason;
  	//问题描述
  	 private String description;
 	//快递编号
  	 private String expressId;
 	//快递单号
  	 private String number;
 	//审核备注
  	 private String note;
 	//进度
  	 private List<OrderInfoServiceLogDTO> progress;
   	//提交时间
   	 private Date subTime;
	 
	 /**
	  * 服务单号
	  * @return
	  */
    public Integer getServiceNumber() {
		return serviceNumber;
	}
    /**
     * 服务单号
     * @param serviceNumber
     */
	public void setServiceNumber(Integer serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
    /**
    *商品名称
	* @return
    */ 
	public String getProductName() {
		return productName;
	}
    /**
    *商品名称
	* @param productName
    */ 
	public void setProductName(String productName) {
		this.productName = productName;
	}
    /**
    *商品图片
	* @return
    */ 
	public String getProductImage() {
		return productImage;
	}
    /**
    *商品图片
	* @param productImage
    */ 
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
    /**
    *颜色
	* @return
    */ 
	public String getColor() {
		return color;
	}
    /**
    *颜色
	* @param color
    */ 
	public void setColor(String color) {
		this.color = color;
	}
    /**
    *规格
	* @return
    */ 
	public String getSpec() {
		return spec;
	}
    /**
    *规格
	* @param spec
    */ 
	public void setSpec(String spec) {
		this.spec = spec;
	}
    /**
    *sku
	* @return
    */ 
	public String getSku() {
		return sku;
	}
    /**
    *sku
	* @param sku
    */ 
	public void setSku(String sku) {
		this.sku = sku;
	}
    /**
    *状态 1：待审核；2：审核失败；3：等待买家发货；4：等待商家收货；5：等待商家发货/退款中；6：商家已发货/已退款；7：完成
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态 1：待审核；2：审核失败；3：等待买家发货；4：等待商家收货；5：等待商家发货/退款中；6：商家已发货/已退款；7：完成
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *类型
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *类型
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *客户发货快递编号
	* @return
    */ 
	public String getCexpressId() {
		return cexpressId;
	}
    /**
    *客户发货快递编号
	* @param cdelivery
    */ 
	public void setCexpressId(String cexpressId) {
		this.cexpressId = cexpressId;
	}
    /**
    *客户快递单号
	* @return
    */ 
	public String getCnumber() {
		return cnumber;
	}
    /**
    *客户快递单号
	* @param cnumber
    */ 
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
    /**
    *客户发货备注
	* @return
    */ 
	public String getCnote() {
		return cnote;
	}
    /**
    *客户发货备注
	* @param cnote
    */ 
	public void setCnote(String cnote) {
		this.cnote = cnote;
	}
    /**
    *客户退换货原因
	* @return
    */ 
	public String getCreason() {
		return creason;
	}
    /**
    *客户退换货原因
	* @param creason
    */ 
	public void setCreason(String creason) {
		this.creason = creason;
	}
	/**
	 * 问题描述
	 * @return
	 */
    public String getDescription() {
		return description;
	}
    /**
     * 问题描述
     * @param description
     */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
    *快递编号
	* @return
    */ 
	public String getExpressId() {
		return expressId;
	}
    /**
    *快递编号
	* @param delivery
    */ 
	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}
    /**
    *快递单号
	* @return
    */ 
	public String getNumber() {
		return number;
	}
    /**
    *快递单号
	* @param number
    */ 
	public void setNumber(String number) {
		this.number = number;
	}

    /**
    *审核备注
	* @return
    */ 
	public String getNote() {
		return note;
	}
    /**
    *审核备注
	* @param note
    */ 
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 提交时间
	 * @return
	 */
    public Date getSubTime() {
		return subTime;
	}
    /**
     * 提交时间
     * @param subTime
     */
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
 
	public List<OrderInfoServiceLogDTO> getProgress() {
		return progress;
	}
	public void setProgress(List<OrderInfoServiceLogDTO> progress) {
		this.progress = progress;
	}
	@Override
	public String toString() {
		return "OrderServiceDetailDTO [serviceNumber=" + serviceNumber + ", productName=" + productName
				+ ", productImage=" + productImage + ", color=" + color + ", spec=" + spec + ", sku=" + sku + ", state="
				+ state + ", type=" + type + ", cexpressId=" + cexpressId + ", cnumber=" + cnumber + ", cnote=" + cnote
				+ ", creason=" + creason + ", description=" + description + ", expressId=" + expressId + ", number="
				+ number + ", note=" + note + ", progress=" + progress + "]";
	}
  
	
}
