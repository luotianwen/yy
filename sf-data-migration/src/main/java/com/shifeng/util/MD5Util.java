package com.shifeng.util;

import static com.shifeng.util.Tools.getRandomNum;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具类
 * @author WinZhong
 *
 */
public class MD5Util {

	/**
	 * MD5加密字符串 ，盐值混淆
	 * @param data
	 * @return
	 */
	public static String hex(String data){
		return DigestUtils.md5Hex(data+Const.MD5_SALT);
	}
	public static String md5(String data){
		return DigestUtils.md5Hex(data);
	}
	public static void main(String[] args) {
		System.out.println(md5("1c7f08b1ba36da27f8fa6a321b09adf91489483171408"));
	}
}
