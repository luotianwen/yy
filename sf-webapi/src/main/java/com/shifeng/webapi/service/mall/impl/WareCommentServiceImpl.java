package com.shifeng.webapi.service.mall.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.service.MallWareCommentService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.mall.WareCommentService;
/**
 * 商品评价Service
 * @author WinZhong
 *
 */
@Service("wareCommentServiceImpl")
public class WareCommentServiceImpl implements WareCommentService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallWareCommentService")
	protected MallWareCommentService mallWareCommentService;
	
	
	/**
	 * 获取商品评论列表
	 * @param productId
	 * @param currentPage
	 * @return
	 */
	 public Page getWareComments(String productId,int currentPage,int pageSize) {
		try {
			ReqResponse<Page> result = mallWareCommentService.getWareComments(productId,currentPage,pageSize);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取商品评论列表】出错：", e);
		}
		return null;
	}
	
	/**
	 * 获取商品评论回复列表
	 * @param commentId
	 * @param currentPage
	 * @return
	 */
	 public Page getWareCommentRepay(String commentId,int currentPage) {
		try {
			ReqResponse<Page> result = mallWareCommentService.getWareCommentRepay(commentId,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取商品评论回复列表】出错：", e);
		}
		return null;
	}

}
