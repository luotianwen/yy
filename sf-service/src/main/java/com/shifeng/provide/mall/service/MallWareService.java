package com.shifeng.provide.mall.service;

import com.shifeng.dto.mall.ware.SkusDTO;
import com.shifeng.dto.mall.ware.WareSkuDTO;
import com.shifeng.response.ReqResponse;

/**
 * 商城商品
 * @author WinZhong
 *
 */
public interface MallWareService {
	
	
	/**
	 * 根据SKU获取商品基本信息和SKU信息
	 * @return
	 */
	ReqResponse<WareSkuDTO> getWareSku(String sku);
	
	
	/**
	 * 根据商品ID获取商品SKU列表信息
	 * @return
	 */
	ReqResponse<SkusDTO> getSkuList(String pid);
	
	

}
