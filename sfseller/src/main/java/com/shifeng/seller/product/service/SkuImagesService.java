package com.shifeng.seller.product.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.product.SkuImages;
import com.shifeng.seller.product.dto.SkuImagesDTO;

/** 
 * sku图片表(p_sku_images)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 16:57:54 
 */  
public interface SkuImagesService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SkuImages> findAllSkuImages(String id) throws Exception;
	
	/**
	 * 查询SKU颜色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SkuImages> findAllColorId(String id) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public SkuImages findSkuImagesById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param skuimages
	 * @throws Exception
	 */
	public void updateSkuImages(List<SkuImagesDTO> skuimages,String userName,int pid,Map<Integer,Integer> mcolor) throws Exception;
	
	/**
	 * 新增
	 * @param skuimages
	 * @throws Exception
	 */
	public void saveSkuImages(List<SkuImagesDTO> skuimages,String userName,int pid,Map<Integer,Integer> mcolor) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSkuImages(String id) throws Exception;
	
}
