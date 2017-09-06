package com.shifeng.provide.mall.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.shop.ShopInfoDTO;
import com.shifeng.response.ReqResponse;

@Service("mallShopDao")
public class MallShopDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 获取店铺基本信息
	 * @param shopid
	 * @param req
	 * @throws Exception 
	 */
	public void getShopInfo(String shopid, ReqResponse<ShopInfoDTO> req) throws Exception {
		ShopInfoDTO shopInfo = (ShopInfoDTO)dao.findForObject("mallShopinfoMapper.findShopinfoById", shopid);
		req.setData(shopInfo);
	}

}
