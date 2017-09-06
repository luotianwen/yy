package com.shifeng.webapi.service.mall.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.entity.coupon.Coupons;
import com.shifeng.provide.coupon.service.CouponService;
import com.shifeng.webapi.service.mall.CouponsService;

/**
 * 
 * @author WinZhong
 *
 */
@Service("couponsServiceImpl")
public class CouponsServiceImpl implements CouponsService {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "couponService")
	protected CouponService couponService;
    /**
     * 查询有效优惠券
     * @param sku
     * @param shopid
     * @param categoryid
     * @return
     * @throws Exception
     */
    public List<Coupons> getALLCoupons(String sku, String shopid, String categoryid) {
		try {
			return couponService.getALLCoupons(sku, shopid, categoryid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
