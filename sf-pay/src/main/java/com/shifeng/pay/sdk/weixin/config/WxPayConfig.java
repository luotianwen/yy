package com.shifeng.pay.sdk.weixin.config;

/**
 * 
 * @author WinZhong
 *
 */
public class WxPayConfig {
	
	public static String APPID = "wx2e1deda16bcced1d";
	public static String MCHID = "1323511701";
	public static String KEY = "S9FH2LLNK7SY8DF9G5Y1C3GX15F2SHOU";
	public static String APPSECRET = "2de82c85d4ec582a73414df915c4a6d1";
	public static String notifyUrl = "http://cvaf.cn:7777/sf-pay/weixinpay/notify.html";
	public static String getAPPID() {
		return APPID;
	}
	public static void setAPPID(String aPPID) {
		APPID = aPPID;
	}
	public static String getMCHID() {
		return MCHID;
	}
	public static void setMCHID(String mCHID) {
		MCHID = mCHID;
	}
	public static String getKEY() {
		return KEY;
	}
	public static void setKEY(String kEY) {
		KEY = kEY;
	}
	public static String getAPPSECRET() {
		return APPSECRET;
	}
	public static void setAPPSECRET(String aPPSECRET) {
		APPSECRET = aPPSECRET;
	}
	public static String getNotifyUrl() {
		return notifyUrl;
	}
	public static void setNotifyUrl(String notifyUrl) {
		WxPayConfig.notifyUrl = notifyUrl;
	}
	
	
	
	

}
