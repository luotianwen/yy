package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.dao.MallWareCommentDao;
import com.shifeng.provide.mall.service.MallWareCommentService;
import com.shifeng.response.ReqResponse;
/**
 * 商品评价
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class MallWareCommentServiceImpl implements MallWareCommentService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallWareCommentDao")
	private MallWareCommentDao mallWareCommentDao;
	

	
	/**
	 * 获取商品评论列表
	 * @param productId
	 * @param currentPage
	 * @return
	 */
	public ReqResponse<Page> getWareComments(String productId,int currentPage,int pageSize) {
		//List<WareCommentDTO>
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallWareCommentDao.getWareComments(productId,currentPage,pageSize,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取商品评论列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取商品评论列表】异常");
			return req;
		}
	}
	
	/**
	 * 获取商品评论回复列表
	 * @param commentId 评论ID
	 * @param currentPage
	 * @return
	 */
	public ReqResponse<Page> getWareCommentRepay(String commentId,int currentPage) {
		//List<WareCommentDTO>
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallWareCommentDao.getWareCommentRepay(commentId,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取商品评论回复列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取商品评论回复列表】异常");
			return req;
		}
	}
	



}
