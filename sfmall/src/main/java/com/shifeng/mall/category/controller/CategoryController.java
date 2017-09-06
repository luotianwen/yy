package com.shifeng.mall.category.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.category.Category;
import com.shifeng.entity.category.CategoryFee;
import com.shifeng.mall.category.service.CategoryFeeService;
import com.shifeng.mall.category.service.CategoryService;
import com.shifeng.util.Const;
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

	@Resource(name="categoryfeeServiceImpl")
	private CategoryFeeService categoryfeeServiceImpl;
	
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
		List<Category> category = categoryServiceImpl.findAllParentCategory("");
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
		Map<String,Object> map = new HashMap<String,Object>();
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
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCategoryFeeById")
	@ResponseBody
	public CategoryFee findCategoryFeeById(String id) throws Exception{
		CategoryFee categoryfee = categoryfeeServiceImpl.findCategoryFeeById(id);
		return categoryfee;
	}
	
}
