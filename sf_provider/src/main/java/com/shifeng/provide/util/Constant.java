package com.shifeng.provide.util;

public class Constant {
	 
	
	/**
	 * 微信key缓存时间
	 */
	public static int WEIXIN_KEY_CACHE_TIME = 60*118;
	
	/**
	 * 微信签名算法
	 */
	public static String WEIXIN_SIGN_ALGORITHMm = "SHA-1";  
	 
	
	/**
	 * 微信access_token redis存储key
	 */
	public static String WEIXIN_ACCESS_TOKEN_KEY ="weixin:access_token";
	 
	
	/**
	 * 微信jsapi_ticket redis存储key
	 */
	public static String WEIXIN_JSAPI_TICKET_KEY ="weixin:jsapi_ticket";

 
	
	/**
	 * 快递跟踪存储key
	 * express_trace:%s:%s   快递code  快递单号
	 */
	public static String EXPRESS_TRACE_KEY ="express_trace:%s:%s";
	 
}
