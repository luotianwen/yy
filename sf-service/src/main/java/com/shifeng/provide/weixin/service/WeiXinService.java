package com.shifeng.provide.weixin.service;

import java.util.Map;

import com.shifeng.dto.login.JointLoginDTO;
import com.shifeng.response.ReqResponse;

public interface WeiXinService {
	
	/**
	 * 微信用户登录
	 * @param appid	公众号的唯一标识
	 * @param secret	公众号的唯一凭证密钥，即appsecret
	 * @param code 用户的code
	 * @return
	 */
	ReqResponse<JointLoginDTO> login(String appid,String secret,String code);
	
	/**
	 * 微信分享签名
	 * @param appid	公众号的唯一标识
	 * @param secret	公众号的唯一凭证密钥，即appsecret
	 * @param url 分享的链接地址
	 * @return
	 */
	ReqResponse<Map<String,String>> getShareSignature(String appid,String secret,String url);

}
