package com.shifeng.op.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductConsultationReplay;
import com.shifeng.op.product.service.ProductConsultationReplayService;
import com.shifeng.plugin.page.Page;

/** 
 * 商品咨询回复(p_product_consultation_replay)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:53 
 */  
@Service("productconsultationreplayServiceImpl")
public class ProductConsultationReplayServiceImpl implements ProductConsultationReplayService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductConsultationReplay> findAllProductConsultationReplay(Page page) throws Exception{
		return (List<ProductConsultationReplay>) dao.findForList("productconsultationreplayMapper.findAllProductConsultationReplayPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ProductConsultationReplay findProductConsultationReplayById(String id) throws Exception{
		return (ProductConsultationReplay) dao.findForObject("productconsultationreplayMapper.findProductConsultationReplayById", id);
	}
	
	/**
	 * 新增
	 * @param productconsultationreplay
	 * @throws Exception
	 */
	public void saveProductConsultationReplay(ProductConsultationReplay productconsultationreplay) throws Exception{
		dao.save("productconsultationreplayMapper.saveProductConsultationReplay", productconsultationreplay);
	}
	
	/**
	 * 修改
	 * @param productconsultationreplay
	 * @throws Exception
	 */
	public void updateProductConsultationReplay(ProductConsultationReplay productconsultationreplay) throws Exception{
		dao.update("productconsultationreplayMapper.updateProductConsultationReplay", productconsultationreplay);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductConsultationReplay(String id) throws Exception{
		dao.delete("productconsultationreplayMapper.deleteProductConsultationReplay", id);
	}
	
}
