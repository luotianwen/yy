package com.shifeng.provide.entity.solr;

import java.util.Date;
import java.util.List;

public class SolrProductSkuDTO {
	
 	//商品 SKU 
 	 private String sku;
  	//商品 id
  	 private Integer pid;
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
	//规格
 	 private Integer specid;
	//最后修改时间 
 	 private Date lasttime;
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
 	 
 	 
 	 private SolrProductRulesDTO rules;
 	 
 	private SolrProductDTO product;
	 
	private List<Integer> property;
 	 
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
		public Integer getPid() {
			return pid;
		}
		public void setPid(Integer pid) {
			this.pid = pid;
		}
		public Date getLasttime() {
			return lasttime;
		}
		public void setLasttime(Date lasttime) {
			this.lasttime = lasttime;
		}
		
		public SolrProductRulesDTO getRules() {
			return rules;
		}
		public void setRules(SolrProductRulesDTO rules) {
			this.rules = rules;
		}
		
		public SolrProductDTO getProduct() {
			return product;
		}
		public void setProduct(SolrProductDTO product) {
			this.product = product;
		}
		
		public List<Integer> getProperty() {
			return property;
		}
		public void setProperty(List<Integer> property) {
			this.property = property;
		}
		@Override
		public String toString() {
			return "SolrProductSkuDTO [sku=" + sku + ", pid=" + pid + ", stocks=" + stocks + ", weight=" + weight
					+ ", marketprice=" + marketprice + ", price=" + price + ", colorid=" + colorid + ", specid="
					+ specid + ", lasttime=" + lasttime + ", starttime=" + starttime + ", endtime=" + endtime
					+ ", activitytype=" + activitytype + ", activityprice=" + activityprice + ", activitystocks="
					+ activitystocks + ", rules=" + rules + ", product=" + product + ", property=" + property + "]";
		}
		 
 	 
 	 

}
