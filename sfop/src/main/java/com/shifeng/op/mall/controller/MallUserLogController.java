package com.shifeng.op.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.mall.MallUserLog;
import com.shifeng.op.mall.service.MallUserLogService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 前台用户登录日志(mall_user_log)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */ 
@Controller
@RequestMapping(value="/malluserlog")
public class MallUserLogController{
	
	@Resource(name="malluserlogServiceImpl")
	private MallUserLogService malluserlogServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallUserLogList")
	public ModelAndView goMallUserLogList(ModelAndView mv) throws Exception{
		mv.setViewName("mall/malluserlogList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param malluserlog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallUserLog")
	@ResponseBody
	public Map<String,Object> findAllMallUserLog(Page page,MallUserLog malluserlog) throws Exception{
		if(malluserlog==null){
			malluserlog = new MallUserLog();
		}
		page.setT(malluserlog);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallUserLog> malluserlogs = malluserlogServiceImpl.findAllMallUserLog(page);
		map.put("malluserlogs", malluserlogs);
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
	@RequestMapping(value="/goMallUserLogEdit")
	@ResponseBody
	public ModelAndView goMallUserLogEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/malluserlogEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallUserLogById")
	@ResponseBody
	public Map<String,Object> findMallUserLogById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallUserLog malluserlog = malluserlogServiceImpl.findMallUserLogById(id);
		map.put("malluserlog",malluserlog);
		return map;
	}
	
	/**
	 * 新增
	 * @param malluserlog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallUserLog")
	@ResponseBody
	public Map<String,Object> saveMallUserLog(MallUserLog malluserlog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			malluserlogServiceImpl.saveMallUserLog(malluserlog);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param malluserlog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallUserLog")
	@ResponseBody
	public Map<String,Object> updateMallUserLog(MallUserLog malluserlog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			malluserlogServiceImpl.updateMallUserLog(malluserlog);
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
	@RequestMapping(value="/deleteMallUserLog")
	@ResponseBody
 	public Map<String,Object> deleteMallUserLog(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			malluserlogServiceImpl.deleteMallUserLog(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
