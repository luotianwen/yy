package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallFeedbackImg;
import com.shifeng.plugin.page.Page;

/** 
 * 意见反馈图片(mall_feedback_img)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:53:40 
 */  
public interface MallFeedbackImgService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallFeedbackImg> findAllMallFeedbackImg(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallFeedbackImg findMallFeedbackImgById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param mallfeedbackimg
	 * @throws Exception
	 */
	public void updateMallFeedbackImg(MallFeedbackImg mallfeedbackimg) throws Exception;
	
	/**
	 * 新增
	 * @param mallfeedbackimg
	 * @throws Exception
	 */
	public void saveMallFeedbackImg(MallFeedbackImg mallfeedbackimg) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallFeedbackImg(String id) throws Exception;
	
}
