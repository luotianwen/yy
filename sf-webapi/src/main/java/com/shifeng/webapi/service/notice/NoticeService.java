package com.shifeng.webapi.service.notice;

import com.shifeng.response.ReqResponse;

public interface NoticeService {
	
	/**
	 * 发送短信验证码
	 * @param phone 手机号
	 * @param code	验证码
	 * @param business	业务名称
	 * @return	返回发送结果
	 */
	boolean sendMobileCode(String phone,int code,String business,ReqResponse<?> req);

}
