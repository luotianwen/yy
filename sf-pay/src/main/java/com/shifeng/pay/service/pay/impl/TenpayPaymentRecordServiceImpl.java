package com.shifeng.pay.service.pay.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.pay.entity.pay.TenpayPaymentRecord;
import com.shifeng.pay.service.pay.TenpayPaymentRecordService;
import com.shifeng.util.IdWorker; 

/** 
 * 财付通支付流水信息(tenpay_payment_record)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-08 13:42:17 
 */  
@Service("tenpayPaymentRecordServiceImpl")
public class TenpayPaymentRecordServiceImpl implements TenpayPaymentRecordService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 保存支付流水信息
	 * @param paymentRecord
	 */
    public void savePaymentRecord(TenpayPaymentRecord paymentRecord) {
    	try {
    		//paymentRecord.setSerial_number(IdWorker.getSerialNumber());
			dao.save("tenpayPaymentRecordMapper.savePaymentRecord", paymentRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
