package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.Notice;
import com.shifeng.plugin.page.Page;

/** 
 * 商城公告(s_notice)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
public interface NoticeService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Notice> findAllNotice(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Notice findNoticeById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param notice
	 * @throws Exception
	 */
	public void updateNotice(Notice notice) throws Exception;
	
	/**
	 * 新增
	 * @param notice
	 * @throws Exception
	 */
	public void saveNotice(Notice notice) throws Exception;

	/**
	 * 删除
	 * @param notice
	 * @throws Exception
	 */
    void deleteNotice(Notice notice)throws Exception;
}
