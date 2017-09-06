package com.shifeng.seller.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.shop.ShopBrand;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.dto.ShopBrandDTO;
import com.shifeng.seller.shop.service.ShopBrandService;

/** 
 * 品牌信息(s_shop_brand)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
@Service("shopbrandServiceImpl")
public class ShopBrandServiceImpl implements ShopBrandService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询店铺品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopBrandDTO> findMyShopBrand(Page page) throws Exception{
		return (List<ShopBrandDTO>) dao.findForList("shopbrandMapper.findMyShopBrandPage", page);
	}
	
	/**
	 * 搜索品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Brand> searchBrand(Page page) throws Exception{
		return (List<Brand>) dao.findForList("brandMapper.searchBrandPage", page);
	}

	/**
	 * 根据ID查询品牌
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Brand findBrandById(String id) throws Exception{
		return (Brand) dao.findForObject("brandMapper.findBrandById", id);
	}
	
	/**
	 * 申请新品牌
	 * @param shopBrand
	 * @throws Exception
	 */
	public void saveApplyBrand(ShopBrand shopBrand,Integer shopId) throws Exception{
		shopBrand.setS_merchants_id(shopId);
		dao.save("shopbrandMapper.saveApplyBrand", shopBrand);
	}
	
	/**
	 * 查询店铺可用品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopBrand> findShopBrand(String shopId) throws Exception{
		return (List<ShopBrand>) dao.findForList("shopbrandMapper.findShopBrand", shopId);
	}
	
	/**
	 * 根据ID查看店铺品牌
	 * @param id 品牌ID
	 * @param user 用户信息
	 * @return
	 * @throws Exception
	 */
	public ShopBrandDTO findShopBrandById(String id,Users user) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("shopid", user.getShopid());
		
		return (ShopBrandDTO) dao.findForObject("shopbrandMapper.findShopBrandById", map);
	}
	
	
}
