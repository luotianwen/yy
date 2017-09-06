package com.shifeng.util;

/***
 * 
 * @author WinZhong
 *
 */
public class Const {

    /**
     * md5盐值字符串,用于混淆MD5
     */
	public static String MD5_SALT = "outdoors戶外открытый ";
    /**
     * AJAX返回状态
     */
    public static final String RESPONSE_STATE = "RESPONSE_STATE";
    /**
     *  返回成功状态
     */
    public static final String RESPONSE_SUCCESS = "200";
    /**
     *  返回失败状态
     */
    public static final String RESPONSE_ERROR = "500";
    /**
     * 返回错误信息
     */
    public static final String ERROR_INFO = "ERROR_INFO";

    /**
     * 登录IP
     */
    public static final String LOGIN_IP = "LOGIN_IP";
    /**
     * session错误登录次数(保留)
     */
    public static final String SESSION_LOGIN_ERROR_NUM = "SESSION_LOGIN_ERROR_NUM";
    /**
     * SAVE_URL
     */
    public static final String SAVE_URL = "SAVE_URL";
    /**
	 * 世峰e卡生成批次最大值
	 */
	public static int CARDBATCH = 0;
    /**
     * 登录用户SESSION
     */
    public static final String SELLER_SESSION_USER = "SELLER_SESSION_USER";
    /**
     * 登录用户SESSION
     */
    public static final String MALL_SESSION_USER = "MALL_SESSION_USER";
    /**
     * 登录用户SESSION
     */
    public static final String OP_SESSION_USER = "OP_SESSION_USER";
    
    /**
     * 分类缓存Key
     */
    public static final String CATEGORY_CACHE = "category:cache";

    /**
     * 分类缓存更新标识
     */
    public static final String CATEGORY_FLAG = "category:flag";

    /**
     * 导航缓存更新标识
     */
    public static final String NAVIGATION_CACHE_FLAG= "navigation:cache:flag";

    /**
     * 导航缓存
     */
    public static final String NAVIGATION_CACHE= "navigation:cache";
    /**
     * sku缓存标识
     */
    public static final String SKU_CACHE_FLAG= "sku:cache:flag:%s";
    public static final String SKU_DETAIL_CACHE="sku:detail:%s";
    public static final int SKU_DETAIL_CACHE_TIME=60*60/6;
    /**
     * 商品缓存标识
     */
    public static final String PRODUCT_CACHE_FLAG= "product:cache:flag:%s";
    public static final String PRODUCT_DETAIL_CACHE= "product:detail:%s";
    public static final int PRODUCT_DETAIL_CACHE_TIME=60*60/6;
    //品牌缓存
    public static final String BAND_DETAIL_CACHE= "brand:detail:%s";
    public static final String BAND_CACHE_FLAG= "brand:cache:flag:%s";

    //专题页缓存
    public static final String SPECIAL_DETAIL_CACHE= "sysspecial:detail:%s";
    public static final String SPECIAL_CACHE_FLAG= "sysspecial:cache:flag:%s";

}
