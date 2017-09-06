package com.shifeng.provide.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

/**
 * http请求工具类
 * @author WinZhong
 *
 */
public class HttpUtil {

	public static void main(String[] args) {

	}
	
	/**
	 * 
	 * 发送Get请求
	 * @param url  请求链接
	 * @param charset  解码字符集
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static String httpGet(String url,String charset) throws ClientProtocolException, IOException, URISyntaxException{
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(new URI(url));
		//执行Get请求，  
		HttpResponse httpresponse = httpclient.execute(httpGet);
		HttpEntity entity = httpresponse.getEntity();
		
		String body = EntityUtils.toString(entity , charset).trim();//EntityUtils.toString(entity);
		return body;
	}
	
	/**
	 * 
	 * 发送Get请求  解码字符集默认UTF-8
	 * @param url  请求链接
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static String httpGet(String url) throws ClientProtocolException, IOException, URISyntaxException{
		return httpGet(url, "UTF-8");
	}
	
	//HttpClientConnectionManager clientConnectionManager = init(); 
	//HttpClient httpclient = HttpClients.custom().setConnectionManager(clientConnectionManager).build();
	public static HttpClientConnectionManager init(){  
        try {  
            SSLContext sslContext  = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {  
                  
                @Override  
                public boolean isTrusted(X509Certificate[] arg0, String arg1)  
                        throws CertificateException {  
                    // TODO Auto-generated method stub  
                    return true;  
                }  
            }).build();  
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory( sslContext, new String[] { "TLSv1" }, null,  
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
            Registry registry = RegistryBuilder  
                    . create()  
                    .register("http", PlainConnectionSocketFactory.INSTANCE)  
                    .register("https", sslsf).build();  
            return new PoolingHttpClientConnectionManager(registry);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  

}
