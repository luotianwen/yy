package com.shifeng.op.coupon.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.coupon.Coupons;
import com.shifeng.op.coupon.service.CouponsService;
import com.shifeng.plugin.page.Page;

/** 
 * 优惠券(c_coupons)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 16:59:02 
 */  
@Service("couponsServiceImpl")
public class CouponsServiceImpl implements CouponsService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Coupons> findAllCoupons(Page page) throws Exception{
		return (List<Coupons>) dao.findForList("couponsMapper.findAllCouponsPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Coupons findCouponsById(String id) throws Exception{
		return (Coupons) dao.findForObject("couponsMapper.findCouponsById", id);
	}
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveCoupons(Coupons coupons,String range) throws Exception{
		dao.save("couponsMapper.saveCoupons", coupons);
		saveRange(coupons, range);
	}
	
	/**
	 * 修改
	 * @param coupons
	 * @throws Exception
	 */
	public void updateCoupons(Coupons coupons,String range) throws Exception{
		dao.update("couponsMapper.updateCoupons", coupons);
		saveRange(coupons, range);
	}
	
	public void saveRange(Coupons coupons,String range) throws Exception{
		if(!StringUtils.isEmpty(range)){
			dao.delete("couponsrangeMapper.deleteCouponsRangeByCid", coupons.getId());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("coupons_id", coupons.getId());
			map.put("type", coupons.getScope());
			map.put("number", range.split(","));
			dao.save("couponsrangeMapper.saveCouponsRange", map);
		}
	}
	
	/**
	 * 发放/暂停发放优惠券
	 * @param map
	 * @throws Exception
	 */
	public void updateCouponsState(Map<String,Object> map) throws Exception{
		dao.update("couponsMapper.updateCouponsState", map);
	}
	
	/**
	 * 优惠券套餐查询所有优惠券
	 * @return
	 * @throws Exception
	 */
	public List<Coupons> findAllCouponsByPackage() throws Exception{
		return (List<Coupons>) dao.findForList("couponsMapper.findAllCouponsByPackage");
	}
	
}
