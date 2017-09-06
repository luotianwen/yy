package com.shifeng.op.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.op.order.service.OrderInfoLogService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 订单日志(o_orderInfo_log)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 11:22:32 
 */ 
@Controller
@RequestMapping(value="/orderInfolog")
public class OrderInfoLogController{
	
	@Resource(name="orderInfologServiceImpl")
	private OrderInfoLogService orderInfologServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goOrderInfoLogList")
	public ModelAndView goOrderInfoLogList(ModelAndView mv) throws Exception{
		mv.setViewName("order/orderInfologList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param orderInfolog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllOrderInfoLog")
	@ResponseBody
	public Map<String,Object> findAllOrderInfoLog(Page page,OrderInfoLog orderInfolog) throws Exception{
		if(orderInfolog==null){
			orderInfolog = new OrderInfoLog();
		}
		page.setT(orderInfolog);
		Map<String,Object> map = new HashMap<String,Object>();
		List<OrderInfoLog> orderInfologs = orderInfologServiceImpl.findAllOrderInfoLog(page);
		map.put("orderInfologs", orderInfologs);
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
	@RequestMapping(value="/goOrderInfoLogEdit")
	@ResponseBody
	public ModelAndView goOrderInfoLogEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("order/orderInfologEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findOrderInfoLogById")
	@ResponseBody
	public Map<String,Object> findOrderInfoLogById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		OrderInfoLog orderInfolog = orderInfologServiceImpl.findOrderInfoLogById(id);
		map.put("orderInfolog",orderInfolog);
		return map;
	}
	
	/**
	 * 新增
	 * @param orderInfolog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveOrderInfoLog")
	@ResponseBody
	public Map<String,Object> saveOrderInfoLog(OrderInfoLog orderInfolog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			orderInfologServiceImpl.saveOrderInfoLog(orderInfolog);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param orderInfolog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateOrderInfoLog")
	@ResponseBody
	public Map<String,Object> updateOrderInfoLog(OrderInfoLog orderInfolog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			orderInfologServiceImpl.updateOrderInfoLog(orderInfolog);
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
	@RequestMapping(value="/deleteOrderInfoLog")
	@ResponseBody
 	public Map<String,Object> deleteOrderInfoLog(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			orderInfologServiceImpl.deleteOrderInfoLog(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
