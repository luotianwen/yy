package com.shifeng.webapi.service.mall;

import java.util.List;

import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.response.ReqResponse;

/**
 * 商城运费模板
 * @author WinZhong
 *
 */

public interface FreightService {


	/**
	 * 获取商品运费
	 * @param wareList 商品列表
	 * @param cityId 到达城市ID
	 * @return
	 */
	List<MallShopWareFreight> getWareFreights(List<OrderWareDTO> wareList,String cityId);
	

}
