package com.shifeng.entity.search;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author WinZhong
 *
 */
public class WareSkuInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 商品 SKU
	@Field("id")
	private String sku;
	// 商品 id
	@Field("pid")
	private Integer pid;
	// 库存
	@Field("stocks")
	private Integer stocks;
	// 市场价
	@Field("marketprice")
	private Double marketprice;
	// 世峰价
	@Field("price")
	private Double price;
	// 颜色
	@Field("colorid")
	private Integer colorid;
	// 颜色名称
	@Field("colorName")
	private String colorName;
	// 规格
	@Field("specid")
	private Integer specid;
	// 规格名称
	@Field("specName")
	private String specName;
	// 开始时间
	@Field("starttime")
	private Date starttime;
	// 结束时间
	@Field("endtime")
	private Date endtime;
	// 活动类型
	@Field("activitytype")
	private Integer activitytype;
	// 活动价
	@Field("activityprice")
	private Double activityprice;
	// 活动数量
	@Field("activitystocks")
	private Integer activitystocks;
	// 折扣
	@Field("discount")
	private Double discount;
	
	//发货地ID
	@Field("originId")
	private String originId;
	
	//发货地名称
	@Field("originName")
	private String originName;

	// sku商品图片
	@Field("imgs")
	private List<String> imgs;
	
	// 商品图片
	@JsonIgnore
	@JSONField(serialize=false)
	@Field("logos")
	private List<String> logos;

	// 店铺编号
	@Field("shopid")
	private int shopid;
	// 店铺名称
	@Field("shopName")
	private String shopName;
	// 店铺logo
	@Field("shopLogo")
	private String shopLogo;
	// 品牌编号
	@Field("brandid")
	private int brandid;
	//品牌名称
	@Field("brandName")
	private String brandName;

    //重量
	@Field("weight")
	private double weight;
	// 商品名称
	@Field("pName")
	private String pName;
	// 店内推荐(1正常 2冻结)
	@Field("recommend")
	private int recommend;
	// 包装清单
	@Field("listing")
	private String listing;
	// 商品参数
	@Field("parameter")
	private String parameter;
	// 商品状态(1在售2下架3删除)
	@Field("state")
	private int state;
	// 售后服务
	@Field("after_service")
	private String after_service;
	// 运费模板
	@Field("freight_master")
	private int freight_master;
	// 副标题
	@Field("goods_subtitle")
	private String goods_subtitle;
	// 商品主图
	@Field("logo")
	private String logo;
	// 商品长度
	@Field("length")
	private String length;
	// 商品宽度
	@Field("width")
	private String width;
	// 商品高度
	@Field("height")
	private String height;
	// 是否支持7天退换货
	@Field("is_seven_return")
	private int is_seven_return;
	// 电脑描述
	@Field("description")
	private String description;
	// 手机版描述
	@Field("phone_describe")
	private String phone_describe;
	//商品货号
	@Field("number")
	private String number;
	//分类id
	@Field("cid")
	private Integer cid;
	//父类分类id
	@Field("pcid")
	private Integer pcid;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPcid() {
		return pcid;
	}

	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * sku
	 * 
	 * @return
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * sku
	 * 
	 * @param sku
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * 库存
	 * 
	 * @return
	 */
	public Integer getStocks() {
		return stocks;
	}

	/**
	 * 库存
	 * 
	 * @param stocks
	 */
	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}

	/**
	 * 市场价
	 * 
	 * @return
	 */
	public Double getMarketprice() {
		return marketprice;
	}

	/**
	 * 市场价
	 * 
	 * @param marketprice
	 */
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}

	/**
	 * 世峰价
	 * 
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 世峰价
	 * 
	 * @return
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 颜色
	 * 
	 * @return
	 */
	public Integer getColorid() {
		return colorid;
	}

	/**
	 * 颜色
	 * 
	 * @param colorid
	 */
	public void setColorid(Integer colorid) {
		this.colorid = colorid;
	}

	/**
	 * 规格
	 * 
	 * @return
	 */
	public Integer getSpecid() {
		return specid;
	}

	/**
	 * 规格
	 * 
	 * @param specid
	 */
	public void setSpecid(Integer specid) {
		this.specid = specid;
	}

	/**
	 * 开始时间
	 * 
	 * @return
	 */
	public Date getStarttime() {
		return starttime;
	}

	/**
	 * 开始时间
	 * 
	 * @param starttime
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	/**
	 * 结束时间
	 * 
	 * @return
	 */
	public Date getEndtime() {
		return endtime;
	}

	/**
	 * 结束时间
	 * 
	 * @param endtime
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	/**
	 * 活动类型
	 * 
	 * @return
	 */
	public Integer getActivitytype() {
		return activitytype;
	}

	/**
	 * 活动类型
	 * 
	 * @param activitytype
	 */
	public void setActivitytype(Integer activitytype) {
		this.activitytype = activitytype;
	}

	/**
	 * 活动价
	 * 
	 * @return
	 */
	public Double getActivityprice() {
		return activityprice;
	}

	/**
	 * 活动价
	 * 
	 * @param activityprice
	 */
	public void setActivityprice(Double activityprice) {
		this.activityprice = activityprice;
	}

	/**
	 * 活动数量
	 * 
	 * @return
	 */
	public Integer getActivitystocks() {
		return activitystocks;
	}

	/**
	 * 活动数量
	 * 
	 * @param activitystocks
	 */
	public void setActivitystocks(Integer activitystocks) {
		this.activitystocks = activitystocks;
	}

	public List<String> getImgs() {
		if(imgs == null || imgs.size() == 0){
			return logos;
		}
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	/**
	 * 店铺编号
	 * 
	 * @return
	 */
	public int getShopid() {
		return shopid;
	}

	/**
	 * 店铺编号
	 * 
	 * @param shopid
	 */
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	/**
	 * 店铺名称
	 * 
	 * @return
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * 店铺名称
	 * 
	 * @param shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * 店铺logo
	 * 
	 * @return
	 */
	public String getShopLogo() {
		return shopLogo;
	}

	/**
	 * 店铺logo
	 * 
	 * @param shopLogo
	 */
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	/**
	 * 品牌编号
	 * 
	 * @return
	 */
	public int getBrandid() {
		return brandid;
	}

	/**
	 * 品牌编号
	 * 
	 * @param brandid
	 */
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	/**
	 * 商品名称
	 * 
	 * @return
	 */
	public String getpName() {
		return pName;
	}

	/**
	 * 商品名称
	 * 
	 * @param name
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * 店内推荐(1正常 2冻结)
	 * 
	 * @return
	 */
	public int getRecommend() {
		return recommend;
	}

	/**
	 * 店内推荐(1正常 2冻结)
	 * 
	 * @param recommend
	 */
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	/**
	 * 包装清单
	 * 
	 * @return
	 */
	public String getListing() {
		return listing;
	}

	/**
	 * 包装清单
	 * 
	 * @param listing
	 */
	public void setListing(String listing) {
		this.listing = listing;
	}

	/**
	 * 商品参数
	 * 
	 * @return
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * 商品参数
	 * 
	 * @param parameter
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	/**
	 * 商品状态(1在售2下架3删除)
	 * 
	 * @return
	 */
	public int getState() {
		return state;
	}

	/**
	 * 商品状态(1在售2下架3删除)
	 * 
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * 售后服务
	 * 
	 * @return
	 */
	public String getAfter_service() {
		return after_service;
	}

	/**
	 * 售后服务
	 * 
	 * @param after_service
	 */
	public void setAfter_service(String after_service) {
		this.after_service = after_service;
	}

	/**
	 * 运费模板
	 * 
	 * @return
	 */
	public int getFreight_master() {
		return freight_master;
	}

	/**
	 * 运费模板
	 * 
	 * @param freight_master
	 */
	public void setFreight_master(int freight_master) {
		this.freight_master = freight_master;
	}

	/**
	 * 副标题
	 * 
	 * @return
	 */
	public String getGoods_subtitle() {
		return goods_subtitle;
	}

	/**
	 * 副标题
	 * 
	 * @param goods_subtitle
	 */
	public void setGoods_subtitle(String goods_subtitle) {
		this.goods_subtitle = goods_subtitle;
	}

	/**
	 * 商品主图
	 * 
	 * @return
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * 商品主图
	 * 
	 * @param logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * 商品长度
	 * 
	 * @return
	 */
	public String getLength() {
		return length;
	}

	/**
	 * 商品长度
	 * 
	 * @param length
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * 商品宽度
	 * 
	 * @return
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * 商品宽度
	 * 
	 * @param width
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 商品高度
	 * 
	 * @return
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * 商品高度
	 * 
	 * @param height
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * 是否支持7天退换货
	 * 
	 * @return
	 */
	public int getIs_seven_return() {
		return is_seven_return;
	}

	/**
	 * 是否支持7天退换货
	 * 
	 * @param is_seven_return
	 */
	public void setIs_seven_return(int is_seven_return) {
		this.is_seven_return = is_seven_return;
	}

	/**
	 * 电脑描述
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 电脑描述
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 手机版描述
	 * 
	 * @return
	 */
	public String getPhone_describe() {
		return phone_describe;
	}

	/**
	 * 手机版描述
	 * 
	 * @param phone_describe
	 */
	public void setPhone_describe(String phone_describe) {
		this.phone_describe = phone_describe;
	}

	/**
	 * 商品 id
	 * 
	 * @return
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 商品 id
	 * 
	 * @param pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
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

	public List<String> getLogos() {
		return logos;
	}

	public void setLogos(List<String> logos) {
		this.logos = logos;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}
	
	

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "WareSkuInfo [sku=" + sku + ", pid=" + pid + ", stocks=" + stocks + ", marketprice=" + marketprice
				+ ", price=" + price + ", colorid=" + colorid + ", colorName=" + colorName + ", specid=" + specid
				+ ", specName=" + specName + ", starttime=" + starttime + ", endtime=" + endtime + ", activitytype="
				+ activitytype + ", activityprice=" + activityprice + ", activitystocks=" + activitystocks
				+ ", discount=" + discount + ", originId=" + originId + ", originName=" + originName + ", imgs=" + imgs
				+ ", logos=" + logos + ", shopid=" + shopid + ", shopName=" + shopName + ", shopLogo=" + shopLogo
				+ ", brandid=" + brandid + ", brandName=" + brandName + ", weight=" + weight + ", pName=" + pName
				+ ", recommend=" + recommend + ", listing=" + listing + ", parameter=" + parameter + ", state=" + state
				+ ", after_service=" + after_service + ", freight_master=" + freight_master + ", goods_subtitle="
				+ goods_subtitle + ", logo=" + logo + ", length=" + length + ", width=" + width + ", height=" + height
				+ ", is_seven_return=" + is_seven_return + ", description=" + description + ", phone_describe="
				+ phone_describe + ", number=" + number + ", cid=" + cid + ", pcid=" + pcid + "]";
	}

}