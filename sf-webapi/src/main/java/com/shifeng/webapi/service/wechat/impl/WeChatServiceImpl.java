package com.shifeng.webapi.service.wechat.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shifeng.provide.weixin.service.WeiXinService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.wechat.WeChatService;

@Service("weChatServiceImpl")
public class WeChatServiceImpl implements WeChatService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Value("#{properties['weixin.appid']}")
	private String appid;
	@Value("#{properties['weixin.secret']}")
	private String secret;
	
	@Resource(name = "weiXinService")
	protected WeiXinService weiXinService;
	

	/**
	 * 微信分享签名
	 * @param url 分享的链接地址
	 * @return
	 */
	public Map<String,String> getShareSignature(String url) {
		try {
			ReqResponse<Map<String,String>> result = weiXinService.getShareSignature(appid, secret, url);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【微信分享签名】出错：", e);
		}
		return null;
	}
	
	

}
