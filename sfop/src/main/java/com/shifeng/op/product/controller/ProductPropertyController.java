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

import com.shifeng.entity.product.ProductProperty;
import com.shifeng.op.product.service.ProductPropertyService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 产品属性表(p_product_property)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */ 
@Controller
@RequestMapping(value="/productproperty")
public class ProductPropertyController{
	
	@Resource(name="productpropertyServiceImpl")
	private ProductPropertyService productpropertyServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductPropertyList")
	public ModelAndView goProductPropertyList(ModelAndView mv) throws Exception{
		mv.setViewName("product/productpropertyList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param productproperty
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllProductProperty")
	@ResponseBody
	public Map<String,Object> findAllProductProperty(Page page,ProductProperty productproperty) throws Exception{
		if(productproperty==null){
			productproperty = new ProductProperty();
		}
		page.setT(productproperty);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductProperty> productpropertys = productpropertyServiceImpl.findAllProductProperty(page);
		map.put("productpropertys", productpropertys);
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
	@RequestMapping(value="/goProductPropertyEdit")
	@ResponseBody
	public ModelAndView goProductPropertyEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("product/productpropertyEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findProductPropertyById")
	@ResponseBody
	public Map<String,Object> findProductPropertyById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ProductProperty productproperty = productpropertyServiceImpl.findProductPropertyById(id);
		map.put("productproperty",productproperty);
		return map;
	}
	
	/**
	 * 新增
	 * @param productproperty
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveProductProperty")
	@ResponseBody
	public Map<String,Object> saveProductProperty(ProductProperty productproperty,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			productpropertyServiceImpl.saveProductProperty(productproperty);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param productproperty
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProductProperty")
	@ResponseBody
	public Map<String,Object> updateProductProperty(ProductProperty productproperty,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			productpropertyServiceImpl.updateProductProperty(productproperty);
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
	@RequestMapping(value="/deleteProductProperty")
	@ResponseBody
 	public Map<String,Object> deleteProductProperty(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			productpropertyServiceImpl.deleteProductProperty(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
