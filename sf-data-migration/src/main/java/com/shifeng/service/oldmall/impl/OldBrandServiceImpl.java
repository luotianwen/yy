package com.shifeng.service.oldmall.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.SQLServerDao;
import com.shifeng.entity.mall.Brand;
import com.shifeng.service.oldmall.OldBrandService;
@Service("oldBrandService")
public class OldBrandServiceImpl implements OldBrandService{

	@Resource(name = "SQLServerDaoImpl")
	private SQLServerDao dao;
	
	/**
	 * 获取品牌列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getBrands() {
		try {
			return (List<Brand>)dao.findForList("oldBrandMapper.getBrands");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
