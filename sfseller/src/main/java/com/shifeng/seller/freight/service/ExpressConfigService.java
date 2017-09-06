package com.shifeng.seller.freight.service;

import java.util.List;
import com.shifeng.entity.freight.ExpressConfig;
import com.shifeng.plugin.page.Page;

/** 
 * 快递配置(o_expressConfig)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:40:52 
 */  
public interface ExpressConfigService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ExpressConfig> findAllExpressConfig() throws Exception;
	
}
