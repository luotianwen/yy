package com.shifeng.webapi.service.ware;

import com.shifeng.dto.mall.ware.WareSkuDTO;

public interface WareService {
	
	/**
	 * 根据SKU获取商品基本信息和SKU信息
	 * @param sku
	 * @return
	 */
	WareSkuDTO getWareSku(String sku);

}
