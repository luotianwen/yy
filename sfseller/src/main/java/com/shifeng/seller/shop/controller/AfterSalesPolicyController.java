package com.shifeng.seller.shop.controller;

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
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.service.AfterSalesPolicyService;
import com.shifeng.util.Const;


/** 
 * 店铺售后政策(s_after_sales_policy)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:27:07 
 */ 
@Controller
@RequestMapping(value="/aftersalespolicy")
public class AfterSalesPolicyController extends BaseController{
	
	@Resource(name="aftersalespolicyServiceImpl")
	private AfterSalesPolicyService aftersalespolicyServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAfterSalesPolicy")
	public ModelAndView goAfterSalesPolicy(ModelAndView mv) throws Exception{
		mv.setViewName("shop/aftersale/aftersales");
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
	public ModelAndView findAllAfterSalesPolicy(ModelAndView mv,Page page,HttpSession session) throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		page.setT(user.getShopid());
		List<AfterSalesPolicy> aftersalespolicys = aftersalespolicyServiceImpl.findAllAfterSalesPolicy(page);
		mv.addObject("aftersalespolicys", aftersalespolicys);
		mv.addObject("page", page);
		mv.setViewName("shop/aftersale/aftersalesList");
		return mv;
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
		AfterSalesPolicy aftersalespolicy = aftersalespolicyServiceImpl.findAfterSalesPolicyById(id);
		mv.addObject("aftersalespolicy", aftersalespolicy);
		mv.setViewName("shop/aftersale/aftersalesEdit");
		return mv;
	}
	
	/**
	 * 修改
	 * @param aftersalespolicy
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/afterSalesPolicyEdit")
	@ResponseBody
	public Map<String,Object> afterSalesPolicyEdit(AfterSalesPolicy aftersalespolicy,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		aftersalespolicy.setShopid(user.getShopid());
		try {
			aftersalespolicyServiceImpl.afterSalesPolicyEdit(aftersalespolicy);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
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
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
 	}
 
}
