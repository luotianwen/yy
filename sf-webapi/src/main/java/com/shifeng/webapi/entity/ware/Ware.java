package com.shifeng.webapi.entity.ware;

import java.io.Serializable;
import java.util.Date;
/** 
 * 
 * @author WinZhong
 *
 */
public class Ware implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//商品编号
  	 private Integer id;
 	//店铺编号
  	 private int shopid;
 	//品牌编号
  	 private int brandid;
 	//父分类属性编号
  	 private int pcid;
 	//分类属性编号
  	 private int cid;
 	//商品名称
  	 private String name;
  	//商品名称关键字高亮
  	 private String highlightName;
 	//店内推荐(1正常 2冻结)
  	 private int recommend;
 	//包装清单
  	 private String listing;
 	//提交时间
  	 private Date submit_time;
 	//商品参数
  	 private String parameter;
 	//商品状态(1在售2下架3删除)
  	 private int state;
 	//售后服务
  	 private String after_service;
 	//排序
  	 private int rank;
 	//运费模板
  	 private int freight_master;
 	//副标题
  	 private String goods_subtitle;
 	//商品主图
  	 private String logo;
 	//商品长度
  	 private String length;
 	//商品宽度
  	 private String width;
 	//商品高度
  	 private String highly;
 	//是否支持7天退换货
  	 private int is_seven_return;
 	//更新时间
  	 private Date update_time;
 	//上架时间
  	 private Date upshelf_time;
 	//下架时间
  	 private Date downshelf_time;
 	//关键字
  	 private String keywords;
 	//电脑描述
  	 private String description;
 	//手机版描述
  	 private String phone_describe;



	 
    /**
    *商品编号
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *商品编号
	* @param id
    */ 
	public void setId(Integer id) {
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
    *父分类属性编号
	* @return
    */ 
	public int getPcid() {
		return pcid;
	}
    /**
    *父分类属性编号
	* @param pcid
    */ 
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
    /**
    *分类属性编号
	* @return
    */ 
	public int getCid() {
		return cid;
	}
    /**
    *分类属性编号
	* @param cid
    */ 
	public void setCid(int cid) {
		this.cid = cid;
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
    *提交时间
	* @return
    */ 
	public Date getSubmit_time() {
		return submit_time;
	}
    /**
    *提交时间
	* @param submit_time
    */ 
	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
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
    *排序
	* @return
    */ 
	public int getRank() {
		return rank;
	}
    /**
    *排序
	* @param rank
    */ 
	public void setRank(int rank) {
		this.rank = rank;
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
	public String getHighly() {
		return highly;
	}
    /**
    *商品高度
	* @param highly
    */ 
	public void setHighly(String highly) {
		this.highly = highly;
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
    *更新时间
	* @return
    */ 
	public Date getUpdate_time() {
		return update_time;
	}
    /**
    *更新时间
	* @param update_time
    */ 
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
    /**
    *上架时间
	* @return
    */ 
	public Date getUpshelf_time() {
		return upshelf_time;
	}
    /**
    *上架时间
	* @param upshelf_time
    */ 
	public void setUpshelf_time(Date upshelf_time) {
		this.upshelf_time = upshelf_time;
	}
    /**
    *下架时间
	* @return
    */ 
	public Date getDownshelf_time() {
		return downshelf_time;
	}
    /**
    *下架时间
	* @param downshelf_time
    */ 
	public void setDownshelf_time(Date downshelf_time) {
		this.downshelf_time = downshelf_time;
	}
    /**
    *关键字
	* @return
    */ 
	public String getKeywords() {
		return keywords;
	}
    /**
    *关键字
	* @param keywords
    */ 
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
    /**
     * 商品名称关键字高亮
     * @param highlightName
     */
	public void setHighlightName(String highlightName) {
		this.highlightName = highlightName;
	}
	
}
