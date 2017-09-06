package com.shifeng.seller.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductEvaluateReplay;
import com.shifeng.seller.product.service.ProductEvaluateReplayService;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价回复(p_product_evaluate_replay)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */  
@Service("productevaluatereplayServiceImpl")
public class ProductEvaluateReplayServiceImpl implements ProductEvaluateReplayService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 新增
	 * @param productevaluatereplay
	 * @throws Exception
	 */
	public void saveProductEvaluateReplay(ProductEvaluateReplay productevaluatereplay) throws Exception{
		dao.save("productevaluatereplayMapper.saveProductEvaluateReplay", productevaluatereplay);
	}
	
}
