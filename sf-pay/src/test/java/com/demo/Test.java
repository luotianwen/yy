package com.demo;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.shifeng.pay.sdk.weixin.common.MD5;
import com.shifeng.util.MD5Util;
import com.shifeng.util.UuidUtil;

public class Test {

	public static void main(String[] args) {

		System.out.println(MD5Util.hex("123"));
		System.out.println(MD5.MD5Encode("123"));
		RandomStringUtils.random(5);//产生5位长度的随机字符串
		 
		//使用指定的字符生成5位长度的随机字符串
		RandomStringUtils.random(5, new char[]{'a','b','c','d','e','f'});
		 
		//生成指定长度的字母和数字的随机组合字符串
		RandomStringUtils.randomAlphanumeric(5);
		 
		//生成随机数字字符串
		System.out.println(RandomStringUtils.randomAlphanumeric(8));
		
		System.out.println(UuidUtil.get32UUID());
		
		System.out.println(BarcodeFormat.QR_CODE);
		
		
		
		
		
		
		
		
		
	}

}
