package com.shifeng.service.mall;

import java.util.List;

import com.shifeng.entity.mall.Brand;

public interface BrandService {
	
	/**
	 * 保存品牌
	 * @param brandList
	 */
	void saveBrands(List<Brand> brandList);

}
