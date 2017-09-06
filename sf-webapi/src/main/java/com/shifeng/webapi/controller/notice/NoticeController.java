package com.shifeng.webapi.controller.notice;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Objects;
import com.shifeng.provide.ali.service.AliService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.MD5Util;
import com.shifeng.util.Tools;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;


@Controller
@RequestMapping(value = "/notice")
public class NoticeController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "aliService")
	protected AliService aliService;
	
	
	//https://reg.jd.com/notifyuser/mobileCode?state=&mobile=%2B008617701058520&_=1488269400287
	/**
	 * 发送短信通知
	 * @param version	版本号
	 * @param ticket	
	 * @param phone	手机号
	 * @param sign	md5(version+ ticket + phone)
	 * @return
	 */
	@RequestMapping(value = "/mobileCode")
	@ResponseBody
	public ReqResponse<String> mobileCode(String version,String ticket,String phone,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}
		try {
			//是否能继续获取访问
			if(!this.isGoOnVisit(ticket, "mobileCode", req)){
				return req;
			}
			//验证版本号
			switch (version) {
			case ApiVersion.V_1_0_0:
					//验证签名
					if(Objects.equal(sign, MD5Util.hex(version+ ticket + phone))){
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
								req.setCode(0);
							}else{
								int code= Tools.getRandomNum();
								ReqResponse<Integer> result = aliService.sendSMS(phone, "{\"code\":\""+code+"\",\"product\":\"手机号\"}","SMS_16340212");
								if(result.getCode() == 0){//短信发送成功
									RedisTool.incrBy(d_key, 1);
									//计算当天到24点还剩下多少秒
									Long s = DateUtil.currentDayResidueTime()/1000;
									//设置过期时间 单位：秒
									RedisTool.expire(d_key, s.intValue());
									String mobilecode_key = String.format(Constant.MOBILECODE_KEY, phone);
									RedisTool.set(mobilecode_key, code+"");
									//验证码十分钟内有效
									RedisTool.expire(mobilecode_key, Constant.AUTHCODE_VALID_TIME);
									req.setCode(0);
								}else{
									req.setCode(103);
									req.setMsg("短信发送失败");
								}
								RedisTool.set(m_key, "1");
								RedisTool.expire(m_key, 60);
							}
						}else{
							req.setCode(0);
						}
					}else{
						req.setCode(ErrorMsg.INVALID_SIGN.getCode());
						req.setMsg(ErrorMsg.INVALID_SIGN.getMsg());
					}
				break;
			default:
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
			}
				
			
		} catch (Exception e) {
			logger.info("发送短信通知出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}
		return req;
	}
	
}
