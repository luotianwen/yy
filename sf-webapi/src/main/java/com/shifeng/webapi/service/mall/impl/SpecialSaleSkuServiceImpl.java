package com.shifeng.webapi.service.mall.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.MallUserInvoiceDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.service.MallSpecialSaleSkuService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.mall.SpecialSaleSkuService;

/**
 * 商城特卖sku
 * @author WinZhong
 *
 */
@Service("specialSaleSkuService")
public class SpecialSaleSkuServiceImpl implements SpecialSaleSkuService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallSpecialSaleSkuService")
	protected MallSpecialSaleSkuService mallSpecialSaleSkuService;
	
	/**
	 * 获取特卖商品列表
	 * @param cid 分类ID
	 * @param sort 排序（0：综合；1：价格从低到高；2：价格从高到低；3：折扣从低到高；4：折扣从高到低）
	 * @return
	 */
	public Page getSpecialSaleWareList(String cid,String sort,int currentPage) {
		try {
			ReqResponse<Page> result = mallSpecialSaleSkuService.getSpecialSaleSku(cid, sort, currentPage);
			if(result.getCode() == 0){
					return result.getData();
			}
		} catch (Exception e) {
			logger.error("【 获取特卖商品列表】出错：", e);
		}
		return null;
	}
	
	
	

}
