package com.shifeng.webapi.service.shop;

import com.shifeng.dto.mall.shop.ShopInfoDTO;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.plugin.page.SolrPage;

public interface ShopService {

	/**
	 * 获取店铺基本信息
	 * @param shopid
	 * @return
	 */
	ShopInfoDTO getShopInfo(String shopid);

	/**
	 * 商品店铺搜索
	 * @param shopId 店铺ID
	 * @param searchParameter 搜索参数
	 * @param page	分页参数
	 * @return
	 */
	SolrPage searchShopWare(String shopid, SearchParameter searchParameter, SolrPage page);
	
	
	

}
