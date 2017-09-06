package com.shifeng.seller.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductConsultationReplay;
import com.shifeng.seller.product.service.ProductConsultationReplayService;
import com.shifeng.plugin.page.Page;

/** 
 * 商品咨询回复(p_product_consultation_replay)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */  
@Service("productconsultationreplayServiceImpl")
public class ProductConsultationReplayServiceImpl implements ProductConsultationReplayService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 新增
	 * @param productconsultationreplay
	 * @throws Exception
	 */
	public void saveProductConsultationReplay(ProductConsultationReplay productconsultationreplay) throws Exception{
		dao.save("productconsultationreplayMapper.saveProductConsultationReplay", productconsultationreplay);
	}
}
