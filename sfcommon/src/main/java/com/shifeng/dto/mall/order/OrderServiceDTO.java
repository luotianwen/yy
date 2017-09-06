package com.shifeng.dto.mall.order;

import java.io.Serializable;
/** 
 * 订单售后(o_orderInfo_service)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-13 17:15:04 
 */  
public class OrderServiceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//服务单号
  	 private Integer serviceNumber;
 	//orderId
  	 private String orderId;
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
 	//类型1换货 2退款3退款退货 4维修 
  	 private Integer type;
 


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
    *orderId
	* @return
    */ 
	public String getOrderId() {
		return orderId;
	}
    /**
    *orderId
	* @param orderId
    */ 
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
   
	
}
