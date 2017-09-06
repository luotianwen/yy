package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonDemo {

	public static void main(String[] args) {
		String str = "{\"access_token\":\"b4SxntjTapgrYWLAMXk9Wes2xTRvnh_fJOkg298Uds48YH2yLNFH1yKqc5cgWBKberXzGPmdF50tbMbhynkcTN3p4Vls2K-s1-mIgBcdzQ1PpuS4tcKFU17ooAKfEEIhHNFjAAAWCU\",\"expires_in\":7200}";
		JSONObject json = JSON.parseObject(str);
		System.out.println(json.getString("access_token5") == null);
		System.out.println(json.getString("expires_in"));
	}

}
