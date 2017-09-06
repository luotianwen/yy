package com.shifeng.seller.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.order.OrderInfoDiscount;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.order.service.OrderInfoDiscountService;
import com.shifeng.util.Const;


/** 
 * 订单折扣表(o_orderInfo_discount)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */ 
@Controller
@RequestMapping(value="/orderInfodiscount")
public class OrderInfoDiscountController{
	
	@Resource(name="orderInfodiscountServiceImpl")
	private OrderInfoDiscountService orderInfodiscountServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goOrderInfoDiscountList")
	public ModelAndView goOrderInfoDiscountList(ModelAndView mv) throws Exception{
		mv.setViewName("order/orderInfodiscountList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param orderInfodiscount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllOrderInfoDiscount")
	@ResponseBody
	public Map<String,Object> findAllOrderInfoDiscount(Page page,OrderInfoDiscount orderInfodiscount) throws Exception{
		if(orderInfodiscount==null){
			orderInfodiscount = new OrderInfoDiscount();
		}
		page.setT(orderInfodiscount);
		Map<String,Object> map = new HashMap<String,Object>();
		List<OrderInfoDiscount> orderInfodiscounts = orderInfodiscountServiceImpl.findAllOrderInfoDiscount(page);
		map.put("orderInfodiscounts", orderInfodiscounts);
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
	@RequestMapping(value="/goOrderInfoDiscountEdit")
	@ResponseBody
	public ModelAndView goOrderInfoDiscountEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("order/orderInfodiscountEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findOrderInfoDiscountById")
	@ResponseBody
	public Map<String,Object> findOrderInfoDiscountById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		OrderInfoDiscount orderInfodiscount = orderInfodiscountServiceImpl.findOrderInfoDiscountById(id);
		map.put("orderInfodiscount",orderInfodiscount);
		return map;
	}
	
	/**
	 * 新增
	 * @param orderInfodiscount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveOrderInfoDiscount")
	@ResponseBody
	public Map<String,Object> saveOrderInfoDiscount(OrderInfoDiscount orderInfodiscount,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			orderInfodiscountServiceImpl.saveOrderInfoDiscount(orderInfodiscount);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param orderInfodiscount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateOrderInfoDiscount")
	@ResponseBody
	public Map<String,Object> updateOrderInfoDiscount(OrderInfoDiscount orderInfodiscount,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			orderInfodiscountServiceImpl.updateOrderInfoDiscount(orderInfodiscount);
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
	@RequestMapping(value="/deleteOrderInfoDiscount")
	@ResponseBody
 	public Map<String,Object> deleteOrderInfoDiscount(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			orderInfodiscountServiceImpl.deleteOrderInfoDiscount(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
