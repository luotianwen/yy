package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.Product;
import com.shifeng.op.dto.product.ProductDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;

/** 
 * 产品表(p_product)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
public interface ProductService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductDTO> findAllProduct(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Product findProductById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param product
	 * @throws Exception
	 */
	public void updateProduct(Product product) throws Exception;
	
	/**
	 * 新增
	 * @param product
	 * @throws Exception
	 */
	public void saveProduct(Product product) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProduct(String id) throws Exception;

	public void updateDownProduct(int[] id, Users user)throws Exception;

	public void updateDeleteProduct(int[] id, Users user)throws Exception;

	public void updateRecoveryProduct(int[] id, Users user)throws Exception;

	public void updateUpProduct(int[] id, Users user)throws Exception;
}
