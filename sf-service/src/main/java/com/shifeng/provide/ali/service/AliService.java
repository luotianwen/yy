package com.shifeng.provide.ali.service;

import com.shifeng.response.ReqResponse;

/**
 * 阿里服务
 * @author WinZhong
 *
 */
public interface AliService {
	
	/**
	 * 发送手机短信通知
	 * @param phone  短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。群发短信需传入多个号码，以英文逗号分隔，一次调用最多传入200个号码。示例：18600000000,13911111111,13322222222
	 * @param smsParam 	短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，传参时需传入{"code":"1234","product":"alidayu"}
	 * @param templateCode 短信模板ID，传入的模板必须是在阿里大于“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
	 * @return  发送状态码 （0：失败、1：成功）
	 */
	ReqResponse<Integer> sendSMS(String phone,String smsParam,String templateCode);

}
