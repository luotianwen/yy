package com.shifeng.op.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.system.Explain;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.system.service.ExplainService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;


/** 
 * 商城说明表(s_explain)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */ 
@Controller
@RequestMapping(value="/explain")
public class ExplainController{
	
	@Resource(name="explainServiceImpl")
	private ExplainService explainServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goExplainList")
	public ModelAndView goExplainList(ModelAndView mv) throws Exception{
		mv.setViewName("system/explainList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllExplain")
	@ResponseBody
	public Map<String,Object> findAllExplain(Page page ,Explain explain) throws Exception{
		page.setT(explain);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Explain> explains = explainServiceImpl.findAllExplain(page);
		map.put("explains", explains);
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
	@RequestMapping(value="/goExplainEdit")
	@ResponseBody
	public ModelAndView goExplainEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/explainEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findExplainById")
	@ResponseBody
	public Map<String,Object> findExplainById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Explain explain = explainServiceImpl.findExplainById(id);
		map.put("explain", explain);
		return map;
	}
	
	/**
	 * 新增
	 * @param explain
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveExplain")
	@ResponseBody
	public Map<String,Object> saveExplain(Explain explain,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			explain.setUpdatename(user.getuName());
			explainServiceImpl.saveExplain(explain);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param explain
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateExplain")
	@ResponseBody
	public Map<String,Object> updateExplain(Explain explain,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			explain.setUpdatename(user.getuName());
			explainServiceImpl.updateExplain(explain);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	@RequestMapping(value="/deleteExplain")
	@ResponseBody
	public Map<String,Object> deleteExplain(Explain explain,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			explainServiceImpl.deleteExplain(explain);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}

 
 
}
