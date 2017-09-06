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

import com.shifeng.entity.shop.ShopCategory;
import com.shifeng.op.shop.service.ShopCategoryService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 店铺经营类目(s_shop_category)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */ 
@Controller
@RequestMapping(value="/shopcategory")
public class ShopCategoryController{
	
	@Resource(name="shopcategoryServiceImpl")
	private ShopCategoryService shopcategoryServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopCategoryList")
	public ModelAndView goShopCategoryList(ModelAndView mv) throws Exception{
		mv.setViewName("shop/shopcategoryList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param shopcategory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShopCategory")
	@ResponseBody
	public Map<String,Object> findAllShopCategory(Page page,ShopCategory shopcategory) throws Exception{
		if(shopcategory==null){
			shopcategory = new ShopCategory();
		}
		page.setT(shopcategory);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShopCategory> shopcategorys = shopcategoryServiceImpl.findAllShopCategory(page);
		map.put("shopcategorys", shopcategorys);
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
	@RequestMapping(value="/goShopCategoryEdit")
	@ResponseBody
	public ModelAndView goShopCategoryEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/shopcategoryEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findShopCategoryById")
	@ResponseBody
	public Map<String,Object> findShopCategoryById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ShopCategory shopcategory = shopcategoryServiceImpl.findShopCategoryById(id);
		map.put("shopcategory",shopcategory);
		return map;
	}
	
	/**
	 * 新增
	 * @param shopcategory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopCategory")
	@ResponseBody
	public Map<String,Object> saveShopCategory(ShopCategory shopcategory,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopcategoryServiceImpl.saveShopCategory(shopcategory);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param shopcategory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopCategory")
	@ResponseBody
	public Map<String,Object> updateShopCategory(ShopCategory shopcategory,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopcategoryServiceImpl.updateShopCategory(shopcategory);
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
	@RequestMapping(value="/deleteShopCategory")
	@ResponseBody
 	public Map<String,Object> deleteShopCategory(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopcategoryServiceImpl.deleteShopCategory(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
