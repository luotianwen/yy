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

import com.shifeng.entity.category.Propertycategory;
import com.shifeng.op.category.service.PropertycategoryService;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
/** 
 * 分类属性关联表(p_propertycategory)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-14 15:25:20 
 */ 
@Controller
@RequestMapping(value="/propertycategory")
public class PropertycategoryController{
	
	@Resource(name="propertycategoryServiceImpl")
	private PropertycategoryService propertycategoryServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPropertycategoryList")
	public ModelAndView goPropertycategoryList(ModelAndView mv,String id,String parentid) throws Exception{
		mv.addObject("cid", id);
		mv.addObject("parentid", parentid);
		mv.setViewName("category/property/propertycategory");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllPropertycategory")
	@ResponseBody
	public Map<String,Object> findAllPropertycategory(Page page) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<Propertycategory> propertycategorys = propertycategoryServiceImpl.findAllPropertycategory(page);
		map.put("propertycategorys", propertycategorys);
		map.put("page", page);
		return map;
	}
 
	/**
	 * 根据分类查询所有分类属性
	 * @param id 分类ID
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllPropertycategoryByPid")
	@ResponseBody
	public List<Propertycategory> findAllPropertycategoryByPid(String id,String parentid) throws Exception{
		List<Propertycategory> propertycategorys = propertycategoryServiceImpl.findAllPropertycategoryByCid(id,parentid);
		return propertycategorys;
	}
	
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPropertycategoryEdit")
	@ResponseBody
	public ModelAndView goPropertycategoryEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("category/property/propertycategoryEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findPropertycategoryById")
	@ResponseBody
	public Map<String,Object> findPropertycategoryById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Propertycategory propertycategory = propertycategoryServiceImpl.findPropertycategoryById(id);
		map.put("propertycategory", propertycategory);
		return map;
	}
	
	/**
	 * 新增
	 * @param Propertycategory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/savePropertycategory")
	@ResponseBody
	public Map<String,Object> savePropertycategory(Propertycategory propertycategory,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		propertycategory.setUpdatename(user.getuName());
		try {
			propertycategoryServiceImpl.savePropertycategory(propertycategory);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param Propertycategory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updatePropertycategory")
	@ResponseBody
	public Map<String,Object> updatePropertycategory(Propertycategory propertycategory,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		propertycategory.setUpdatename(user.getuName());
		try {
			propertycategoryServiceImpl.updatePropertycategory(propertycategory);
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
	@RequestMapping(value="/deletePropertycategory")
	@ResponseBody
	public Map<String,Object> deletePropertycategory(String id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			propertycategoryServiceImpl.deletePropertycategory(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
 
}
