package com.shifeng.mall.search.service;

import com.shifeng.entity.search.SearchParameter;
import com.shifeng.entity.search.SkuInfo;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.entity.search.Suggest;
import com.shifeng.plugin.page.SolrPage;

import java.util.List;

public interface SearchService {

	/**
	 * 关键词提示
	 * @param keyword
	 * @return
	 * @
	 */
	List<Suggest> suggest(String keyword);

	/**
	 * 商品搜索
	 * @param searchParameter 搜索参数
	 * @param page	分页参数
	 * @return
	 */
	SolrPage searchWare(SearchParameter searchParameter, SolrPage page);

	/**
	 * 获取商品sku详情
	 * @param sku 商品sku
	 * @return
	 */
	WareSkuInfo getWareSkuInfo(String sku);

	/**
	 * 获取商品SKU列表
	 * @param pid 商品id
	 * @return
	 */
	List<SkuInfo> getSkuInfo(String pid);
	/**
	 * 商品店铺搜索
	 * @param shopId 店铺ID
	 * @param searchParameter 搜索参数
	 * @param page	分页参数
	 * @return
	 */
	SolrPage searchShopWare(String shopId,SearchParameter searchParameter, SolrPage page);
}
