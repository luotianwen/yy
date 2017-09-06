package com.shifeng.op.coupon.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.coupon.Coupons;
import com.shifeng.plugin.page.Page;

/** 
 * 优惠券(c_coupons)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 16:59:02 
 */  
public interface CouponsService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Coupons> findAllCoupons(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Coupons findCouponsById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param coupons
	 * @throws Exception
	 */
	public void updateCoupons(Coupons coupons,String range) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveCoupons(Coupons coupons,String range) throws Exception;
    
	/**
	 * 发放/暂停发放优惠券
	 * @param map
	 * @throws Exception
	 */
	public void updateCouponsState(Map<String,Object> map) throws Exception;
	
	/**
	 * 优惠券套餐查询所有优惠券
	 * @return
	 * @throws Exception
	 */
	public List<Coupons> findAllCouponsByPackage() throws Exception;
	
	
}
