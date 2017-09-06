package com.shifeng.op.brand.service;

import java.util.List;

import com.shifeng.entity.brand.Brand;
import com.shifeng.plugin.page.Page;

/**
 * 品牌接口
 * @author sen
 *
 */
public interface BrandService {
	/**
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Brand> findAllBrand(Page page) throws Exception;
	
	/**
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Brand> findAllBrandFroOudit() throws Exception;
	
	/**
	 * 根据ID查询品牌
	 */
	public Brand findBrandById(String id) throws Exception;
	
	/**
	 * 修改品牌
	 * @param brand
	 * @throws Exception
	 */
	public void updateBrand(Brand brand) throws Exception;
	
	/**
	 * 新增品牌
	 * @param brand
	 * @throws Exception
	 */
	public void saveBrand(Brand brand) throws Exception;

	public void updateBrandOpen(Brand brand)throws Exception;

	/**
	 * 查询可用所有品牌
	 * @return
	 * @throws Exception
	 */
	public List<Brand> findAllBrandByState() throws Exception;

	public List findAllShopBrand(Page page)throws Exception;
}
