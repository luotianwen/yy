package com.shifeng.provide.mall.service;

import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/**
 * 商品评价Service
 * @author WinZhong
 *
 */
public interface MallWareCommentService {
	
	/**
	 * 获取商品评论列表
	 * @param productId
	 * @param currentPage
	 * @return
	 */
	 ReqResponse<Page> getWareComments(String productId,int currentPage,int pageSize);
	
	/**
	 * 获取商品评论回复列表
	 * @param commentId 评论ID
	 * @param currentPage
	 * @return
	 */
	 ReqResponse<Page> getWareCommentRepay(String commentId,int currentPage);
	

}
