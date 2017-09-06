package com.shifeng.provide.mall.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.ware.WareSkuDTO;
import com.shifeng.response.ReqResponse;

@Service("mallWareDao")
public class MallWareDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

 

	/**
	 * 根据SKU获取商品基本信息和SKU信息
	 * @param sku
	 * @param req
	 * @throws Exception 
	 */
	public void getWareSku(String sku, ReqResponse<WareSkuDTO> req) throws Exception {
		WareSkuDTO wareSku = (WareSkuDTO)dao.findForObject("mallWareMapper.getWareSku", sku);
		req.setData(wareSku);
	}

}
