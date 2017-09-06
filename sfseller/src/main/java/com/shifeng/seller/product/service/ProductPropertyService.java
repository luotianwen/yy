package com.shifeng.seller.product.service;

import java.util.List;

import com.shifeng.entity.product.ProductProperty;
import com.shifeng.seller.product.dto.ProductPropertyDTO;

/** 
 * 产品属性表(p_product_property)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
public interface ProductPropertyService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductProperty> findAllProductProperty(String id) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ProductProperty findProductPropertyById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param productproperty
	 * @throws Exception
	 */
	public void updateProductProperty(List<ProductPropertyDTO> productproperty,String userName,int pid,int cid) throws Exception;
	
	/**
	 * 新增
	 * @param productproperty
	 * @throws Exception
	 */
	public void saveProductProperty(List<ProductPropertyDTO> productproperty,String userName,int pid,int cid) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductProperty(String id) throws Exception;
	
}
