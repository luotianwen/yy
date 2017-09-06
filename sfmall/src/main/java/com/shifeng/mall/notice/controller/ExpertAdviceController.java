package com.shifeng.mall.notice.controller;

import com.shifeng.entity.system.ExpertAdvice;
import com.shifeng.entity.system.Notice;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.notice.service.ExpertAdviceService;
import com.shifeng.plugin.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/** 
 * 专家建议(s_expert_advice)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */ 
@Controller
@RequestMapping(value="/expertadvice")
public class ExpertAdviceController extends BaseController{
	
	@Resource(name="expertadviceServiceImpl")
	private ExpertAdviceService expertadviceServiceImpl;
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllExpertadvice")
	public ModelAndView findAllExpertadvice(ModelAndView mv ,Page<Notice> page ) throws Exception{
		List<ExpertAdvice> expertadvices = expertadviceServiceImpl.findAllExpertAdvice(page);
		mv.addObject("expertadvices", expertadvices);
		mv.addObject("page", page);
		mv.setViewName(basePath + "system/expertadviceList.btl");
		return mv;
	}
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}")
	public ModelAndView findExpertadviceById(ModelAndView mv ,@PathVariable String id) throws Exception{
		ExpertAdvice expertadvice = expertadviceServiceImpl.findExpertAdviceById(id);
		mv.addObject("expertadvice", expertadvice);
		mv.setViewName(basePath + "system/expertadvice.btl");
		return mv;
	}


 
 
}
