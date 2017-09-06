package com.shifeng.provide.coupon.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.coupon.Coupons;
import com.shifeng.provide.coupon.service.CouponService;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongshi on 2017/4/18.
 */
@Service(timeout=1200000)
public class CouponServiceImpl implements CouponService {
    @Resource(name = "baseDaoImpl")
    private BaseDao dao;
    @Override
    public List<Coupons> getALLCoupons(String sku, String shopid, String categoryid) throws Exception {
        if(StringUtils.isEmpty(sku)&&StringUtils.isEmpty(shopid)&&StringUtils.isEmpty(categoryid))
            return null;
        Map map=new HashMap<>();
        map.put("sku",sku);
        map.put("shopid",shopid);
        map.put("categoryid",categoryid);
        return (List<Coupons>) dao.findForList("couponsMapper.findAllCoupons",map);
    }
}
