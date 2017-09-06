package com.shifeng.seller.shop.controller;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.entity.shop.ShopCategorySpec;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.dto.ShopCategoryDTO;
import com.shifeng.seller.shop.service.ShopCategoryService;
import com.shifeng.seller.shop.service.ShopCategorySpecService;
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
 * 店铺分类规格属性(p_shop_category_spec)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-28 13:20:44 
 */ 
@Controller
@RequestMapping(value="/shopcategoryspec")
public class ShopCategorySpecController extends BaseController {

	@Resource(name="shopcategoryspecServiceImpl")
	private ShopCategorySpecService shopcategoryspecServiceImpl;

	@Resource(name="shopcategoryServiceImpl")
	private ShopCategoryService shopcategoryServiceImpl;
	
	/**
	 * 跳转店铺分类管理页面
	 */
	@RequestMapping(value="/goShopCategorySpec")
	@ResponseBody
	public ModelAndView goShopCategorySpec(ModelAndView mv,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		try {
			List<ShopCategoryDTO> shopCategoryDTO = shopcategoryServiceImpl.findAllParentCategoryByShopId(user.getShopid()+"");
			mv.addObject("shopCategoryDTO", shopCategoryDTO);
			
			mv.setViewName("order/shopspec");
		} catch (Exception e) {
			mv.setViewName("500");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 查询所有
	 * @param page
	 * @param cid 分类ID
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/findAllShopCategorySpec")
	@ResponseBody
	public ModelAndView findAllShopCategorySpec(ModelAndView mv,Page page,String cid,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		try {
			List<ShopCategorySpec> shopCategorySpecs = shopcategoryspecServiceImpl.findAllShopCategorySpecPage(page,cid,user.getShopid()+"");
			mv.addObject("shopCategorySpecs", shopCategorySpecs);

			mv.addObject("categoryid", cid);
			mv.setViewName("order/shopspecList");
		} catch (Exception e) {
			mv.setViewName("500");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 新增
	 * @param shopcategoryspec
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopCategorySpec")
	@ResponseBody
	public Map<String,Object> saveShopCategorySpec(ShopCategorySpec shopcategoryspec,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		shopcategoryspec.setShopid(user.getShopid());
		try {
			if(!StringUtils.isEmpty(shopcategoryspec.getName())){
				shopcategoryspecServiceImpl.saveShopCategorySpec(shopcategoryspec,map);
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			}else{
				map.put(Const.ERROR_INFO, "规格名称不能为空!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param shopcategoryspec
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopCategorySpec")
	@ResponseBody
	public Map<String,Object> updateShopCategorySpec(ShopCategorySpec shopcategoryspec,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			shopcategoryspecServiceImpl.updateShopCategorySpec(shopcategoryspec);
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
	@RequestMapping(value="/deleteShopCategorySpec")
	@ResponseBody
 	public Map<String,Object> deleteShopCategorySpec(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopcategoryspecServiceImpl.deleteShopCategorySpec(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
 	}
 
}
