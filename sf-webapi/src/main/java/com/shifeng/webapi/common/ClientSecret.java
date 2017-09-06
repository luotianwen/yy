package com.shifeng.webapi.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author WinZhong
 *
 */
public class ClientSecret {

	private static Map<String,String> map = new HashMap<String,String>();
	private static String format ="V%s_%s";
	
	static{
		//M端
		map.put("V1.0.0_1", "d6febb02cbd34a98b486767146c96379");
		//微信端
		map.put("V1.0.0_2", "657bbd1df4c7461cb4dde06b216cce40");
		//安卓app
		map.put("V1.0.0_3", "f99e653b1abe4828a355047e44e72533");
		//苹果app
		map.put("V1.0.0_4", "e518a8d0bda94b948cc6696cf0200b6b");
	}
	
	public static void main(String[] args) {
		System.out.println(String.format(format, "1.0.0", 1));
		System.out.println(ClientSecret.getClientSecret("1.0.0", 1));
	}

	public static String getClientSecret(String version,int type) {
		return map.get(String.format(format, version,type));
	}
	
}
