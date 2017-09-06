package com.shifeng.op.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.shifeng.op.dto.shop.ShopDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.shop.service.ShopinfoService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 店铺表(s_shopinfo)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */ 
@Controller
@RequestMapping(value="/shopinfo")
public class ShopinfoController{
	
	@Resource(name="shopinfoServiceImpl")
	private ShopinfoService shopinfoServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopinfoList")
	public ModelAndView goShopinfoList(ModelAndView mv) throws Exception{
		mv.setViewName("shop/shopinfoList");
		return mv;
	}

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopinfoPassList")
	public ModelAndView goPassShopinfoList(ModelAndView mv) throws Exception{
		mv.setViewName("shop/shopinfoPassList");
		return mv;
	}
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopinfoPassEdit")
	@ResponseBody
	public ModelAndView goShopinfoPassEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/shopinfoPassEdit");
		return mv;
	}
	/**
	 * 查询所有
	 * @param page
	 * @param shopinfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllPassShopinfo")
	@ResponseBody
	public Map<String,Object> findAllPassShopinfo(Page page,ShopDTO shopinfo) throws Exception{
		if(shopinfo==null){
			shopinfo = new ShopDTO();
		}
		page.setT(shopinfo);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShopDTO> shopinfos = shopinfoServiceImpl.findAllPassShopinfo(page);
		map.put("shopinfos", shopinfos);
		map.put("page", page);
		return map;
	}

	/**
	 * 查询所有
	 * @param page
	 * @param shopinfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShopinfo")
	@ResponseBody
	public Map<String,Object> findAllShopinfo(Page page,ShopDTO shopinfo) throws Exception{
		if(shopinfo==null){
			shopinfo = new ShopDTO();
		}
		page.setT(shopinfo);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShopDTO> shopinfos = shopinfoServiceImpl.findAllShopinfo(page);
		map.put("shopinfos", shopinfos);
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
	@RequestMapping(value="/goShopinfoEdit")
	@ResponseBody
	public ModelAndView goShopinfoEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/shopinfoEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findShopinfoById")
	@ResponseBody
	public Map<String,Object> findShopinfoById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Shopinfo shopinfo = shopinfoServiceImpl.findShopinfoById(id);
		map.put("shopinfo",shopinfo);
		return map;
	}

	/**
	 * 新增
	 * @param shopinfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopinfo")
	@ResponseBody
	public Map<String,Object> saveShopinfo(Shopinfo shopinfo,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopinfoServiceImpl.saveShopinfo(shopinfo);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 修改
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateAccount")
	@ResponseBody
	public Map<String,Object> updateAccount(String id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			int pwd=shopinfoServiceImpl.updateAccount(id,user);
			if(pwd!=0) {
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
				map.put("info", pwd);
			}else{
				map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 修改
	 * @param shopinfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopinfo")
	@ResponseBody
	public Map<String,Object> updateShopinfo(Shopinfo shopinfo,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopinfo.setUpdatename(user.getuName());
			shopinfoServiceImpl.updateShopinfo(shopinfo,map);
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
	@RequestMapping(value="/deleteShopinfo")
	@ResponseBody
 	public Map<String,Object> deleteShopinfo(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopinfoServiceImpl.deleteShopinfo(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}

	/**
	 *审核通过
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/passShopinfo")
	@ResponseBody
	public Map<String,Object> passShopinfo(int id,String note,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopinfoServiceImpl.passShopinfo(id,note,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopinfoPassView")
	@ResponseBody
	public ModelAndView goShopinfoPassView(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/shopinfoPassView");
		return mv;
	}

	/**
	 * 驳回
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/backShopinfo")
	@ResponseBody
	public Map<String,Object> backShopinfo(int id,String note,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopinfoServiceImpl.backShopinfo(id,note,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
}
