package com.shifeng.provide.ali.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shifeng.provide.ali.service.AliService;
import com.shifeng.response.ReqResponse;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 
 * @author WinZhong
 *
 */
@Service("aliServiceImpl")
public class AliServiceImpl implements AliService{
	
	protected static Logger logger = Logger.getLogger(AliServiceImpl.class);
	//App Key
	@Value("#{properties['sms.appKey']}")
	String SMSAppKey;
	//App Secret
	@Value("#{properties['sms.appSecret']}")
	String  SMSAppSecret;
	//serverUrl
	@Value("#{properties['sms.serverUrl']}")
	String  SMSServerUrl;
	
	/**
	 * 发送手机短信通知
	 * @param phone  短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。群发短信需传入多个号码，以英文逗号分隔，一次调用最多传入200个号码。示例：18600000000,13911111111,13322222222
	 * @param smsParam 	短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，传参时需传入{"code":"1234","product":"alidayu"}
	 * @param templateCode 短信模板ID，传入的模板必须是在阿里大于“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
	 * @return  发送状态码 （0：失败、1：成功）
	 */
	public ReqResponse<Integer> sendSMS(String phone,String smsParam,String templateCode) {
		ReqResponse<Integer> req = new ReqResponse<Integer>();
		logger.info("参数："+SMSServerUrl+SMSAppKey+SMSAppSecret);
		TaobaoClient client = new DefaultTaobaoClient( SMSServerUrl,  SMSAppKey,  SMSAppSecret);
		AlibabaAliqinFcSmsNumSendRequest smsReq = new AlibabaAliqinFcSmsNumSendRequest();
		//公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
		smsReq.setExtend("7777777");
		//短信类型，传入值请填写normal
		smsReq.setSmsType("normal");
		//短信签名
		smsReq.setSmsFreeSignName("世峰户外商城");
		//短信模板变量
		smsReq.setSmsParamString(smsParam);
		//短信接收号码
		smsReq.setRecNum(phone);
		smsReq.setSmsTemplateCode(templateCode);
		AlibabaAliqinFcSmsNumSendResponse rsp;
		logger.info("短信通知接收手机号："+phone+"\t发送内容："+smsParam);
		try {
			rsp = client.execute(smsReq);
			if(rsp.getErrorCode() == null){
				logger.info(rsp.getBody());
				req.setCode(0);
			}else{
				logger.error("短信通知发送失败："+rsp.getBody());
				req.setCode(1);
				req.setMsg("短信通知发送失败");
			}
		} catch (ApiException e) {
			logger.error("短信通知发送失败：", e);
			req.setCode(1);
			req.setMsg("短信通知发送失败");
		}
		return req;
	}

}
