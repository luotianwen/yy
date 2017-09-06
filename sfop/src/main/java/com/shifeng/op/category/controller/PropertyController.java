package com.shifeng.op.category.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.category.Property;
import com.shifeng.entity.category.Propertycategory;
import com.shifeng.entity.category.Propertyvalue;
import com.shifeng.op.category.service.PropertyService;
import com.shifeng.op.category.service.PropertycategoryService;
import com.shifeng.op.category.service.PropertyvalueService;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
/** 
 * 属性表(p_property)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */ 
@Controller
@RequestMapping(value="/property")
public class PropertyController{
	
	/**
	 * 属性
	 */
	@Resource(name="propertyServiceImpl")
	private PropertyService propertyServiceImpl;
	/**
	 * 属性值
	 */
	@Resource(name="propertyvalueServiceImpl")
	private PropertyvalueService propertyvalueServiceImpl;
	/**
	 * 分类属性
	 */
	@Resource(name="propertycategoryServiceImpl")
	private PropertycategoryService propertycategoryServiceImpl;
	
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPropertyList")
	public ModelAndView goPropertyList(ModelAndView mv) throws Exception{
		mv.setViewName("category/property/propertyList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllProperty")
	@ResponseBody
	public Map<String,Object> findAllProperty(String name) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<Property> propertys = propertyServiceImpl.findAllProperty(name);
		map.put("propertys", propertys);
		if(propertys.size()>0){
			List<Propertyvalue> propertyValues = propertyvalueServiceImpl.findAllPropertyvalue(propertys.get(0).getId()+"");
			map.put("propertyValues", propertyValues);
			map.put("name", propertys.get(0).getName());
			map.put("id", propertys.get(0).getId());
		}
		
		return map;
	}
 
	/**
	 * 分类新增属性，查询所有属性
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findProperty")
	@ResponseBody
	public Map<String,Object> findProperty(String id,String parentid,String name) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<Property> propertys = propertyServiceImpl.findAllProperty(name);
		map.put("propertys", propertys);
		
		List<Propertycategory> propertycategory = propertycategoryServiceImpl.findAllPropertycategoryByCid(id,parentid);
		map.put("propertycategory", propertycategory);
		
		return map;
	}
	
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPropertyEdit")
	@ResponseBody
	public ModelAndView goPropertyEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("category/property/propertyEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findPropertyById")
	@ResponseBody
	public Map<String,Object> findPropertyById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Property property = propertyServiceImpl.findPropertyById(id);
		map.put("property", property);
		return map;
	}
	
	/**
	 * 新增
	 * @param Property
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveProperty")
	@ResponseBody
	public Map<String,Object> saveProperty(Property property,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		property.setUpdatename(user.getuName());
		try {
			propertyServiceImpl.saveProperty(property);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param Property
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProperty")
	@ResponseBody
	public Map<String,Object> updateProperty(Property property,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		property.setUpdatename(user.getuName());
		try {
			propertyServiceImpl.updateProperty(property);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 删除
	 * @param property
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="deleteProperty")
	@ResponseBody
	public Map<String,Object> deleteProperty(String id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			propertyServiceImpl.deleteProperty(id,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
		}
		return map;
	}
 
 
}
