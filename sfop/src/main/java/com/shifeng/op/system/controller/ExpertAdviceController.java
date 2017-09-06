package com.shifeng.op.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.system.ExpertAdvice;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.system.service.ExpertAdviceService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;


/** 
 * 专家建议(s_expert_advice)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */ 
@Controller
@RequestMapping(value="/expertadvice")
public class ExpertAdviceController{
	
	@Resource(name="expertadviceServiceImpl")
	private ExpertAdviceService expertadviceServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goExpertAdviceList")
	public ModelAndView goExpertAdviceList(ModelAndView mv) throws Exception{
		mv.setViewName("system/expertadviceList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllExpertAdvice")
	@ResponseBody
	public Map<String,Object> findAllExpertAdvice(Page page,ExpertAdvice expertAdvice) throws Exception{
		page.setT(expertAdvice);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ExpertAdvice> expertadvices = expertadviceServiceImpl.findAllExpertAdvice(page);
		map.put("expertadvices", expertadvices);
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
	@RequestMapping(value="/goExpertAdviceEdit")
	@ResponseBody
	public ModelAndView goExpertAdviceEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/expertadviceEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findExpertAdviceById")
	@ResponseBody
	public Map<String,Object> findExpertAdviceById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		ExpertAdvice expertadvice = expertadviceServiceImpl.findExpertAdviceById(id);
		map.put("expertadvice", expertadvice);
		return map;
	}
	
	/**
	 * 新增
	 * @param expertadvice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveExpertAdvice")
	@ResponseBody
	public Map<String,Object> saveExpertAdvice(ExpertAdvice expertadvice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			if(StringUtils.isEmpty(expertadvice.getPublisher())){
				expertadvice.setPublisher(user.getuName());
			}
			expertadvice.setUpdatename(user.getuName());
			expertadviceServiceImpl.saveExpertAdvice(expertadvice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param expertadvice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateExpertAdvice")
	@ResponseBody
	public Map<String,Object> updateExpertAdvice(ExpertAdvice expertadvice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			if(StringUtils.isEmpty(expertadvice.getPublisher())){
				expertadvice.setPublisher(user.getuName());
			}
			expertadvice.setUpdatename(user.getuName());
			expertadviceServiceImpl.updateExpertAdvice(expertadvice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 修改
	 * @param expertadvice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteExpertAdvice")
	@ResponseBody
	public Map<String,Object> deleteExpertAdvice(ExpertAdvice expertadvice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			expertadviceServiceImpl.deleteExpertAdvice(expertadvice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
 
 
}
