package com.shifeng.seller.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.shop.ShippingAddress;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.service.ShippingAddressService;
import com.shifeng.util.Const;


/** 
 * 店铺发货地址(s_shipping_address)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:27:07 
 */ 
@Controller
@RequestMapping(value="/shippingaddress")
public class ShippingAddressController extends BaseController{
	
	@Resource(name="shippingaddressServiceImpl")
	private ShippingAddressService shippingaddressServiceImpl;

	@Resource(name="systemService")
    private SystemService systemServiceImpl;
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShippingAddress")
	public ModelAndView goShippingAddress(ModelAndView mv) throws Exception{
		mv.setViewName("shop/shippingaddress/shippingaddress");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShippingAddress")
	@ResponseBody
	public ModelAndView findAllShippingAddress(ModelAndView mv,Page page,HttpSession session) throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		page.setT(user.getShopid());
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShippingAddress> shippingaddresss = shippingaddressServiceImpl.findAllShippingAddress(page);
		mv.addObject("shippingaddresss", shippingaddresss);
		mv.addObject("page", page);
		
		mv.setViewName("shop/shippingaddress/shippingaddressList");
		return mv;
	}
 
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShippingAddressEdit")
	@ResponseBody
	public ModelAndView goShippingAddressEdit(ModelAndView mv,String id) throws Exception{
		ShippingAddress shippingaddress = shippingaddressServiceImpl.findShippingAddressById(id);
		mv.addObject("shippingaddress",shippingaddress);
		
		//查询所有省份
		List province = getAllProvince();
		mv.addObject("province", province);
		
		mv.setViewName("shop/shippingaddress/shippingaddressEdit");
		return mv;
	}
	
	/**
	 * 修改
	 * @param shippingaddress
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/shippingAddressEdit")
	@ResponseBody
	public Map<String,Object> shippingAddressEdit(ShippingAddress shippingaddress,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		shippingaddress.setShopid(user.getShopid());
		try {
			shippingaddressServiceImpl.shippingAddressEdit(shippingaddress);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteShippingAddress")
	@ResponseBody
 	public Map<String,Object> deleteShippingAddress(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shippingaddressServiceImpl.deleteShippingAddress(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
 	}
 
}
