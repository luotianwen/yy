package com.shifeng.op.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.configuration.BaseConfigurationStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.system.SysAdvSet;
import com.shifeng.op.system.service.SysAdvSetService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 系统广告费用设置(sys_adv_set)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-01 09:57:51 
 */ 
@Controller
@RequestMapping(value="/sysadvset")
public class SysAdvSetController{
	
	@Resource(name="sysadvsetServiceImpl")
	private SysAdvSetService sysadvsetServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysAdvSetList")
	public ModelAndView goSysAdvSetList(ModelAndView mv) throws Exception{
		mv.setViewName("system/sysadvsetList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param sysadvset
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysAdvSet")
	@ResponseBody
	public Map<String,Object> findAllSysAdvSet(Page page,SysAdvSet sysadvset) throws Exception{
		if(sysadvset==null){
			sysadvset = new SysAdvSet();
		}
		page.setT(sysadvset);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysAdvSet> sysadvsets = sysadvsetServiceImpl.findAllSysAdvSet(page);
		map.put("sysadvsets", sysadvsets);
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
	@RequestMapping(value="/goSysAdvSetEdit")
	@ResponseBody
	public ModelAndView goSysAdvSetEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/sysadvsetEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysAdvSetById")
	@ResponseBody
	public Map<String,Object> findSysAdvSetById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysAdvSet sysadvset = sysadvsetServiceImpl.findSysAdvSetById(id);
		map.put("sysadvset",sysadvset);
		return map;
	}
	
	/**
	 * 新增
	 * @param sysadvset
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysAdvSet")
	@ResponseBody
	public Map<String,Object> saveSysAdvSet(SysAdvSet sysadvset,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysadvsetServiceImpl.saveSysAdvSet(sysadvset);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param sysadvset
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysAdvSet")
	@ResponseBody
	public Map<String,Object> updateSysAdvSet(SysAdvSet sysadvset,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysadvsetServiceImpl.updateSysAdvSet(sysadvset);
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
	@RequestMapping(value="/deleteSysAdvSet")
	@ResponseBody
 	public Map<String,Object> deleteSysAdvSet(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			sysadvsetServiceImpl.deleteSysAdvSet(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
