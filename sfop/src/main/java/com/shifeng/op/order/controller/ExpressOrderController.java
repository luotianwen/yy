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

import com.shifeng.entity.order.ExpressOrder;
import com.shifeng.op.order.service.ExpressOrderService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


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

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goExpressOrderList")
	public ModelAndView goExpressOrderList(ModelAndView mv) throws Exception{
		mv.setViewName("order/expressorderList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param expressorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllExpressOrder")
	@ResponseBody
	public Map<String,Object> findAllExpressOrder(Page page,ExpressOrder expressorder) throws Exception{
		if(expressorder==null){
			expressorder = new ExpressOrder();
		}
		page.setT(expressorder);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ExpressOrder> expressorders = expressorderServiceImpl.findAllExpressOrder(page);
		map.put("expressorders", expressorders);
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
	@RequestMapping(value="/goExpressOrderEdit")
	@ResponseBody
	public ModelAndView goExpressOrderEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("order/expressorderEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findExpressOrderById")
	@ResponseBody
	public Map<String,Object> findExpressOrderById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ExpressOrder expressorder = expressorderServiceImpl.findExpressOrderById(id);
		map.put("expressorder",expressorder);
		return map;
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
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			expressorderServiceImpl.saveExpressOrder(expressorder);
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
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			expressorderServiceImpl.updateExpressOrder(expressorder);
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
	@RequestMapping(value="/deleteExpressOrder")
	@ResponseBody
 	public Map<String,Object> deleteExpressOrder(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			expressorderServiceImpl.deleteExpressOrder(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
