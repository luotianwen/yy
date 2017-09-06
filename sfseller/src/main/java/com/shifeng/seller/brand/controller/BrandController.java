package com.shifeng.seller.brand.controller;

import com.shifeng.entity.brand.Brand;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.brand.service.BrandService;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** 
 * 品牌表(b_brand)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 15:01:34 
 */ 
@Controller
@RequestMapping(value="/brand")
public class BrandController{
	
	@Resource(name="brandServiceImpl")
	private BrandService brandServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goBrandList")
	public ModelAndView goBrandList(ModelAndView mv) throws Exception{
		mv.setViewName("brand/brandList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllBrand")
	@ResponseBody
	public Map<String,Object> findAllBrand(Page page,ModelAndView mv ,Brand brand) throws Exception{
		page.setT(brand);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Brand> brands = brandServiceImpl.findAllBrand(page);
		map.put("brands", brands);
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
	@RequestMapping(value="/goBrandEdit")
	@ResponseBody
	public ModelAndView goBrandEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("brand/brandEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findBrandById")
	@ResponseBody
	public Map<String,Object> findBrandById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Brand brand = brandServiceImpl.findBrandById(id);
		map.put("brand", brand);
		return map;
	}

	@RequestMapping(value="/goBrandOpen")
	@ResponseBody
	public Map<String,Object> goBrandOpen(Brand brand,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		brand.setUpdatename(user.getuName());
		try {
			brandServiceImpl.updateBrandOpen(brand);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 新增
	 * @param brand
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveBrand")
	@ResponseBody
	public Map<String,Object> saveBrand(Brand brand,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		brand.setUpdatename(user.getuName());
		try {
			brandServiceImpl.saveBrand(brand);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param brand
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateBrand")
	@ResponseBody
	public Map<String,Object> updateBrand(Brand brand,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		brand.setUpdatename(user.getuName());
		try {
			brandServiceImpl.updateBrand(brand);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
	}
	
 
 
}
