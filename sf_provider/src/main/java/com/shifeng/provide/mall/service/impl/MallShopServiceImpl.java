package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.shop.ShopInfoDTO;
import com.shifeng.provide.mall.dao.MallShopDao;
import com.shifeng.provide.mall.service.MallShopService;
import com.shifeng.response.ReqResponse;

@Service(timeout=1200000)
public class MallShopServiceImpl implements MallShopService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallShopDao")
	private MallShopDao mallShopDao;

	/**
	 * 获取店铺基本信息
	 * @param shopid
	 * @return
	 */
	public ReqResponse<ShopInfoDTO> getShopInfo(String shopid) {
		ReqResponse<ShopInfoDTO> req = new ReqResponse<ShopInfoDTO>();
		try {
			mallShopDao.getShopInfo(shopid,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取店铺基本信息】出错：", e);
			req.setCode(1);
			req.setMsg("【获取店铺基本信息】异常");
			return req;
		}
	}
	
	
}
