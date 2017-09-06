package com.shifeng.webapi.controller.mall;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shifeng.dto.mall.comments.OrderShopCommentDTO;
import com.shifeng.entity.user.SysUser;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.WareCommentService;
import com.shifeng.webapi.service.order.OrderService;

/**
 * 评价
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 商品评价
	 */
	@Resource(name = "wareCommentServiceImpl")
	protected WareCommentService wareCommentService;
	
	@Resource(name = "orderServiceImpl")
	protected OrderService orderService;
	
	
	/**
	 * 获取商品评论列表
	 * @param version
	 * @param ticket
	 * @param productId
	 * @param currentPage 当前页
	 * @param sign (version+ticket+productId+currentPage)
	 * @return
	 */
	@RequestMapping(value = "/wareComments")
	@ResponseBody
	public ReqResponse<Page> wareComments(String version,String ticket,String productId,Integer currentPage,Integer pageSize,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"comment/wareComments", req)){
    		return req;
    	}
    	String content = version+ticket+productId+currentPage;
		if(null == pageSize){
			pageSize =10;
		}else{
			content +=pageSize;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, content,req)){
					if(null == currentPage){
						currentPage =1;
					}
					Page page = wareCommentService.getWareComments(productId, currentPage,pageSize);
				    req.setData(page);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	
	/**
	 * 获取商品评论回复列表
	 * @param version
	 * @param ticket
	 * @param commentId 评论ID
	 * @param currentPage 当前页
	 * @param sign (version+ticket+commentId+currentPage)
	 * @return
	 */
	@RequestMapping(value = "/wareCommentRepay")
	@ResponseBody
	public ReqResponse<Page> wareCommentRepay(String version,String ticket,String commentId,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"comment/wareCommentRepay", req)){
    		return req;
    	}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+commentId+currentPage,req)){
					if(null == currentPage){
						currentPage =1;
					}
					Page page = wareCommentService.getWareCommentRepay(commentId, currentPage);
				    req.setData(page);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	 

	
	
	/**
	 * 评论订单
	 * @param version
	 * @param token
	 * @param comment 评论内容JSON串
	 * @param orderId 订单ID
	 * @param sign (version+ticket+comment+orderId)
	 * @return
	 */
	@RequestMapping(value = "/commentOrder")
	@ResponseBody
	public ReqResponse<String> commentOrder(String version,String token,String comment,String orderId,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "comment/commentOrder", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+comment+orderId,req)){
					SysUser user = this.getUser(token, req);
					OrderShopCommentDTO orderShopComment = JSON.parseObject(comment, OrderShopCommentDTO.class); 
					orderShopComment.setUserId(user_id);
					orderShopComment.setReceiveName(user.getName());
					orderShopComment.setOrderid(orderId);
					System.out.println(orderShopComment.toString());
					boolean bl = orderService.commentOrder(orderShopComment);
					if(!bl){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg(ErrorMsg.FAIL.getMsg());
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	 
	
	
}
