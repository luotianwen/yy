package com.shifeng.seller.freight.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.freight.ExpressConfig;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.freight.service.ExpressConfigService;

/** 
 * 快递配置(o_expressConfig)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:40:52 
 */  
@Service("expressConfigServiceImpl")
public class ExpressConfigServiceImpl implements ExpressConfigService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ExpressConfig> findAllExpressConfig() throws Exception{
		return (List<ExpressConfig>) dao.findForList("expressConfigMapper.findAllExpressConfig");
	}
	
}
