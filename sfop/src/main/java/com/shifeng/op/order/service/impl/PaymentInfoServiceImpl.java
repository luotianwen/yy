package com.shifeng.op.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.PaymentInfo;
import com.shifeng.op.order.service.PaymentInfoService;
import com.shifeng.plugin.page.Page;

/** 
 * 支付表(o_paymentInfo)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
@Service("paymentInfoServiceImpl")
public class PaymentInfoServiceImpl implements PaymentInfoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PaymentInfo> findAllPaymentInfo(Page page) throws Exception{
		return (List<PaymentInfo>) dao.findForList("paymentInfoMapper.findAllPaymentInfoPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public PaymentInfo findPaymentInfoById(String id) throws Exception{
		return (PaymentInfo) dao.findForObject("paymentInfoMapper.findPaymentInfoById", id);
	}
	
	/**
	 * 新增
	 * @param paymentInfo
	 * @throws Exception
	 */
	public void savePaymentInfo(PaymentInfo paymentInfo) throws Exception{
		dao.save("paymentInfoMapper.savePaymentInfo", paymentInfo);
	}
	
	/**
	 * 修改
	 * @param paymentInfo
	 * @throws Exception
	 */
	public void updatePaymentInfo(PaymentInfo paymentInfo) throws Exception{
		dao.update("paymentInfoMapper.updatePaymentInfo", paymentInfo);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePaymentInfo(String id) throws Exception{
		dao.delete("paymentInfoMapper.deletePaymentInfo", id);
	}
	
}
