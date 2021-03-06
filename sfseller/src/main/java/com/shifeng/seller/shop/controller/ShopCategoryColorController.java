package com.shifeng.seller.shop.controller;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.entity.shop.ShopCategoryColor;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.dto.ShopCategoryDTO;
import com.shifeng.seller.shop.service.ShopCategoryColorService;
import com.shifeng.seller.shop.service.ShopCategoryService;
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
 * 店铺分类颜色属性(p_shop_category_color)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-28 13:20:44 
 */ 
@Controller
@RequestMapping(value="/shopcategorycolor")
public class ShopCategoryColorController extends BaseController {

	@Resource(name="shopcategorycolorServiceImpl")
	private ShopCategoryColorService shopcategorycolorServiceImpl;
	
	@Resource(name="shopcategoryServiceImpl")
	private ShopCategoryService shopcategoryServiceImpl;
	
	/**
	 * 跳转店铺分类管理页面
	 */
	@RequestMapping(value="/goShopCategoryColor")
	@ResponseBody
	public ModelAndView goShopCategoryColor(ModelAndView mv,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		try {
			List<ShopCategoryDTO> shopCategoryDTO = shopcategoryServiceImpl.findAllParentCategoryByShopId(user.getShopid()+"");
			mv.addObject("shopCategoryDTO", shopCategoryDTO);
			
			mv.setViewName("order/shopcolor");
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
	@RequestMapping(value="/findAllShopCategoryColor")
	@ResponseBody
	public ModelAndView findAllShopCategoryColor(ModelAndView mv,Page page,String cid,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		try {
			List<ShopCategoryColor> shopCategoryColors = shopcategorycolorServiceImpl.findAllShopCategoryColorPage(page,cid,user.getShopid()+"");
			mv.addObject("shopCategoryColors", shopCategoryColors);
			
			mv.addObject("categoryid", cid);
			mv.setViewName("order/shopcolorList");
		} catch (Exception e) {
			mv.setViewName("500");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 新增
	 * @param shopcategorycolor
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopCategoryColor")
	@ResponseBody
	public Map<String,Object> saveShopCategoryColor(ShopCategoryColor shopcategorycolor,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		shopcategorycolor.setShopid(user.getShopid());
		try {
			if(!StringUtils.isEmpty(shopcategorycolor.getName())){
				shopcategorycolorServiceImpl.saveShopCategoryColor(shopcategorycolor,map);
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			}else{
				map.put(Const.ERROR_INFO, "颜色名称不能为空!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param shopcategorycolor
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopCategoryColor")
	@ResponseBody
	public Map<String,Object> updateShopCategoryColor(ShopCategoryColor shopcategorycolor,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		try {
			shopcategorycolorServiceImpl.updateShopCategoryColor(shopcategorycolor);
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
	@RequestMapping(value="/deleteShopCategoryColor")
	@ResponseBody
 	public Map<String,Object> deleteShopCategoryColor(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopcategorycolorServiceImpl.deleteShopCategoryColor(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		return map;
 	}
 
}
