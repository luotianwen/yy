package com.shifeng.op.system.controller;

import com.shifeng.entity.system.SysAppCategoryads;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.system.service.SysAppCategoryadsService;
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
 * app类目广告(sys_app_categoryads)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-15 16:00:42 
 */ 
@Controller
@RequestMapping(value="/sysappcategoryads")
public class SysAppCategoryadsController{
	
	@Resource(name="sysappcategoryadsServiceImpl")
	private SysAppCategoryadsService sysappcategoryadsServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysAppCategoryadsList")
	public ModelAndView goSysAppCategoryadsList(ModelAndView mv) throws Exception{
		mv.setViewName("system/sysappcategoryadsList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param sysappcategoryads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysAppCategoryads")
	@ResponseBody
	public Map<String,Object> findAllSysAppCategoryads(Page page,SysAppCategoryads sysappcategoryads) throws Exception{
		if(sysappcategoryads==null){
			sysappcategoryads = new SysAppCategoryads();
		}
		page.setT(sysappcategoryads);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysAppCategoryads> sysappcategoryadss = sysappcategoryadsServiceImpl.findAllSysAppCategoryads(page);
		map.put("sysappcategoryadss", sysappcategoryadss);
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
	@RequestMapping(value="/goSysAppCategoryadsEdit")
	@ResponseBody
	public ModelAndView goSysAppCategoryadsEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/sysappcategoryadsEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysAppCategoryadsById")
	@ResponseBody
	public Map<String,Object> findSysAppCategoryadsById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysAppCategoryads sysappcategoryads = sysappcategoryadsServiceImpl.findSysAppCategoryadsById(id);
		map.put("sysappcategoryads",sysappcategoryads);
		return map;
	}
	
	/**
	 * 新增
	 * @param sysappcategoryads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysAppCategoryads")
	@ResponseBody
	public Map<String,Object> saveSysAppCategoryads(SysAppCategoryads sysappcategoryads,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysappcategoryads.setUpdatename(user.getuName());
			sysappcategoryadsServiceImpl.saveSysAppCategoryads(sysappcategoryads);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param sysappcategoryads
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysAppCategoryads")
	@ResponseBody
	public Map<String,Object> updateSysAppCategoryads(SysAppCategoryads sysappcategoryads,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			sysappcategoryads.setUpdatename(user.getuName());
			sysappcategoryadsServiceImpl.updateSysAppCategoryads(sysappcategoryads);
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
	@RequestMapping(value="/deleteSysAppCategoryads")
	@ResponseBody
 	public Map<String,Object> deleteSysAppCategoryads(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			sysappcategoryadsServiceImpl.deleteSysAppCategoryads(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
