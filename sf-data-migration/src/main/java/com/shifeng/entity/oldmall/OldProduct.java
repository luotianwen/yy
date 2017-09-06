package com.shifeng.entity.oldmall;

public class OldProduct {
 
	// 商品id
	private String pid;
	// 商品名称
	private String pName;
	//品牌名称
	private String brandName;
	//商品描述
	private String pDescribe;
	//商品参数
	private String pParameter;
	//包装清单
	private String pListing;
	//长
	private String pLength;
	//宽
	private String pWidth;
	//高
	private String pHighly;
	//商品副标题
	private String pGoodsSubTitle;
	//是否7天无理由退换货
	private String isSevenReturn;
	
	
	
	
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getpDescribe() {
		return pDescribe;
	}
	public void setpDescribe(String pDescribe) {
		this.pDescribe = pDescribe;
	}
	public String getpParameter() {
		return pParameter;
	}
	public void setpParameter(String pParameter) {
		this.pParameter = pParameter;
	}
	public String getpListing() {
		return pListing;
	}
	public void setpListing(String pListing) {
		this.pListing = pListing;
	}
	public String getpLength() {
		return pLength;
	}
	public void setpLength(String pLength) {
		this.pLength = pLength;
	}
	public String getpWidth() {
		return pWidth;
	}
	public void setpWidth(String pWidth) {
		this.pWidth = pWidth;
	}
	public String getpHighly() {
		return pHighly;
	}
	public void setpHighly(String pHighly) {
		this.pHighly = pHighly;
	}
	public String getpGoodsSubTitle() {
		return pGoodsSubTitle;
	}
	public void setpGoodsSubTitle(String pGoodsSubTitle) {
		this.pGoodsSubTitle = pGoodsSubTitle;
	}
	public String getIsSevenReturn() {
		return isSevenReturn;
	}
	public void setIsSevenReturn(String isSevenReturn) {
		this.isSevenReturn = isSevenReturn;
	}
	@Override
	public String toString() {
		return "OldProduct [pid=" + pid + ", pName=" + pName + ", brandName=" + brandName + ", pDescribe=" + pDescribe
				+ ", pParameter=" + pParameter + ", pListing=" + pListing + ", pLength=" + pLength + ", pWidth="
				+ pWidth + ", pHighly=" + pHighly + ", pGoodsSubTitle=" + pGoodsSubTitle + ", isSevenReturn="
				+ isSevenReturn + "]";
	}
	 
	
	 
	

}
