package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	
	 //服务地址  沙箱网关：https://openapi.alipaydev.com/gateway.do 
	 public static String serverUrl = "https://openapi.alipay.com/gateway.do";


	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "2088701539723278";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;

	// MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    public static String key = "llzfz3ubf965xlxa4babcdfrw0pe580b";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKpAWujv/1sAVcif/iT9YGlpCHP4QTt+DZZaWvHiaAsKnDQurhVTgsMAjBTmjVcSeUYNcWQ+k9r+DMIzbI3G8rgkwppVYItrd3N2r5UIEkymsyhm9eVnqgqfc7mYtwPH9qkiSe13BvfS6e4o5UIUsc6JMTkbnTcIwHLhUCi4L4A1AgMBAAECgYBoyNMrKwtvZvVlVZOGEKyWNB8PwWvkweB6+YGf/kkrAozBUTmzxoJkoqGU+5FiVexuQTfZCurVjicsH5pgaGJaEpeSO3TXz3t1SAneNKEddtQTbrcQBAQ+pJkT9p8YvXXbb1lT+2ZAhf0Az049rWjLzJMG7qh/BAJ4HT6/FEXcwQJBANkU0r8PKGgHXRYWRxG80HidnhrxnwFS9a2ph7BMnq4ky/fXMId6gd8djsPOza94IYjUx4y8Ndt2Iuc5aWnfhXsCQQDIxjjK+dUf86l/K34a5Skqay5HE2ne83KDw/I9ZBpiVU+ThOTQTwz6AiY/UXj+HS8mjNv3+9PovJPP5z8iaaoPAkBuoDP99cWLriT7+oJhQa2jqf9Gj9eOHy7gP0LMz18WM95WAS3T/NRuVWvJ0Xv0be35AyZmTAvOOVf0KcfUkno9AkBxgbc78ZBvFvc9YR5TIDlstNmd7zjMhf+4xL+fu4c7DpYFhX1C0143vZ1X8LyhlWhBuCLoCOQd0PcT8916nBg7AkA25UueyeMLaU7g0S/EbbDTl4dP+kBXxYvNzDuDQygHV5aX8SSSCojT+dMfQVqihkZ87o0k+MGSBTnvfr0aKkS4";
	
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://192.168.1.177:7777/sf-pay/pay/alipay/notify.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://192.168.1.177:7777/sf-pay/alipay/return.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String wap_return_url = "http://350770b8.nat123.cc:43097/sf-pay/alipay/wapReturn.html";
	
	// 签名方式 	MD5/RSA
	public static String sign_type = "MD5";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "E:\\sf_pay_log\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// pc调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";
	
	// app调用的接口名，无需修改
	public static String appService = "alipay.wap.create.direct.pay.by.user";
	
	//
	public static String format = "json";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";
	
	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";
	
	//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
	public static String getPartner() {
		return partner;
	}

	public static void setPartner(String partner) {
		AlipayConfig.partner = partner;
	}

	public static String getSeller_id() {
		return seller_id;
	}

	public static void setSeller_id(String seller_id) {
		AlipayConfig.seller_id = seller_id;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		AlipayConfig.key = key;
	}

	public static String getPrivate_key() {
		return private_key;
	}

	public static void setPrivate_key(String private_key) {
		AlipayConfig.private_key = private_key;
	}

	public static String getAlipay_public_key() {
		return alipay_public_key;
	}

	public static void setAlipay_public_key(String alipay_public_key) {
		AlipayConfig.alipay_public_key = alipay_public_key;
	}

	public static String getNotify_url() {
		return notify_url;
	}

	public static void setNotify_url(String notify_url) {
		AlipayConfig.notify_url = notify_url;
	}

	public static String getReturn_url() {
		return return_url;
	}

	public static void setReturn_url(String return_url) {
		AlipayConfig.return_url = return_url;
	}

	public static String getSign_type() {
		return sign_type;
	}

	public static void setSign_type(String sign_type) {
		AlipayConfig.sign_type = sign_type;
	}

	public static String getLog_path() {
		return log_path;
	}

	public static void setLog_path(String log_path) {
		AlipayConfig.log_path = log_path;
	}

	public static String getInput_charset() {
		return input_charset;
	}

	public static void setInput_charset(String input_charset) {
		AlipayConfig.input_charset = input_charset;
	}

	public static String getPayment_type() {
		return payment_type;
	}

	public static void setPayment_type(String payment_type) {
		AlipayConfig.payment_type = payment_type;
	}
 
	public static String getAnti_phishing_key() {
		return anti_phishing_key;
	}

	public static void setAnti_phishing_key(String anti_phishing_key) {
		AlipayConfig.anti_phishing_key = anti_phishing_key;
	}

	public static String getExter_invoke_ip() {
		return exter_invoke_ip;
	}

	public static void setExter_invoke_ip(String exter_invoke_ip) {
		AlipayConfig.exter_invoke_ip = exter_invoke_ip;
	}

	public static String getWap_return_url() {
		return wap_return_url;
	}

	public static void setWap_return_url(String wap_return_url) {
		AlipayConfig.wap_return_url = wap_return_url;
	}

		

	
	
	
	
	
	
	
	
	
}

