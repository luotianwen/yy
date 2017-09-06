package com.demo;

import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
	 
		String str = " 123456 ".trim();
		//判断字符串是否为数字
		System.out.println(str.matches("[0-9]*"));
		
		
	}

}
