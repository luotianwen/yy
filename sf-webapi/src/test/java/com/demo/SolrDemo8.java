package com.demo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrDemo8 {

	// solr 服务器地址
	public static final String solrUrl = "http://192.168.1.177:8080";

	public static void main(String[] args) throws SolrServerException, IOException {

		HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl + "/brand");
		HttpSolrClient solrClient = builder.build();
		// 读取超时
		solrClient.setSoTimeout(5000);
		// 链接超时时间
		solrClient.setConnectionTimeout(5000);
		// 单个主机打开的最大连接数
		solrClient.setDefaultMaxConnectionsPerHost(100);
		// 最大连接数
		solrClient.setMaxTotalConnections(1000);
		// 重定向
		solrClient.setFollowRedirects(false);
		// 是否允许压缩
		solrClient.setAllowCompression(true);
		//// 设定xml文档解析器
		solrClient.setParser(new XMLResponseParser());
		
		HttpClientUtil.setBasicAuth((DefaultHttpClient) solrClient.getHttpClient(),"WinZhong", "WinZhong");
		
		 String ids = "1,37";
		// 创建查询条件
		SolrQuery query = new SolrQuery();
		query.setQuery("id:(" + ids.replaceAll(",", " OR ") + ")");
		query.setStart(0);
		query.setRows(10);
 

		try {
			QueryResponse queryResponse = solrClient.query(query);
			
			SolrDocumentList list = queryResponse.getResults();
	        //solrClient.commit();
	        System.out.println("数量："+list.getNumFound());
	        Iterator<SolrDocument> itr = list.iterator();
	        while (itr.hasNext()) {
	            SolrDocument solrDocument = itr.next();
	            System.out.println(solrDocument.getFieldValue("brandName"));
	            System.out.println(solrDocument.getFieldValue("id"));
	        }
			
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

}
