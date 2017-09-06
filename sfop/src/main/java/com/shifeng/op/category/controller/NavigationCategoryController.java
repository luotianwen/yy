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

import com.shifeng.entity.category.NavigationCategory;
import com.shifeng.op.category.service.NavigationCategoryService;
import com.shifeng.op.dto.category.NavigationCategoryDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
/** 
 * 分类导航关联表(p_navigation_category)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 14:37:55 
 */ 
@Controller
@RequestMapping(value="/navigationcategory")
public class NavigationCategoryController{
	
	@Resource(name="navigationcategoryServiceImpl")
	private NavigationCategoryService navigationcategoryServiceImpl;

	/**
	 * 查询所有导航分类
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllNavigationCategoryByNid")
	@ResponseBody
	public List<NavigationCategoryDTO> findAllNavigationCategoryByNid(String id) throws Exception{
		List<NavigationCategoryDTO> navigationcategorys = navigationcategoryServiceImpl.findAllNavigationCategoryByNid(id);
		return navigationcategorys;
	}
	 
	/**
	 * 根据父分类查询所有子分类
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllNavigationCategoryByPid")
	@ResponseBody
	public List<NavigationCategoryDTO> findAllNavigationCategoryByPid(String id,String nid) throws Exception{
		List<NavigationCategoryDTO> navigationcategorys = navigationcategoryServiceImpl.findAllNavigationCategoryByPid(id,nid);
		return navigationcategorys;
	}
	
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllNavigationCategory")
	@ResponseBody
	public Map<String,Object> findAllNavigationCategory(Page page,ModelAndView mv) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<NavigationCategory> navigationcategorys = navigationcategoryServiceImpl.findAllNavigationCategory(page);
		map.put("navigationcategorys", navigationcategorys);
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
	@RequestMapping(value="/goNavigationCategoryEdit")
	@ResponseBody
	public ModelAndView goNavigationCategoryEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("category/navigation/navigationcategoryEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findNavigationCategoryById")
	@ResponseBody
	public Map<String,Object> findNavigationCategoryById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		NavigationCategory navigationcategory = navigationcategoryServiceImpl.findNavigationCategoryById(id);
		map.put("navigationcategory", navigationcategory);
		return map;
	}
	
	/**
	 * 新增
	 * @param NavigationCategoryDTO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveNavigationCategory")
	@ResponseBody
	public Map<String,Object> saveNavigationCategory(String id,String ids,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			navigationcategoryServiceImpl.saveNavigationCategory(id,ids,user.getuName());
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param NavigationCategoryDTO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateNavigationCategory")
	@ResponseBody
	public Map<String,Object> updateNavigationCategory(NavigationCategory navigationcategory,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		navigationcategory.setUpdatename(user.getuName());
		try {
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			navigationcategoryServiceImpl.updateNavigationCategory(navigationcategory);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	@RequestMapping(value="/deleteNavigationcategory")
	@ResponseBody
	public Map<String,Object> deleteNavigationcategory(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			navigationcategoryServiceImpl.deleteNavigationcategory(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
}
