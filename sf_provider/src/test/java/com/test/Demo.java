package com.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Demo {

	public static void main(String[] args) {
		HttpClient httpclient = HttpClients.createDefault();
		 
			try {
				HttpGet httpGet = new HttpGet(new URI("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx2e1deda16bcced1d&secret=2de82c85d4ec582a73414df915c4a6d1"));
				//执行Get请求，  
				HttpResponse httpresponse = httpclient.execute(httpGet);
				HttpEntity entity = httpresponse.getEntity();
				String body = EntityUtils.toString(entity);
				System.out.println(body);
				JSONObject json = JSON.parseObject(body);
				System.out.println(json.getString("access_token"));
				System.out.println(json.getString("expires_in"));
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 

	}

}
