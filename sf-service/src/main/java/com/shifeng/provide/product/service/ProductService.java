package com.shifeng.provide.product.service;

import java.util.Date;
import java.util.List;
import com.shifeng.entity.product.Product;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;  
/** 
 * 产品表(p_product)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-17 13:40:54 
 */
public interface ProductService {

	/**
	 * 根据商品ID查询单个商品的详细信息
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @return
	 */
	ReqResponse<Product> getProduct(String product_id,String shop_id);

	/**
	 * 获取商品上架的商品信息列表
	 * @param page  分页参数  page.t 检索参数
	 * @param shop_id  店铺的id 
	 * @return
	 */
	ReqResponse<Page<?>> getListingProductList(Page<?> page,String shop_id);

	/**
	 * 获取商品下架的商品信息列表
	 * @param page  分页参数  page.t 检索参数
	 * @param shop_id  店铺的id 
	 * @return
	 */
	ReqResponse<Page<?>> getDelistingProductList(Page<?> page,String shop_id);
	
	/**
	 *  新增商品
	 * @param product  商品
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> addProduct(Product product,String operatorName);
	
	/**
	 *  修改商品
	 * @param product  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> updateProduct(Product product,String shop_id,String operatorName);
	
	/**
	 *  商品上架
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> listingProduct(String product_id,String shop_id,String operatorName);
	
	/**
	 * 商品下架
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> delistingProduct(String product_id,String shop_id,String operatorName);
	
	/**
	 * 删除商品信息
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> deleteProduct(String product_id,String shop_id,String operatorName);
	
	/**
	 * 恢复删除商品
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> recoverProduct(String product_id,String shop_id,String operatorName);
	
	/**
	 * 设置商品定时上下架
	 * @param product_id  商品的id 
	 * @param shop_id  店铺的id 
	 * @param upTime 定时上架时间
	 * @param downTime 定时下架时间
	 * @param operatorName  修改人名称
	 * @return
	 */
	ReqResponse<String> updateProductStatusByTimer(String product_id,String shop_id,Date upTime,String downTime,String operatorName);
	
}
