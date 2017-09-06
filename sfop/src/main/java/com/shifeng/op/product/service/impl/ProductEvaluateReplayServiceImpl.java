package com.shifeng.op.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductEvaluateReplay;
import com.shifeng.op.product.service.ProductEvaluateReplayService;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价回复(p_product_evaluate_replay)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:53 
 */  
@Service("productevaluatereplayServiceImpl")
public class ProductEvaluateReplayServiceImpl implements ProductEvaluateReplayService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductEvaluateReplay> findAllProductEvaluateReplay(Page page) throws Exception{
		return (List<ProductEvaluateReplay>) dao.findForList("productevaluatereplayMapper.findAllProductEvaluateReplayPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ProductEvaluateReplay findProductEvaluateReplayById(String id) throws Exception{
		return (ProductEvaluateReplay) dao.findForObject("productevaluatereplayMapper.findProductEvaluateReplayById", id);
	}
	
	/**
	 * 新增
	 * @param productevaluatereplay
	 * @throws Exception
	 */
	public void saveProductEvaluateReplay(ProductEvaluateReplay productevaluatereplay) throws Exception{
		dao.save("productevaluatereplayMapper.saveProductEvaluateReplay", productevaluatereplay);
	}
	
	/**
	 * 修改
	 * @param productevaluatereplay
	 * @throws Exception
	 */
	public void updateProductEvaluateReplay(ProductEvaluateReplay productevaluatereplay) throws Exception{
		dao.update("productevaluatereplayMapper.updateProductEvaluateReplay", productevaluatereplay);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductEvaluateReplay(String id) throws Exception{
		dao.delete("productevaluatereplayMapper.deleteProductEvaluateReplay", id);
	}
	
}
