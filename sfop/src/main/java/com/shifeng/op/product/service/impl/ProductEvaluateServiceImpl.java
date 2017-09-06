package com.shifeng.op.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductEvaluate;
import com.shifeng.op.dto.product.ProductEvaluateDTO;
import com.shifeng.op.product.service.ProductEvaluateService;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价(p_product_evaluate)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:52 
 */  
@Service("productevaluateServiceImpl")
public class ProductEvaluateServiceImpl implements ProductEvaluateService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductEvaluateDTO> findAllProductEvaluate(Page page) throws Exception{
		return (List<ProductEvaluateDTO>) dao.findForList("productevaluateMapper.findAllProductEvaluatePage", page);
	}
	
	/**
	 * 修改
	 * @param productevaluate
	 * @throws Exception
	 */
	public void updateProductEvaluate(ProductEvaluate productevaluate) throws Exception{
		dao.update("productevaluateMapper.updateProductEvaluate", productevaluate);
	}
	
}
