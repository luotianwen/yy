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

import com.shifeng.entity.mall.MallUsers;
import com.shifeng.op.mall.service.MallUsersService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 前台用户表(mall_users)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */ 
@Controller
@RequestMapping(value="/mallusers")
public class MallUsersController{
	
	@Resource(name="mallusersServiceImpl")
	private MallUsersService mallusersServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallUsersList")
	public ModelAndView goMallUsersList(ModelAndView mv) throws Exception{
		mv.setViewName("mall/mallusersList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mallusers
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallUsers")
	@ResponseBody
	public Map<String,Object> findAllMallUsers(Page page,MallUsers mallusers) throws Exception{
		if(mallusers==null){
			mallusers = new MallUsers();
		}
		page.setT(mallusers);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallUsers> malluserss = mallusersServiceImpl.findAllMallUsers(page);
		map.put("malluserss", malluserss);
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
	@RequestMapping(value="/goMallUsersEdit")
	@ResponseBody
	public ModelAndView goMallUsersEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/mallusersEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallUsersById")
	@ResponseBody
	public Map<String,Object> findMallUsersById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallUsers mallusers = mallusersServiceImpl.findMallUsersById(id);
		map.put("mallusers",mallusers);
		return map;
	}
	
	/**
	 * 新增
	 * @param mallusers
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallUsers")
	@ResponseBody
	public Map<String,Object> saveMallUsers(MallUsers mallusers,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallusersServiceImpl.saveMallUsers(mallusers);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param mallusers
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallUsers")
	@ResponseBody
	public Map<String,Object> updateMallUsers(MallUsers mallusers,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallusersServiceImpl.updateMallUsers(mallusers);
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
	@RequestMapping(value="/deleteMallUsers")
	@ResponseBody
 	public Map<String,Object> deleteMallUsers(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			mallusersServiceImpl.deleteMallUsers(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
