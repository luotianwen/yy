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

import com.shifeng.entity.system.SysAppleadpic;
import com.shifeng.op.system.service.SysAppleadpicService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * app引导页(sys_appleadpic)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:50 
 */ 
@Controller
@RequestMapping(value="/sysappleadpic")
public class SysAppleadpicController{
	
	@Resource(name="sysappleadpicServiceImpl")
	private SysAppleadpicService sysappleadpicServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysAppleadpicList")
	public ModelAndView goSysAppleadpicList(ModelAndView mv) throws Exception{
		mv.setViewName("system/sysappleadpicList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param sysappleadpic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysAppleadpic")
	@ResponseBody
	public Map<String,Object> findAllSysAppleadpic(Page page,SysAppleadpic sysappleadpic) throws Exception{
		if(sysappleadpic==null){
			sysappleadpic = new SysAppleadpic();
		}
		page.setT(sysappleadpic);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysAppleadpic> sysappleadpics = sysappleadpicServiceImpl.findAllSysAppleadpic(page);
		map.put("sysappleadpics", sysappleadpics);
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
	@RequestMapping(value="/goSysAppleadpicEdit")
	@ResponseBody
	public ModelAndView goSysAppleadpicEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/sysappleadpicEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysAppleadpicById")
	@ResponseBody
	public Map<String,Object> findSysAppleadpicById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysAppleadpic sysappleadpic = sysappleadpicServiceImpl.findSysAppleadpicById(id);
		map.put("sysappleadpic",sysappleadpic);
		return map;
	}
	
	/**
	 * 新增
	 * @param sysappleadpic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysAppleadpic")
	@ResponseBody
	public Map<String,Object> saveSysAppleadpic(SysAppleadpic sysappleadpic,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysappleadpic.setUpdatename(user.getuName());
			sysappleadpicServiceImpl.saveSysAppleadpic(sysappleadpic);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param sysappleadpic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysAppleadpic")
	@ResponseBody
	public Map<String,Object> updateSysAppleadpic(SysAppleadpic sysappleadpic,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysappleadpic.setUpdatename(user.getuName());
			sysappleadpicServiceImpl.updateSysAppleadpic(sysappleadpic);
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
	@RequestMapping(value="/deleteSysAppleadpic")
	@ResponseBody
 	public Map<String,Object> deleteSysAppleadpic(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			sysappleadpicServiceImpl.deleteSysAppleadpic(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
