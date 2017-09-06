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

import com.shifeng.entity.shop.AfterSalesPolicy;
import com.shifeng.op.shop.service.AfterSalesPolicyService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 售后政策(s_after_sales_policy)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:24 
 */ 
@Controller
@RequestMapping(value="/aftersalespolicy")
public class AfterSalesPolicyController{
	
	@Resource(name="aftersalespolicyServiceImpl")
	private AfterSalesPolicyService aftersalespolicyServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAfterSalesPolicyList")
	public ModelAndView goAfterSalesPolicyList(ModelAndView mv) throws Exception{
		mv.setViewName("shop/aftersalespolicyList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param aftersalespolicy
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllAfterSalesPolicy")
	@ResponseBody
	public Map<String,Object> findAllAfterSalesPolicy(Page page,AfterSalesPolicy aftersalespolicy) throws Exception{
		if(aftersalespolicy==null){
			aftersalespolicy = new AfterSalesPolicy();
		}
		page.setT(aftersalespolicy);
		Map<String,Object> map = new HashMap<String,Object>();
		List<AfterSalesPolicy> aftersalespolicys = aftersalespolicyServiceImpl.findAllAfterSalesPolicy(page);
		map.put("aftersalespolicys", aftersalespolicys);
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
	@RequestMapping(value="/goAfterSalesPolicyEdit")
	@ResponseBody
	public ModelAndView goAfterSalesPolicyEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/aftersalespolicyEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAfterSalesPolicyById")
	@ResponseBody
	public Map<String,Object> findAfterSalesPolicyById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		AfterSalesPolicy aftersalespolicy = aftersalespolicyServiceImpl.findAfterSalesPolicyById(id);
		map.put("aftersalespolicy",aftersalespolicy);
		return map;
	}
	
	/**
	 * 新增
	 * @param aftersalespolicy
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveAfterSalesPolicy")
	@ResponseBody
	public Map<String,Object> saveAfterSalesPolicy(AfterSalesPolicy aftersalespolicy,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			aftersalespolicyServiceImpl.saveAfterSalesPolicy(aftersalespolicy);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param aftersalespolicy
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateAfterSalesPolicy")
	@ResponseBody
	public Map<String,Object> updateAfterSalesPolicy(AfterSalesPolicy aftersalespolicy,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			aftersalespolicyServiceImpl.updateAfterSalesPolicy(aftersalespolicy);
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
	@RequestMapping(value="/deleteAfterSalesPolicy")
	@ResponseBody
 	public Map<String,Object> deleteAfterSalesPolicy(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			aftersalespolicyServiceImpl.deleteAfterSalesPolicy(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
