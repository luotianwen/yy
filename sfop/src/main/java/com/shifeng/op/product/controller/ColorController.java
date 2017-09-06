package com.shifeng.op.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.product.Color;
import com.shifeng.op.product.service.ColorService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 颜色表(p_color)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */ 
@Controller
@RequestMapping(value="/color")
public class ColorController{
	
	@Resource(name="colorServiceImpl")
	private ColorService colorServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goColorList")
	public ModelAndView goColorList(ModelAndView mv) throws Exception{
		mv.setViewName("product/colorList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param color
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllColor")
	@ResponseBody
	public Map<String,Object> findAllColor(Page page,Color color) throws Exception{
		if(color==null){
			color = new Color();
		}
		page.setT(color);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Color> colors = colorServiceImpl.findAllColor(page);
		map.put("colors", colors);
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
	@RequestMapping(value="/goColorEdit")
	@ResponseBody
	public ModelAndView goColorEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("product/colorEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findColorById")
	@ResponseBody
	public Map<String,Object> findColorById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Color color = colorServiceImpl.findColorById(id);
		map.put("color",color);
		return map;
	}
	
	/**
	 * 新增
	 * @param color
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveColor")
	@ResponseBody
	public Map<String,Object> saveColor(Color color,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			colorServiceImpl.saveColor(color);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param color
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateColor")
	@ResponseBody
	public Map<String,Object> updateColor(Color color,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			colorServiceImpl.updateColor(color);
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
	@RequestMapping(value="/deleteColor")
	@ResponseBody
 	public Map<String,Object> deleteColor(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			colorServiceImpl.deleteColor(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
