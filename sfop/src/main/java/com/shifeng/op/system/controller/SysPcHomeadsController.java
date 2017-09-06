package com.shifeng.op.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.system.SysPcHomeads;
import com.shifeng.op.system.service.SysPcHomeadsService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * pc首页广告(sys_pc_homeads)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */ 
@Controller
@RequestMapping(value="/syspchomeads")
public class SysPcHomeadsController{
	
	@Resource(name="syspchomeadsServiceImpl")
	private SysPcHomeadsService syspchomeadsServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysPcHomeadsList")
	public ModelAndView goSysPcHomeadsList(ModelAndView mv) throws Exception{
		mv.setViewName("system/syspchomeadsList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param syspchomeads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysPcHomeads")
	@ResponseBody
	public Map<String,Object> findAllSysPcHomeads(Page page,SysPcHomeads syspchomeads) throws Exception{
		if(syspchomeads==null){
			syspchomeads = new SysPcHomeads();
		}
		page.setT(syspchomeads);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysPcHomeads> syspchomeadss = syspchomeadsServiceImpl.findAllSysPcHomeads(page);
		map.put("syspchomeadss", syspchomeadss);
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
	@RequestMapping(value="/goSysPcHomeadsEdit")
	@ResponseBody
	public ModelAndView goSysPcHomeadsEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/syspchomeadsEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysPcHomeadsById")
	@ResponseBody
	public Map<String,Object> findSysPcHomeadsById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysPcHomeads syspchomeads = syspchomeadsServiceImpl.findSysPcHomeadsById(id);
		map.put("syspchomeads",syspchomeads);
		return map;
	}
	
	/**
	 * 新增
	 * @param syspchomeads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysPcHomeads")
	@ResponseBody
	public Map<String,Object> saveSysPcHomeads(SysPcHomeads syspchomeads,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			syspchomeads.setUpdatename(user.getuName());
			syspchomeadsServiceImpl.saveSysPcHomeads(syspchomeads);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param syspchomeads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysPcHomeads")
	@ResponseBody
	public Map<String,Object> updateSysPcHomeads(SysPcHomeads syspchomeads,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			syspchomeads.setUpdatename(user.getuName());
			syspchomeadsServiceImpl.updateSysPcHomeads(syspchomeads);
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
	@RequestMapping(value="/deleteSysPcHomeads")
	@ResponseBody
 	public Map<String,Object> deleteSysPcHomeads(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			syspchomeadsServiceImpl.deleteSysPcHomeads(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
