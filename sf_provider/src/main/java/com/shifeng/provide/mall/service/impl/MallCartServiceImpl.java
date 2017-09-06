package com.shifeng.provide.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.provide.mall.dao.MallCartDao;
import com.shifeng.provide.mall.service.MallCartService;
import com.shifeng.response.ReqResponse;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商城购物车
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class MallCartServiceImpl implements MallCartService {

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallCartDao")
	private MallCartDao mallCartDao;

	/**
	 * 添加购物车商品
	 * @param user_id
	 * @param sku
	 * @param pcount 商品数量 
	 * @return
	 */
	public ReqResponse<String> addCartWare(String user_id,String sku,int pcount) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallCartDao.addCartWare(user_id,sku,pcount,req);
			return req;
		} catch (Exception e) {
			logger.error("【添加购物车商品】出错：", e);
			req.setCode(1);
			req.setMsg("【添加购物车商品】异常");
			return req;
		}
	}

	/**
	 * 删除购物车商品
	 * @param user_id
	 * @param skus 多个英文逗号分开 
	 * @return
	 */
	public ReqResponse<String> deleteCartWare(String user_id,String skus) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallCartDao.deleteCartWare(user_id,skus,req);
			return req;
		} catch (Exception e) {
			logger.error("【删除购物车商品】出错：", e);
			req.setCode(1);
			req.setMsg("【删除购物车商品】异常");
			return req;
		}
	}

	/**
	 * 修改购物车商品数量
	 * @param user_id
	 * @param sku
	 * @return
	 */
	public ReqResponse<String> updateCartWare(String user_id,String sku,int wareNumber) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallCartDao.updateCartWare(user_id,sku,wareNumber,req);
			return req;
		} catch (Exception e) {
			logger.error("【修改购物车商品数量】出错：", e);
			req.setCode(1);
			req.setMsg("【修改购物车商品数量】异常");
			return req;
		}
	}
	


	/**
	 * 获取我的购物车商品列表
	 * @param user_id
	 * @return
	 */
	public ReqResponse<List<MallCartShopDTO>> getCartWareList(String user_id) {
		ReqResponse<List<MallCartShopDTO>> req = new ReqResponse<List<MallCartShopDTO>>();
		try {
			mallCartDao.getCartWareList(user_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的购物车商品列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的购物车商品列表】异常");
			return req;
		}
	}



}
