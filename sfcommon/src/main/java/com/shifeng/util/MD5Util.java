package com.shifeng.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具类
 * @author WinZhong
 *
 */
public class MD5Util {

	/**
	 * MD5加密字符串
	 * @param data
	 * @return
	 */
	public static String hex(String data){
		return DigestUtils.md5Hex(data);
	}

	/**
	 * MD5加密字符串 ，盐值混淆
	 * @param data
	 * @return
	 */
	public static String hexSALT(String data){
		return DigestUtils.md5Hex(data+Const.MD5_SALT);
	}
	
}
