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

import com.shifeng.entity.order.PorderInfoDiscount;
import com.shifeng.op.order.service.PorderInfoDiscountService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 父订单折扣表(o_porderInfo_discount)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */ 
@Controller
@RequestMapping(value="/porderInfodiscount")
public class PorderInfoDiscountController{
	
	@Resource(name="porderInfodiscountServiceImpl")
	private PorderInfoDiscountService porderInfodiscountServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPorderInfoDiscountList")
	public ModelAndView goPorderInfoDiscountList(ModelAndView mv) throws Exception{
		mv.setViewName("order/porderInfodiscountList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param porderInfodiscount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllPorderInfoDiscount")
	@ResponseBody
	public Map<String,Object> findAllPorderInfoDiscount(Page page,PorderInfoDiscount porderInfodiscount) throws Exception{
		if(porderInfodiscount==null){
			porderInfodiscount = new PorderInfoDiscount();
		}
		page.setT(porderInfodiscount);
		Map<String,Object> map = new HashMap<String,Object>();
		List<PorderInfoDiscount> porderInfodiscounts = porderInfodiscountServiceImpl.findAllPorderInfoDiscount(page);
		map.put("porderInfodiscounts", porderInfodiscounts);
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
	@RequestMapping(value="/goPorderInfoDiscountEdit")
	@ResponseBody
	public ModelAndView goPorderInfoDiscountEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("order/porderInfodiscountEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findPorderInfoDiscountById")
	@ResponseBody
	public Map<String,Object> findPorderInfoDiscountById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PorderInfoDiscount porderInfodiscount = porderInfodiscountServiceImpl.findPorderInfoDiscountById(id);
		map.put("porderInfodiscount",porderInfodiscount);
		return map;
	}
	
	/**
	 * 新增
	 * @param porderInfodiscount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/savePorderInfoDiscount")
	@ResponseBody
	public Map<String,Object> savePorderInfoDiscount(PorderInfoDiscount porderInfodiscount,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			porderInfodiscountServiceImpl.savePorderInfoDiscount(porderInfodiscount);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param porderInfodiscount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updatePorderInfoDiscount")
	@ResponseBody
	public Map<String,Object> updatePorderInfoDiscount(PorderInfoDiscount porderInfodiscount,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			porderInfodiscountServiceImpl.updatePorderInfoDiscount(porderInfodiscount);
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
	@RequestMapping(value="/deletePorderInfoDiscount")
	@ResponseBody
 	public Map<String,Object> deletePorderInfoDiscount(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			porderInfodiscountServiceImpl.deletePorderInfoDiscount(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
