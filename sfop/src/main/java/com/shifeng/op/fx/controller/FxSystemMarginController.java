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

import com.shifeng.entity.fx.FxSystemMargin;
import com.shifeng.op.fx.service.FxSystemMarginService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 系统分销利率设置(fx_system_margin)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */ 
@Controller
@RequestMapping(value="/fxsystemmargin")
public class FxSystemMarginController{
	
	@Resource(name="fxsystemmarginServiceImpl")
	private FxSystemMarginService fxsystemmarginServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFxSystemMarginList")
	public ModelAndView goFxSystemMarginList(ModelAndView mv) throws Exception{
		mv.setViewName("fx/fxsystemmarginList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param fxsystemmargin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllFxSystemMargin")
	@ResponseBody
	public Map<String,Object> findAllFxSystemMargin(Page page,FxSystemMargin fxsystemmargin) throws Exception{
		if(fxsystemmargin==null){
			fxsystemmargin = new FxSystemMargin();
		}
		page.setT(fxsystemmargin);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FxSystemMargin> fxsystemmargins = fxsystemmarginServiceImpl.findAllFxSystemMargin(page);
		map.put("fxsystemmargins", fxsystemmargins);
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
	@RequestMapping(value="/goFxSystemMarginEdit")
	@ResponseBody
	public ModelAndView goFxSystemMarginEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("fx/fxsystemmarginEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findFxSystemMarginById")
	@ResponseBody
	public Map<String,Object> findFxSystemMarginById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		FxSystemMargin fxsystemmargin = fxsystemmarginServiceImpl.findFxSystemMarginById(id);
		map.put("fxsystemmargin",fxsystemmargin);
		return map;
	}
	
	/**
	 * 新增
	 * @param fxsystemmargin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveFxSystemMargin")
	@ResponseBody
	public Map<String,Object> saveFxSystemMargin(FxSystemMargin fxsystemmargin,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			if(fxsystemmargin.getSmarginrate()>=fxsystemmargin.getEmarginrate()||fxsystemmargin.getCommissionrate()>=fxsystemmargin.getEmarginrate()){
				map.put(Const.ERROR_INFO, "验证不通过");
			}
			else {
				int count=fxsystemmarginServiceImpl.countFxSystemMargin(fxsystemmargin);
				if(count>0){
					map.put(Const.ERROR_INFO, "比率值范围有重复");
				}
				else {
					fxsystemmargin.setUpdateName(user.getuName());
					fxsystemmarginServiceImpl.saveFxSystemMargin(fxsystemmargin);
					map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param fxsystemmargin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateFxSystemMargin")
	@ResponseBody
	public Map<String,Object> updateFxSystemMargin(FxSystemMargin fxsystemmargin,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			if(fxsystemmargin.getSmarginrate()>=fxsystemmargin.getEmarginrate()||fxsystemmargin.getCommissionrate()>=fxsystemmargin.getEmarginrate()){
				map.put(Const.ERROR_INFO, "验证不通过");
			}
			else {
				int count = fxsystemmarginServiceImpl.countFxSystemMargin(fxsystemmargin);
				if (count > 0) {
					map.put(Const.ERROR_INFO, "比率值范围有重复");
				} else {
					fxsystemmargin.setUpdateName(user.getuName());
					fxsystemmarginServiceImpl.updateFxSystemMargin(fxsystemmargin);
					map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
				}
			}
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
	@RequestMapping(value="/deleteFxSystemMargin")
	@ResponseBody
 	public Map<String,Object> deleteFxSystemMargin(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			fxsystemmarginServiceImpl.deleteFxSystemMargin(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
