package com.shifeng.webapi.service.mall.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.provide.mall.service.MallFreightService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.mall.FreightService;

/**
 * 商城运费模板
 * @author WinZhong
 *
 */
@Service("freightServiceImpl")
public class FreightServiceImpl implements FreightService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallFreightService")
	protected MallFreightService mallFreightService;


	/**
	 * 获取商品运费
	 * @param wareList 商品列表
	 * @param cityId 到达城市ID
	 * @return
	 */
	public List<MallShopWareFreight> getWareFreights(List<OrderWareDTO> wareList,String cityId) {
		try {
			ReqResponse<List<MallShopWareFreight>> result = mallFreightService.getWareFreights(wareList,cityId);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取商品运费】出错：", e);
		}
		return null;
	}
	

}
