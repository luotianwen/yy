package com.shifeng.op.card.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.card.Card;
import com.shifeng.plugin.page.Page;
/** 
 * 世峰e卡(c_card)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 13:38:19 
 */  
public interface CardService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Card> findAllCard(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Card findCardById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param card
	 * @throws Exception
	 */
	public void updateCard(Card card) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveCard(Card card) throws Exception;
    
	
	/**
	 * 获取当前最大批次号
	 */
	public int findMaxBatch() throws Exception;
	
	/**
	 * 世峰e卡发送短信
	 * @param sms
	 * @param map
	 * @throws Exception
	 */
	public void updateCardSMS(Card card,Map<String,Object> map) throws Exception;
	
}
