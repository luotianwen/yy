package com.shifeng.provide.mall.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.ware.WareCommentDTO;
import com.shifeng.dto.mall.ware.WareCommentRepayDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

@Service("mallWareCommentDao")
public class MallWareCommentDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 获取商品评论列表
	 * @param productId
	 * @param req
	 * @throws Exception 
	 */
	public void getWareComments(String productId,int currentPage,int pageSize, ReqResponse<Page> req) throws Exception {
		Page<String> page = new Page<String>();
		page.setT(productId);
		if(pageSize != 0){
			page.setPageSize(pageSize);
		}
		page.setCurrentPage(currentPage);
		List<WareCommentDTO> cList = (List<WareCommentDTO>)dao.findForList("mallWareCommentMapper.getWareCommentsPage", page);
		page.setResultData(cList);
		req.setData(page);
	}

	/**
	 * 获取商品评论回复列表
	 * @param commentId 评论ID
	 * @param currentPage
	 * @return
	 * @throws Exception 
	 */
	public void getWareCommentRepay(String commentId, ReqResponse<Page> req) throws Exception {
		Page<String> page = new Page<String>();
		page.setT(commentId);
		List<WareCommentRepayDTO> cList = (List<WareCommentRepayDTO>)dao.findForList("mallWareCommentMapper.getWareCommentRepayPage", page);
		page.setResultData(cList);
		req.setData(page);
		
	}
	
	
	
	
	
	
	

}
