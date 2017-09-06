package com.shifeng.op.fx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.fx.FxOrder;
import com.shifeng.op.fx.service.FxOrderService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 分销订单(fx_order)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-08 11:48:01 
 */ 
@Controller
@RequestMapping(value="/fxorder")
public class FxOrderController{
	
	@Resource(name="fxorderServiceImpl")
	private FxOrderService fxorderServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFxOrderList")
	public ModelAndView goFxOrderList(ModelAndView mv) throws Exception{
		mv.setViewName("fx/fxorderList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param fxorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllFxOrder")
	@ResponseBody
	public Map<String,Object> findAllFxOrder(Page page,FxOrder fxorder) throws Exception{
		if(fxorder==null){
			fxorder = new FxOrder();
		}
		page.setT(fxorder);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FxOrder> fxorders = fxorderServiceImpl.findAllFxOrder(page);
		map.put("fxorders", fxorders);
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
	@RequestMapping(value="/goFxOrderEdit")
	@ResponseBody
	public ModelAndView goFxOrderEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("fx/fxorderEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findFxOrderById")
	@ResponseBody
	public Map<String,Object> findFxOrderById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		FxOrder fxorder = fxorderServiceImpl.findFxOrderById(id);
		map.put("fxorder",fxorder);
		return map;
	}
	
	/**
	 * 新增
	 * @param fxorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveFxOrder")
	@ResponseBody
	public Map<String,Object> saveFxOrder(FxOrder fxorder,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxorderServiceImpl.saveFxOrder(fxorder);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param fxorder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateFxOrder")
	@ResponseBody
	public Map<String,Object> updateFxOrder(FxOrder fxorder,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxorderServiceImpl.updateFxOrder(fxorder);
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
	@RequestMapping(value="/deleteFxOrder")
	@ResponseBody
 	public Map<String,Object> deleteFxOrder(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			fxorderServiceImpl.deleteFxOrder(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
