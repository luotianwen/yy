package com.shifeng.mall.notice.controller;

import com.shifeng.entity.system.Notice;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.notice.service.NoticeService;
import com.shifeng.plugin.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/** 
 * 商城公告(s_notice)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */ 
@Controller
@RequestMapping(value="/notice")
public class NoticeController extends BaseController {
	
	@Resource(name="noticeServiceImpl")
	private NoticeService noticeServiceImpl;

	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllNotice")
	public ModelAndView findAllNotice(ModelAndView mv ,Page<Notice> page ) throws Exception{
		List<Notice> notices = noticeServiceImpl.findAllNotice(page);
		mv.addObject("notices", notices);
		mv.addObject("page", page);
		mv.setViewName(basePath + "system/noticeList.btl");
		return mv;
	}
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}")
	public ModelAndView findNoticeById(ModelAndView mv ,@PathVariable String id) throws Exception{
		Notice notice = noticeServiceImpl.findNoticeById(id);
		mv.addObject("notice", notice);
		mv.setViewName(basePath + "system/notice.btl");
		return mv;
	}

 
}
