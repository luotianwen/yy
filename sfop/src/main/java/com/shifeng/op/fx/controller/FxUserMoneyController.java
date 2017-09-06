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

import com.shifeng.entity.fx.FxUserMoney;
import com.shifeng.op.fx.service.FxUserMoneyService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 用户余额(fx_user_money)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */ 
@Controller
@RequestMapping(value="/fxusermoney")
public class FxUserMoneyController{
	
	@Resource(name="fxusermoneyServiceImpl")
	private FxUserMoneyService fxusermoneyServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFxUserMoneyList")
	public ModelAndView goFxUserMoneyList(ModelAndView mv) throws Exception{
		mv.setViewName("fx/fxusermoneyList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param fxusermoney
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllFxUserMoney")
	@ResponseBody
	public Map<String,Object> findAllFxUserMoney(Page page,FxUserMoney fxusermoney) throws Exception{
		if(fxusermoney==null){
			fxusermoney = new FxUserMoney();
		}
		page.setT(fxusermoney);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FxUserMoney> fxusermoneys = fxusermoneyServiceImpl.findAllFxUserMoney(page);
		map.put("fxusermoneys", fxusermoneys);
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
	@RequestMapping(value="/goFxUserMoneyEdit")
	@ResponseBody
	public ModelAndView goFxUserMoneyEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("fx/fxusermoneyEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findFxUserMoneyById")
	@ResponseBody
	public Map<String,Object> findFxUserMoneyById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		FxUserMoney fxusermoney = fxusermoneyServiceImpl.findFxUserMoneyById(id);
		map.put("fxusermoney",fxusermoney);
		return map;
	}
	
	/**
	 * 新增
	 * @param fxusermoney
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveFxUserMoney")
	@ResponseBody
	public Map<String,Object> saveFxUserMoney(FxUserMoney fxusermoney,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxusermoneyServiceImpl.saveFxUserMoney(fxusermoney);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param fxusermoney
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateFxUserMoney")
	@ResponseBody
	public Map<String,Object> updateFxUserMoney(FxUserMoney fxusermoney,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxusermoneyServiceImpl.updateFxUserMoney(fxusermoney);
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
	@RequestMapping(value="/deleteFxUserMoney")
	@ResponseBody
 	public Map<String,Object> deleteFxUserMoney(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			fxusermoneyServiceImpl.deleteFxUserMoney(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
