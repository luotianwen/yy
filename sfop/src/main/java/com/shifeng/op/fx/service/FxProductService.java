package com.shifeng.op.fx.service;

import com.shifeng.entity.fx.FxProduct;
import com.shifeng.plugin.page.Page;

import java.util.List;

/** 
 * 商品分销价格(fx_product)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-09 10:31:56 
 */  
public interface FxProductService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxProduct> findAllFxProduct(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public FxProduct findFxProductById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param fxproduct
	 * @throws Exception
	 */
	public void updateFxProduct(FxProduct fxproduct) throws Exception;
	
	/**
	 * 新增
	 * @param fxproduct
	 * @throws Exception
	 */
	public void saveFxProduct(FxProduct fxproduct) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxProduct(String id) throws Exception;

    void updateFxProductBySnumber(String s, double v)throws Exception;
}
