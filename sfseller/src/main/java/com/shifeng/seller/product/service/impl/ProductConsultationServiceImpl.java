package com.shifeng.seller.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductConsultation;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.product.dto.ProductConsultationDTO;
import com.shifeng.seller.product.service.ProductConsultationService;

/** 
 * 商品咨询(p_product_consultation)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */  
@Service("productconsultationServiceImpl")
public class ProductConsultationServiceImpl implements ProductConsultationService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductConsultationDTO> findAllProductConsultation(Page page) throws Exception{
		return (List<ProductConsultationDTO>) dao.findForList("productconsultationMapper.findAllProductConsultationPage", page);
	}
	
	/**
	 * 修改
	 * @param productconsultation
	 * @throws Exception
	 */
	public void updateProductConsultation(ProductConsultation productconsultation) throws Exception{
		dao.update("productconsultationMapper.updateProductConsultation", productconsultation);
	}
	
}
