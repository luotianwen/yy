package com.shifeng.op.order.service;

import java.util.List;
import com.shifeng.entity.order.PaymentInfo;
import com.shifeng.plugin.page.Page;

/** 
 * 支付表(o_paymentInfo)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
public interface PaymentInfoService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PaymentInfo> findAllPaymentInfo(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public PaymentInfo findPaymentInfoById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param paymentInfo
	 * @throws Exception
	 */
	public void updatePaymentInfo(PaymentInfo paymentInfo) throws Exception;
	
	/**
	 * 新增
	 * @param paymentInfo
	 * @throws Exception
	 */
	public void savePaymentInfo(PaymentInfo paymentInfo) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePaymentInfo(String id) throws Exception;
	
}
