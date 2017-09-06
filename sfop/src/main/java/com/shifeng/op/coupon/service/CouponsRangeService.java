package com.shifeng.op.coupon.service;

import java.util.List;

import com.shifeng.entity.coupon.CouponsRange;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.dto.category.CategoryDTO;
import com.shifeng.plugin.page.Page;

/** 
 * 优惠券使用范围(c_coupons_range)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:55 
 */  
public interface CouponsRangeService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Object findAllCouponsRange(String id,String scope) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public CouponsRange findCouponsRangeById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param couponsrange
	 * @throws Exception
	 */
	public void updateCouponsRange(CouponsRange couponsrange) throws Exception;
	
	/**
	 * 新增
	 * @param couponsrange
	 * @throws Exception
	 */
	public void saveCouponsRange(CouponsRange couponsrange) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteCouponsRange(String id) throws Exception;
	
	/**
	 * 优惠券使用范围(指定参加/不参加店铺)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Shopinfo> findShopForCoupons(Page page) throws Exception;
	
	/**
	 * 优惠券使用范围(指定参加/不参加分类)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<CategoryDTO> findAllCategoryForCoupons(String id) throws Exception;
	
}
