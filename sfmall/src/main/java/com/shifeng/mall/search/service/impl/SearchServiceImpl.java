package com.shifeng.mall.search.service.impl;


import com.shifeng.entity.search.SearchParameter;
import com.shifeng.entity.search.SkuInfo;
import com.shifeng.entity.search.Suggest;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.mall.search.service.SearchService;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.provide.search.MallSearchService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * 
 * @author WinZhong
 *
 */
@Service("searchServiceImpl")
public class SearchServiceImpl implements SearchService {

	@Resource(name = "mallSearchService")
	private MallSearchService mallSearchService;


	protected Logger logger = Logger.getLogger(this.getClass());


	/**
	 * 关键词提示
	 * @param keyword
	 * @return
	 * @
	 */
	public List<Suggest> suggest(String keyword) {
		return mallSearchService.suggest(keyword);
	}


	/**
	 * 商品搜索
	 * @param searchParameter 搜索参数
	 * @param page	分页参数
	 * @return
	 */
	public SolrPage searchWare(SearchParameter searchParameter, SolrPage page) {

		return mallSearchService.searchWare(searchParameter, page);
	}



	/**
	 * 获取商品sku详情
	 * @param sku 商品sku
	 * @return
	 */
	public WareSkuInfo getWareSkuInfo(String sku) {

		return mallSearchService.getWareSkuInfo(sku);
	}



	/**
	 * 获取商品SKU列表
	 * @param pid 商品id
	 * @return
	 */
	public List<SkuInfo> getSkuInfo(String pid) {

		return mallSearchService.getSkuInfo(pid);
	}

	@Override
	public SolrPage searchShopWare(String shopId, SearchParameter searchParameter, SolrPage page) {
		return mallSearchService.searchShopWare(shopId,searchParameter,page);
	}


}
