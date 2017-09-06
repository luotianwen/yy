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

import com.shifeng.entity.product.ProductEvaluate;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.product.service.ProductEvaluateService;
import com.shifeng.op.shop.service.ShopinfoService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.dto.product.ProductEvaluateDTO;
import com.shifeng.op.entity.users.Users;


/** 
 * 商品评价(p_product_evaluate)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:52 
 */ 
@Controller
@RequestMapping(value="/productevaluate")
public class ProductEvaluateController{
	
	@Resource(name="productevaluateServiceImpl")
	private ProductEvaluateService productevaluateServiceImpl;

	@Resource(name="shopinfoServiceImpl")
	private ShopinfoService shopinfoServiceImpl;
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductEvaluateList")
	public ModelAndView goProductEvaluateList(ModelAndView mv) throws Exception{
		List<Shopinfo> shopinfos =shopinfoServiceImpl.findAllShopinfoByState();
		mv.addObject("shopinfos",shopinfos);
		
		mv.setViewName("product/productevaluateList");
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
	public Map<String,Object> findAllProductEvaluate(Page page,ProductEvaluate productevaluate) throws Exception{
		if(productevaluate==null){
			productevaluate = new ProductEvaluate();
		}
		page.setT(productevaluate);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductEvaluateDTO> productevaluates = productevaluateServiceImpl.findAllProductEvaluate(page);
		map.put("productevaluates", productevaluates);
		map.put("page", page);
		return map;
	}
 
	/**
	 * 修改
	 * @param productevaluate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProductEvaluate")
	@ResponseBody
	public Map<String,Object> updateProductEvaluate(ProductEvaluate productevaluate,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			productevaluateServiceImpl.updateProductEvaluate(productevaluate);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}

}
