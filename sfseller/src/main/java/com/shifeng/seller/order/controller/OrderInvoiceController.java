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

import com.shifeng.entity.order.OrderInvoice;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.order.service.OrderInvoiceService;
import com.shifeng.util.Const;


/** 
 * 订单发票(o_orderInvoice)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */ 
@Controller
@RequestMapping(value="/orderInvoice")
public class OrderInvoiceController{
	
	@Resource(name="orderInvoiceServiceImpl")
	private OrderInvoiceService orderInvoiceServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goOrderInvoiceList")
	public ModelAndView goOrderInvoiceList(ModelAndView mv) throws Exception{
		mv.setViewName("order/orderInvoiceList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param orderInvoice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllOrderInvoice")
	@ResponseBody
	public Map<String,Object> findAllOrderInvoice(Page page,OrderInvoice orderInvoice) throws Exception{
		if(orderInvoice==null){
			orderInvoice = new OrderInvoice();
		}
		page.setT(orderInvoice);
		Map<String,Object> map = new HashMap<String,Object>();
		List<OrderInvoice> orderInvoices = orderInvoiceServiceImpl.findAllOrderInvoice(page);
		map.put("orderInvoices", orderInvoices);
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
	@RequestMapping(value="/goOrderInvoiceEdit")
	@ResponseBody
	public ModelAndView goOrderInvoiceEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("order/orderInvoiceEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findOrderInvoiceById")
	@ResponseBody
	public Map<String,Object> findOrderInvoiceById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		OrderInvoice orderInvoice = orderInvoiceServiceImpl.findOrderInvoiceById(id);
		map.put("orderInvoice",orderInvoice);
		return map;
	}
	
	/**
	 * 新增
	 * @param orderInvoice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveOrderInvoice")
	@ResponseBody
	public Map<String,Object> saveOrderInvoice(OrderInvoice orderInvoice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			orderInvoiceServiceImpl.saveOrderInvoice(orderInvoice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param orderInvoice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateOrderInvoice")
	@ResponseBody
	public Map<String,Object> updateOrderInvoice(OrderInvoice orderInvoice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			orderInvoiceServiceImpl.updateOrderInvoice(orderInvoice);
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
	@RequestMapping(value="/deleteOrderInvoice")
	@ResponseBody
 	public Map<String,Object> deleteOrderInvoice(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			orderInvoiceServiceImpl.deleteOrderInvoice(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
