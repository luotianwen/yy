package com.shifeng.op.mall.controller;

import com.shifeng.entity.mall.MallFeedbackImg;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.mall.service.MallFeedbackImgService;
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
 * 意见反馈图片(mall_feedback_img)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:53:40 
 */ 
@Controller
@RequestMapping(value="/mallfeedbackimg")
public class MallFeedbackImgController{
	
	@Resource(name="mallfeedbackimgServiceImpl")
	private MallFeedbackImgService mallfeedbackimgServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallFeedbackImgList")
	public ModelAndView goMallFeedbackImgList(ModelAndView mv,String feedback_id) throws Exception{
		mv.addObject("feedback_id",feedback_id);
		mv.setViewName("mall/mallfeedbackimgList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mallfeedbackimg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallFeedbackImg")
	@ResponseBody
	public Map<String,Object> findAllMallFeedbackImg(Page page,MallFeedbackImg mallfeedbackimg) throws Exception{
		if(mallfeedbackimg==null){
			mallfeedbackimg = new MallFeedbackImg();
		}
		page.setT(mallfeedbackimg);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallFeedbackImg> mallfeedbackimgs = mallfeedbackimgServiceImpl.findAllMallFeedbackImg(page);
		map.put("mallfeedbackimgs", mallfeedbackimgs);
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
	@RequestMapping(value="/goMallFeedbackImgEdit")
	@ResponseBody
	public ModelAndView goMallFeedbackImgEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/mallfeedbackimgEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallFeedbackImgById")
	@ResponseBody
	public Map<String,Object> findMallFeedbackImgById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallFeedbackImg mallfeedbackimg = mallfeedbackimgServiceImpl.findMallFeedbackImgById(id);
		map.put("mallfeedbackimg",mallfeedbackimg);
		return map;
	}
	
	/**
	 * 新增
	 * @param mallfeedbackimg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallFeedbackImg")
	@ResponseBody
	public Map<String,Object> saveMallFeedbackImg(MallFeedbackImg mallfeedbackimg,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallfeedbackimgServiceImpl.saveMallFeedbackImg(mallfeedbackimg);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param mallfeedbackimg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallFeedbackImg")
	@ResponseBody
	public Map<String,Object> updateMallFeedbackImg(MallFeedbackImg mallfeedbackimg,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallfeedbackimgServiceImpl.updateMallFeedbackImg(mallfeedbackimg);
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
	@RequestMapping(value="/deleteMallFeedbackImg")
	@ResponseBody
 	public Map<String,Object> deleteMallFeedbackImg(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			mallfeedbackimgServiceImpl.deleteMallFeedbackImg(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
