package com.shifeng.op.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.product.ProRules;
import com.shifeng.op.product.service.ProRulesService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.dto.coupons.ProductDTO;
import com.shifeng.op.dto.coupons.SearchRangeDTO;
import com.shifeng.op.entity.users.Users;


/** 
 * SKU表(p_pro_rules)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */ 
@Controller
@RequestMapping(value="/prorules")
public class ProRulesController{
	
	@Resource(name="prorulesServiceImpl")
	private ProRulesService prorulesServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProRulesList")
	public ModelAndView goProRulesList(ModelAndView mv) throws Exception{
		mv.setViewName("product/prorulesList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param prorules
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllProRules")
	@ResponseBody
	public Map<String,Object> findAllProRules(Page page,ProRules prorules) throws Exception{
		if(prorules==null){
			prorules = new ProRules();
		}
		page.setT(prorules);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProRules> proruless = prorulesServiceImpl.findAllProRules(page);
		map.put("proruless", proruless);
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
	@RequestMapping(value="/goProRulesEdit")
	@ResponseBody
	public ModelAndView goProRulesEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("product/prorulesEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findProRulesById")
	@ResponseBody
	public Map<String,Object> findProRulesById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ProRules prorules = prorulesServiceImpl.findProRulesById(id);
		map.put("prorules",prorules);
		return map;
	}
	
	/**
	 * 新增
	 * @param prorules
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveProRules")
	@ResponseBody
	public Map<String,Object> saveProRules(ProRules prorules,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			prorulesServiceImpl.saveProRules(prorules);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param prorules
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProRules")
	@ResponseBody
	public Map<String,Object> updateProRules(ProRules prorules,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			prorulesServiceImpl.updateProRules(prorules);
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
	@RequestMapping(value="/deleteProRules")
	@ResponseBody
 	public Map<String,Object> deleteProRules(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			prorulesServiceImpl.deleteProRules(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
