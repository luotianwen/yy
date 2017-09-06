package com.shifeng.op.system.controller;

import com.shifeng.entity.system.SysAppHomeads;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.system.service.SysAppHomeadsService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
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
 * app首页广告(sys_app_homeads)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-15 16:00:42 
 */ 
@Controller
@RequestMapping(value="/sysapphomeads")
public class SysAppHomeadsController{
	
	@Resource(name="sysapphomeadsServiceImpl")
	private SysAppHomeadsService sysapphomeadsServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysAppHomeadsList")
	public ModelAndView goSysAppHomeadsList(ModelAndView mv) throws Exception{
		mv.setViewName("system/sysapphomeadsList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param sysapphomeads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysAppHomeads")
	@ResponseBody
	public Map<String,Object> findAllSysAppHomeads(Page page,SysAppHomeads sysapphomeads) throws Exception{
		if(sysapphomeads==null){
			sysapphomeads = new SysAppHomeads();
		}
		page.setT(sysapphomeads);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysAppHomeads> sysapphomeadss = sysapphomeadsServiceImpl.findAllSysAppHomeads(page);
		map.put("sysapphomeadss", sysapphomeadss);
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
	@RequestMapping(value="/goSysAppHomeadsEdit")
	@ResponseBody
	public ModelAndView goSysAppHomeadsEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/sysapphomeadsEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysAppHomeadsById")
	@ResponseBody
	public Map<String,Object> findSysAppHomeadsById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysAppHomeads sysapphomeads = sysapphomeadsServiceImpl.findSysAppHomeadsById(id);
		map.put("sysapphomeads",sysapphomeads);
		return map;
	}
	
	/**
	 * 新增
	 * @param sysapphomeads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysAppHomeads")
	@ResponseBody
	public Map<String,Object> saveSysAppHomeads(SysAppHomeads sysapphomeads,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysapphomeads.setUpdatename(user.getuName());
			sysapphomeadsServiceImpl.saveSysAppHomeads(sysapphomeads);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param sysapphomeads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysAppHomeads")
	@ResponseBody
	public Map<String,Object> updateSysAppHomeads(SysAppHomeads sysapphomeads,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {sysapphomeads.setUpdatename(user.getuName());
			sysapphomeadsServiceImpl.updateSysAppHomeads(sysapphomeads);
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
	@RequestMapping(value="/deleteSysAppHomeads")
	@ResponseBody
 	public Map<String,Object> deleteSysAppHomeads(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			sysapphomeadsServiceImpl.deleteSysAppHomeads(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
