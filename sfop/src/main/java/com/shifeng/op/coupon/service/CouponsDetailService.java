package com.shifeng.op.coupon.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.coupon.CouponsDetail;
import com.shifeng.plugin.page.Page;

/** 
 * 优惠券明细表(c_couponsDetail)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:55 
 */  
public interface CouponsDetailService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CouponsDetail> findAllCouponsDetail(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public CouponsDetail findCouponsDetailById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param couponsDetail
	 * @throws Exception
	 */
	public void updateCouponsDetail(CouponsDetail couponsDetail) throws Exception;
	
	/**
	 * 新增
	 * @param couponsDetail
	 * @throws Exception
	 */
	public void saveCouponsDetail(String id,String number,Map<String,Object> map) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteCouponsDetail(String id) throws Exception;
	
}
