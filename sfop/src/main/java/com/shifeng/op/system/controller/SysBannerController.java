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

import com.shifeng.entity.system.SysBanner;
import com.shifeng.op.system.service.SysBannerService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 系统banner(sys_banner)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */ 
@Controller
@RequestMapping(value="/sysbanner")
public class SysBannerController{
	
	@Resource(name="sysbannerServiceImpl")
	private SysBannerService sysbannerServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysBannerList")
	public ModelAndView goSysBannerList(ModelAndView mv) throws Exception{
		mv.setViewName("system/sysbannerList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param sysbanner
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysBanner")
	@ResponseBody
	public Map<String,Object> findAllSysBanner(Page page,SysBanner sysbanner) throws Exception{
		if(sysbanner==null){
			sysbanner = new SysBanner();
		}
		page.setT(sysbanner);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysBanner> sysbanners = sysbannerServiceImpl.findAllSysBanner(page);
		map.put("sysbanners", sysbanners);
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
	@RequestMapping(value="/goSysBannerEdit")
	@ResponseBody
	public ModelAndView goSysBannerEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/sysbannerEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysBannerById")
	@ResponseBody
	public Map<String,Object> findSysBannerById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysBanner sysbanner = sysbannerServiceImpl.findSysBannerById(id);
		map.put("sysbanner",sysbanner);
		return map;
	}
	
	/**
	 * 新增
	 * @param sysbanner
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysBanner")
	@ResponseBody
	public Map<String,Object> saveSysBanner(SysBanner sysbanner,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysbanner.setUpdatename(user.getuName());
			sysbannerServiceImpl.saveSysBanner(sysbanner);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param sysbanner
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysBanner")
	@ResponseBody
	public Map<String,Object> updateSysBanner(SysBanner sysbanner,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {sysbanner.setUpdatename(user.getuName());
			sysbannerServiceImpl.updateSysBanner(sysbanner);
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
	@RequestMapping(value="/deleteSysBanner")
	@ResponseBody
 	public Map<String,Object> deleteSysBanner(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			sysbannerServiceImpl.deleteSysBanner(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
