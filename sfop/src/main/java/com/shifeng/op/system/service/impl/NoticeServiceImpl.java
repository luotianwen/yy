package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.Notice;
import com.shifeng.op.system.service.NoticeService;
import com.shifeng.plugin.page.Page;

/** 
 * 商城公告(s_notice)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
@Service("noticeServiceImpl")
public class NoticeServiceImpl implements NoticeService{

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
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveNotice(Notice notice) throws Exception{
		dao.save("noticeMapper.saveNotice", notice);
	}

	@Override
	public void deleteNotice(Notice notice) throws Exception {
		dao.delete("noticeMapper.deleteNotice", notice);
	}

	/**
	 * 修改
	 * @param notice
	 * @throws Exception
	 */
	public void updateNotice(Notice notice) throws Exception{
		dao.update("noticeMapper.updateNotice", notice);
	}
	
	
}
