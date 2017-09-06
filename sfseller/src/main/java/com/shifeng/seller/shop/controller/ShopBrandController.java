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

import com.alibaba.druid.util.StringUtils;
import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.shop.ShopBrand;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.brand.service.BrandService;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.dto.ShopBrandDTO;
import com.shifeng.seller.shop.service.ShopBrandService;
import com.shifeng.util.Const;


/** 
 * 品牌信息(s_shop_brand)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */ 
@Controller
@RequestMapping(value="/shopbrand")
public class ShopBrandController extends BaseController {
	
	@Resource(name="shopbrandServiceImpl")
	private ShopBrandService shopbrandServiceImpl;
	@Resource(name="brandServiceImpl")
	private BrandService brandServiceImpl;
	
	/**
	 * 跳转品牌管理页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopBrand")
	@ResponseBody
	public ModelAndView goShopBrand(ModelAndView mv,HttpSession session) throws Exception{
		mv.setViewName("brand/mybrand");
		return mv;
	}
	
	/**
	 * 品牌管理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMyShopBrand")
	@ResponseBody
	public ModelAndView findMyShopBrand(ModelAndView mv,Page page,ShopBrand shopBrand,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		shopBrand.setUpdatename(user.getuName());
		shopBrand.setS_merchants_id(user.getShopid());
		page.setT(shopBrand);
		List<ShopBrandDTO> shopbrand = shopbrandServiceImpl.findMyShopBrand(page);
		
		mv.addObject("page", page);
		mv.addObject("shopbrand", shopbrand);
		
		mv.setViewName("brand/brandList");
		return mv;
	}
	
	/**
	 * 搜索品牌
	 * @param page
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/searchBrand")
	@ResponseBody
	public Map<String,Object> searchBrand(Page page,String name) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		page.setT(name);
		List<Brand> brand = shopbrandServiceImpl.searchBrand(page);
		map.put("page", page);
		map.put("brand", brand);
		return map;
	}
	
	/**
	 * 跳转申请品牌页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="goApplyBrand")
	@ResponseBody
	public ModelAndView goApplyBrand(ModelAndView mv){
		mv.setViewName("brand/applyBrand");
		return mv;
	}
	
	/**
	 * 根据ID查询品牌信息
	 * @param mv
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findBrandById")
	@ResponseBody
	public ModelAndView findBrandById(ModelAndView mv,String id){
		try {
			if(!StringUtils.isEmpty(id)){
				Brand brand = shopbrandServiceImpl.findBrandById(id);
				mv.addObject("brand", brand);
				mv.setViewName("brand/editBrand");
			}else{
				mv.setViewName("brand/saveBrand");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 新增审核品牌
	 */
	@RequestMapping(value="applyBrand")
	@ResponseBody
	public Map<String,Object> saveApplyBrand(ShopBrand shopBrand,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			shopbrandServiceImpl.saveApplyBrand(shopBrand,user.getShopid());
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 根据ID查询商家品牌信息
	 * @param mv
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findShopBrandById")
	@ResponseBody
	public ModelAndView findShopBrandById(ModelAndView mv,String id,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			ShopBrandDTO dto = shopbrandServiceImpl.findShopBrandById(id,user);
			mv.addObject("dto", dto);
			mv.setViewName("brand/shopbrand");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
}
