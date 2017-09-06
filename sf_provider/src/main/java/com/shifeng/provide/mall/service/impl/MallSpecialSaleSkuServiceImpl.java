package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.dao.MallSpecialSaleSkuDao;
import com.shifeng.provide.mall.service.MallSpecialSaleSkuService;
import com.shifeng.response.ReqResponse;

/**
 * 商城特卖sku
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class MallSpecialSaleSkuServiceImpl implements MallSpecialSaleSkuService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallSpecialSaleSkuDao")
	private MallSpecialSaleSkuDao mallSpecialSaleSkuDao;
	
	/**
	 * 获取特卖商品列表
	 * @param cid 分类ID
	 * @param sort 排序（0：综合；1：价格从低到高；2：价格从高到低；3：折扣从低到高；4：折扣从高到低）
	 * @return
	 */
	public ReqResponse<Page> getSpecialSaleSku(String cid,String sort,int currentPage) {
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallSpecialSaleSkuDao.getSpecialSaleSku(cid, sort,currentPage, req);
			return req;
		} catch (Exception e) {
			logger.error("【获取特卖商品列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取特卖商品列表】异常");
			return req;
		}
	}
	
	
	

}
