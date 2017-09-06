package com.shifeng.seller.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.seller.shop.dto.ShopCategoryDTO;
import com.shifeng.seller.shop.service.ShopCategoryService;

/** 
 * 店铺经营类目(s_shop_category)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
@Service("shopcategoryServiceImpl")
public class ShopCategoryServiceImpl implements ShopCategoryService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据店铺ID查询
	 * @param id 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findShopCategoryByMid(String id) throws Exception{
		return (List<ShopCategoryDTO>) dao.findForList("shopcategoryMapper.findShopCategoryByMid", id);
	}
	
	/**
	 * 查询店铺类目
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findAllParentCategoryByShopId(String shopId) throws Exception{
		return (List<ShopCategoryDTO>) dao.findForList("shopcategoryMapper.findAllParentCategoryByShopId", shopId);
	}
	
	
	/**
	 * 根据父ID查询
	 * @param id 父ID
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findShopCategoryByPid(String id,String shopId) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("shopId",shopId);
		return (List<ShopCategoryDTO>) dao.findForList("shopcategoryMapper.findShopCategoryByPid", map);
	}
	
	
}
