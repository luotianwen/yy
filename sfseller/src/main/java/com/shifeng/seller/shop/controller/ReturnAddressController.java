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

import com.shifeng.entity.shop.ReturnAddress;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.service.ReturnAddressService;
import com.shifeng.util.Const;


/** 
 * 店铺退货地址(s_return_address)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:27:07 
 */ 
@Controller
@RequestMapping(value="/returnaddress")
public class ReturnAddressController extends BaseController{
	
	@Resource(name="returnaddressServiceImpl")
	private ReturnAddressService returnaddressServiceImpl;

	@Resource(name="systemService")
    private SystemService systemServiceImpl;
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goReturnAddress")
	public ModelAndView goReturnAddress(ModelAndView mv) throws Exception{
		mv.setViewName("shop/returnaddress/returnaddress");
		return mv;
	}
	
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllReturnAddress")
	@ResponseBody
	public ModelAndView findAllReturnAddress(ModelAndView mv,Page page,HttpSession session) throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		page.setT(user.getShopid());
		List<ReturnAddress> returnaddresss = returnaddressServiceImpl.findAllReturnAddress(page);
		
		mv.addObject("returnaddresss", returnaddresss);
		mv.addObject("page", page);
		
		mv.setViewName("shop/returnaddress/returnaddressList");
		return mv;
	}
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goReturnAddressEdit")
	@ResponseBody
	public ModelAndView goReturnAddressEdit(ModelAndView mv,String id) throws Exception{
		ReturnAddress returnaddress = returnaddressServiceImpl.findReturnAddressById(id);
		mv.addObject("returnaddress", returnaddress);
		
		//查询所有省份
		List province = getAllProvince();
		mv.addObject("province", province);
		
		mv.setViewName("shop/returnaddress/returnaddressEdit");
		return mv;
	}
	
	/**
	 * 修改
	 * @param returnaddress
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/returnAddressEdit")
	@ResponseBody
	public Map<String,Object> returnAddressEdit(ReturnAddress returnaddress,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		returnaddress.setShopid(user.getShopid());
		try {
			returnaddressServiceImpl.returnAddressEdit(returnaddress);
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
	@RequestMapping(value="/deleteReturnAddress")
	@ResponseBody
 	public Map<String,Object> deleteReturnAddress(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			returnaddressServiceImpl.deleteReturnAddress(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "删除失败，请稍后重试!!!");
		}
		return map;
 	}
 
}
