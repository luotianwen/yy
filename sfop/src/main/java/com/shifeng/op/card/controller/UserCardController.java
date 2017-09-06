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

import com.shifeng.entity.card.UserCard;
import com.shifeng.op.card.service.UserCardService;
import com.shifeng.op.dto.card.SearchCardDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;


/** 
 * 用户世峰e卡(c_user_card)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 16:02:33 
 */ 
@Controller
@RequestMapping(value="/usercard")
public class UserCardController{
	
	@Resource(name="usercardServiceImpl")
	private UserCardService usercardServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUserCardList")
	public ModelAndView goUserCardList(ModelAndView mv) throws Exception{
		mv.setViewName("card/usercardList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param usercard
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllUserCard")
	@ResponseBody
	public Map<String,Object> findAllUserCard(Page<SearchCardDTO> page,SearchCardDTO dto) throws Exception{
		if(dto==null){
			dto = new SearchCardDTO();
		}
		page.setT(dto);
		Map<String,Object> map = new HashMap<String,Object>();
		List<UserCard> usercards = usercardServiceImpl.findAllUserCard(page);
		map.put("usercards", usercards);
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
	@RequestMapping(value="/goUserCardEdit")
	@ResponseBody
	public ModelAndView goUserCardEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("card/usercardEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findUserCardById")
	@ResponseBody
	public Map<String,Object> findUserCardById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		UserCard usercard = usercardServiceImpl.findUserCardById(id);
		map.put("usercard",usercard);
		return map;
	}
	
	/**
	 * 新增
	 * @param usercard
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveUserCard")
	@ResponseBody
	public Map<String,Object> saveUserCard(UserCard usercard,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			usercardServiceImpl.saveUserCard(usercard);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param usercard
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUserCard")
	@ResponseBody
	public Map<String,Object> updateUserCard(UserCard usercard,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			usercardServiceImpl.updateUserCard(usercard);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteUserCard")
	@ResponseBody
 	public Map<String,Object> deleteUserCard(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			usercardServiceImpl.deleteUserCard(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
	
	
	/**
	 * 根据ID查询用户绑定e卡信息
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findUserCardByCid")
	@ResponseBody
	public Map<String,Object> findUserCardByCid(String id,HttpSession session) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			boolean bool = usercardServiceImpl.findUserCardByCid(id);
			map.put("bool", bool);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "修改异常，请稍后重试!!!");
		}
		
		return map;
	}
	
}
