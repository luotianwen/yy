package com.shifeng.op.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShopEvaluate;
import com.shifeng.op.shop.service.ShopEvaluateService;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺评价(p_shop_evaluate)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 15:37:29 
 */  
@Service("shopevaluateServiceImpl")
public class ShopEvaluateServiceImpl implements ShopEvaluateService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopEvaluate> findAllShopEvaluate(Page page) throws Exception{
		return (List<ShopEvaluate>) dao.findForList("shopevaluateMapper.findAllShopEvaluatePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ShopEvaluate findShopEvaluateById(String id) throws Exception{
		return (ShopEvaluate) dao.findForObject("shopevaluateMapper.findShopEvaluateById", id);
	}
	
	/**
	 * 新增
	 * @param shopevaluate
	 * @throws Exception
	 */
	public void saveShopEvaluate(ShopEvaluate shopevaluate) throws Exception{
		dao.save("shopevaluateMapper.saveShopEvaluate", shopevaluate);
	}
	
	/**
	 * 修改
	 * @param shopevaluate
	 * @throws Exception
	 */
	public void updateShopEvaluate(ShopEvaluate shopevaluate) throws Exception{
		dao.update("shopevaluateMapper.updateShopEvaluate", shopevaluate);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopEvaluate(String id) throws Exception{
		dao.delete("shopevaluateMapper.deleteShopEvaluate", id);
	}
	
}
