package com.shifeng.op.freight.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.freight.ExpressConfig;
import com.shifeng.op.freight.service.ExpressConfigService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 快递配置(o_expressConfig)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:40:52 
 */ 
@Controller
@RequestMapping(value="/expressConfig")
public class ExpressConfigController{
	
	@Resource(name="expressConfigServiceImpl")
	private ExpressConfigService expressConfigServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goExpressConfigList")
	public ModelAndView goExpressConfigList(ModelAndView mv) throws Exception{
		mv.setViewName("freight/expressConfigList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param expressConfig
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllExpressConfig")
	@ResponseBody
	public Map<String,Object> findAllExpressConfig(Page page,ExpressConfig expressConfig) throws Exception{
		if(expressConfig==null){
			expressConfig = new ExpressConfig();
		}
		page.setT(expressConfig);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ExpressConfig> expressConfigs = expressConfigServiceImpl.findAllExpressConfig(page);
		map.put("expressConfigs", expressConfigs);
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
	@RequestMapping(value="/goExpressConfigEdit")
	@ResponseBody
	public ModelAndView goExpressConfigEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("freight/expressConfigEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findExpressConfigById")
	@ResponseBody
	public Map<String,Object> findExpressConfigById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ExpressConfig expressConfig = expressConfigServiceImpl.findExpressConfigById(id);
		map.put("expressConfig",expressConfig);
		return map;
	}
	
	/**
	 * 新增
	 * @param expressConfig
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveExpressConfig")
	@ResponseBody
	public Map<String,Object> saveExpressConfig(ExpressConfig expressConfig,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {expressConfig.setUpdatename(user.getuName());
			expressConfigServiceImpl.saveExpressConfig(expressConfig);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param expressConfig
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateExpressConfig")
	@ResponseBody
	public Map<String,Object> updateExpressConfig(ExpressConfig expressConfig,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {expressConfig.setUpdatename(user.getuName());
			expressConfigServiceImpl.updateExpressConfig(expressConfig);
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
	@RequestMapping(value="/deleteExpressConfig")
	@ResponseBody
 	public Map<String,Object> deleteExpressConfig(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			expressConfigServiceImpl.deleteExpressConfig(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
