package com.shifeng.seller.product.controller;

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
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.product.dto.ProRulesDTO;
import com.shifeng.seller.product.service.ProRulesService;
import com.shifeng.util.Const;


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
	@RequestMapping(value="/goProRules")
	public ModelAndView goProRules(ModelAndView mv) throws Exception{
		mv.setViewName("product/prorules");
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
	public ModelAndView findAllProRules(ModelAndView mv,Page page,ProRulesDTO prorules,HttpSession session) throws Exception{
		if(prorules==null){
			prorules = new ProRulesDTO();
		}
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		prorules.setShopid(user.getShopid()+"");
		page.setT(prorules);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProRules> proruless = prorulesServiceImpl.findAllProRules(page);
		mv.addObject("proruless", proruless);
		mv.addObject("page", page);
		mv.setViewName("product/prorulesList");
		return mv;
	}

 
	/**
	 * 修改
	 * @param prorules
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProRulesStocks")
	@ResponseBody
	public Map<String,Object> updateProRulesStocks(String sku,String stocks,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			prorulesServiceImpl.updateProRulesStocks(sku,stocks,user,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "修改失败，请稍后重试!!!");
		}
		return map;
	}
	
}
