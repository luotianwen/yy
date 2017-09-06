package com.shifeng.webapi.service.mall;


import com.shifeng.plugin.page.Page;

/**
 * 商品评价Service
 * @author WinZhong
 *
 */
public interface WareCommentService {
	
	/**
	 * 获取商品评论列表
	 * @param productId
	 * @param currentPage
	 * @return
	 */
	 Page getWareComments(String productId,int currentPage,int pageSize);
	
	/**
	 * 获取商品评论回复列表
	 * @param commentId 评论ID
	 * @param currentPage
	 * @return
	 */
	 Page getWareCommentRepay(String commentId,int currentPage);
	

}
