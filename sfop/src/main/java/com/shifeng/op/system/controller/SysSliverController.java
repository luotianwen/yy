package com.shifeng.op.system.controller;

import com.shifeng.entity.system.SysSliver;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.system.service.SysSliverService;
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
 * 银币设置(sys_sliver)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 19:10:30 
 */ 
@Controller
@RequestMapping(value="/syssliver")
public class SysSliverController{
	
	@Resource(name="syssliverServiceImpl")
	private SysSliverService syssliverServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysSliverList")
	public ModelAndView goSysSliverList(ModelAndView mv) throws Exception{
		mv.setViewName("system/syssliverList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param syssliver
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysSliver")
	@ResponseBody
	public Map<String,Object> findAllSysSliver(Page page,SysSliver syssliver) throws Exception{
		if(syssliver==null){
			syssliver = new SysSliver();
		}
		page.setT(syssliver);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysSliver> sysslivers = syssliverServiceImpl.findAllSysSliver(page);
		map.put("sysslivers", sysslivers);
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
	@RequestMapping(value="/goSysSliverEdit")
	@ResponseBody
	public ModelAndView goSysSliverEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/syssliverEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysSliverById")
	@ResponseBody
	public Map<String,Object> findSysSliverById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysSliver syssliver = syssliverServiceImpl.findSysSliverById(id);
		map.put("syssliver",syssliver);
		return map;
	}
	
	/**
	 * 新增
	 * @param syssliver
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysSliver")
	@ResponseBody
	public Map<String,Object> saveSysSliver(SysSliver syssliver,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			syssliver.setUpdatename(user.getuName());
			syssliverServiceImpl.saveSysSliver(syssliver);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param syssliver
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysSliver")
	@ResponseBody
	public Map<String,Object> updateSysSliver(SysSliver syssliver,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			syssliver.setUpdatename(user.getuName());
			syssliverServiceImpl.updateSysSliver(syssliver);
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
	@RequestMapping(value="/deleteSysSliver")
	@ResponseBody
 	public Map<String,Object> deleteSysSliver(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			syssliverServiceImpl.deleteSysSliver(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
