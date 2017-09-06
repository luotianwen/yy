package com.shifeng.webapi.service.search.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.TermsResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.GroupParams;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.ware.HotWareDTO;
import com.shifeng.dto.ware.WareDTO;
import com.shifeng.dto.ware.WareSkuDTO;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.entity.search.SkuInfo;
import com.shifeng.entity.search.Suggest;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.provide.search.MallSearchService;
import com.shifeng.util.MapTurnBean;
import com.shifeng.util.PinYinUtil;
import com.shifeng.util.SolrUtils;
import com.shifeng.webapi.service.search.SearchService;
import com.shifeng.webapi.solr.MyHttpSolrClient;

/**
 * 
 * @author WinZhong
 *
 */
@Service("searchServiceImpl")
public class SearchServiceImpl implements SearchService{

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
	

	
	/**
	 * 获取店铺最热商品
	 * @param shopid 店铺id
	 * @return
	 */
	public List<HotWareDTO> getShopHotWare(int shopid) {
		return mallSearchService.getShopHotWare(shopid);
	}

}
