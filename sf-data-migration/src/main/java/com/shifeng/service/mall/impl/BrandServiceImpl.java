package com.shifeng.service.mall.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.Brand;
import com.shifeng.service.mall.BrandService;

@Service("brandService")
public class BrandServiceImpl implements BrandService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 保存品牌
	 * @param brandList
	 */
	public void saveBrands(List<Brand> brandList) {
		try {
			dao.save("brandMapper.saveBrand", brandList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
