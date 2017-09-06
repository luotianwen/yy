package com.shifeng.provide.entity.solr;

public class SolrProductDTO {
	
	//店铺编号
 	 private int shopid;
	//店铺名称
 	 private String shopName;
	//店铺logo
 	 private String shopLogo;
	//品牌编号
 	 private int brandid;
	//父分类属性编号
 	 private int pcid;
	//分类属性编号
 	 private int cid;
	//商品名称
 	 private String pName;
	//商品状态(1在售2下架3删除)
 	 private int state;
	//副标题
 	 private String goods_subtitle;
	//商品主图
 	 private String logo;
	//是否支持7天退换货
 	 private int is_seven_return;
	//关键字
 	 private String keywords;
    //发货地ID
 	private String originId;
     //发货地名称
 	private String originName;
 	 
 	 
 	 
	//售后服务
 	 private String after_service;
	//运费模板
 	 private int freight_master;
	//商品长度
 	 private String length;
	//商品宽度
 	 private String width;
	//商品高度
 	 private String highly;
	//电脑描述
 	 private String description;
	//手机版描述
 	 private String phone_describe;
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public int getBrandid() {
		return brandid;
	}
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	public int getPcid() {
		return pcid;
	}
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getGoods_subtitle() {
		return goods_subtitle;
	}
	public void setGoods_subtitle(String goods_subtitle) {
		this.goods_subtitle = goods_subtitle;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getIs_seven_return() {
		return is_seven_return;
	}
	public void setIs_seven_return(int is_seven_return) {
		this.is_seven_return = is_seven_return;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
	public String getAfter_service() {
		return after_service;
	}
	public void setAfter_service(String after_service) {
		this.after_service = after_service;
	}
	public int getFreight_master() {
		return freight_master;
	}
	public void setFreight_master(int freight_master) {
		this.freight_master = freight_master;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHighly() {
		return highly;
	}
	public void setHighly(String highly) {
		this.highly = highly;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhone_describe() {
		return phone_describe;
	}
	public void setPhone_describe(String phone_describe) {
		this.phone_describe = phone_describe;
	}
	@Override
	public String toString() {
		return "SolrProductDTO [shopid=" + shopid + ", shopName=" + shopName + ", shopLogo=" + shopLogo + ", brandid="
				+ brandid + ", pcid=" + pcid + ", cid=" + cid + ", pName=" + pName + ", state=" + state
				+ ", goods_subtitle=" + goods_subtitle + ", logo=" + logo + ", is_seven_return=" + is_seven_return
				+ ", keywords=" + keywords + ", originId=" + originId + ", originName=" + originName
				+ ", after_service=" + after_service + ", freight_master=" + freight_master + ", length=" + length
				+ ", width=" + width + ", highly=" + highly + ", description=" + description + ", phone_describe="
				+ phone_describe + "]";
	}
 	 
 	 
 	 
 	 
 	 

}
