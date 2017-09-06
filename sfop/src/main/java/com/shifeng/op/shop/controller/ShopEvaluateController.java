package com.shifeng.op.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.entity.shop.ShopEvaluate;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.shop.service.ShopEvaluateService;


/** 
 * 店铺评价(p_shop_evaluate)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 15:37:29 
 */ 
@Controller
@RequestMapping(value="/shopevaluate")
public class ShopEvaluateController{
	
	@Resource(name="shopevaluateServiceImpl")
	private ShopEvaluateService shopevaluateServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopEvaluateList")
	public ModelAndView goShopEvaluateList(ModelAndView mv) throws Exception{
		mv.setViewName("product/shopevaluateList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param shopevaluate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShopEvaluate")
	@ResponseBody
	public Map<String,Object> findAllShopEvaluate(Page page,ShopEvaluate shopevaluate) throws Exception{
		if(shopevaluate==null){
			shopevaluate = new ShopEvaluate();
		}
		page.setT(shopevaluate);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShopEvaluate> shopevaluates = shopevaluateServiceImpl.findAllShopEvaluate(page);
		map.put("shopevaluates", shopevaluates);
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
	@RequestMapping(value="/goShopEvaluateEdit")
	@ResponseBody
	public ModelAndView goShopEvaluateEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("product/shopevaluateEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findShopEvaluateById")
	@ResponseBody
	public Map<String,Object> findShopEvaluateById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ShopEvaluate shopevaluate = shopevaluateServiceImpl.findShopEvaluateById(id);
		map.put("shopevaluate",shopevaluate);
		return map;
	}
	
	/**
	 * 新增
	 * @param shopevaluate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopEvaluate")
	@ResponseBody
	public Map<String,Object> saveShopEvaluate(ShopEvaluate shopevaluate,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopevaluateServiceImpl.saveShopEvaluate(shopevaluate);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param shopevaluate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopEvaluate")
	@ResponseBody
	public Map<String,Object> updateShopEvaluate(ShopEvaluate shopevaluate,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopevaluateServiceImpl.updateShopEvaluate(shopevaluate);
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
	@RequestMapping(value="/deleteShopEvaluate")
	@ResponseBody
 	public Map<String,Object> deleteShopEvaluate(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopevaluateServiceImpl.deleteShopEvaluate(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
