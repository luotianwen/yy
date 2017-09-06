package com.shifeng.op.coupon.service;

import java.util.List;
import com.shifeng.entity.coupon.CouponPackage;
import com.shifeng.plugin.page.Page;

/** 
 * 优惠券套餐(c_couponPackage)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:54 
 */  
public interface CouponPackageService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CouponPackage> findAllCouponPackage(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public CouponPackage findCouponPackageById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param couponPackage
	 * @throws Exception
	 */
	public void updateCouponPackage(CouponPackage couponPackage) throws Exception;
	
	/**
	 * 新增
	 * @param couponPackage
	 * @throws Exception
	 */
	public void saveCouponPackage(CouponPackage couponPackage) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteCouponPackage(String id) throws Exception;
	
}
