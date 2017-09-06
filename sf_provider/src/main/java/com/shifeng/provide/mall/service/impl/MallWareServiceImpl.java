package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.ware.SkusDTO;
import com.shifeng.dto.mall.ware.WareSkuDTO;
import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.provide.mall.dao.MallWareDao;
import com.shifeng.provide.mall.service.MallWareService;
import com.shifeng.response.ReqResponse;

/**
 * 商城商品
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class MallWareServiceImpl implements MallWareService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallWareDao")
	private MallWareDao mallWareDao;
	
	
	/**
	 * 根据SKU获取商品基本信息和SKU信息
	 * @return
	 */
	public ReqResponse<WareSkuDTO> getWareSku(String sku) {
		ReqResponse<WareSkuDTO> req = new ReqResponse<WareSkuDTO>();
		try {
			mallWareDao.getWareSku(sku,req);
			return req;
		} catch (Exception e) {
			logger.error("【根据SKU获取商品基本信息和SKU信息】出错：", e);
			req.setCode(1);
			req.setMsg("【根据SKU获取商品基本信息和SKU信息】异常");
			return req;
		}
	}
	
	
	/**
	 * 根据商品ID获取商品SKU列表信息
	 * @return
	 */
	public ReqResponse<SkusDTO> getSkuList(String pid) {
		return null;
	}
	
	

}
