package com.shifeng.entity.search;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import com.shifeng.util.SolrUtils;

/**
 * 搜索参数实体
 * @author WinZhong
 *
 */
public class SearchParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//搜索关键字
	private String keyword = "*";
	//Filter value  过滤参数  商品属性值  多个用,号隔开  例：2,3
	private String fv;
	//分类 Category  id
	private String c;
	//品牌brand id
	private String b;
	//搜索排序（0：综合；1：销量；2：价格从低到高；3：价格从高到低）
	private int sort = 0;
	//请求客户端ip
	private String ip;
	//是否开启关键词高亮 默认关闭
	private boolean isHighlight = false;
	//按价格区间筛选 最低价
	private double start_price;
	//按价格区间筛选 最高价
	private double end_price;
	//是否自定义价格 默认关闭
	private boolean isCustomPrice = false;
	//是否需要筛选属性property（1：需要；2：否）不传默认1
	private int p = 1;
	
	/**
	 * 搜索关键字
	 * @return
	 */
	public String getKeyword() {
		return keyword;	
	}
	/**
	 * 搜索关键字
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		if(StringUtils.isBlank(keyword) || keyword == null){
			this.keyword =  "*";		
		}else{
			isHighlight = true;
			//转义特殊字符，防止注入
			this.keyword =  SolrUtils.escapeQueryChars(keyword.trim());
		}
	}
	/**
	 * Filter value  过滤参数  商品属性值  多个用,号隔开  例：2,3
	 * @return
	 */
	public String getFv() {
		return fv;
	}
	/**
	 * Filter value  过滤参数  商品属性值  多个用,号隔开  例：2,3
	 * @param fv
	 */
	public void setFv(String fv) {
		this.fv = fv;
	}
	/**
	 * 分类 Category id
	 * @return
	 */
	public String getC() {
		return c;
	}
	/**
	 * 分类 Category id
	 * @param c
	 */
	public void setC(String c) {
		this.c = c;
	}
	/**
	 * 搜索排序（0：综合；1：销量；2：价格从低到高；3：价格从高到低）
	 * @return
	 */
	public int getSort() {
		return sort;
	}
	/**
	 * 搜索排序（0：综合；1：销量；2：价格从低到高；3：价格从高到低）
	 * @param sort
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	/**
	 * 是否开启关键词高亮 默认关闭
	 * @return
	 */
	public boolean isHighlight() {
		return isHighlight;
	}
	/**
	 * 是否开启关键词高亮 默认关闭
	 * @param isHighlight
	 */
	public void setHighlight(boolean isHighlight) {
		this.isHighlight = isHighlight;
	}
	/**
	 * 品牌brand id
	 * @return
	 */
	public String getB() {
		return b;
	}
	/**
	 * 品牌brand id
	 * @param b
	 */
	public void setB(String b) {
		this.b = b;
	}
	
	/**
	 * 生成参数签名
	 * @return
	 */
	public String sign() {
		return DigestUtils.md5Hex(keyword+fv+c+b+sort);
	}
	/**
	 * 请求客户端ip
	 * @return
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 请求客户端ip
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 按价格区间筛选 最低价
	 * @return
	 */
	public double getStart_price() {
		return start_price;
	}
	/**
	 * 按价格区间筛选 最低价
	 * @param start_price
	 */
	public void setStart_price(double start_price) {
		if(start_price != 0.0){
			this.start_price = start_price;
			isCustomPrice =true;
		}
	}
	/**
	 * 按价格区间筛选 最高价
	 * @return
	 */
	public double getEnd_price() {
		return end_price;
	}
	/**
	 * 按价格区间筛选 最高价
	 * @param end_price
	 */
	public void setEnd_price(double end_price) {
		if(end_price != 0.0){
			this.end_price = end_price;
			isCustomPrice =true;
		}
	}
	/**
	 * 是否自定义价格 默认关闭
	 * @return
	 */
	public boolean isCustomPrice() {
		return isCustomPrice;
	}
	/**
	 * 是否自定义价格 默认关闭
	 * @param isCustomPrice
	 */
	public void setCustomPrice(boolean isCustomPrice) {
		//this.isCustomPrice = isCustomPrice;
	}
	/**
	 * 是否需要筛选属性property（1：需要；2：否）不传默认1
	 * @return
	 */
	public int getP() {
		return p;
	}
	/**
	 * 是否需要筛选属性property（1：需要；2：否）不传默认1
	 * @param p
	 */
	public void setP(int p) {
		this.p = p;
	}

	
	@Override
	public String toString() {
		return "SearchParameter [keyword=" + keyword + ", fv=" + fv + ", c=" + c + ", b=" + b + ", sort=" + sort
				+ ", ip=" + ip + ", isHighlight=" + isHighlight + ", start_price=" + start_price + ", end_price="
				+ end_price + ", isCustomPrice=" + isCustomPrice + ", p=" + p + "]";
	}
	
	
	
	
}
