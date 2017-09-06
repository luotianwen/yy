package com.shifeng.provide.mall.service;

import java.util.List;

import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.response.ReqResponse;

/**
 * 商城购物车
 * @author WinZhong
 *
 */

public interface MallCartService {

	/**
	 * 添加购物车商品
	 * @param user_id
	 * @param sku 
	 * @param pcount 商品数量 
	 * @return
	 */
	ReqResponse<String> addCartWare(String user_id,String sku,int pcount);

	/**
	 * 删除购物车商品
	 * @param user_id
	 * @param skus 多个英文逗号分开 
	 * @return
	 */
	ReqResponse<String> deleteCartWare(String user_id,String skus);

	/**
	 * 修改购物车商品数量
	 * @param user_id
	 * @param sku
	 * @return
	 */
	ReqResponse<String> updateCartWare(String user_id,String sku,int wareNumber);

	/**
	 * 获取我的购物车商品列表
	 * @param user_id
	 * @return
	 */
	ReqResponse<List<MallCartShopDTO>> getCartWareList(String user_id);


}
