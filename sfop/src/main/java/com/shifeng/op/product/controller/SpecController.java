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

import com.shifeng.entity.product.Spec;
import com.shifeng.op.product.service.SpecService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 规格表(p_spec)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */ 
@Controller
@RequestMapping(value="/spec")
public class SpecController{
	
	@Resource(name="specServiceImpl")
	private SpecService specServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSpecList")
	public ModelAndView goSpecList(ModelAndView mv) throws Exception{
		mv.setViewName("product/specList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param spec
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSpec")
	@ResponseBody
	public Map<String,Object> findAllSpec(Page page,Spec spec) throws Exception{
		if(spec==null){
			spec = new Spec();
		}
		page.setT(spec);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Spec> specs = specServiceImpl.findAllSpec(page);
		map.put("specs", specs);
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
	@RequestMapping(value="/goSpecEdit")
	@ResponseBody
	public ModelAndView goSpecEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("product/specEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSpecById")
	@ResponseBody
	public Map<String,Object> findSpecById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Spec spec = specServiceImpl.findSpecById(id);
		map.put("spec",spec);
		return map;
	}
	
	/**
	 * 新增
	 * @param spec
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSpec")
	@ResponseBody
	public Map<String,Object> saveSpec(Spec spec,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			specServiceImpl.saveSpec(spec);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param spec
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSpec")
	@ResponseBody
	public Map<String,Object> updateSpec(Spec spec,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			specServiceImpl.updateSpec(spec);
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
	@RequestMapping(value="/deleteSpec")
	@ResponseBody
 	public Map<String,Object> deleteSpec(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			specServiceImpl.deleteSpec(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
