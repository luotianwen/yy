package com.tenpay.config;

public class TenPayConfig {
	
	/**
	 * 收款方
	 */
	public static String spname = "世峰户外商城";  

	/**
	 * 商户号
	 */
	public static String partner = "1217890901";

	/**
	 * 密钥
	 */
	public static String key = "9528f1166256f69ab7a8ede80a596318";

	/**
	 * 交易完成后跳转的URL
	 */
	public static String return_url = "http://cvaf.cn:7777/sf-pay/tenPay/payResult.html";

	/**
	 * 接收财付通通知的URL
	 */
	public static String notify_url = "http://cvaf.cn:7777/sf-pay/tenPay/checkPay.html";

	public static String getSpname() {
		return spname;
	}

	public static void setSpname(String spname) {
		TenPayConfig.spname = spname;
	}

	public static String getPartner() {
		return partner;
	}

	public static void setPartner(String partner) {
		TenPayConfig.partner = partner;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		TenPayConfig.key = key;
	}

	public static String getReturn_url() {
		return return_url;
	}

	public static void setReturn_url(String return_url) {
		TenPayConfig.return_url = return_url;
	}

	public static String getNotify_url() {
		return notify_url;
	}

	public static void setNotify_url(String notify_url) {
		TenPayConfig.notify_url = notify_url;
	}
	
	
	
	
	
	

}
