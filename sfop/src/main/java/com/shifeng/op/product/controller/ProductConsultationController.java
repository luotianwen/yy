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

import com.shifeng.entity.product.ProductConsultation;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.product.service.ProductConsultationService;
import com.shifeng.op.shop.service.ShopinfoService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.dto.product.ProductConsultationDTO;
import com.shifeng.op.entity.users.Users;


/** 
 * 商品咨询(p_product_consultation)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:53 
 */ 
@Controller
@RequestMapping(value="/productconsultation")
public class ProductConsultationController{
	
	@Resource(name="productconsultationServiceImpl")
	private ProductConsultationService productconsultationServiceImpl;

	@Resource(name="shopinfoServiceImpl")
	private ShopinfoService shopinfoServiceImpl;
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductConsultationList")
	public ModelAndView goProductConsultationList(ModelAndView mv) throws Exception{
		List<Shopinfo> shopinfos =shopinfoServiceImpl.findAllShopinfoByState();
		mv.addObject("shopinfos",shopinfos);
		
		mv.setViewName("product/productconsultationList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param productconsultation
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllProductConsultation")
	@ResponseBody
	public Map<String,Object> findAllProductConsultation(Page page,ProductConsultation productconsultation) throws Exception{
		if(productconsultation==null){
			productconsultation = new ProductConsultation();
		}
		page.setT(productconsultation);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductConsultationDTO> productconsultations = productconsultationServiceImpl.findAllProductConsultation(page);
		map.put("productconsultations", productconsultations);
		map.put("page", page);
		return map;
	}
 
	/**
	 * 修改
	 * @param productconsultation
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProductConsultation")
	@ResponseBody
	public Map<String,Object> updateProductConsultation(ProductConsultation productconsultation,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			productconsultationServiceImpl.updateProductConsultation(productconsultation);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
}
