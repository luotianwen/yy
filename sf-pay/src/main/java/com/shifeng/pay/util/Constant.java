package com.shifeng.pay.util;

public class Constant {
	
	/**
	 * 接口每分钟最大允许调用次数
	 */
	public static int MINUTE_MAX_VISIT_COUNT = 20;
	
	/**
	 * ticket
	 */
	public static String TICKET_KEY ="ticket:%s";
	
	/**
	 * 用户登录授权token
	 * token_用户ID_token值
	 */
	public static String TOKEN_KEY ="token:%s_%s";
	
	/**
	 * 验证码key
	 * authcode_ticket值_验证码类型
	 */
	public static String AUTHCODE_KEY ="authcode:%s_%s";

	
	/**
	 * 访问次数key
	 * visit_count_ticket值_method方法名
	 */
	public static String VISIT_COUNT_KEY ="visit:count:%s_%s";
	
	/**
	 * 每天短信发送次数key
	 *notice:mobileCode:count:手机号
	 */
	public static String NOTICE_MOBILECODE_DAY_COUNT_KEY ="notice:mobileCode:count:day:%s";
	
	/**
	 * 每天每个手机号最大发送手机验证码次数
	 */
	public static int DAY_MAX_SEND_MOBILECODE_COUNT = 5;
	
	/**
	 * 每分钟每个手机号最大发送手机验证码次数
	 */
	public static int MINUTE_MAX_SEND_MOBILECODE_COUNT = 1;
	/**
	 * 每分钟短信发送次数key
	 *notice:mobileCode:minute:count:手机号
	 */
	public static String NOTICE_MOBILECODE_MINUTE_COUNT_KEY ="notice:mobileCode:count:minute:%s";
	/**
	 * 短信验证码key
	 *mobileCode:手机号
	 */
	public static String MOBILECODE_KEY ="mobileCode:%s";
	
}
