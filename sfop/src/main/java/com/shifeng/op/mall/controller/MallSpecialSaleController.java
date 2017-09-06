package com.shifeng.op.mall.controller;

import com.shifeng.entity.mall.MallSpecialSale;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.mall.service.MallSpecialSaleService;
import com.shifeng.plugin.page.Page;
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
 * 特卖(mall_special_sale)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:47 
 */ 
@Controller
@RequestMapping(value="/mallspecialsale")
public class MallSpecialSaleController{
	
	@Resource(name="mallspecialsaleServiceImpl")
	private MallSpecialSaleService mallspecialsaleServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallSpecialSaleList")
	public ModelAndView goMallSpecialSaleList(ModelAndView mv) throws Exception{
		mv.setViewName("mall/mallspecialsaleList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mallspecialsale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallSpecialSale")
	@ResponseBody
	public Map<String,Object> findAllMallSpecialSale(Page page,MallSpecialSale mallspecialsale) throws Exception{
		if(mallspecialsale==null){
			mallspecialsale = new MallSpecialSale();
		}
		page.setT(mallspecialsale);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallSpecialSale> mallspecialsales = mallspecialsaleServiceImpl.findAllMallSpecialSale(page);
		map.put("mallspecialsales", mallspecialsales);
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
	@RequestMapping(value="/goMallSpecialSaleEdit")
	@ResponseBody
	public ModelAndView goMallSpecialSaleEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/mallspecialsaleEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallSpecialSaleById")
	@ResponseBody
	public Map<String,Object> findMallSpecialSaleById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallSpecialSale mallspecialsale = mallspecialsaleServiceImpl.findMallSpecialSaleById(id);
		map.put("mallspecialsale",mallspecialsale);
		return map;
	}
	
	/**
	 * 新增
	 * @param mallspecialsale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallSpecialSale")
	@ResponseBody
	public Map<String,Object> saveMallSpecialSale(MallSpecialSale mallspecialsale,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallspecialsale.setUser_id(user.getuId());
			mallspecialsale.setUpdateName(user.getuName());
			mallspecialsaleServiceImpl.saveMallSpecialSale(mallspecialsale);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param mallspecialsale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallSpecialSale")
	@ResponseBody
	public Map<String,Object> updateMallSpecialSale(MallSpecialSale mallspecialsale,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallspecialsale.setUpdateName(user.getuName());
			mallspecialsaleServiceImpl.updateMallSpecialSale(mallspecialsale);
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
	@RequestMapping(value="/deleteMallSpecialSale")
	@ResponseBody
 	public Map<String,Object> deleteMallSpecialSale(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			mallspecialsaleServiceImpl.deleteMallSpecialSale(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
