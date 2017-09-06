package com.shifeng.pay.config;
/**
 * 支付回调地址
 * @author Win
 *
 */
public class PayReturnUrl {
	
	/**
	 * PC商品订单支付回调
	 */
	public static String PC_PAY_RETURN_URL = "";
	
	/**
	 * APP商品订单支付回调
	 */
	public static String APP_PAY_RETURN_URL = "";
 
	/**
	 * WAP商品订单支付回调
	 */
	public static String WAP_PAY_RETURN_URL = "";
	
	/**
	 * 商家店铺入驻续费订单支付回调
	 */
	public static String SHOP_RETURN_URL = "";

	public static String getPC_PAY_RETURN_URL() {
		return PC_PAY_RETURN_URL;
	}

	public static void setPC_PAY_RETURN_URL(String pC_PAY_RETURN_URL) {
		PC_PAY_RETURN_URL = pC_PAY_RETURN_URL;
	}

	public static String getAPP_PAY_RETURN_URL() {
		return APP_PAY_RETURN_URL;
	}

	public static void setAPP_PAY_RETURN_URL(String aPP_PAY_RETURN_URL) {
		APP_PAY_RETURN_URL = aPP_PAY_RETURN_URL;
	}

	public static String getWAP_PAY_RETURN_URL() {
		return WAP_PAY_RETURN_URL;
	}

	public static void setWAP_PAY_RETURN_URL(String wAP_PAY_RETURN_URL) {
		WAP_PAY_RETURN_URL = wAP_PAY_RETURN_URL;
	}

	public static String getSHOP_RETURN_URL() {
		return SHOP_RETURN_URL;
	}

	public static void setSHOP_RETURN_URL(String sHOP_RETURN_URL) {
		SHOP_RETURN_URL = sHOP_RETURN_URL;
	}

	 
	

}
