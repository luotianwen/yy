package com.shifeng.provide.product.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.entity.product.Product;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.product.dao.ProductDao;
import com.shifeng.provide.product.service.ProductService;
import com.shifeng.response.ReqResponse;

/** 
 * 产品表(p_product)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-17 13:40:54 
 */  
@Service(timeout=1200000)
public class ProductServiceImpl implements ProductService{

	@Resource(name = "productDao")
	private ProductDao productDao;
	

	/**
	 * 根据商品ID查询单个商品的详细信息
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @return
	 */
	public ReqResponse<Product> getProduct(String product_id,String shop_id) {
		return null;
	}

	/**
	 * 获取商品上架的商品信息列表
	 * @param page  分页参数  page.t 检索参数
	 * @param shop_id  店铺的id 
	 * @return
	 */
	public ReqResponse<Page<?>> getListingProductList(Page<?> page,String shop_id) {
		return null;
	}

	/**
	 * 获取商品下架的商品信息列表
	 * @param page  分页参数  page.t 检索参数
	 * @param shop_id  店铺的id 
	 * @return
	 */
	public ReqResponse<Page<?>> getDelistingProductList(Page<?> page,String shop_id) {
		return null;
	}
	
	/**
	 *  新增商品
	 * @param product  商品
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> addProduct(Product product,String operatorName) {
		return null;
	}
	
	/**
	 *  修改商品
	 * @param product  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> updateProduct(Product product,String shop_id,String operatorName) {
		return null;
	}
	
	/**
	 *  商品上架
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> listingProduct(String product_id,String shop_id,String operatorName) {
		return null;
	}
	
	/**
	 * 商品下架
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> delistingProduct(String product_id,String shop_id,String operatorName) {
		return null;
	}
	
	/**
	 * 删除商品信息
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> deleteProduct(String product_id,String shop_id,String operatorName) {
		return null;
	}
	
	/**
	 * 恢复删除商品
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> recoverProduct(String product_id,String shop_id,String operatorName) {
		return null;
	}
	
	/**
	 * 设置商品定时上下架
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param upTime 定时上架时间
	 * @param downTime 定时下架时间
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> updateProductStatusByTimer(String product_id,String shop_id,Date upTime,String downTime,String operatorName) {
		return null;
	}
	
	
	
}
