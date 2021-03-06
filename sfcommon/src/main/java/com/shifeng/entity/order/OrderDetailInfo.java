package com.shifeng.entity.order;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单明细表(o_orderDetailInfo)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-24 10:07:12 
 */  
public class OrderDetailInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private Integer id;
 	//订单编号
  	 private String orderId;
 	//商品id
  	 private Integer pid;
 	//Sku
  	 private String sku;
 	//商品货号
  	 private String productNumber;
 	//商品名称
  	 private String productName;
 	//商品图片
  	 private String productImage;
 	//分类
  	 private Integer category;
 	//商品类型
  	 private Integer productType;
 	//积分
  	 private Integer giftPoints;
 	//商品状态
  	 private Integer productStatus;
 	//折扣
  	 private Double discount;
 	//市场价
  	 private Double initialPrice;
 	//销售价格
  	 private Double soldPrice;
 	//购买数量
  	 private Integer quantity;
 	//总金额
  	 private Double totalMoney;
 	//颜色
  	 private String color;
  	//颜色id
  	 private Integer colorid;
 	//规格
  	 private String specification;
  	//规格id
  	 private Integer specid;
 	//免运费(1：是；2：否)
  	 private Integer freeShipment;
 	//父订单号
  	 private String perentId;
 	//佣金
  	 private Double commission;
  	//评价状态(1:未评价，2：已评价)
  	 private Integer estatus;
 	//售后状态（0正常 0正常 1换货 2退款3退款退货 4维修9售后关闭）
  	 private Integer sstatus;


	 
    /**
    *主键
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *主键
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *订单编号
	* @return
    */ 
	public String getOrderId() {
		return orderId;
	}
    /**
    *订单编号
	* @param orderId
    */ 
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
    /**
    *商品id
	* @return
    */ 
	public Integer getPid() {
		return pid;
	}
    /**
    *商品id
	* @param pid
    */ 
	public void setPid(Integer pid) {
		this.pid = pid;
	}
    /**
    *Sku
	* @return
    */ 
	public String getSku() {
		return sku;
	}
    /**
    *Sku
	* @param sku
    */ 
	public void setSku(String sku) {
		this.sku = sku;
	}
    /**
    *商品货号
	* @return
    */ 
	public String getProductNumber() {
		return productNumber;
	}
    /**
    *商品货号
	* @param productNumber
    */ 
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
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
    *分类
	* @return
    */ 
	public Integer getCategory() {
		return category;
	}
    /**
    *分类
	* @param category
    */ 
	public void setCategory(Integer category) {
		this.category = category;
	}
    /**
    *商品类型
	* @return
    */ 
	public Integer getProductType() {
		return productType;
	}
    /**
    *商品类型
	* @param productType
    */ 
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
    /**
    *积分
	* @return
    */ 
	public Integer getGiftPoints() {
		return giftPoints;
	}
    /**
    *积分
	* @param giftPoints
    */ 
	public void setGiftPoints(Integer giftPoints) {
		this.giftPoints = giftPoints;
	}
    /**
    *商品状态
	* @return
    */ 
	public Integer getProductStatus() {
		return productStatus;
	}
    /**
    *商品状态
	* @param productStatus
    */ 
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
    /**
    *折扣
	* @return
    */ 
	public Double getDiscount() {
		return discount;
	}
    /**
    *折扣
	* @param discount
    */ 
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
    /**
    *市场价
	* @return
    */ 
	public Double getInitialPrice() {
		return initialPrice;
	}
    /**
    *市场价
	* @param initialPrice
    */ 
	public void setInitialPrice(Double initialPrice) {
		this.initialPrice = initialPrice;
	}
    /**
    *销售价格
	* @return
    */ 
	public Double getSoldPrice() {
		return soldPrice;
	}
    /**
    *销售价格
	* @param soldPrice
    */ 
	public void setSoldPrice(Double soldPrice) {
		this.soldPrice = soldPrice;
	}
    /**
    *购买数量
	* @return
    */ 
	public Integer getQuantity() {
		return quantity;
	}
    /**
    *购买数量
	* @param quantity
    */ 
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    /**
    *总金额
	* @return
    */ 
	public Double getTotalMoney() {
		return totalMoney;
	}
    /**
    *总金额
	* @param totalMoney
    */ 
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
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
	 * 颜色id
	 * @return
	 */
    public Integer getColorid() {
		return colorid;
	}
    /**
     * 颜色id
     * @param colorid
     */
	public void setColorid(Integer colorid) {
		this.colorid = colorid;
	}
	/**
    *规格
	* @return
    */ 
	public String getSpecification() {
		return specification;
	}
    /**
    *规格
	* @param specification
    */ 
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * 规格id
	 * @return
	 */
    public Integer getSpecid() {
		return specid;
	}
    /**
     * 规格id
     * @param specid
     */
	public void setSpecid(Integer specid) {
		this.specid = specid;
	}
	/**
    *免运费(1：是；2：否)
	* @return
    */ 
	public Integer getFreeShipment() {
		return freeShipment;
	}
    /**
    *免运费(1：是；2：否)
	* @param freeShipment
    */ 
	public void setFreeShipment(Integer freeShipment) {
		this.freeShipment = freeShipment;
	}
    /**
    *父订单号
	* @return
    */ 
	public String getPerentId() {
		return perentId;
	}
    /**
    *父订单号
	* @param perentId
    */ 
	public void setPerentId(String perentId) {
		this.perentId = perentId;
	}
    /**
    *佣金
	* @return
    */ 
	public Double getCommission() {
		return commission;
	}
    /**
    *佣金
	* @param commission
    */ 
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	/**
    *评价状态(1:未评价，2：已评价)
	* @return
    */ 
	public Integer getEstatus() {
		return estatus;
	}
    /**
    *评价状态(1:未评价，2：已评价)
	* @param estatus
    */ 
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
    /**
    *售后状态（0正常 1退货2换货3维修9售后关闭）
	* @return
    */ 
	public Integer getSstatus() {
		return sstatus;
	}
    /**
    *售后状态（0正常 1退货2换货3维修9售后关闭）
	* @param sstatus
    */ 
	public void setSstatus(Integer sstatus) {
		this.sstatus = sstatus;
	}
	
}
