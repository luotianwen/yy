package com.shifeng.mall.notice.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.Notice;
import com.shifeng.mall.notice.service.NoticeService;
import com.shifeng.plugin.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
 * 商城公告(s_notice)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
@Service("noticeServiceImpl")
public class NoticeServiceImpl implements NoticeService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Notice> findAllNotice(Page page) throws Exception{
		return (List<Notice>) dao.findForList("noticeMapper.findAllNoticePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Notice findNoticeById(String id) throws Exception{
		return (Notice) dao.findForObject("noticeMapper.findNoticeById", id);
	}

	
}
