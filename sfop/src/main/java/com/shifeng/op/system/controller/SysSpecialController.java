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

import com.shifeng.entity.system.SysSpecial;
import com.shifeng.op.system.service.SysSpecialService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 专题页名称(sys_special)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */ 
@Controller
@RequestMapping(value="/sysspecial")
public class SysSpecialController{
	
	@Resource(name="sysspecialServiceImpl")
	private SysSpecialService sysspecialServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysSpecialList")
	public ModelAndView goSysSpecialList(ModelAndView mv) throws Exception{
		mv.setViewName("system/sysspecialList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param sysspecial
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysSpecial")
	@ResponseBody
	public Map<String,Object> findAllSysSpecial(Page page,SysSpecial sysspecial) throws Exception{
		if(sysspecial==null){
			sysspecial = new SysSpecial();
		}
		page.setT(sysspecial);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysSpecial> sysspecials = sysspecialServiceImpl.findAllSysSpecial(page);
		map.put("sysspecials", sysspecials);
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
	@RequestMapping(value="/goSysSpecialEdit")
	@ResponseBody
	public ModelAndView goSysSpecialEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/sysspecialEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysSpecialById")
	@ResponseBody
	public Map<String,Object> findSysSpecialById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysSpecial sysspecial = sysspecialServiceImpl.findSysSpecialById(id);
		map.put("sysspecial",sysspecial);
		return map;
	}
	
	/**
	 * 新增
	 * @param sysspecial
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysSpecial")
	@ResponseBody
	public Map<String,Object> saveSysSpecial(SysSpecial sysspecial,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysspecial.setUpdatename(user.getuName());
			sysspecialServiceImpl.saveSysSpecial(sysspecial);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param sysspecial
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysSpecial")
	@ResponseBody
	public Map<String,Object> updateSysSpecial(SysSpecial sysspecial,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysspecial.setUpdatename(user.getuName());
			sysspecialServiceImpl.updateSysSpecial(sysspecial);
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
	@RequestMapping(value="/deleteSysSpecial")
	@ResponseBody
 	public Map<String,Object> deleteSysSpecial(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			sysspecialServiceImpl.deleteSysSpecial(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
