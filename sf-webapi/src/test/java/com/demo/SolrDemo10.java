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
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;

public class SolrDemo10 {

	// solr 服务器地址
	public static final String solrUrl = "http://192.168.1.177:8080";

	public static void main(String[] args) throws SolrServerException, IOException {

		HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl + "/product");
		HttpSolrClient solrClient = builder.build();
		// 读取超时
		solrClient.setSoTimeout(5000);
        //是否允许跟踪重定向 默认false
		solrClient.setFollowRedirects(false);
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
		
		//HttpClientUtil.setBasicAuth((DefaultHttpClient) solrClient.getHttpClient(),"WinZhong", "WinZhong");
		
		// 创建doc文档
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", "777");
        doc.addField("pid", "666");
        
		try {
			UpdateResponse response = solrClient.add(doc);;
			
			//对索引进行优化
			solrClient.optimize();
            //提交
			solrClient.commit();
            // 输出统计信息
            System.out.println("Query Time：" + response.getQTime());
            System.out.println("Elapsed Time：" + response.getElapsedTime());
            System.out.println("Status：" + response.getStatus());
			
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

}
