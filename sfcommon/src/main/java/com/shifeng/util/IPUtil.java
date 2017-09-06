package com.shifeng.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shifeng.entity.ip.IpPosition;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * IP地址相关工具类
 * @author Win
 *
 */
public class IPUtil {

		public static void main(String[] args) {
			IPUtil.getIpPosition("127.0.0.1");
		}
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	public static IpPosition getIp(HttpServletRequest request){
		return getIpPosition(getIpAddress(request));
	}
	/**
		 * 解析IP地理位置
		 * @param ip
		 * @return
		 */
		public static IpPosition getIpPosition(String ip){
		    String host = "https://dm-81.data.aliyun.com";
		    String path = "/rest/160601/ip/getIpInfo.json";
		    String method = "GET";
		    String appcode = "94aa6ed40e1d4c00a33089a0be7becc6";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    querys.put("ip", ip);
		    
		    IpPosition ipPosition = null;

		    try {
		    	/**
		    	* 重要提示如下:
		    	* HttpUtils请从
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		    	* 下载
		    	*
		    	* 相应的依赖请参照
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		    	*/
		    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
		    	String body = EntityUtils.toString(response.getEntity());
		    	//获取response的body
		    	JSONObject json = JSON.parseObject(body);
		    	int code = json.getInteger("code");
		    	if(code == 0){
		    		ipPosition = json.getObject("data", IpPosition.class);
		    	}
		    	if(ipPosition==null|| StringUtils.isEmpty(ipPosition.getRegion_id())){
					ipPosition=new IpPosition();
					ipPosition.setRegion_id("110000");
					ipPosition.setRegion("北京市");
				}
		    } catch (Exception e) {
				ipPosition=new IpPosition();
				ipPosition.setRegion_id("110000");
				ipPosition.setRegion("北京市");
		    }
			return ipPosition;
		}
		
/*		{
			  "code": 0,
			  "data": {
			    "ip": "210.75.225.254",
			    "country": "中国",
			    "area": "华北",
			    "region": "北京市",
			    "city": "北京市",
			    "county": "",
			    "isp": "电信",
			    "country_id": "86",
			    "area_id": "100000",
			    "region_id": "110000",
			    "city_id": "110000",
			    "county_id": "-1",
			    "isp_id": "100017"
			  }
			}*/


}
