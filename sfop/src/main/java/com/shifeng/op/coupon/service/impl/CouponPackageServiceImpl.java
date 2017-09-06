package com.shifeng.op.coupon.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.coupon.CouponPackage;
import com.shifeng.op.coupon.service.CouponPackageService;
import com.shifeng.plugin.page.Page;

/** 
 * 优惠券套餐(c_couponPackage)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:54 
 */  
@Service("couponPackageServiceImpl")
public class CouponPackageServiceImpl implements CouponPackageService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CouponPackage> findAllCouponPackage(Page page) throws Exception{
		return (List<CouponPackage>) dao.findForList("couponPackageMapper.findAllCouponPackagePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public CouponPackage findCouponPackageById(String id) throws Exception{
		return (CouponPackage) dao.findForObject("couponPackageMapper.findCouponPackageById", id);
	}
	
	/**
	 * 新增
	 * @param couponPackage
	 * @throws Exception
	 */
	public void saveCouponPackage(CouponPackage couponPackage) throws Exception{
		dao.save("couponPackageMapper.saveCouponPackage", couponPackage);
	}
	
	/**
	 * 修改
	 * @param couponPackage
	 * @throws Exception
	 */
	public void updateCouponPackage(CouponPackage couponPackage) throws Exception{
		dao.update("couponPackageMapper.updateCouponPackage", couponPackage);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteCouponPackage(String id) throws Exception{
		dao.delete("couponPackageMapper.deleteCouponPackage", id);
	}
	
}
