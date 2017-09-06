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

import com.shifeng.entity.category.Propertyvalue;
import com.shifeng.op.category.service.PropertyvalueService;
import com.shifeng.op.entity.users.Users;
import com.shifeng.util.Const;
/** 
 * 属性值表(p_propertyvalue)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */ 
@Controller
@RequestMapping(value="/propertyvalue")
public class PropertyvalueController{
	
	@Resource(name="propertyvalueServiceImpl")
	private PropertyvalueService propertyvalueServiceImpl;

	
	/**
	 * 根据属性ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllPropertyvalue")
	@ResponseBody
	public List<Propertyvalue> findAllPropertyvalue(String id) throws Exception{
		List<Propertyvalue> propertyValues = propertyvalueServiceImpl.findAllPropertyvalue(id);
		return propertyValues;
	}
	
	/**
	 * 跳转新增页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPropertyvalueAdd")
	@ResponseBody
	public ModelAndView goPropertyvalueAdd(ModelAndView mv,String id) throws Exception{
		mv.addObject("pid", id);
		mv.setViewName("category/property/propertyvalueEdit");
		return mv;
	}
	
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPropertyvalueEdit")
	@ResponseBody
	public ModelAndView goPropertyvalueEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("category/property/propertyvalueEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findPropertyvalueById")
	@ResponseBody
	public Map<String,Object> findPropertyvalueById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Propertyvalue propertyvalue = propertyvalueServiceImpl.findPropertyvalueById(id);
		map.put("propertyvalue", propertyvalue);
		return map;
	}
	
	/**
	 * 新增
	 * @param Propertyvalue
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/savePropertyvalue")
	@ResponseBody
	public Map<String,Object> savePropertyvalue(Propertyvalue propertyvalue,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		propertyvalue.setUpdatename(user.getuName());
		try {
			propertyvalueServiceImpl.savePropertyvalue(propertyvalue);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param Propertyvalue
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updatePropertyvalue")
	@ResponseBody
	public Map<String,Object> updatePropertyvalue(Propertyvalue propertyvalue,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		propertyvalue.setUpdatename(user.getuName());
		try {
			propertyvalueServiceImpl.updatePropertyvalue(propertyvalue);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 删除
	 * @param Propertyvalue
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deletePropertyvalue")
	@ResponseBody
	public Map<String,Object> deletePropertyvalue(String id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			propertyvalueServiceImpl.deletePropertyvalue(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
 
}
