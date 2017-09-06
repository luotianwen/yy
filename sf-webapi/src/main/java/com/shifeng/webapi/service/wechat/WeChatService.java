package com.shifeng.webapi.service.wechat;

import java.util.Map;

public interface WeChatService {
	

	/**
	 * 微信分享签名
	 * @param url 分享的链接地址
	 * @return
	 */
	Map<String,String> getShareSignature(String url);

}
