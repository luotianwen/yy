package com.shifeng.op.category.controller;

import com.shifeng.entity.category.Category;
import com.shifeng.op.category.service.CategoryService;
import com.shifeng.op.dto.category.CategoryDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/** 
 * 分类表(c_category)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-13 11:33:30 
 */ 
@Controller
@RequestMapping(value="/category")
public class CategoryController{
	
	@Resource(name="categoryServiceImpl")
	private CategoryService categoryServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCategoryList")
	public ModelAndView goCategoryList(ModelAndView mv) throws Exception{
		mv.setViewName("category/categoryList");
		return mv;
	}

	 
	/**
	 * 查询所有父分类
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllParentCategory")
	@ResponseBody
	public Map<String,Object> findAllParentCategory(ModelAndView mv) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<Category> category = categoryServiceImpl.findAllParentCategory();
		map.put("category", category);
		return map;
	}
 
	/**
	 * 根据父类ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCategoryByPid")
	@ResponseBody
	public Map<String,Object> findCategoryByPid(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			List<Category> category = categoryServiceImpl.findCategoryByPid(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			map.put("category", category);
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "查询异常!!!");
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
	@RequestMapping(value="/goCategoryEdit")
	@ResponseBody
	public ModelAndView goCategoryEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("category/categoryEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCategoryById")
	@ResponseBody
	public Map<String,Object> findCategoryById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Category category = categoryServiceImpl.findCategoryById(id);
		map.put("category", category);
		if(StringUtils.isEmpty(id)){
			List<Category> categorys = categoryServiceImpl.findAllParentCategory();
			map.put("categorys", categorys);
		}
		
		return map;
	}
	
	/**
	 * 新增
	 * @param Category
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCategory")
	@ResponseBody
	public Map<String,Object> saveCategory(Category category,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		category.setUpdatename(user.getuName());
		try {//通知更新导航分类
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			categoryServiceImpl.saveCategory(category);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param Category
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCategory")
	@ResponseBody
	public Map<String,Object> updateCategory(Category category,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		category.setUpdatename(user.getuName());
		try {//通知更新导航分类
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			categoryServiceImpl.updateCategory(category);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 方法描述：删除
	 * 返回类型：Map<String,Object>
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteCategory")
	@ResponseBody
	public Map<String,Object> deleteCategory(@RequestParam(value="id") String id,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			categoryServiceImpl.deleteCategory(id,user.getuName());
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 跳转导航分类页面
	 */
	@RequestMapping(value="/goCategoryTree")
	@ResponseBody
	public ModelAndView goCategoryTree(ModelAndView mv,String id){
		mv.addObject("id", id);
		mv.setViewName("category/navigation/navigationcategoryTree");
		return mv;
	}
	
	/**
	 * 查询所有分类
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllCategoryForNavigation")
	@ResponseBody
	public Map<String,Object> findAllCategoryForNavigation(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<CategoryDTO> category = categoryServiceImpl.findAllCategoryForNavigation(id);
		map.put("category", category);
		return map;
	}
	
	/**
	 * 查询所有分类
	 */
	@RequestMapping(value="findAllCategory")
	@ResponseBody
	public Map<String,Object> findAllCategory() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		List<CategoryDTO> categorys = categoryServiceImpl.findAllCategoryState();
		map.put("categorys", categorys);
		return map;
	}
	
}
