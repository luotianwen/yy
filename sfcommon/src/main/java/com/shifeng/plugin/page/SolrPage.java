package com.shifeng.plugin.page;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shifeng.dto.mall.brand.BrandDTO;
import com.shifeng.dto.mall.property.PropertyDTO;

import java.util.List;

/**
 * 
*    
* 项目名称：mall-search
* 类名称：SolrPage   
* 类描述： Solr分页封装函数
* 创建人：Win Zhong   
* 修改备注：
* @version    
 */
public class SolrPage {
	/**
	 * 分页数据
	 */
	private Object result;
	
	/**
	 * 筛选属性列表
	 */
	private List<PropertyDTO> propertyList;
	
	/**
	 * 品牌列表
	 */
	private List<BrandDTO> brandList;

	/**
	 * 总页数 这个数是计算出来的
	 * 
	 */
	private long pageCount;

	/**
	 * 每页显示几条记录
	 */
	@JsonIgnore
	@JSONField(serialize=false)
	private int pageSize = 10;

	/**
	 * 默认 当前页 为第一页 这个数是计算出来的
	 */
	private int pageNow = 1;

	/**
	 * 总记录数
	 */
	private long rowCount;

	/**
	 * 从第几条记录开始
	 */
	@JsonIgnore
	@JSONField(serialize=false)
	private int startPage = 1;


	public SolrPage() {
	}

	/**
	 * 要获得记录的开始索引　即　开始页码
	 * 
	 * @return
	 */
	@JsonIgnore
	@JSONField(serialize=false)
	public int getFirstResult() {
		return (this.pageNow - 1) * this.pageSize;
	}


	/**
	 * 使用构造函数，，强制必需输入 每页显示数量　和　当前页
	 * 
	 * @param pageSize
	 *            　　每页显示数量
	 * @param pageNow
	 *            　当前页
	 */
	public SolrPage(int pageSize, int pageNow) {
		this.pageSize = pageSize;
		this.pageNow = pageNow;
	}

	/**
	 * 使用构造函数，，强制必需输入 当前页
	 * 
	 * @param pageNow
	 *            　当前页
	 */
	public SolrPage(int pageNow) {
		this.pageNow = pageNow;
		startPage = (this.pageNow - 1) * this.pageSize;
	}

	/**
	 * 查询结果方法 把　记录数　结果集合　放入到　SolrPage对象
	 * 
	 * @param rowCount
	 *            总记录数
	 * @param result
	 *            结果集合
	 */

	public void setQueryResult(long rowCount, Object result) {
		setRowCount(rowCount);
		setResult(result);
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
		setPageCount(this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1);
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public void setPage(int page) {
		this.pageNow = page;
	}

	public long getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	
	

	public List<PropertyDTO> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<PropertyDTO> propertyList) {
		this.propertyList = propertyList;
	}

	public List<BrandDTO> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<BrandDTO> brandList) {
		this.brandList = brandList;
	}

	@Override
	public String toString() {
		return "SolrPage [result=" + result + ", propertyList=" + propertyList + ", brandList=" + brandList
				+ ", pageCount=" + pageCount + ", pageSize=" + pageSize + ", pageNow=" + pageNow + ", rowCount="
				+ rowCount + ", startPage=" + startPage + "]";
	}

}
