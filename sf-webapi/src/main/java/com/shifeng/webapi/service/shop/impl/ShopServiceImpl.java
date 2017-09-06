package com.shifeng.webapi.service.shop.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.shop.ShopInfoDTO;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.provide.mall.service.MallShopService;
import com.shifeng.provide.search.MallSearchService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.shop.ShopService;

/**
 * 
 * @author WinZhong
 *
 */
@Service("shopServiceImpl")
public class ShopServiceImpl implements ShopService{

    @Resource(name = "mallShopService")
    private MallShopService mallShopService;

    @Resource(name = "mallSearchService")
    private MallSearchService mallSearchService;

	protected Logger logger = Logger.getLogger(this.getClass());
	


	/**
	 * 获取店铺基本信息
	 * @param shopid
	 * @return
	 */
	public ShopInfoDTO getShopInfo(String shopid) {
		try {
			ReqResponse<ShopInfoDTO> result = mallShopService.getShopInfo(shopid);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取店铺基本信息】出错：", e);
		}
		return null;
	}


	/**
	 * 商品店铺搜索
	 * @param shopId 店铺ID
	 * @param searchParameter 搜索参数
	 * @param page	分页参数
	 * @return
	 */
	public SolrPage searchShopWare(String shopid, SearchParameter searchParameter, SolrPage page) {
		return mallSearchService.searchShopWare(shopid, searchParameter, page);
	}
	
	
}
