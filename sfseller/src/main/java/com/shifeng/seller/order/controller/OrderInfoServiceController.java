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
import com.shifeng.entity.order.OrderInfoService;
import com.shifeng.entity.order.OrderInfoServiceImg;
import com.shifeng.entity.order.OrderInfoServiceLog;
import com.shifeng.entity.shop.ShippingAddress;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.freight.service.ExpressConfigService;
import com.shifeng.seller.order.service.OrderInfoServiceImgService;
import com.shifeng.seller.order.service.OrderInfoServiceLogService;
import com.shifeng.seller.order.service.OrderInfoServiceService;
import com.shifeng.seller.shop.service.ShippingAddressService;
import com.shifeng.util.Const;


/** 
 * 订单售后(o_orderInfo_service)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 19:08:54 
 */ 
@Controller
@RequestMapping(value="/orderInfoservice")
public class OrderInfoServiceController{
	
	@Resource(name="orderInfoserviceServiceImpl")
	private OrderInfoServiceService orderInfoserviceServiceImpl;
	
	@Resource(name="shippingaddressServiceImpl")
	private ShippingAddressService shippingaddressServiceImpl;
	
	@Resource(name="orderInfoserviceimgServiceImpl")
	private OrderInfoServiceImgService orderInfoserviceimgServiceImpl;
	
	@Resource(name="orderInfoservicelogServiceImpl")
	private OrderInfoServiceLogService orderInfoservicelogServiceImpl;
	
	@Resource(name="expressConfigServiceImpl")
	private ExpressConfigService expressConfigServiceImpl;
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goOrderInfoServiceList")
	public ModelAndView goOrderInfoServiceList(ModelAndView mv) throws Exception{
		//系统快递
		List<ExpressConfig> expressconfig = expressConfigServiceImpl.findAllExpressConfig();
		mv.addObject("expressconfig", expressconfig);
		
		
		mv.setViewName("order/orderInfoService");
		return mv;
	}	
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param orderInfoservice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllOrderInfoService")
	@ResponseBody
	public ModelAndView findAllOrderInfoService(ModelAndView mv,Page page,OrderInfoService orderInfoservice) throws Exception{
		if(orderInfoservice==null){
			orderInfoservice = new OrderInfoService();
		}
		page.setT(orderInfoservice);
		Map<String,Object> map = new HashMap<String,Object>();
		List<OrderInfoService> orderInfoservices = orderInfoserviceServiceImpl.findAllOrderInfoService(page);
		mv.addObject("orderInfoservices", orderInfoservices);
		mv.addObject("page", page);
		
		mv.setViewName("order/orderinfoServiceList");
		return mv;
	}
 
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findOrderInfoServiceById")
	@ResponseBody
	public ModelAndView findOrderInfoServiceById(ModelAndView mv,String id,HttpSession session) throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		//服务订单信息
		OrderInfoService orderInfoservice = orderInfoserviceServiceImpl.findOrderInfoServiceById(id);
		mv.addObject("orderInfoservice",orderInfoservice);
		
		//服务订单图片
		List<OrderInfoServiceImg> orderInfoServiceImgs = orderInfoserviceimgServiceImpl.findOrderInfoServiceImgByOisId(id);
		mv.addObject("orderInfoServiceImgs", orderInfoServiceImgs);
		
		//日志
		List<OrderInfoServiceLog> orderInfoServiceLogs = orderInfoservicelogServiceImpl.findOrderInfoServiceLogByOosId(id);
		mv.addObject("orderInfoServiceLogs", orderInfoServiceLogs);
		
		mv.setViewName("order/orderInfoServiceDetail");
		return mv;
	}
	
	/**
	 * 审核
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/auditOrderInfoService")
	@ResponseBody
	public ModelAndView auditOrderInfoService(ModelAndView mv,String id,HttpSession session) throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		//服务订单信息
		OrderInfoService orderInfoservice = orderInfoserviceServiceImpl.findOrderInfoServiceById(id);
		mv.addObject("orderInfoservice",orderInfoservice);
		
		//服务订单图片
		List<OrderInfoServiceImg> orderInfoServiceImgs = orderInfoserviceimgServiceImpl.findOrderInfoServiceImgByOisId(id);
		mv.addObject("orderInfoServiceImgs", orderInfoServiceImgs);
		
		//店铺发货地址
		List<ShippingAddress> shippingaddresss = shippingaddressServiceImpl.findShippingAddressByShopId(user.getShopid()+"");
		mv.addObject("shippingaddresss",shippingaddresss);
		
		mv.setViewName("order/auditOrderInfoService");
		return mv;
	}
	
	
	/**
	 * 修改
	 * @param orderInfoservice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateOrderInfoService")
	@ResponseBody
	public Map<String,Object> updateOrderInfoService(OrderInfoService orderInfoservice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		orderInfoservice.setUpdatename(user.getuName());
		try {
			orderInfoserviceServiceImpl.updateOrderInfoService(orderInfoservice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 买家发货
	 */
	@RequestMapping(value="shipments")
	@ResponseBody
	public Map<String,String> shipments(String expressId,String number,String id,String type,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("expressId", expressId);
		map.put("number", number);
		map.put("id", id);
		map.put("type", type);
		map.put("updatename", user.getuName());
		
		try {
			orderInfoserviceServiceImpl.updateShipments(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "修改异常，请稍后重试!!!");
		}
		
		return map;
	}
	
}
