package com.shifeng.op.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.shop.ShopBrand;
import com.shifeng.op.dto.shop.AuditBrandDTO;
import com.shifeng.op.dto.shop.ShopBrandDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.shop.service.ShopBrandService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;

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
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopBrand> findAllShopBrand(Page page) throws Exception{
		return (List<ShopBrand>) dao.findForList("shopbrandMapper.findAllShopBrand", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public AuditBrandDTO findShopBrandById(String id) throws Exception{
		return (AuditBrandDTO) dao.findForObject("shopbrandMapper.findShopBrandById", id);
	}
	
	/**
	 * 新增
	 * @param shopbrand
	 * @throws Exception
	 */
	public void saveShopBrand(ShopBrand shopbrand) throws Exception{
		dao.save("shopbrandMapper.saveShopBrand", shopbrand);
	}
	
	/**
	 * 修改
	 * @param shopbrand
	 * @throws Exception
	 */
	public void updateShopBrand(ShopBrand shopbrand) throws Exception{
		dao.update("shopbrandMapper.updateShopBrand", shopbrand);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopBrand(String id) throws Exception{
		dao.delete("shopbrandMapper.deleteShopBrand", id);
	}

	@Override
	public List<ShopBrandDTO> findAllShopBrandByShop(Page page) throws Exception {
		return (List<ShopBrandDTO>) dao.findForList("shopbrandMapper.findAllShopBrandByShopPage", page);
	}

	@Override
	public void saveALLShopBrand(int s_merchants_id, int[] b_brand_id, Users user) throws Exception {
     this.deleteShopBrand(s_merchants_id+"");
		 Map map=new HashMap<>();
		map.put("s_merchants_id",s_merchants_id);
		map.put("b_brand_id",b_brand_id);
	  dao.save("shopbrandMapper.addShopBrandBatch", map);
	}

	/**
     * 查询所有审核品牌
     * @param page
     * @return
     * @throws Exception
     */
	public List<AuditBrandDTO> findAuditBrand(Page page)throws Exception{
		return (List<AuditBrandDTO>) dao.findForList("shopbrandMapper.findAuditBrandPage", page);
	}
	
	/**
     * 品牌审核
     * @param shopbrand
     * @throws Exception
     */
	public void updateAuditShopBrand(ShopBrand shopbrand) throws Exception{
		dao.update("shopbrandMapper.updateAuditShopBrand", shopbrand);
	}
	
}
