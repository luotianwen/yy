package com.shifeng.provide.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.provide.mall.dao.MallFreightDao;
import com.shifeng.provide.mall.service.MallFreightService;
import com.shifeng.response.ReqResponse;

/**
 * 商城运费模板
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class MallFreightServiceImpl implements MallFreightService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallFreightDao")
	private MallFreightDao mallFreightDao;


	/**
	 * 获取商品运费
	 * @param wareList 商品列表
	 * @param cityId 到达城市ID
	 * @return
	 */
	public ReqResponse<List<MallShopWareFreight>> getWareFreights(List<OrderWareDTO> wareList,String cityId) {
		ReqResponse<List<MallShopWareFreight>> req = new ReqResponse<List<MallShopWareFreight>>();
		try {
			mallFreightDao.getWareFreights(wareList,cityId,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取商品运费】出错：", e);
			req.setCode(1);
			req.setMsg("【获取商品运费】异常");
			return req;
		}
	}


}
