package com.shifeng.op.mall.controller;

import com.shifeng.entity.mall.MallUsersSilverLog;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.mall.service.MallUsersSilverLogService;
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
 * 我的银币日志(mall_users_silver_log)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */ 
@Controller
@RequestMapping(value="/malluserssilverlog")
public class MallUsersSilverLogController{
	
	@Resource(name="malluserssilverlogServiceImpl")
	private MallUsersSilverLogService malluserssilverlogServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallUsersSilverLogList")
	public ModelAndView goMallUsersSilverLogList(ModelAndView mv,String uid) throws Exception{
		mv.addObject("uid",uid);
		mv.setViewName("mall/malluserssilverlogList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param malluserssilverlog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallUsersSilverLog")
	@ResponseBody
	public Map<String,Object> findAllMallUsersSilverLog(Page page,MallUsersSilverLog malluserssilverlog) throws Exception{
		if(malluserssilverlog==null){
			malluserssilverlog = new MallUsersSilverLog();
		}
		page.setT(malluserssilverlog);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallUsersSilverLog> malluserssilverlogs = malluserssilverlogServiceImpl.findAllMallUsersSilverLog(page);
		map.put("malluserssilverlogs", malluserssilverlogs);
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
	@RequestMapping(value="/goMallUsersSilverLogEdit")
	@ResponseBody
	public ModelAndView goMallUsersSilverLogEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/malluserssilverlogEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallUsersSilverLogById")
	@ResponseBody
	public Map<String,Object> findMallUsersSilverLogById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallUsersSilverLog malluserssilverlog = malluserssilverlogServiceImpl.findMallUsersSilverLogById(id);
		map.put("malluserssilverlog",malluserssilverlog);
		return map;
	}
	
	/**
	 * 新增
	 * @param malluserssilverlog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallUsersSilverLog")
	@ResponseBody
	public Map<String,Object> saveMallUsersSilverLog(MallUsersSilverLog malluserssilverlog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			malluserssilverlogServiceImpl.saveMallUsersSilverLog(malluserssilverlog);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param malluserssilverlog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallUsersSilverLog")
	@ResponseBody
	public Map<String,Object> updateMallUsersSilverLog(MallUsersSilverLog malluserssilverlog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			malluserssilverlogServiceImpl.updateMallUsersSilverLog(malluserssilverlog);
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
	@RequestMapping(value="/deleteMallUsersSilverLog")
	@ResponseBody
 	public Map<String,Object> deleteMallUsersSilverLog(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			malluserssilverlogServiceImpl.deleteMallUsersSilverLog(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
