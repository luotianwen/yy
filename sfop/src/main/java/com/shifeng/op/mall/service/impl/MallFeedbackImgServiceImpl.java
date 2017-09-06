package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallFeedbackImg;
import com.shifeng.op.mall.service.MallFeedbackImgService;
import com.shifeng.plugin.page.Page;

/** 
 * 意见反馈图片(mall_feedback_img)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:53:40 
 */  
@Service("mallfeedbackimgServiceImpl")
public class MallFeedbackImgServiceImpl implements MallFeedbackImgService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallFeedbackImg> findAllMallFeedbackImg(Page page) throws Exception{
		return (List<MallFeedbackImg>) dao.findForList("mallfeedbackimgMapper.findAllMallFeedbackImgPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallFeedbackImg findMallFeedbackImgById(String id) throws Exception{
		return (MallFeedbackImg) dao.findForObject("mallfeedbackimgMapper.findMallFeedbackImgById", id);
	}
	
	/**
	 * 新增
	 * @param mallfeedbackimg
	 * @throws Exception
	 */
	public void saveMallFeedbackImg(MallFeedbackImg mallfeedbackimg) throws Exception{
		dao.save("mallfeedbackimgMapper.saveMallFeedbackImg", mallfeedbackimg);
	}
	
	/**
	 * 修改
	 * @param mallfeedbackimg
	 * @throws Exception
	 */
	public void updateMallFeedbackImg(MallFeedbackImg mallfeedbackimg) throws Exception{
		dao.update("mallfeedbackimgMapper.updateMallFeedbackImg", mallfeedbackimg);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallFeedbackImg(String id) throws Exception{
		dao.delete("mallfeedbackimgMapper.deleteMallFeedbackImg", id);
	}
	
}
