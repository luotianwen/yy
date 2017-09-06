package com.shifeng.op.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.mall.MallCart;
import com.shifeng.op.mall.service.MallCartService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 购物车(mall_cart)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */ 
@Controller
@RequestMapping(value="/mallcart")
public class MallCartController{
	
	@Resource(name="mallcartServiceImpl")
	private MallCartService mallcartServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallCartList")
	public ModelAndView goMallCartList(ModelAndView mv) throws Exception{
		mv.setViewName("mall/mallcartList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mallcart
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallCart")
	@ResponseBody
	public Map<String,Object> findAllMallCart(Page page,MallCart mallcart) throws Exception{
		if(mallcart==null){
			mallcart = new MallCart();
		}
		page.setT(mallcart);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallCart> mallcarts = mallcartServiceImpl.findAllMallCart(page);
		map.put("mallcarts", mallcarts);
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
	@RequestMapping(value="/goMallCartEdit")
	@ResponseBody
	public ModelAndView goMallCartEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/mallcartEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallCartById")
	@ResponseBody
	public Map<String,Object> findMallCartById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallCart mallcart = mallcartServiceImpl.findMallCartById(id);
		map.put("mallcart",mallcart);
		return map;
	}
	
	/**
	 * 新增
	 * @param mallcart
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallCart")
	@ResponseBody
	public Map<String,Object> saveMallCart(MallCart mallcart,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallcartServiceImpl.saveMallCart(mallcart);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param mallcart
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallCart")
	@ResponseBody
	public Map<String,Object> updateMallCart(MallCart mallcart,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallcartServiceImpl.updateMallCart(mallcart);
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
	@RequestMapping(value="/deleteMallCart")
	@ResponseBody
 	public Map<String,Object> deleteMallCart(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			mallcartServiceImpl.deleteMallCart(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
