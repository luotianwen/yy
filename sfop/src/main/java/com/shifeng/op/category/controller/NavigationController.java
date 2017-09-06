package com.shifeng.op.category.controller;

import com.shifeng.entity.category.Navigation;
import com.shifeng.op.category.service.NavigationService;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
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
 * 导航表(p_navigation)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 14:37:55 
 */ 
@Controller
@RequestMapping(value="/navigation")
public class NavigationController{
	
	@Resource(name="navigationServiceImpl")
	private NavigationService navigationServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goNavigationList")
	public ModelAndView goNavigationList(ModelAndView mv) throws Exception{
		mv.setViewName("category/navigation/navigationList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有导航
 	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllNavigation")
	@ResponseBody
	public Map<String,Object> findAllNavigation(Page page) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<Navigation> navigations = navigationServiceImpl.findAllNavigation(page);
		map.put("navigations", navigations);
		return map;
	}
 
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goNavigationEdit")
	@ResponseBody
	public ModelAndView goNavigationEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("category/navigation/navigationEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findNavigationById")
	@ResponseBody
	public Map<String,Object> findNavigationById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Navigation navigation = navigationServiceImpl.findNavigationById(id);
		map.put("navigation", navigation);
		return map;
	}
	
	/**
	 * 新增
	 * @param Navigation
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveNavigation")
	@ResponseBody
	public Map<String,Object> saveNavigation(Navigation navigation,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		navigation.setUpdatename(user.getuName());
		try {
			//通知更新导航分类
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			navigationServiceImpl.saveNavigation(navigation);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param Navigation
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateNavigation")
	@ResponseBody
	public Map<String,Object> updateNavigation(Navigation navigation,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		navigation.setUpdatename(user.getuName());
		try {
			//通知更新导航分类
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			navigationServiceImpl.updateNavigation(navigation);
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
	@RequestMapping(value="/deleteNavigation")
	@ResponseBody
	public Map<String,Object> deleteNavigation(String id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		
		try {
			//通知更新导航分类
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			navigationServiceImpl.deleteNavigation(id,user.getuName());
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
 
}
