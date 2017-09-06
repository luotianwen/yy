package com.shifeng.pay.service.pay.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.pay.entity.pay.AlipayPaymentRecord;
import com.shifeng.pay.service.pay.AlipayPaymentRecordService;
import com.shifeng.util.IdWorker; 

/** 
 * 支付宝支付流水信息(alipay_payment_record)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-08 13:42:17 
 */  
@Service("alipayPaymentRecordServiceImpl")
public class AlipayPaymentRecordServiceImpl implements AlipayPaymentRecordService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 保存支付流水信息
	 * @param paymentRecord
	 */
    public void savePaymentRecord(AlipayPaymentRecord paymentRecord) {
    	try {
    		//paymentRecord.setSerial_number(IdWorker.getSerialNumber());
			dao.save("alipayPaymentRecordMapper.savePaymentRecord", paymentRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
