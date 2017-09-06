package com.shifeng.provide.express.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shifeng.dto.express.ExpressTraceDTO;
import com.shifeng.provide.express.ExpressService;
import com.shifeng.provide.util.Constant;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.redis.RedisTool;

/**
 * 快递查询接口实现
 * @author Win
 *
 */
@Service(timeout=1200000)
public class ExpressServiceImpl implements ExpressService{

    private Logger logger = Logger.getLogger(this.getClass());
    
	
	/**
	 * 查询快递跟踪信息
	 * @param expressCode 快递代码
	 * @param expressNumber	快递单号
	 * @return
	 */
	public ReqResponse<List<ExpressTraceDTO>> getExpressTrace(String expressCode,String expressNumber) {
		ReqResponse<List<ExpressTraceDTO>> req = new ReqResponse<List<ExpressTraceDTO>>();
		String key = String.format(Constant.EXPRESS_TRACE_KEY, expressCode,expressNumber);
		String data = RedisTool.get(key);
		if(StringUtils.isNotBlank(data)){
			 List<ExpressTraceDTO> expressTraceList = JSON.parseArray(data, ExpressTraceDTO.class);
			 req.setData(expressTraceList);
			 return req;
		}
		List<ExpressTraceDTO> expressTraceList = query(expressCode, expressNumber);
		if(expressTraceList != null){
			RedisTool.set(key, JSON.toJSONString(expressTraceList));
			//设置过期时间 单位：秒
			RedisTool.expire(key, 1*60*10);
			
			req.setData(expressTraceList);
		}else{
			req.setCode(1);
			req.setMsg("单号不存在或者已经过期");
		}
		return req;
	}
	
    public static void main(String[] args) {
    	ExpressServiceImpl e = new ExpressServiceImpl();
    	//System.out.println(new Date().getTime());
    	ReqResponse<List<ExpressTraceDTO>> req = e.getExpressTrace("zhongtong","436293833116");
    	System.err.println(req.getData());
    }
    
    
    
	/**
	 * 查询快递跟踪信息
	 * @param type 快递代码
	 * @param postid	快递单号
	 * @return
	 */
    private List<ExpressTraceDTO> query(String type,String postid){
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet request = new HttpGet("https://www.kuaidi100.com/query?type="+type+"&postid="+postid+"&id=1&valicode=&temp=0.9056539479136658");

		/// 设置请求报头，模拟Chrome浏览器
		request.addHeader("Accept","*/*"); 
		request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36"); 
		request.addHeader("Accept-Encoding", "gzip, deflate, sdch");
		request.addHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
		request.addHeader("Content-Type", "text/html; charset=UTF-8");
		request.addHeader("Cache-Control", "max-age=0");
		request.addHeader("Connection", "keep-alive");
		request.addHeader("Cookie", "__gads=ID=7c764cfc8805fb63:T=1492762238:S=ALNI_MbqdR65e5YK5gZhUtp3DSy6T6_92w; WWWID=WWW3C4CAC3057741AB0F9D399D9DC375996; Hm_lvt_22ea01af58ba2be0fec7c11b25e88e6c=1492762238,1493710055; Hm_lpvt_22ea01af58ba2be0fec7c11b25e88e6c=1493710861; sortStatus=0");
		request.addHeader("DNT", "1");
		request.addHeader("Host", "www.kuaidi100.com");
		request.addHeader("X-Requested-With", "XMLHttpRequest");
		
		System.out.println(request.getRequestLine());
		try {
			// 执行get请求
			HttpResponse httpResponse = closeableHttpClient.execute(request);
			//获取响应消息实体 
			HttpEntity entity = httpResponse.getEntity(); 
			//响应状态
			System.out.println("status:" + httpResponse.getStatusLine());
			//判断响应实体是否为空 
			if (entity != null) {
				 String json = EntityUtils.toString(entity);
				 System.out.println(json);
				 JSONObject obj = JSON.parseObject(json);
				 String data = obj.get("data").toString();
				 if(StringUtils.isNotBlank(data)){
					 List<ExpressTraceDTO> expressTraceList = JSON.parseArray(data, ExpressTraceDTO.class);  
					 //System.out.println(expressTraceList);
					 return expressTraceList;
				 }
			}
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流并释放资源
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

}
