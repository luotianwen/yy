package com.shifeng.op.mall.controller;

import com.shifeng.entity.mall.MallFeedback;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.mall.service.MallFeedbackService;
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
 * 意见反馈(mall_feedback)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:53:39 
 */ 
@Controller
@RequestMapping(value="/mallfeedback")
public class MallFeedbackController{
	
	@Resource(name="mallfeedbackServiceImpl")
	private MallFeedbackService mallfeedbackServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallFeedbackList")
	public ModelAndView goMallFeedbackList(ModelAndView mv) throws Exception{
		mv.setViewName("mall/mallfeedbackList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mallfeedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallFeedback")
	@ResponseBody
	public Map<String,Object> findAllMallFeedback(Page page,MallFeedback mallfeedback) throws Exception{
		if(mallfeedback==null){
			mallfeedback = new MallFeedback();
		}
		page.setT(mallfeedback);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallFeedback> mallfeedbacks = mallfeedbackServiceImpl.findAllMallFeedback(page);
		map.put("mallfeedbacks", mallfeedbacks);
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
	@RequestMapping(value="/goMallFeedbackEdit")
	@ResponseBody
	public ModelAndView goMallFeedbackEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/mallfeedbackEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallFeedbackById")
	@ResponseBody
	public Map<String,Object> findMallFeedbackById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallFeedback mallfeedback = mallfeedbackServiceImpl.findMallFeedbackById(id);
		map.put("mallfeedback",mallfeedback);
		return map;
	}
	
	/**
	 * 新增
	 * @param mallfeedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallFeedback")
	@ResponseBody
	public Map<String,Object> saveMallFeedback(MallFeedback mallfeedback,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallfeedbackServiceImpl.saveMallFeedback(mallfeedback);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param mallfeedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallFeedback")
	@ResponseBody
	public Map<String,Object> updateMallFeedback(MallFeedback mallfeedback,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallfeedback.setOperator_name(user.getuName());
			mallfeedbackServiceImpl.updateMallFeedback(mallfeedback);
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
	@RequestMapping(value="/deleteMallFeedback")
	@ResponseBody
 	public Map<String,Object> deleteMallFeedback(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			mallfeedbackServiceImpl.deleteMallFeedback(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
