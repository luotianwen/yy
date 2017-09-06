package com.shifeng.op.category.controller;

import com.shifeng.entity.category.CategoryFee;
import com.shifeng.op.category.service.CategoryFeeService;
import com.shifeng.op.category.service.CategoryService;
import com.shifeng.op.dto.category.CategoryDTO;
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
 * 分类费用(c_category_fee)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 17:44:46 
 */ 
@Controller
@RequestMapping(value="/categoryfee")
public class CategoryFeeController{
	
	@Resource(name="categoryfeeServiceImpl")
	private CategoryFeeService categoryfeeServiceImpl;
	@Resource(name="categoryServiceImpl")
	private CategoryService categoryServiceImpl;
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCategoryFeeList")
	public ModelAndView goCategoryFeeList(ModelAndView mv) throws Exception{
		List<CategoryDTO> categorys =categoryServiceImpl.findAllCategoryState();
		mv.addObject("categorys",categorys);
		mv.setViewName("category/categoryfee/categoryfeeList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllCategoryFee")
	@ResponseBody
	public Map<String,Object> findAllCategoryFee(Page page,String name) throws Exception{
		page.setT(name);
		Map<String,Object> map = new HashMap<String,Object>();
		List<CategoryFee> categoryfees = categoryfeeServiceImpl.findAllCategoryFee(page);
		map.put("categoryfees", categoryfees);
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
	@RequestMapping(value="/goCategoryFeeEdit")
	@ResponseBody
	public ModelAndView goCategoryFeeEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("category/categoryfee/categoryfeeEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCategoryFeeById")
	@ResponseBody
	public Map<String,Object> findCategoryFeeById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		CategoryFee categoryfee = categoryfeeServiceImpl.findCategoryFeeById(id);
		map.put("categoryfee", categoryfee);
		return map;
	}
	
	/**
	 * 修改
	 * @param CategoryFeeDTO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCategoryFee")
	@ResponseBody
	public Map<String,Object> updateCategoryFee(CategoryFee categoryfee,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		categoryfee.setUpdatename(user.getuName());
		try {//通知更新导航分类
			RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"0");
			categoryfeeServiceImpl.updateCategoryFee(categoryfee);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
 
 
}
