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

import com.shifeng.entity.product.ProductConsultation;
import com.shifeng.entity.product.ProductConsultationReplay;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.product.dto.ProductConsultationDTO;
import com.shifeng.seller.product.service.ProductConsultationReplayService;
import com.shifeng.seller.product.service.ProductConsultationService;
import com.shifeng.util.Const;


/** 
 * 商品咨询(p_product_consultation)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */ 
@Controller
@RequestMapping(value="/productconsultation")
public class ProductConsultationController{
	
	@Resource(name="productconsultationServiceImpl")
	private ProductConsultationService productconsultationServiceImpl;
	
	@Resource(name="productconsultationreplayServiceImpl")
	private ProductConsultationReplayService productconsultationreplayServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductConsultationList")
	public ModelAndView goProductConsultationList(ModelAndView mv) throws Exception{
		mv.setViewName("product/consultation/productconsultation");
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
	public ModelAndView findAllProductConsultation(ModelAndView mv,Page page,ProductConsultation productconsultation) throws Exception{
		if(productconsultation==null){
			productconsultation = new ProductConsultation();
		}
		page.setT(productconsultation);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductConsultationDTO> productconsultations = productconsultationServiceImpl.findAllProductConsultation(page);
		mv.addObject("productconsultations", productconsultations);
		mv.addObject("page", page);
		mv.setViewName("product/consultation/productconsultationList");
		return mv;
	}

	/**
	 * 新增
	 * @param ProductConsultationreplay
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveProductConsultationReplay")
	@ResponseBody
	public Map<String,Object> saveProductConsultationReplay(ProductConsultationReplay productConsultationreplay,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		productConsultationreplay.setrName(user.getuName());
		productConsultationreplay.setRuserId(user.getuId());
		try {
			productconsultationreplayServiceImpl.saveProductConsultationReplay(productConsultationreplay);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
}
