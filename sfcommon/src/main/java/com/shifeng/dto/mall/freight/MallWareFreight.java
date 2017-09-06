package com.shifeng.dto.mall.freight;

import java.io.Serializable;

/**
 * 快递店铺商品运费
 * 
 * @author Win
 *
 */
public class MallWareFreight implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		//运费ID
		private Integer freight_id;
		
		// 是否包邮1是2否
		private Integer isFree;
		// 计费规则(1按件数;2按重量)
		private Integer ruleType;
		
		// 默认首重
		private double defaultFirstUnit;
		// 默认首重金额
		private double defaultFirstMoney;
		// 默认每增加重量
		private double defaultLastUnit;
		// 默认每增加重量金额
		private double defaultLastMoney;
		
		//运费明细ID
		private Integer freight_detail_id;
		// 首重
		private double firstunit;
		// 首重金额
		private double firstfee;
		// 每增加重量
		private double addunit;
		// 每增加重量金额
		private double addfee;
		

	 	 //店铺id
	  	 private Integer shopId;
	 	 //商品sku
	 	 private String sku;
	     //重量
	   	 private double weight;
		public Integer getFreight_id() {
			return freight_id;
		}
		public void setFreight_id(Integer freight_id) {
			this.freight_id = freight_id;
		}
		public Integer getIsFree() {
			return isFree;
		}
		public void setIsFree(Integer isFree) {
			this.isFree = isFree;
		}
		public Integer getRuleType() {
			return ruleType;
		}
		public void setRuleType(Integer ruleType) {
			this.ruleType = ruleType;
		}
		public double getDefaultFirstUnit() {
			return defaultFirstUnit;
		}
		public void setDefaultFirstUnit(double defaultFirstUnit) {
			this.defaultFirstUnit = defaultFirstUnit;
		}
		public double getDefaultFirstMoney() {
			return defaultFirstMoney;
		}
		public void setDefaultFirstMoney(double defaultFirstMoney) {
			this.defaultFirstMoney = defaultFirstMoney;
		}
		public double getDefaultLastUnit() {
			return defaultLastUnit;
		}
		public void setDefaultLastUnit(double defaultLastUnit) {
			this.defaultLastUnit = defaultLastUnit;
		}
		public double getDefaultLastMoney() {
			return defaultLastMoney;
		}
		public void setDefaultLastMoney(double defaultLastMoney) {
			this.defaultLastMoney = defaultLastMoney;
		}
		public Integer getFreight_detail_id() {
			return freight_detail_id;
		}
		public void setFreight_detail_id(Integer freight_detail_id) {
			this.freight_detail_id = freight_detail_id;
		}
		public double getFirstunit() {
			return firstunit;
		}
		public void setFirstunit(double firstunit) {
			this.firstunit = firstunit;
		}
		public double getFirstfee() {
			return firstfee;
		}
		public void setFirstfee(double firstfee) {
			this.firstfee = firstfee;
		}
		public double getAddunit() {
			return addunit;
		}
		public void setAddunit(double addunit) {
			this.addunit = addunit;
		}
		public double getAddfee() {
			return addfee;
		}
		public void setAddfee(double addfee) {
			this.addfee = addfee;
		}
		public Integer getShopId() {
			return shopId;
		}
		public void setShopId(Integer shopId) {
			this.shopId = shopId;
		}
		public String getSku() {
			return sku;
		}
		public void setSku(String sku) {
			this.sku = sku;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "MallWareFreight [freight_id=" + freight_id + ", isFree=" + isFree + ", ruleType=" + ruleType
					+ ", defaultFirstUnit=" + defaultFirstUnit + ", defaultFirstMoney=" + defaultFirstMoney
					+ ", defaultLastUnit=" + defaultLastUnit + ", defaultLastMoney=" + defaultLastMoney
					+ ", freight_detail_id=" + freight_detail_id + ", firstunit=" + firstunit + ", firstfee=" + firstfee
					+ ", addunit=" + addunit + ", addfee=" + addfee + ", shopId=" + shopId + ", sku=" + sku
					+ ", weight=" + weight + "]";
		}
		
		
		
	 
		
		
		

}
