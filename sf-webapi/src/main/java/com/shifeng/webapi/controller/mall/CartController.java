package com.shifeng.webapi.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.CartService;

/**
 * 我的购物车
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "cartServiceImpl")
	protected CartService cartService;
	
	
	/**
	 * 获取购物车商品列表
	 * @param version
	 * @param token
	 * @param currentPage 当前页
	 * @param sign (version+token)
	 * @return
	 */
	@RequestMapping(value = "/cartWareList")
	@ResponseBody
	public ReqResponse<List<MallCartShopDTO>> cartWareList(String version,String token,String sign){
		ReqResponse<List<MallCartShopDTO>> req = new ReqResponse<List<MallCartShopDTO>>();
		//登录验证
		if(!checkLogin(token, "cart/cartWareList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token,req)){
					List<MallCartShopDTO> wareList = cartService.getCartWareList(user_id); 
				    req.setData(wareList);
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
	 * 添加购物车商品
	 * @param version
	 * @param token
	 * @param sku
	 * @param sign （version+token+sku）
	 * @return
	 */
	@RequestMapping(value = "/addCartWare")
	@ResponseBody
	public ReqResponse<String> addCartWare(String version,String token,String sku,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "cart/addCartWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+sku,req)){
						boolean bl = cartService.addCartWare(user_id, sku,req); 
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
	 * 删除购物车商品
	 * @param version
	 * @param token
	 * @param sku 关注sku，多个英文逗号隔开
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/deleteCartWare")
	@ResponseBody
	public ReqResponse<String> deleteCartWare(String version,String token,String sku,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "cart/deleteCartWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+sku,req)){
					boolean bl = cartService.deleteCartWare(user_id, sku); 
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
	 * 修改购物车商品
	 * @param version
	 * @param token
	 * @param sku
	 * @param sign （version+token+sku+wareNumber）
	 * @return
	 */
	@RequestMapping(value = "/editCartWare")
	@ResponseBody
	public ReqResponse<String> editCartWare(String version,String token,String sku,int wareNumber,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "cart/editCartWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+sku+wareNumber,req)){
					boolean bl = cartService.updateCartWare(user_id, sku,wareNumber); 
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
