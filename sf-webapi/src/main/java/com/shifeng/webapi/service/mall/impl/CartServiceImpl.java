package com.shifeng.webapi.service.mall.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.provide.mall.service.MallCartService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.service.mall.CartService;

/**
 * 商城购物车
 * @author WinZhong
 *
 */
@Service("cartServiceImpl")
public class CartServiceImpl implements CartService {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallCartService")
	protected MallCartService mallCartService;
	


	/**
	 * 添加购物车商品
	 * @param user_id
	 * @param sku 
	 * @return
	 */
	public boolean addCartWare(String user_id,String sku,ReqResponse<String> req) {
		try {
			ReqResponse<String> result = mallCartService.addCartWare(user_id,sku,1);
			if(result.getCode() == 0){
				return true;
			}else if(result.getCode() == 80){
				req.setCode(ErrorMsg.FAIL.getCode());
				req.setMsg("哇哦，购物车快被挤爆了，先把选好的商品下单吧");
			}
		} catch (Exception e) {
			logger.error("【添加购物车商品】出错：", e);
		}
		return false;
	}

	/**
	 * 删除购物车商品
	 * @param user_id
	 * @param skus 多个英文逗号分开 
	 * @return
	 */
	public boolean deleteCartWare(String user_id,String skus) {
		try {
			ReqResponse<String> result = mallCartService.deleteCartWare(user_id,skus);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【删除购物车商品】出错：", e);
		}
		return false;
	}

	/**
	 * 修改购物车商品数量
	 * @param user_id
	 * @param sku
	 * @return
	 */
	public boolean updateCartWare(String user_id,String sku,int wareNumber) {
		try {
			ReqResponse<String> result = mallCartService.updateCartWare(user_id,sku,wareNumber);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【修改购物车商品数量】出错：", e);
		}
		return false;
	}

	/**
	 * 获取我的购物车商品列表
	 * @param user_id
	 * @return
	 */
	public List<MallCartShopDTO> getCartWareList(String user_id) {
		try {
			ReqResponse<List<MallCartShopDTO>> result = mallCartService.getCartWareList(user_id);
			if(result.getCode() == 0){
				System.out.println(result.getData());
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【添加购物车商品】出错：", e);
		}
		return null;
	}

}
