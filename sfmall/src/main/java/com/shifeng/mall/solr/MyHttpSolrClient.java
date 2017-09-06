package com.shifeng.mall.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

/**
 * solr客户端
 * @author WinZhong
 *
 */
public class MyHttpSolrClient{
	
	/**solr服务器地址 链接必须以/结尾*/
	private String baseURL;
	/**请求core名字*/
	private String coreName;
	/**读取超时*/
	private int timeout;
	/**链接超时时间*/
	private int connectionTimeout;
	/**单个主机打开的最大连接数*/
	private int defaultMaxConnectionsPerHost;
	/**最大连接数*/
	private int maxTotal;
	/**重定向*/
	private boolean followRedirects;
	/**是否允许压缩*/
	private boolean allowCompression;
	
	private HttpSolrClient solrClient;

	public HttpSolrClient getHttpSolrClient(){
		if(solrClient == null){
			 HttpSolrClient.Builder builder = new HttpSolrClient.Builder(baseURL+coreName);
		     solrClient = builder.build();
				//读取超时
		     solrClient.setSoTimeout(timeout);
				//链接超时时间
		     solrClient.setConnectionTimeout(connectionTimeout);
				//单个主机打开的最大连接数
		     solrClient.setDefaultMaxConnectionsPerHost(defaultMaxConnectionsPerHost);
				//最大连接数
		     solrClient.setMaxTotalConnections(maxTotal);
				//重定向
		     solrClient.setFollowRedirects(followRedirects);
				//是否允许压缩
		     solrClient.setAllowCompression(allowCompression);
		     ////设定xml文档解析器 
		     solrClient.setParser(new XMLResponseParser());
		}
		return solrClient;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getCoreName() {
		return coreName;
	}

	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getDefaultMaxConnectionsPerHost() {
		return defaultMaxConnectionsPerHost;
	}

	public void setDefaultMaxConnectionsPerHost(int defaultMaxConnectionsPerHost) {
		this.defaultMaxConnectionsPerHost = defaultMaxConnectionsPerHost;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public boolean isFollowRedirects() {
		return followRedirects;
	}

	public void setFollowRedirects(boolean followRedirects) {
		this.followRedirects = followRedirects;
	}

	public boolean isAllowCompression() {
		return allowCompression;
	}

	public void setAllowCompression(boolean allowCompression) {
		this.allowCompression = allowCompression;
	}
 
	
	

}
