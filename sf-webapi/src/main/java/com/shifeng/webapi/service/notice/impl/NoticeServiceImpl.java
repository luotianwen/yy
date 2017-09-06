package com.shifeng.webapi.service.notice.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.common.SmsTemplateCode;
import com.shifeng.provide.ali.service.AliService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.service.notice.NoticeService;

@Service("noticeServiceImpl")
public class NoticeServiceImpl implements NoticeService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "aliService")
	protected AliService aliService;
	
	
	/**
	 * 发送短信验证码
	 * @param phone 手机号
	 * @param code	验证码
	 * @param business	业务名称
	 * @return	返回发送结果
	 */
	public boolean sendMobileCode(String phone,int code,String business,ReqResponse<?> req) {
		String m_key = String.format(Constant.NOTICE_MOBILECODE_MINUTE_COUNT_KEY, phone);
		//获取手机号一分钟内是否发送过短信
		String m_val = RedisTool.get(m_key);
		if(m_val == null){//没有发送
			String d_key = String.format(Constant.NOTICE_MOBILECODE_DAY_COUNT_KEY, phone);
			//获取手机号每天短信发送次数
			String d_val = RedisTool.get(d_key);
			int count =0;
			try {
				count = Integer.valueOf(d_val);
			} catch (NumberFormatException e) {
			}
			if(count >= Constant.DAY_MAX_SEND_MOBILECODE_COUNT){
				req.setCode(103);
				req.setMsg("短信发送失败");
			}else{
				try {
					logger.info("手机号："+phone+"\t验证码："+code+"\t业务："+business);
					ReqResponse<Integer> result = aliService.sendSMS(phone, "{\"code\":\""+code+"\",\"type\":\""+business+"\"}",SmsTemplateCode.operation_authcode);
					RedisTool.set(m_key, "1");
					RedisTool.expire(m_key, 60);
					if(result.getCode() == 0){//短信发送成功
						//短信发送成功
						RedisTool.incrBy(d_key, 1);
						//计算当天到24点还剩下多少秒
						Long s = DateUtil.currentDayResidueTime()/1000;
						//设置过期时间 单位：秒
						RedisTool.expire(d_key, s.intValue());
						return true;
					}else{
						req.setCode(103);
						req.setMsg("短信发送失败");
					}
				} catch (Exception e) {
					logger.error("【发送短信验证码】出错：", e);
				}
			}
		}else{
			req.setCode(103);
			req.setMsg("一分钟内只能获取一次短信验证码");
		}
		
		return false;
	}
	
	

}
