package com.shifeng.provide.coupon.service;

import com.shifeng.entity.coupon.Coupons;

import java.util.List;

/**
 * Created by yongshi on 2017/4/18.
 */
public interface CouponService {
    /**
     * 查询有效优惠券
     * @param sku
     * @param shopid
     * @param categoryid
     * @return
     * @throws Exception
     */
    public List<Coupons> getALLCoupons(String sku, String shopid, String categoryid)throws Exception;
}
