package com.shifeng.provide.product.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.provide.product.service.ProRulesService;

/** 
 * SKU表(p_pro_rules)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-17 13:40:55 
 */  
@Service(timeout=1200000)
public class ProRulesServiceImpl implements ProRulesService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	 
	
	
}
