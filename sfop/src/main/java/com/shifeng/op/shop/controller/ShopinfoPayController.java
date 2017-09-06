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

import com.shifeng.entity.shop.ShopinfoPay;
import com.shifeng.op.shop.service.ShopinfoPayService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 店铺续费表(s_shopinfo_pay)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */ 
@Controller
@RequestMapping(value="/shopinfopay")
public class ShopinfoPayController{
	
	@Resource(name="shopinfopayServiceImpl")
	private ShopinfoPayService shopinfopayServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopinfoPayList")
	public ModelAndView goShopinfoPayList(ModelAndView mv) throws Exception{
		mv.setViewName("shop/shopinfopayList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param shopinfopay
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShopinfoPay")
	@ResponseBody
	public Map<String,Object> findAllShopinfoPay(Page page,ShopinfoPay shopinfopay) throws Exception{
		if(shopinfopay==null){
			shopinfopay = new ShopinfoPay();
		}
		page.setT(shopinfopay);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShopinfoPay> shopinfopays = shopinfopayServiceImpl.findAllShopinfoPay(page);
		map.put("shopinfopays", shopinfopays);
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
	@RequestMapping(value="/goShopinfoPayEdit")
	@ResponseBody
	public ModelAndView goShopinfoPayEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/shopinfopayEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findShopinfoPayById")
	@ResponseBody
	public Map<String,Object> findShopinfoPayById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ShopinfoPay shopinfopay = shopinfopayServiceImpl.findShopinfoPayById(id);
		map.put("shopinfopay",shopinfopay);
		return map;
	}
	
	/**
	 * 新增
	 * @param shopinfopay
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopinfoPay")
	@ResponseBody
	public Map<String,Object> saveShopinfoPay(ShopinfoPay shopinfopay,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopinfopayServiceImpl.saveShopinfoPay(shopinfopay);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param shopinfopay
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopinfoPay")
	@ResponseBody
	public Map<String,Object> updateShopinfoPay(ShopinfoPay shopinfopay,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		shopinfopay.setUpdatename(user.getuName());
		try {
			shopinfopayServiceImpl.updateShopinfoPay(shopinfopay);
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
	@RequestMapping(value="/deleteShopinfoPay")
	@ResponseBody
 	public Map<String,Object> deleteShopinfoPay(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopinfopayServiceImpl.deleteShopinfoPay(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
