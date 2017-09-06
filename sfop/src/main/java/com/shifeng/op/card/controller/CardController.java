package com.shifeng.op.card.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.card.Card;
import com.shifeng.op.card.service.CardService;
import com.shifeng.op.dto.card.Orderby;
import com.shifeng.op.dto.card.SearchCardDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
/** 
 * 世峰e卡(c_card)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 13:38:19 
 */ 
@Controller
@RequestMapping(value="/card")
public class CardController{
	
	@Resource(name="cardServiceImpl")
	private CardService cardServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCardList")
	public ModelAndView goCardList(ModelAndView mv) throws Exception{
		mv.setViewName("card/cardList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllCard")
	@ResponseBody
	public Map<String,Object> findAllCard(Page<SearchCardDTO> page,SearchCardDTO dto) throws Exception{
		if(dto==null){
			dto = new SearchCardDTO();
			Orderby orderby = new Orderby();
			dto.setOrderby(orderby);
			page.setT(dto);
		}else{
			if(dto.getOrderby()==null){
				Orderby orderby = new Orderby();
				dto.setOrderby(orderby);
			}
			page.setT(dto);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Card> cards = cardServiceImpl.findAllCard(page);
		map.put("cards", cards);
		map.put("page", page);
		return map;
	}
 
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCardEdit")
	@ResponseBody
	public ModelAndView goCardEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("card/cardEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCardById")
	@ResponseBody
	public Map<String,Object> findCardById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Card card = cardServiceImpl.findCardById(id);
		map.put("card", card);
		return map;
	}
	
	/**
	 * 新增
	 * @param Card
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCard")
	@ResponseBody
	public Map<String,Object> saveCard(Card card,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		card.setUserid(user.getuName());
		try {
			cardServiceImpl.saveCard(card);
			
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param Card
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCard")
	@ResponseBody
	public Map<String,Object> updateCard(Card card,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		card.setUpdateuser(user.getuName());
		try {
			cardServiceImpl.updateCard(card);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 跳转世峰e卡发送短信页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sendSMS")
	@ResponseBody
	public ModelAndView sendSMS(ModelAndView mv,String id,HttpSession session) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("card/cardSMS");
		
		return mv;
	}
	
	/**
	 * 世峰e卡发送短信
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCardSMS")
	@ResponseBody
	public Map<String,Object> updateCardSMS(Card card,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		
		card.setUpdateuser(user.getuName());
		try {
			cardServiceImpl.updateCardSMS(card,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "短信发送失败，请稍后重试!!!");
		}
		return map;
	}
	
 
}
