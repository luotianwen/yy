package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallFeedback;
import com.shifeng.op.mall.service.MallFeedbackService;
import com.shifeng.plugin.page.Page;

/** 
 * 意见反馈(mall_feedback)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:53:39 
 */  
@Service("mallfeedbackServiceImpl")
public class MallFeedbackServiceImpl implements MallFeedbackService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallFeedback> findAllMallFeedback(Page page) throws Exception{
		return (List<MallFeedback>) dao.findForList("mallfeedbackMapper.findAllMallFeedbackPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallFeedback findMallFeedbackById(String id) throws Exception{
		return (MallFeedback) dao.findForObject("mallfeedbackMapper.findMallFeedbackById", id);
	}
	
	/**
	 * 新增
	 * @param mallfeedback
	 * @throws Exception
	 */
	public void saveMallFeedback(MallFeedback mallfeedback) throws Exception{
		dao.save("mallfeedbackMapper.saveMallFeedback", mallfeedback);
	}
	
	/**
	 * 修改
	 * @param mallfeedback
	 * @throws Exception
	 */
	public void updateMallFeedback(MallFeedback mallfeedback) throws Exception{
		dao.update("mallfeedbackMapper.updateMallFeedback", mallfeedback);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallFeedback(String id) throws Exception{
		dao.delete("mallfeedbackMapper.deleteMallFeedback", id);
	}
	
}
