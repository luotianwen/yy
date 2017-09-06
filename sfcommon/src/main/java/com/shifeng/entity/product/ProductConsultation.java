package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * 商品咨询(p_product_consultation)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-21 09:43:44 
 */  
public class ProductConsultation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//sku
  	 private Integer sku;
 	//商品编号
  	 private Integer pid;
 	//商品名称
  	 private String name;
 	//颜色id
  	 private Integer colorid;
 	//颜色名称
  	 private String colorName;
 	//规格id
  	 private Integer specid;
 	//规格名称
  	 private String specName;
 	//用户编号
  	 private String userId;
 	//买家姓名
  	 private String receiveName;
 	//店铺编号
  	 private Integer shopid;
 	//内容
  	 private String content;
 	//审核状态（1：未审核；2：审核成功；3：审核失败）
  	 private Integer state;
 	//创建时间
  	 private Date cdate;



	 
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
    *sku
	* @return
    */ 
	public Integer getSku() {
		return sku;
	}
    /**
    *sku
	* @param sku
    */ 
	public void setSku(Integer sku) {
		this.sku = sku;
	}
    /**
    *商品编号
	* @return
    */ 
	public Integer getPid() {
		return pid;
	}
    /**
    *商品编号
	* @param pid
    */ 
	public void setPid(Integer pid) {
		this.pid = pid;
	}
    /**
    *商品名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *商品名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *颜色id
	* @return
    */ 
	public Integer getColorid() {
		return colorid;
	}
    /**
    *颜色id
	* @param colorid
    */ 
	public void setColorid(Integer colorid) {
		this.colorid = colorid;
	}
    /**
    *颜色名称
	* @return
    */ 
	public String getColorName() {
		return colorName;
	}
    /**
    *颜色名称
	* @param colorName
    */ 
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
    /**
    *规格id
	* @return
    */ 
	public Integer getSpecid() {
		return specid;
	}
    /**
    *规格id
	* @param specid
    */ 
	public void setSpecid(Integer specid) {
		this.specid = specid;
	}
    /**
    *规格名称
	* @return
    */ 
	public String getSpecName() {
		return specName;
	}
    /**
    *规格名称
	* @param specName
    */ 
	public void setSpecName(String specName) {
		this.specName = specName;
	}
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
    *内容
	* @return
    */ 
	public String getContent() {
		return content;
	}
    /**
    *内容
	* @param content
    */ 
	public void setContent(String content) {
		this.content = content;
	}
    /**
    *审核状态（1：未审核；2：审核成功；3：审核失败）
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *审核状态（1：未审核；2：审核成功；3：审核失败）
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getCdate() {
		return cdate;
	}
    /**
    *创建时间
	* @param cdate
    */ 
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
}
