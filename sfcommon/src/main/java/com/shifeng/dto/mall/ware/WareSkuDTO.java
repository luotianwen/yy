package com.shifeng.dto.mall.ware;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 商品sku基本信息 DTO
 * @author WinZhong
 *
 */
public class WareSkuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//商品编号
  	 private Integer id;
 	//店铺编号
  	 private int shopid;
 	//店铺名称
  	 private String shopName;
 	//店铺logo
  	 private String shopLogo;
 	//品牌编号
  	 private int brandid;
 	//商品名称
  	 private String name;
 	//店内推荐(1正常 2冻结)
  	 private int recommend;
 	//包装清单
  	 private String listing;
 	//商品参数
  	 private String parameter;
 	//商品状态(1在售2下架3删除)
  	 private int state;
 	//售后服务
  	 private String after_service;
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
 	//电脑描述
  	 private String description;
 	//手机版描述
  	 private String phone_describe;
  	 
  	 /****************商品SKU******************/
  	 
  	//商品 SKU 
  	 private Integer sku;
  	//库存
   	 private Integer stocks;
  	//重量
   	 private Integer weight;
  	//市场价
   	 private Double marketprice;
  	//世峰价
   	 private Double price;
 	//颜色
  	 private Integer colorid;
 	//颜色名称
  	 private String colorName;
 	//规格
  	 private Integer specid;
 	//规格名称
  	 private String specName;
 	//开始时间
  	 private Date starttime;
 	//结束时间
  	 private Date endtime;
 	//活动类型
  	 private Integer activitytype;
 	//活动价
  	 private Double activityprice;
 	//活动数量
  	 private Double activitystocks;
  	 
  	 //sku商品图片
  	 private List<String> imgList;
  	 
	 //商品货号
	private String number;
	//商品货号
	public String getNumber() {
		return number;
	}
	//商品货号
	public void setNumber(String number) {
		this.number = number;
	}

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
    *库存
	* @return
    */ 
	public Integer getStocks() {
		return stocks;
	}
    /**
    *库存
	* @param stocks
    */ 
	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}
    /**
    *重量
	* @return
    */ 
	public Integer getWeight() {
		return weight;
	}
    /**
    *重量
	* @param weight
    */ 
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
    /**
    *市场价
	* @return
    */ 
	public Double getMarketprice() {
		return marketprice;
	}
    /**
    *市场价
	* @param marketprice
    */ 
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}
	/**
	 * 世峰价
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
    /**
    *世峰价
	* @return
    */ 
	public Double getPrice() {
		return price;
	}
    /**
    *颜色
	* @return
    */ 
	public Integer getColorid() {
		return colorid;
	}
    /**
    *颜色
	* @param colorid
    */ 
	public void setColorid(Integer colorid) {
		this.colorid = colorid;
	}
    /**
    *规格
	* @return
    */ 
	public Integer getSpecid() {
		return specid;
	}
    /**
    *规格
	* @param specid
    */ 
	public void setSpecid(Integer specid) {
		this.specid = specid;
	}
    /**
    *开始时间
	* @return
    */ 
	public Date getStarttime() {
		return starttime;
	}
    /**
    *开始时间
	* @param starttime
    */ 
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
    /**
    *结束时间
	* @return
    */ 
	public Date getEndtime() {
		return endtime;
	}
    /**
    *结束时间
	* @param endtime
    */ 
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
    /**
    *活动类型
	* @return
    */ 
	public Integer getActivitytype() {
		return activitytype;
	}
    /**
    *活动类型
	* @param activitytype
    */ 
	public void setActivitytype(Integer activitytype) {
		this.activitytype = activitytype;
	}
    /**
    *活动价
	* @return
    */ 
	public Double getActivityprice() {
		return activityprice;
	}
    /**
    *活动价
	* @param activityprice
    */ 
	public void setActivityprice(Double activityprice) {
		this.activityprice = activityprice;
	}
    /**
    *活动数量
	* @return
    */ 
	public Double getActivitystocks() {
		return activitystocks;
	}
    /**
    *活动数量
	* @param activitystocks
    */ 
	public void setActivitystocks(Double activitystocks) {
		this.activitystocks = activitystocks;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	
}