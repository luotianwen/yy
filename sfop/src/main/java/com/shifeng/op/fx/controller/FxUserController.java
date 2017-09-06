package com.shifeng.op.fx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.fx.FxUser;
import com.shifeng.op.fx.service.FxUserService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 分销用户(fx_user)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */ 
@Controller
@RequestMapping(value="/fxuser")
public class FxUserController{
	
	@Resource(name="fxuserServiceImpl")
	private FxUserService fxuserServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFxUserList")
	public ModelAndView goFxUserList(ModelAndView mv) throws Exception{
		mv.setViewName("fx/fxuserList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param fxuser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllFxUser")
	@ResponseBody
	public Map<String,Object> findAllFxUser(Page page,FxUser fxuser) throws Exception{
		if(fxuser==null){
			fxuser = new FxUser();
		}
		page.setT(fxuser);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FxUser> fxusers = fxuserServiceImpl.findAllFxUser(page);
		map.put("fxusers", fxusers);
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
	@RequestMapping(value="/goFxUserEdit")
	@ResponseBody
	public ModelAndView goFxUserEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("fx/fxuserEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findFxUserById")
	@ResponseBody
	public Map<String,Object> findFxUserById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		FxUser fxuser = fxuserServiceImpl.findFxUserById(id);
		map.put("fxuser",fxuser);
		return map;
	}
	
	/**
	 * 新增
	 * @param fxuser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveFxUser")
	@ResponseBody
	public Map<String,Object> saveFxUser(FxUser fxuser,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxuserServiceImpl.saveFxUser(fxuser);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param fxuser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateFxUser")
	@ResponseBody
	public Map<String,Object> updateFxUser(FxUser fxuser,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxuserServiceImpl.updateFxUser(fxuser);
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
	@RequestMapping(value="/deleteFxUser")
	@ResponseBody
 	public Map<String,Object> deleteFxUser(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			fxuserServiceImpl.deleteFxUser(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
