package com.shifeng.op.brand.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.brand.Brand;
import com.shifeng.op.brand.service.BrandService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌接口实现类
 * @author sen
 *
 */
@Service("brandServiceImpl")
public class BrandServiceImpl implements BrandService{
	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Brand> findAllBrand(Page page) throws Exception{
		return (List<Brand>) dao.findForList("brandMapper.findAllBrandPage", page);
	}
	
	/**
	 * 查询所有品牌
	 * @return
	 * @throws Exception
	 */
	public List<Brand> findAllBrandFroOudit() throws Exception{
		return (List<Brand>) dao.findForList("brandMapper.findAllBrandFroOudit");
	}
	
	/**
	 * 根据ID查询品牌
	 */
	public Brand findBrandById(String id) throws Exception{
		return (Brand) dao.findForObject("brandMapper.findBrandById", id);
	}
	
	/**
	 * 新增品牌
	 * @throws Exception
	 */
	public void saveBrand(Brand brand) throws Exception{
		dao.save("brandMapper.saveBrand", brand);
	}

	@Override
	public void updateBrandOpen(Brand brand) throws Exception {
		RedisTool.set(String.format(Const.BAND_CACHE_FLAG,brand.getId()),"0");
		dao.update("brandMapper.updateBrandOpen", brand);
	}

	@Override
	public List<Brand> findAllBrandByState() throws Exception {
		return (List<Brand>) dao.findForList("brandMapper.findAllBrandByState");
	}

	@Override
	public List<Brand> findAllShopBrand(Page page) throws Exception {
		return (List<Brand>) dao.findForList("brandMapper.findAllShopBrand",page);
	}

	/**
	 * 修改品牌
	 * @param brand
	 * @throws Exception
	 */
	public void updateBrand(Brand brand) throws Exception{
		RedisTool.set(String.format(Const.BAND_CACHE_FLAG,brand.getId()),"0");
		dao.update("brandMapper.updateBrand", brand);
	}
	
}
