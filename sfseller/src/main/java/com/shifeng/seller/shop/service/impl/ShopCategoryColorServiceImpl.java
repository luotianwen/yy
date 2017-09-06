package com.shifeng.seller.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShopCategoryColor;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.shop.service.ShopCategoryColorService;

/** 
 * 店铺分类颜色属性(p_shop_category_color)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-28 13:20:44 
 */  
@Service("shopcategorycolorServiceImpl")
public class ShopCategoryColorServiceImpl implements ShopCategoryColorService{

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
	public List<ShopCategoryColor> findAllShopCategoryColorPage(Page page ,String cid,String shopId) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("cid", cid);
		map.put("shopId", shopId);
		page.setT(map);
		return (List<ShopCategoryColor>) dao.findForList("shopcategorycolorMapper.findAllShopCategoryColorPage", page);
	}
	
	/**
	 * 查询所有
	 * @param id 分类ID
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryColor> findAllShopCategoryColor(String cid,String shopId) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("cid", cid);
		map.put("shopId", shopId);
		return (List<ShopCategoryColor>) dao.findForList("shopcategorycolorMapper.findAllShopCategoryColor", map);
	}
	
	/**
	 * 根据ID查询
	 */
	public ShopCategoryColor findShopCategoryColorById(String id) throws Exception{
		return (ShopCategoryColor) dao.findForObject("shopcategorycolorMapper.findShopCategoryColorById", id);
	}
	
	/**
	 * 新增
	 * @param shopcategorycolor
	 * @throws Exception
	 */
	public void saveShopCategoryColor(ShopCategoryColor shopcategorycolor,Map<String,Object> map) throws Exception{
		dao.save("shopcategorycolorMapper.saveShopCategoryColor", shopcategorycolor);
		
		map.put("id", shopcategorycolor.getId());
		map.put("name", shopcategorycolor.getName());
	}
	
	/**
	 * 修改
	 * @param shopcategorycolor
	 * @throws Exception
	 */
	public void updateShopCategoryColor(ShopCategoryColor shopcategorycolor) throws Exception{
		dao.update("shopcategorycolorMapper.updateShopCategoryColor", shopcategorycolor);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopCategoryColor(String id) throws Exception{
		dao.delete("shopcategorycolorMapper.deleteShopCategoryColor", id);
	}
	
}
