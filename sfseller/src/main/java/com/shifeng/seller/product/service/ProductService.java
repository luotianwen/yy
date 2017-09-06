package com.shifeng.seller.product.service;

import java.util.List;

import com.shifeng.entity.product.Product;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.product.dto.ProductDTO;
import com.shifeng.seller.product.dto.ProductListDTO;

/** 
 * 产品表(p_product)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
public interface ProductService {

	/**
	 * 产品列表
	 */
	public List<ProductListDTO> findAllProduct(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Product findProductById(String id,String shopId) throws Exception;
	
	/**
	 * 修改
	 * @param product
	 * @throws Exception
	 */
	public void updateProduct(ProductDTO product,Users user) throws Exception;
	
	/**
	 * 新增
	 * @param product
	 * @throws Exception
	 */
	public void saveProduct(ProductDTO product,Users user) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProduct(String id) throws Exception;

	/**
	 * 修改产品状态
	 * @param id 产品ID
	 * @param user
	 * @throws Exception
	 */
	public void updateProductState(String id,Users user,String state) throws Exception;
	
}
