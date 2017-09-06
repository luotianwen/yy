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

import com.shifeng.entity.card.UserCardOrder;
import com.shifeng.op.card.service.UserCardOrderService;
import com.shifeng.op.dto.card.SearchCardDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;


/** 
 * 用户世峰卡消费(c_user_card_order)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 16:02:33 
 */ 
@Controller
@RequestMapping(value="/usercardorder")
public class UserCardOrderController{
	
	@Resource(name="usercardorderServiceImpl")
	private UserCardOrderService usercardorderServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUserCardOrderList")
	public ModelAndView goUserCardOrderList(ModelAndView mv) throws Exception{
		mv.setViewName("card/usercardorderList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param usercardorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllUserCardOrder")
	@ResponseBody
	public Map<String,Object> findAllUserCardOrder(Page<SearchCardDTO> page,SearchCardDTO dto) throws Exception{
		if(dto==null){
			dto = new SearchCardDTO();
		}
		page.setT(dto);
		Map<String,Object> map = new HashMap<String,Object>();
		List<UserCardOrder> usercardorders = usercardorderServiceImpl.findAllUserCardOrder(page);
		map.put("usercardorders", usercardorders);
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
	@RequestMapping(value="/goUserCardOrderEdit")
	@ResponseBody
	public ModelAndView goUserCardOrderEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("card/usercardorderEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findUserCardOrderById")
	@ResponseBody
	public Map<String,Object> findUserCardOrderById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		UserCardOrder usercardorder = usercardorderServiceImpl.findUserCardOrderById(id);
		map.put("usercardorder",usercardorder);
		return map;
	}
	
	/**
	 * 新增
	 * @param usercardorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveUserCardOrder")
	@ResponseBody
	public Map<String,Object> saveUserCardOrder(UserCardOrder usercardorder,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			usercardorderServiceImpl.saveUserCardOrder(usercardorder);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param usercardorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUserCardOrder")
	@ResponseBody
	public Map<String,Object> updateUserCardOrder(UserCardOrder usercardorder,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			usercardorderServiceImpl.updateUserCardOrder(usercardorder);
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
	@RequestMapping(value="/deleteUserCardOrder")
	@ResponseBody
 	public Map<String,Object> deleteUserCardOrder(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			usercardorderServiceImpl.deleteUserCardOrder(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
