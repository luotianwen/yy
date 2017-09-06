package com.shifeng.op.card.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.card.Card;
import com.shifeng.op.card.service.CardService;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.ali.service.AliService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.GenerateCode;

/** 
 * 世峰e卡(c_card)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 13:38:19 
 */  
@Service("cardServiceImpl")
public class CardServiceImpl implements CardService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	@Resource(name = "aliService")
	private AliService aliService;
	
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Card> findAllCard(Page page) throws Exception{
		return (List<Card>) dao.findForList("cardMapper.findAllCardPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Card findCardById(String id) throws Exception{
		return (Card) dao.findForObject("cardMapper.findCardById", id);
	}
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveCard(Card card) throws Exception{
		List<Card> list = new ArrayList<Card>();
		if(Const.CARDBATCH==0){
			Const.CARDBATCH = findMaxBatch();
		}
		Const.CARDBATCH++;
		for(int i=0,len=card.getCount();i<len;i++){
			Card newCard = new Card();
			
			String number = i+1+Const.CARDBATCH*1000+"";
			while(number.length()<8)
				number = "0"+number;
			
			newCard.setNumber(number);
			newCard.setBatch(Const.CARDBATCH);
			newCard.setRemark(card.getRemark());
			newCard.setPassword(GenerateCode.genCodes(8));
			newCard.setSdate(card.getSdate());
			newCard.setEdate(card.getEdate()+" 23:59:59");
			newCard.setMoney(card.getMoney());
			newCard.setUserid(card.getUserid());
			
			list.add(newCard);
			
			if(list.size()>=100){
				dao.save("cardMapper.saveCard", list);
				list.clear();
			}
		}
		
		if(list.size()>0){
			dao.save("cardMapper.saveCard", list);
		}
		
	}
	
	/**
	 * 修改
	 * @param card
	 * @throws Exception
	 */
	public void updateCard(Card card) throws Exception{
		dao.update("cardMapper.updateCard", card);
	}
	
	/**
	 * 获取当前最大批次号
	 */
	public int findMaxBatch() throws Exception{
		String number = (String)dao.findForObject("cardMapper.findMaxBatch");
		if(StringUtils.isEmpty(number)){
			return 0;
		}else{
			return Integer.valueOf(number);
		}
	}
	
	/**
	 * 世峰e卡发送短信
	 * @param sms
	 * @param map
	 * @throws Exception
	 */
	public void updateCardSMS(Card card,Map<String,Object> map) throws Exception{
		Card nCard = (Card) dao.findForObject("cardMapper.findCardById", card.getNumber());
		
		if(1!=nCard.getStatus()){
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "该e卡已被绑定或作废，无法发送给用户！");
			return;
		}
		
		ReqResponse<Integer> req = aliService.sendSMS(card.getPhone(), "{\"number\":\""+card.getNumber()+"\",\"password\":\""+nCard.getPassword()+"\"}", "SMS_39225092");
		if(req.getCode()==0){
			card.setSendstatus(2);
			dao.findForObject("cardMapper.updateCardSMS",card);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			card.setSendstatus(3);
			dao.findForObject("cardMapper.updateCardSMS",card);
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "短信发送失败！");
		}
	}
	
}
