package com.shifeng.op.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShopCategory;
import com.shifeng.op.shop.service.ShopCategoryService;
import com.shifeng.plugin.page.Page;

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
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategory> findAllShopCategory(Page page) throws Exception{
		return (List<ShopCategory>) dao.findForList("shopcategoryMapper.findAllShopCategory", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ShopCategory findShopCategoryById(String id) throws Exception{
		return (ShopCategory) dao.findForObject("shopcategoryMapper.findShopCategoryById", id);
	}
	
	/**
	 * 新增
	 * @param shopcategory
	 * @throws Exception
	 */
	public void saveShopCategory(ShopCategory shopcategory) throws Exception{
		dao.save("shopcategoryMapper.saveShopCategory", shopcategory);
	}
	
	/**
	 * 修改
	 * @param shopcategory
	 * @throws Exception
	 */
	public void updateShopCategory(ShopCategory shopcategory) throws Exception{
		dao.update("shopcategoryMapper.updateShopCategory", shopcategory);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopCategory(String id) throws Exception{
		dao.delete("shopcategoryMapper.deleteShopCategory", id);
	}
	
}
