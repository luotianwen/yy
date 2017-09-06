package com.shifeng.seller.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShopCategorySpec;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.shop.service.ShopCategorySpecService;

/** 
 * 店铺分类规格属性(p_shop_category_spec)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-28 13:20:44 
 */  
@Service("shopcategoryspecServiceImpl")
public class ShopCategorySpecServiceImpl implements ShopCategorySpecService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	
	/**
	 * 查询所有
	 * @param page
	 * @param id 分类ID
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategorySpec> findAllShopCategorySpecPage(Page page,String cid,String shopId) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("cid", cid);
		map.put("shopId", shopId);
		page.setT(map);
		return (List<ShopCategorySpec>) dao.findForList("shopcategoryspecMapper.findAllShopCategorySpecPage", page);
	}
	
	/**
	 * 查询所有
	 * @param id 分类ID
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategorySpec> findAllShopCategorySpec(String cid,String shopId) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("cid", cid);
		map.put("shopId", shopId);
		return (List<ShopCategorySpec>) dao.findForList("shopcategoryspecMapper.findAllShopCategorySpec", map);
	}
	
	/**
	 * 根据ID查询
	 */
	public ShopCategorySpec findShopCategorySpecById(String id) throws Exception{
		return (ShopCategorySpec) dao.findForObject("shopcategoryspecMapper.findShopCategorySpecById", id);
	}
	
	/**
	 * 新增
	 * @param shopcategoryspec
	 * @throws Exception
	 */
	public void saveShopCategorySpec(ShopCategorySpec shopcategoryspec,Map<String,Object> map) throws Exception{
		dao.save("shopcategoryspecMapper.saveShopCategorySpec", shopcategoryspec);
		
		map.put("id", shopcategoryspec.getId());
		map.put("name", shopcategoryspec.getName());
	}
	
	/**
	 * 修改
	 * @param shopcategoryspec
	 * @throws Exception
	 */
	public void updateShopCategorySpec(ShopCategorySpec shopcategoryspec) throws Exception{
		dao.update("shopcategoryspecMapper.updateShopCategorySpec", shopcategoryspec);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopCategorySpec(String id) throws Exception{
		dao.delete("shopcategoryspecMapper.deleteShopCategorySpec", id);
	}
	
}
