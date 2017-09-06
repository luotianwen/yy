package com.shifeng.provide.async;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.shifeng.provide.ali.service.AliService;

@Service("smsService")
public class SmsService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "aliServiceImpl")
	private AliService aliService;
	
	@Async("SMSExecutor")
	public void sendSMS(String phone,String smsParam,String templateCode) {
		aliService.sendSMS(phone, smsParam, templateCode);
	}

}
