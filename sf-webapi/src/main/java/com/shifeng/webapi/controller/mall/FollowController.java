package com.shifeng.webapi.controller.mall;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.FollowService;

/**
 * 我的关注
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/my/follow")
public class FollowController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "followServiceImpl")
	protected FollowService followService;
	
	
	/**
	 * 获取关注商品列表
	 * @param version
	 * @param token
	 * @param currentPage 当前页
	 * @param sign (version+token+currentPage)
	 * @return
	 */
	@RequestMapping(value = "/followWareList")
	@ResponseBody
	public ReqResponse<Page> followWareList(String version,String token,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
		//登录验证
		if(!checkLogin(token, "follow/followWareList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+currentPage,req)){
					if(null == currentPage){
						currentPage = 1;
					}
				   Page page = followService.getFollowWareList(user_id,currentPage); 
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
	 * 添加关注商品
	 * @param version
	 * @param token
	 * @param sku
	 * @param sign （version+token+sku）
	 * @return
	 */
	@RequestMapping(value = "/followWare")
	@ResponseBody
	public ReqResponse<String> followWare(String version,String token,int sku,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "follow/followWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+sku,req)){
					 if(!followService.isFollowWare(user_id, sku)){
						boolean bl = followService.addFollowWare(user_id, sku); 
						if(!bl){
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg(ErrorMsg.FAIL.getMsg());
						}
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

	
	/**
	 * 是否关注商品
	 * @param version
	 * @param token
	 * @param sku
	 * @param sign （version+token+sku）
	 * @return
	 */
	@RequestMapping(value = "/isFollowWare")
	@ResponseBody
	public ReqResponse<Boolean> isFollowWare(String version,String token,int sku,String sign){
		ReqResponse<Boolean> req = new ReqResponse<Boolean>();
		//登录验证
		if(!checkLogin(token, "follow/isFollowWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+sku,req)){
					 req.setData(followService.isFollowWare(user_id, sku));
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
	 * 删除关注商品
	 * @param version
	 * @param token
	 * @param sku 关注sku，多个英文逗号隔开
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/deleteFollowWare")
	@ResponseBody
	public ReqResponse<String> deleteFollowWare(String version,String token,String sku,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "follow/deleteFollowWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+sku,req)){
					boolean bl = followService.deleteFollowWare(user_id, sku); 
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
	
	
	
	
	
	/**
	 * 获取关注店铺列表
	 * @param version
	 * @param token
	 * @param currentPage 当前页
	 * @param sign (version+token+currentPage)
	 * @return
	 */
	@RequestMapping(value = "/followVenderList")
	@ResponseBody
	public ReqResponse<Page> followVenderList(String version,String token,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
		//登录验证
		if(!checkLogin(token, "follow/followVenderList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+currentPage,req)){
					if(null == currentPage){
						currentPage = 1;
					}
				   Page page = followService.getFollowVenderList(user_id,currentPage); 
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
	 * 添加关注店铺
	 * @param version
	 * @param token
	 * @param shopId
	 * @param sign （version+token+shopId）
	 * @return
	 */
	@RequestMapping(value = "/followVender")
	@ResponseBody
	public ReqResponse<String> followVender(String version,String token,int shopId,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "follow/followVender", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+shopId,req)){
					 if(!followService.isFollowVender(user_id, shopId)){
						boolean bl = followService.addFollowVender(user_id, shopId); 
						if(!bl){
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg(ErrorMsg.FAIL.getMsg());
						}
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
	

	/**
	 * 是否关注店铺
	 * @param version
	 * @param token
	 * @param shopId
	 * @param sign （version+token+shopId）
	 * @return
	 */
	@RequestMapping(value = "/isFollowVender")
	@ResponseBody
	public ReqResponse<Boolean> isFollowVender(String version,String token,int shopId,String sign){
		ReqResponse<Boolean> req = new ReqResponse<Boolean>();
		//登录验证
		if(!checkLogin(token, "follow/isFollowVender", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+shopId,req)){
					 req.setData(followService.isFollowVender(user_id, shopId));
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
	 * 删除关注店铺
	 * @param version
	 * @param token
	 * @param shopId  关注shopId，多个英文逗号隔开
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/deleteFollowVender")
	@ResponseBody
	public ReqResponse<String> deleteFollowVender(String version,String token,String shopId,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "follow/deleteFollowVender", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+shopId,req)){
					boolean bl = followService.deleteFollowVender(user_id, shopId); 
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
