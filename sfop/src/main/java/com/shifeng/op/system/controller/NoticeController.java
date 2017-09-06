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

import com.shifeng.entity.system.Notice;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.system.service.NoticeService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;


/** 
 * 商城公告(s_notice)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */ 
@Controller
@RequestMapping(value="/notice")
public class NoticeController{
	
	@Resource(name="noticeServiceImpl")
	private NoticeService noticeServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goNoticeList")
	public ModelAndView goNoticeList(ModelAndView mv) throws Exception{
		mv.setViewName("system/noticeList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllNotice")
	@ResponseBody
	public Map<String,Object> findAllNotice(Page<Notice> page,Notice notice) throws Exception{
		page.setT(notice);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Notice> notices = noticeServiceImpl.findAllNotice(page);
		map.put("notices", notices);
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
	@RequestMapping(value="/goNoticeEdit")
	@ResponseBody
	public ModelAndView goNoticeEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/noticeEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findNoticeById")
	@ResponseBody
	public Map<String,Object> findNoticeById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Notice notice = noticeServiceImpl.findNoticeById(id);
		map.put("notice", notice);
		return map;
	}
	
	/**
	 * 新增
	 * @param notice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveNotice")
	@ResponseBody
	public Map<String,Object> saveNotice(Notice notice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			if(StringUtils.isEmpty(notice.getPublisher())){
				notice.setPublisher(user.getuName());
			}
			notice.setUpdatename(user.getuName());
			noticeServiceImpl.saveNotice(notice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param notice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateNotice")
	@ResponseBody
	public Map<String,Object> updateNotice(Notice notice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			if(StringUtils.isEmpty(notice.getPublisher())){
				notice.setPublisher(user.getuName());
			}
			notice.setUpdatename(user.getuName());
			noticeServiceImpl.updateNotice(notice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}

	/**
	 * 删除
	 * @param notice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteNotice")
	@ResponseBody
	public Map<String,Object> deleteNotice(Notice notice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			noticeServiceImpl.deleteNotice(notice);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
 
}
