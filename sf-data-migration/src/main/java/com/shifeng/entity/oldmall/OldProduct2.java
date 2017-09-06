package com.shifeng.entity.oldmall;

import java.text.DecimalFormat;

public class OldProduct2 {
	// sku id
	private String sku;
	// 商品id
	private String pid;
	// 世峰价
	private double price;
	// 库存
	private String stocks;
	// 商品市场价格
	private double pMarketPrice;
	// 商品编号
	private String pNumber;
	// 商品名称
	private String pName;
 	//商品颜色
 	 private String color;
	//商品规格
 	 private String spec;
	// 状态（0：下架；1：上架）
	private String pState;
	// 图片路径 | 分割
	private String iPath;
	// 图片颜色 | 分割
	private String iColor;
	// 店铺id
	private int shop_id;
	// 店铺名称
	private String sShopName;
	
	DecimalFormat df = new DecimalFormat("######0.00");
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPrice() {
		return df.format(price);
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStocks() {
		return stocks;
	}
	public void setStocks(String stocks) {
		this.stocks = stocks;
	}
	public String getpMarketPrice() {
		return df.format(pMarketPrice);
	}
	public void setpMarketPrice(double pMarketPrice) {
		this.pMarketPrice = pMarketPrice;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpState() {
		return pState;
	}
	public void setpState(String pState) {
		this.pState = pState;
	}
	public String getiPath() {
		System.out.println(iPath);
		System.out.println(iColor);
		if(iPath != null && !"-1".equals(iColor)){
			String[] c = iColor.split("\\|");
			int wz = c.length-1;
			for(int i = 0;i<wz;i++){
				if(color.equals(c[i])){
					wz = i;
					break;
				}
			}
			return "http://seebong-hangzhou.oss-cn-hangzhou.aliyuncs.com/"+iPath.split("\\|")[wz];
		}
		return "http://seebong-hangzhou.oss-cn-hangzhou.aliyuncs.com/"+iPath;
	}
	public void setiPath(String iPath) {
		this.iPath = iPath;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getsShopName() {
		return sShopName;
	}
	public void setsShopName(String sShopName) {
		this.sShopName = sShopName;
	}

    /**
    *商品颜色
	* @return
    */ 
	public String getColor() {
		return color;
	}
    /**
    *商品颜色
	* @param type
    */ 
	public void setColor(String color) {
		this.color = color;
	}
    /**
    *商品规格
	* @return
    */ 
	public String getSpec() {
		return spec;
	}
    /**
    *商品规格
	* @param type
    */ 
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getiColor() {
		return iColor;
	}
	public void setiColor(String iColor) {
		this.iColor = iColor;
	}
	@Override
	public String toString() {
		return "Product [sku=" + sku + ", pid=" + pid + ", price=" + price + ", stocks=" + stocks + ", pMarketPrice="
				+ pMarketPrice + ", pNumber=" + pNumber + ", pName=" + pName + ", color=" + color + ", spec=" + spec
				+ ", pState=" + pState + ", iPath=" + iPath + ", iColor=" + iColor + ", shop_id=" + shop_id
				+ ", sShopName=" + sShopName + ", df=" + df + "]";
	}
	
	
	

}
