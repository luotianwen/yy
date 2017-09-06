package com.shifeng.provide.entity.ware;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
/**
 * 商品sku信息
 * @author Win
 *
 */
public class WareSKU implements Serializable {

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
  	 private String pName;
 	//商品状态(1在售2下架3删除)
  	 private int state;
 	//商品主图
  	 private String logo;


  	//id
   	 private String sku;
  	//库存
   	 private Integer stocks;
  	//市场价
   	 private Double marketprice;
  	//世峰价
   	 private Double price;
  	//商品货号
   	 private String number;
  	//图片编号
   	 private Integer imageid;
  	//颜色
   	 private Integer colorid;
 	//颜色名称
  	 private String colorName;
 	//颜色主图
 	private String colorPic;
  	//规格
   	 private Integer specid;
 	//规格名称
  	 private String specName;
  	//开始时间
   	 private Date starttime;
  	//结束时间
   	 private Date endtime;
  	//活动类型 0正常1秒杀2特价3团购4一元购
   	 private Integer activitytype;
  	//活动价
   	 private Double activityprice;
  	//活动数量
   	 private Double activitystocks;
	 
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
	public String getpName() {
		return pName;
	}
    /**
    *商品名称
	* @param name
    */ 
	public void setpName(String pName) {
		this.pName = pName;
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
    *世峰价
    *如果存在活动则返回活动价
	* @return
    */ 
	public Double getPrice() {
		
		if(activitytype != null && 0 != activitytype){//如果存在活动则返回活动价
			return activityprice;
		}
		return price;
	}
    /**
    *世峰价
	* @param price
    */ 
	public void setPrice(Double price) {
		this.price = price;
	}
    /**
    *商品货号
	* @return
    */ 
	public String getNumber() {
		return number;
	}
    /**
    *商品货号
	* @param number
    */ 
	public void setNumber(String number) {
		this.number = number;
	}
    /**
    *图片编号
	* @return
    */ 
	public Integer getImageid() {
		return imageid;
	}
    /**
    *图片编号
	* @param imageid
    */ 
	public void setImageid(Integer imageid) {
		this.imageid = imageid;
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
    *活动类型 0正常1秒杀2特价3团购4一元购
	* @return
    */ 
	public Integer getActivitytype() {
		return activitytype;
	}
    /**
    *活动类型 0正常1秒杀2特价3团购4一元购
	* @param activitytype
    */ 
	public void setActivitytype(Integer activitytype) {
		this.activitytype = activitytype;
	}
    /**
    *活动价
    *如果不存在活动则返回世峰价
	* @return
    */ 
	public Double getActivityprice() {
		if(activitytype == null || 0 == activitytype){//如果不存在活动则返回世峰价
			return price;
		}
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
	public String getColorPic() {
		if(StringUtils.isBlank(colorPic)){
			return logo;
		}
		return colorPic;
	}
	public void setColorPic(String colorPic) {
		this.colorPic = colorPic;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	@Override
	public String toString() {
		return "WareSKU [id=" + id + ", shopid=" + shopid + ", brandid=" + brandid + ", pcid=" + pcid + ", cid=" + cid
				+ ", pName=" + pName + ", state=" + state + ", logo=" + logo + ", sku=" + sku + ", stocks=" + stocks
				+ ", marketprice=" + marketprice + ", price=" + price + ", number=" + number + ", imageid=" + imageid
				+ ", colorid=" + colorid + ", colorName=" + colorName + ", colorPic=" + colorPic + ", specid=" + specid
				+ ", specName=" + specName + ", starttime=" + starttime + ", endtime=" + endtime + ", activitytype="
				+ activitytype + ", activityprice=" + activityprice + ", activitystocks=" + activitystocks + "]";
	}
	 
	
	
}
