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

import com.shifeng.entity.freight.ExpressConfig;
import com.shifeng.entity.order.ExpressOrder;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.freight.service.ExpressConfigService;
import com.shifeng.seller.order.service.ExpressOrderService;
import com.shifeng.util.Const;


/** 
 * 订单快递(o_express_order)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */ 
@Controller
@RequestMapping(value="/expressorder")
public class ExpressOrderController{
	
	@Resource(name="expressorderServiceImpl")
	private ExpressOrderService expressorderServiceImpl;

	@Resource(name="expressConfigServiceImpl")
	private ExpressConfigService expressConfigServiceImpl;
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goExpressOrder")
	public ModelAndView goExpressOrder(ModelAndView mv) throws Exception{
		mv.setViewName("order/expressorder");
		return mv;
	}
	 
	/**
	 * 根据订单ID查询
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findExpressOrderByOid")
	@ResponseBody
	public ModelAndView findExpressOrderByOid(ModelAndView mv,String orderId) throws Exception{
		ExpressOrder expressorder = expressorderServiceImpl.findExpressOrderByOid(orderId);
		mv.addObject("expressorder",expressorder);
		
		//系统快递
		List<ExpressConfig> expressconfig = expressConfigServiceImpl.findAllExpressConfig();
		mv.addObject("expressconfig", expressconfig);
		
		mv.setViewName("order/expressorderList");
		return mv;
	}
	
	/**
	 * 新增
	 * @param expressorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveExpressOrder")
	@ResponseBody
	public Map<String,Object> saveExpressOrder(ExpressOrder expressorder,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			expressorderServiceImpl.saveExpressOrder(expressorder,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param expressorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateExpressOrder")
	@ResponseBody
	public Map<String,Object> updateExpressOrder(ExpressOrder expressorder,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			expressorderServiceImpl.updateExpressOrder(expressorder);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	
 
}
