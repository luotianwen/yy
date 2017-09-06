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

import com.shifeng.entity.product.ProductEvaluate;
import com.shifeng.entity.product.ProductEvaluateReplay;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.product.dto.ProductEvaluateDTO;
import com.shifeng.seller.product.service.ProductEvaluateReplayService;
import com.shifeng.seller.product.service.ProductEvaluateService;
import com.shifeng.util.Const;


/** 
 * 商品评价(p_product_evaluate)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */ 
@Controller
@RequestMapping(value="/productevaluate")
public class ProductEvaluateController{
	
	@Resource(name="productevaluateServiceImpl")
	private ProductEvaluateService productevaluateServiceImpl;
	
	@Resource(name="productevaluatereplayServiceImpl")
	private ProductEvaluateReplayService productevaluatereplayServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductEvaluateList")
	public ModelAndView goProductEvaluateList(ModelAndView mv) throws Exception{
		mv.setViewName("product/evaluate/productevaluate");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param productevaluate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllProductEvaluate")
	@ResponseBody
	public ModelAndView findAllProductEvaluate(ModelAndView mv,Page page,ProductEvaluate productevaluate) throws Exception{
		if(productevaluate==null){
			productevaluate = new ProductEvaluate();
		}
		page.setT(productevaluate);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductEvaluateDTO> productevaluates = productevaluateServiceImpl.findAllProductEvaluate(page);
		mv.addObject("productevaluates", productevaluates);
		mv.addObject("page", page);
		mv.setViewName("product/evaluate/productevaluateList");
		return mv;
	}
	
	/**
	 * 新增
	 * @param productevaluatereplay
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveProductEvaluateReplay")
	@ResponseBody
	public Map<String,Object> saveProductEvaluateReplay(ProductEvaluateReplay productevaluatereplay,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		productevaluatereplay.setrName(user.getuName());
		productevaluatereplay.setRuserId(user.getuId());
		try {
			productevaluatereplayServiceImpl.saveProductEvaluateReplay(productevaluatereplay);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	
}
