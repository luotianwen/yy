package com.shifeng.op.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.shop.StoreSupervisor;
import com.shifeng.op.shop.service.StoreSupervisorService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 店铺负责人员(s_store_supervisor)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */ 
@Controller
@RequestMapping(value="/storesupervisor")
public class StoreSupervisorController{
	
	@Resource(name="storesupervisorServiceImpl")
	private StoreSupervisorService storesupervisorServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goStoreSupervisorList")
	public ModelAndView goStoreSupervisorList(ModelAndView mv) throws Exception{
		mv.setViewName("shop/storesupervisorList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param storesupervisor
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllStoreSupervisor")
	@ResponseBody
	public Map<String,Object> findAllStoreSupervisor(Page page,StoreSupervisor storesupervisor) throws Exception{
		if(storesupervisor==null){
			storesupervisor = new StoreSupervisor();
		}
		page.setT(storesupervisor);
		Map<String,Object> map = new HashMap<String,Object>();
		List<StoreSupervisor> storesupervisors = storesupervisorServiceImpl.findAllStoreSupervisor(page);
		map.put("storesupervisors", storesupervisors);

		return map;
	}
 
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goStoreSupervisorEdit")
	@ResponseBody
	public ModelAndView goStoreSupervisorEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/storesupervisorEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findStoreSupervisorById")
	@ResponseBody
	public Map<String,Object> findStoreSupervisorById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		StoreSupervisor storesupervisor = storesupervisorServiceImpl.findStoreSupervisorById(id);
		map.put("storesupervisor",storesupervisor);
		return map;
	}
	
	/**
	 * 新增
	 * @param storesupervisor
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveStoreSupervisor")
	@ResponseBody
	public Map<String,Object> saveStoreSupervisor(StoreSupervisor storesupervisor,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			storesupervisorServiceImpl.saveStoreSupervisor(storesupervisor);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param storesupervisor
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateStoreSupervisor")
	@ResponseBody
	public Map<String,Object> updateStoreSupervisor(StoreSupervisor storesupervisor,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			storesupervisorServiceImpl.updateStoreSupervisor(storesupervisor);
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
	@RequestMapping(value="/deleteStoreSupervisor")
	@ResponseBody
 	public Map<String,Object> deleteStoreSupervisor(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			storesupervisorServiceImpl.deleteStoreSupervisor(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
