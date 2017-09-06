package com.shifeng.webapi.service.ware.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.ware.WareSkuDTO;
import com.shifeng.provide.mall.service.MallWareService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.ware.WareService;

/**
 * 
 * @author WinZhong
 *
 */
@Service("wareServiceImpl")
public class WareServiceImpl implements WareService{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    @Resource(name = "mallWareService")
    private MallWareService mallWareService;

	protected Logger logger = Logger.getLogger(this.getClass());
	

	
	/**
	 * 根据SKU获取商品基本信息和SKU信息
	 * @param sku
	 * @return
	 */
	public WareSkuDTO getWareSku(String sku) {
		try {
			ReqResponse<WareSkuDTO> result = mallWareService.getWareSku(sku);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【根据SKU获取商品基本信息和SKU信息】出错：", e);
		}
		return null;
	}

}
