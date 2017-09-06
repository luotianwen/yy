package com.shifeng.entity.search;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
/** 
 * 
 * @author WinZhong
 *
 */
public class SkuInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//商品 SKU 
	@Field("id")
	private String sku;
	//商品 id
	@Field("pid")
	private Integer pid;
	//库存
	@Field("stocks")
	private Integer stocks;
	//市场价
	@Field("marketprice")
	private Double marketprice;
	//世峰价
	@Field("price")
	private Double price;
	//颜色
	@Field("colorid")
	private Integer colorid;
	//颜色名称
	@Field("colorName")
	private String colorName;
	//规格
	@Field("specid")
	private Integer specid;
	//规格名称
	@Field("specName")
	private String specName;
	//开始时间
	@Field("starttime")
	private Date starttime;
	//结束时间
	@Field("endtime")
	private Date endtime;
	//活动类型
	@Field("activitytype")
	private Integer activitytype;
	//活动价
	@Field("activityprice")
	private Double activityprice;
	//活动数量
	@Field("activitystocks")
	private Integer activitystocks;
	// 折扣
	@Field("discount")
	private Double discount;
	//颜色主图
	@Field("colorPic")
	private String colorPic;
	//sku商品图片
	@Field("imgs")
	private List<String> imgs;





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
	public Integer getActivitystocks() {
		return activitystocks;
	}
	/**
	 *活动数量
	 * @param activitystocks
	 */ 
	public void setActivitystocks(Integer activitystocks) {
		this.activitystocks = activitystocks;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
	

	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * 颜色主图
	 * @return
	 */
	public String getColorPic() {
		return colorPic;
	}
	/**
	 * 颜色主图
	 * @param colorPic
	 */
	public void setColorPic(String colorPic) {
		this.colorPic = colorPic;
	}
	/**
	 * 商品 id
	 * @return
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 商品 id
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
	@Override
	public String toString() {
		return "SkuInfo [sku=" + sku + ", pid=" + pid + ", stocks=" + stocks + ", marketprice=" + marketprice
				+ ", price=" + price + ", colorid=" + colorid + ", colorName=" + colorName + ", specid=" + specid
				+ ", specName=" + specName + ", starttime=" + starttime + ", endtime=" + endtime + ", activitytype="
				+ activitytype + ", activityprice=" + activityprice + ", activitystocks=" + activitystocks
				+ ", discount=" + discount + ", colorPic=" + colorPic + ", imgs=" + imgs + "]";
	}



}