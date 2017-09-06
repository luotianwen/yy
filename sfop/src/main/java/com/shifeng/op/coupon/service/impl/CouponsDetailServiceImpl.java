package com.shifeng.op.coupon.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.coupon.Coupons;
import com.shifeng.entity.coupon.CouponsDetail;
import com.shifeng.op.coupon.service.CouponsDetailService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.util.GenerateCode;

/** 
 * 优惠券明细表(c_couponsDetail)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:55 
 */  
@Service("couponsDetailServiceImpl")
public class CouponsDetailServiceImpl implements CouponsDetailService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CouponsDetail> findAllCouponsDetail(Page page) throws Exception{
		return (List<CouponsDetail>) dao.findForList("couponsDetailMapper.findAllCouponsDetailPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public CouponsDetail findCouponsDetailById(String id) throws Exception{
		return (CouponsDetail) dao.findForObject("couponsDetailMapper.findCouponsDetailById", id);
	}
	
	/**
	 * 新增
	 * @param couponsDetail
	 * @throws Exception
	 */
	public void saveCouponsDetail(String id,String number,Map<String,Object> map) throws Exception{
		Coupons coupons = (Coupons) dao.findForObject("couponsMapper.findCouponsById", id);
		int count = Integer.valueOf(number);
		if(coupons.getSurplusNumber()>=count){
			String[] passwords = new String[count];
			
			for(int i=0;i<count;i++){
				passwords[i] = GenerateCode.genCodes(8);
			}
			map.put("coupons", coupons);
			map.put("passwords", passwords);
			dao.save("couponsDetailMapper.saveCouponsDetail", map);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "优惠券数量不足，仅余"+coupons.getSurplusNumber()+"张可用！");
		}
	}
	
	/**
	 * 修改
	 * @param couponsDetail
	 * @throws Exception
	 */
	public void updateCouponsDetail(CouponsDetail couponsDetail) throws Exception{
		dao.update("couponsDetailMapper.updateCouponsDetail", couponsDetail);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteCouponsDetail(String id) throws Exception{
		dao.delete("couponsDetailMapper.deleteCouponsDetail", id);
	}
	
}
