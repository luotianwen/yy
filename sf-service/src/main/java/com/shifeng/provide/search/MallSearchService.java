package com.shifeng.provide.search;

import java.util.List;

import com.shifeng.dto.mall.MallSpecialSaleSkuDTO;
import com.shifeng.dto.ware.HotWareDTO;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.entity.search.SkuInfo;
import com.shifeng.entity.search.Suggest;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.plugin.page.SolrPage;

public interface MallSearchService {
	
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
	 * 商品店铺搜索
	 * @param shopId 店铺ID
	 * @param searchParameter 搜索参数
	 * @param page	分页参数
	 * @return
	 */
	SolrPage searchShopWare(String shopId,SearchParameter searchParameter, SolrPage page);
	
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
	 * 获取店铺最热商品
	 * @param shopid 店铺id
	 * @return
	 */
	List<HotWareDTO> getShopHotWare(int shopid);

	
	/**
	 * 获取特卖商品
	 * @param searchParameter
	 * @param page
	 * @return
	 */
	/*List<MallSpecialSaleSkuDTO> getSpecialSaleSku(SearchParameter searchParameter, SolrPage page);*/
	
	
}
