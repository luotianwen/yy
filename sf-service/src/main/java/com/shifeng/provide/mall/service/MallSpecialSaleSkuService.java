package com.shifeng.provide.mall.service;

import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/**
 * 商城特卖sku
 * @author WinZhong
 *
 */
public interface MallSpecialSaleSkuService {
	
	/**
	 * 获取特卖商品列表
	 * @param cid 分类ID
	 * @param sort 排序（0：综合；1：价格从低到高；2：价格从高到低；3：折扣从低到高；4：折扣从高到低）
	 * @return
	 */
	ReqResponse<Page> getSpecialSaleSku(String cid,String sort,int currentPage);
	
	
	

}
