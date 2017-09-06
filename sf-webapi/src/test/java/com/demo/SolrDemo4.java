package com.demo;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.shifeng.entity.search.WareSkuInfo;

public class SolrDemo4 {
	
	 //solr 服务器地址    
    public static final String solrUrl = "http://192.168.1.222:7777/sf-search"; 

	public static void main(String[] args) throws SolrServerException, IOException {

		 HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl+"/sku");
	     HttpSolrClient solrClient = builder.build();
			//读取超时
	     solrClient.setSoTimeout(5000);
			//链接超时时间
	     solrClient.setConnectionTimeout(5000);
			//单个主机打开的最大连接数
	     solrClient.setDefaultMaxConnectionsPerHost(100);
			//最大连接数
	     solrClient.setMaxTotalConnections(1000);
			//重定向
	     solrClient.setFollowRedirects(false);
			//是否允许压缩
	     solrClient.setAllowCompression(true);
	     ////设定xml文档解析器 
	     solrClient.setParser(new XMLResponseParser());
	     
	    
	     
	     SolrQuery query = new SolrQuery(); 
	     
	     query.setQuery("id:10405");

		//指定文档结果中应返回的 Field 集
		query.set("fl", "id,stocks,marketprice,price,colorid,specid,starttime,endtime,activitytype,activityprice,activitystocks,imgs,shopid,shopName,shopLogo,brandid,pName,recommend,listing,parameter,state,after_service,freight_master,goods_subtitle,logo,length,width,height,is_seven_return,description,phone_describe");
		// 查询并返回结果
		QueryResponse queryResponse = solrClient.query(query,METHOD.POST);
		System.out.println(queryResponse.getResults());
		//获取请求结果
		List<WareSkuInfo> skuInfoList = (List<WareSkuInfo>) queryResponse.getBeans(WareSkuInfo.class);
	    
		System.out.println(skuInfoList.get(0).toString());
		   
		
	}
	 
}
