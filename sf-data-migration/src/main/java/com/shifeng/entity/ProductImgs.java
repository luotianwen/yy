package com.shifeng.entity;

public class ProductImgs {
	// 商品id
	private String pid;
	// 图片路径 | 分割
	private String iPath;
	// 图片颜色 | 分割
	private String iColor;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getiPath() {
		return iPath;
	}
	public void setiPath(String iPath) {
		this.iPath = iPath;
	}
	public String getiColor() {
		return iColor;
	}
	public void setiColor(String iColor) {
		this.iColor = iColor;
	}
	@Override
	public String toString() {
		return "ProductImgs [pid=" + pid + ", iPath=" + iPath + ", iColor=" + iColor + "]";
	}
	 
	
	

}
