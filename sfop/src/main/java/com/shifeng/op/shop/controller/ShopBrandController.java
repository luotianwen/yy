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

import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.shop.ShopBrand;
import com.shifeng.op.brand.service.BrandService;
import com.shifeng.op.dto.shop.AuditBrandDTO;
import com.shifeng.op.dto.shop.ShopBrandDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.shop.service.ShopBrandService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;


/** 
 * 品牌信息(s_shop_brand)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */ 
@Controller
@RequestMapping(value="/shopbrand")
public class ShopBrandController{
	
	@Resource(name="shopbrandServiceImpl")
	private ShopBrandService shopbrandServiceImpl;
	@Resource(name="brandServiceImpl")
	private BrandService brandServiceImpl;
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopBrandList")
	public ModelAndView goShopBrandList(ModelAndView mv,int s_merchants_id) throws Exception{
		mv.addObject("s_merchants_id",s_merchants_id);
		mv.setViewName("shop/shopbrandList");
		return mv;
	}
	/**
	 * 根据店铺ID查询所有
	 * @param page
	 * @param shopbrand
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShopBrandByShop")
	@ResponseBody
	public Map<String,Object> findAllShopBrandByShop(Page page,ShopBrandDTO shopbrand) throws Exception{
		if(shopbrand==null){
			shopbrand = new ShopBrandDTO();
		}
		page.setT(shopbrand);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShopBrandDTO> brands = shopbrandServiceImpl.findAllShopBrandByShop(page);
		map.put("brands", brands);
		return map;
	}


	/**
	 * 查询所有
	 * @param page
	 * @param shopbrand
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShopBrand")
	@ResponseBody
	public Map<String,Object> findAllShopBrand(Page page,ShopBrand shopbrand) throws Exception{
		if(shopbrand==null){
			shopbrand = new ShopBrand();
		}
		page.setT(shopbrand);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Brand> brands = brandServiceImpl.findAllShopBrand(page);
		map.put("brands", brands);
		return map;
	}
 
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopBrandEdit")
	@ResponseBody
	public ModelAndView goShopBrandEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/shopbrandEdit");
		return mv;
	}
	
	/**
	 * 新增
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopBrand")
	@ResponseBody
	public Map<String,Object> saveShopBrand(int  s_merchants_id,int[] b_brand_id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopbrandServiceImpl.saveALLShopBrand(s_merchants_id,b_brand_id,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param shopbrand
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopBrand")
	@ResponseBody
	public Map<String,Object> updateShopBrand(ShopBrand shopbrand,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopbrandServiceImpl.updateShopBrand(shopbrand);
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
	@RequestMapping(value="/deleteShopBrand")
	@ResponseBody
 	public Map<String,Object> deleteShopBrand(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopbrandServiceImpl.deleteShopBrand(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}

	@RequestMapping(value="/goAuditBrand")
	public ModelAndView goAuditBrand(ModelAndView mv){
		mv.setViewName("shop/auditbrandList");
		return mv;
	}
	
	/**
	 * 查询所有审核品牌
	 * @param page
	 * @param shopbrand
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAuditBrand")
	@ResponseBody
	public Map<String,Object> findAuditBrand(Page page,ShopBrand shopbrand) throws Exception{
		if(shopbrand==null){
			shopbrand = new ShopBrand();
		}
		page.setT(shopbrand);
		Map<String,Object> map = new HashMap<String,Object>();
		List<AuditBrandDTO> shopbrands = shopbrandServiceImpl.findAuditBrand(page);
		map.put("shopbrands", shopbrands);
		map.put("page", page);
		return map;
	}
	
	/**
	 * 跳转审核页面
	 * @param mv
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/goAuditBrandEdit")
	@ResponseBody
	public ModelAndView goAuditBrandEdit(ModelAndView mv,String id){
		mv.addObject("id", id);
		mv.setViewName("shop/auditbrandEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findShopBrandById")
	@ResponseBody
	public Map<String,Object> findShopBrandById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		AuditBrandDTO shopbrand = shopbrandServiceImpl.findShopBrandById(id);
		
		map.put("shopbrand",shopbrand);
		return map;
	}
	
	/**
	 * 品牌审核
	 * @param shopbrand
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/auditShopBrand")
	@ResponseBody
	public Map<String,Object> auditShopBrand(ShopBrand shopbrand,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopbrand.setUpdatename(user.getuName());
			shopbrandServiceImpl.updateAuditShopBrand(shopbrand);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 新增品牌
	 */
	@RequestMapping(value="saveBrand")
	@ResponseBody
	public Map<String,Object> saveBrand(Brand brand){
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			brandServiceImpl.saveBrand(brand);
			map.put("id", brand.getId());
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	
}
