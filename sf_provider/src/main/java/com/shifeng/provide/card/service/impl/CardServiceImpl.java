package com.shifeng.provide.card.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.shifeng.provide.card.dao.CardDao;

/**
 * 分销提现接口
 * @author sen
 *
 */
public class CardServiceImpl {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "cardDao")
	private CardDao cardDao;
	
	 
}
