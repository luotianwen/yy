package com.shifeng.provide.mall.service;

import com.shifeng.dto.mall.shop.ShopInfoDTO;
import com.shifeng.response.ReqResponse;

public interface MallShopService {

	/**
	 * 获取店铺基本信息
	 * @param shopid
	 * @return
	 */
	ReqResponse<ShopInfoDTO> getShopInfo(String shopid);
}
