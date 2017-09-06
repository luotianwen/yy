package com.shifeng.op.fx.controller;

import com.shifeng.entity.fx.FxUserMoneyLog;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.fx.service.FxUserMoneyLogService;
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
 * 用户余额日志(fx_user_money_log)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */ 
@Controller
@RequestMapping(value="/fxusermoneylog")
public class FxUserMoneyLogController{
	
	@Resource(name="fxusermoneylogServiceImpl")
	private FxUserMoneyLogService fxusermoneylogServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFxUserMoneyLogList")
	public ModelAndView goFxUserMoneyLogList(ModelAndView mv,String  uid) throws Exception{
		mv.addObject("uid",uid);
		mv.setViewName("fx/fxusermoneylogList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param fxusermoneylog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllFxUserMoneyLog")
	@ResponseBody
	public Map<String,Object> findAllFxUserMoneyLog(Page page,FxUserMoneyLog fxusermoneylog) throws Exception{
		if(fxusermoneylog==null){
			fxusermoneylog = new FxUserMoneyLog();
		}
		page.setT(fxusermoneylog);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FxUserMoneyLog> fxusermoneylogs = fxusermoneylogServiceImpl.findAllFxUserMoneyLog(page);
		map.put("fxusermoneylogs", fxusermoneylogs);
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
	@RequestMapping(value="/goFxUserMoneyLogEdit")
	@ResponseBody
	public ModelAndView goFxUserMoneyLogEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("fx/fxusermoneylogEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findFxUserMoneyLogById")
	@ResponseBody
	public Map<String,Object> findFxUserMoneyLogById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		FxUserMoneyLog fxusermoneylog = fxusermoneylogServiceImpl.findFxUserMoneyLogById(id);
		map.put("fxusermoneylog",fxusermoneylog);
		return map;
	}
	
	/**
	 * 新增
	 * @param fxusermoneylog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveFxUserMoneyLog")
	@ResponseBody
	public Map<String,Object> saveFxUserMoneyLog(FxUserMoneyLog fxusermoneylog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxusermoneylogServiceImpl.saveFxUserMoneyLog(fxusermoneylog);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param fxusermoneylog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateFxUserMoneyLog")
	@ResponseBody
	public Map<String,Object> updateFxUserMoneyLog(FxUserMoneyLog fxusermoneylog,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxusermoneylogServiceImpl.updateFxUserMoneyLog(fxusermoneylog);
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
	@RequestMapping(value="/deleteFxUserMoneyLog")
	@ResponseBody
 	public Map<String,Object> deleteFxUserMoneyLog(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			fxusermoneylogServiceImpl.deleteFxUserMoneyLog(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
