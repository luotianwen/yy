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

import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.op.shop.service.ShopinfoLogService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 店铺审核日志(s_shopinfo_log)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */ 
@Controller
@RequestMapping(value="/shopinfolog")
public class ShopinfoLogController{
	
	@Resource(name="shopinfologServiceImpl")
	private ShopinfoLogService shopinfologServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goShopinfoLogList")
	public ModelAndView goShopinfoLogList(ModelAndView mv,int s_merchants_id,int type) throws Exception{
		mv.addObject("s_merchants_id",s_merchants_id);
		mv.addObject("type",type);
		mv.setViewName("shop/shopinfologList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param shopinfolog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllShopinfoLog")
	@ResponseBody
	public Map<String,Object> findAllShopinfoLog(Page page,ShopinfoLog shopinfolog) throws Exception{
		if(shopinfolog==null){
			shopinfolog = new ShopinfoLog();
		}
		page.setT(shopinfolog);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ShopinfoLog> shopinfologs = shopinfologServiceImpl.findAllShopinfoLog(page);
		map.put("shopinfologs", shopinfologs);
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
	@RequestMapping(value="/goShopinfoLogEdit")
	@ResponseBody
	public ModelAndView goShopinfoLogEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/shopinfologEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findShopinfoLogById")
	@ResponseBody
	public Map<String,Object> findShopinfoLogById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ShopinfoLog shopinfolog = shopinfologServiceImpl.findShopinfoLogById(id);
		map.put("shopinfolog",shopinfolog);
		return map;
	}
	
	/**
	 * 新增
	 * @param shopinfolog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveShopinfoLog")
	@ResponseBody
	public Map<String,Object> saveShopinfoLog(ShopinfoLog shopinfolog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopinfologServiceImpl.saveShopinfoLog(shopinfolog);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param shopinfolog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShopinfoLog")
	@ResponseBody
	public Map<String,Object> updateShopinfoLog(ShopinfoLog shopinfolog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			shopinfologServiceImpl.updateShopinfoLog(shopinfolog);
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
	@RequestMapping(value="/deleteShopinfoLog")
	@ResponseBody
 	public Map<String,Object> deleteShopinfoLog(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			shopinfologServiceImpl.deleteShopinfoLog(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
