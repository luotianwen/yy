package com.shifeng.webapi.entity.ware;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
/** 
 * 
 * @author WinZhong
 *
 */
public class WareInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//商品编号
	@Field("id")
  	 private String id;
 	//店铺编号
	@Field("shopid")
  	 private int shopid;
 	//店铺名称
	@Field("shopName")
  	 private String shopName;
 	//店铺logo
	@Field("shopLogo")
  	 private String shopLogo;
 	//品牌编号
	@Field("brandid")
  	 private int brandid;
 	//商品名称
	@Field("name")
  	 private String name;
 	//店内推荐(1正常 2冻结)
	@Field("recommend")
  	 private int recommend;
 	//包装清单
	@Field("listing")
  	 private String listing;
 	//商品参数
	@Field("parameter")
  	 private String parameter;
 	//商品状态(1在售2下架3删除)
	@Field("state")
  	 private int state;
 	//售后服务
 	@Field("after_service")
  	 private String after_service;
 	//运费模板
 	@Field("freight_master")
  	 private int freight_master;
 	//副标题
	@Field("goods_subtitle")
  	 private String goods_subtitle;
 	//商品主图
	@Field("logo")
  	 private String logo;
 	//商品长度
	@Field("length")
  	 private String length;
 	//商品宽度
	@Field("width")
  	 private String width;
 	//商品高度
	@Field("height")
  	 private String height;
 	//是否支持7天退换货
	@Field("is_seven_return")
  	 private int is_seven_return;
 	//电脑描述
	@Field("description")
  	 private String description;
 	//手机版描述
	@Field("phone_describe")
  	 private String phone_describe;

  	 
  	 //商品图片
	@Field("pimgs")
  	 private String[] pimgs;


	 
    /**
    *商品编号
	* @return
    */ 
	public String getId() {
		return id;
	}
    /**
    *商品编号
	* @param id
    */ 
	public void setId(String id) {
		this.id = id;
	}
    /**
    *店铺编号
	* @return
    */ 
	public int getShopid() {
		return shopid;
	}
    /**
    *店铺编号
	* @param shopid
    */ 
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	
	/**
	 * 店铺名称
	 * @return
	 */
    public String getShopName() {
		return shopName;
	}
    /**
     * 店铺名称
     * @param shopName
     */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	/**
	 * 店铺logo
	 * @return
	 */
	public String getShopLogo() {
		return shopLogo;
	}
	/**
	 *  店铺logo
	 * @param shopLogo
	 */
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	
    /**
    *品牌编号
	* @return
    */ 
	public int getBrandid() {
		return brandid;
	}
    /**
    *品牌编号
	* @param brandid
    */ 
	public void setBrandid(int brandid) {
		this.brandid = brandid;
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
    *店内推荐(1正常 2冻结)
	* @return
    */ 
	public int getRecommend() {
		return recommend;
	}
    /**
    *店内推荐(1正常 2冻结)
	* @param recommend
    */ 
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
    /**
    *包装清单
	* @return
    */ 
	public String getListing() {
		return listing;
	}
    /**
    *包装清单
	* @param listing
    */ 
	public void setListing(String listing) {
		this.listing = listing;
	}
     
    /**
    *商品参数
	* @return
    */ 
	public String getParameter() {
		return parameter;
	}
    /**
    *商品参数
	* @param parameter
    */ 
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
    /**
    *商品状态(1在售2下架3删除)
	* @return
    */ 
	public int getState() {
		return state;
	}
    /**
    *商品状态(1在售2下架3删除)
	* @param state
    */ 
	public void setState(int state) {
		this.state = state;
	}
    /**
    *售后服务
	* @return
    */ 
	public String getAfter_service() {
		return after_service;
	}
    /**
    *售后服务
	* @param after_service
    */ 
	public void setAfter_service(String after_service) {
		this.after_service = after_service;
	}
    
    /**
    *运费模板
	* @return
    */ 
	public int getFreight_master() {
		return freight_master;
	}
    /**
    *运费模板
	* @param freight_master
    */ 
	public void setFreight_master(int freight_master) {
		this.freight_master = freight_master;
	}
    /**
    *副标题
	* @return
    */ 
	public String getGoods_subtitle() {
		return goods_subtitle;
	}
    /**
    *副标题
	* @param goods_subtitle
    */ 
	public void setGoods_subtitle(String goods_subtitle) {
		this.goods_subtitle = goods_subtitle;
	}
    /**
    *商品主图
	* @return
    */ 
	public String getLogo() {
		return logo;
	}
    /**
    *商品主图
	* @param logo
    */ 
	public void setLogo(String logo) {
		this.logo = logo;
	}
    /**
    *商品长度
	* @return
    */ 
	public String getLength() {
		return length;
	}
    /**
    *商品长度
	* @param length
    */ 
	public void setLength(String length) {
		this.length = length;
	}
    /**
    *商品宽度
	* @return
    */ 
	public String getWidth() {
		return width;
	}
    /**
    *商品宽度
	* @param width
    */ 
	public void setWidth(String width) {
		this.width = width;
	}
    /**
    *商品高度
	* @return
    */ 
	public String getHeight() {
		return height;
	}
    /**
    *商品高度
	* @param height
    */ 
	public void setHeight(String height) {
		this.height = height;
	}
    /**
    *是否支持7天退换货
	* @return
    */ 
	public int getIs_seven_return() {
		return is_seven_return;
	}
    /**
    *是否支持7天退换货
	* @param is_seven_return
    */ 
	public void setIs_seven_return(int is_seven_return) {
		this.is_seven_return = is_seven_return;
	}
    
    /**
    *电脑描述
	* @return
    */ 
	public String getDescription() {
		return description;
	}
    /**
    *电脑描述
	* @param description
    */ 
	public void setDescription(String description) {
		this.description = description;
	}
    /**
    *手机版描述
	* @return
    */ 
	public String getPhone_describe() {
		return phone_describe;
	}
    /**
    *手机版描述
	* @param phone_describe
    */ 
	public void setPhone_describe(String phone_describe) {
		this.phone_describe = phone_describe;
	}
	 
	public String[] getPimgs() {
		return pimgs;
	}
	public void setPimgs(String[] pimgs) {
		this.pimgs = pimgs;
	}
	@Override
	public String toString() {
		return "WareInfo [id=" + id + ", shopid=" + shopid + ", shopName=" + shopName + ", shopLogo=" + shopLogo
				+ ", brandid=" + brandid + ", name=" + name + ", recommend=" + recommend + ", listing=" + listing
				+ ", parameter=" + parameter + ", state=" + state + ", after_service=" + after_service
				+ ", freight_master=" + freight_master + ", goods_subtitle=" + goods_subtitle + ", logo=" + logo
				+ ", length=" + length + ", width=" + width + ", height=" + height + ", is_seven_return="
				+ is_seven_return + ", description=" + description + ", phone_describe=" + phone_describe + ", imgList="
				+ pimgs + "]";
	}
   
	
	
	
}
