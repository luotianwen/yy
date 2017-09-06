package com.shifeng.webapi.service.mall;

import com.shifeng.entity.coupon.Coupons;

import java.util.List;

/**
 * 
 * @author WinZhong
 *
 */
public interface CouponsService {
    /**
     * 查询有效优惠券
     * @param sku
     * @param shopid
     * @param categoryid
     * @return
     * @throws Exception
     */
    List<Coupons> getALLCoupons(String sku, String shopid, String categoryid);
}
