package com.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.shifeng.dto.ware.WareDTO;
import com.shifeng.dto.ware.WareSkuDTO;

public class SolrDemo3 {
	
	 //solr 服务器地址    
    public static final String solrUrl = "http://localhost:7777/sf-search"; 

	public static void main(String[] args) throws SolrServerException, IOException {

		 HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl+"/product");
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
	     
	     query.setQuery("sq:(休闲 AND 白色)");//黑色^100
	     //商品状态(1在售2下架3删除)
		 query.addFilterQuery("state:1");
		 

		System.out.println("开启关键词高亮");
	    // 开启高亮组件  
	    query.setHighlight(true); 
	    // 字段开启了高亮
	    query.addHighlightField("highlightWareName"); 
	    // 以下两个方法主要是在高亮的关键字前后加上html代码 
	    query.setHighlightSimplePre("<font color='red'>"); 
	    query.setHighlightSimplePost("</font>");
	    
	    query.set("sort", "pid asc");
	    
	    

		// 从多少条开始
		query.setStart(0);
		// 显示几条
		query.setRows(20);
	     
	   
		
		// 查询并返回结果
		QueryResponse queryResponse = solrClient.query(query,METHOD.POST);
		//获取请求结果
		List<WareSkuDTO> wareSkuList = (List<WareSkuDTO>) queryResponse.getBeans(WareSkuDTO.class);
	    //获取所有高亮的字段  
	    Map<String,Map<String,List<String>>> highlightMap = queryResponse.getHighlighting();
	    //System.out.println(highlightMap);
	    System.out.println(wareSkuList.size());
	    if(null != wareSkuList){
	    	
	    	 List<WareDTO> wareList = new ArrayList<WareDTO>();
	    	 WareDTO ware = null;
	    	 Integer pid = null;
	    	 List<WareSkuDTO> skuList = null;
		    for(WareSkuDTO sku:wareSkuList){
		    	System.out.println(sku.getColorName());
	        	//获取高亮内容
	            List<String> highlightList = highlightMap.get(sku.getId()).get("highlightWareName");  
	            if(highlightList!=null && highlightList.size()>0){ 
		           	 //赋值高亮字段
	            	 //sku.setpName(highlightList.get(0));
	            }
	            if(null == pid || pid == sku.getPid()){
	            	if(null == ware){
	            		ware = new WareDTO();
	            		//ware.setpName(sku.getpName());
	            		skuList = new ArrayList<WareSkuDTO>();
	            	}
	            	skuList.add(sku);
	            	pid = sku.getPid();
	            }else{
	            	ware.setSkuList(skuList);
	            	wareList.add(ware);
	            	
	            	ware = new WareDTO();
            		//ware.setpName(sku.getpName());
            		skuList = new ArrayList<WareSkuDTO>();
            		skuList.add(sku);
            		
            		pid = sku.getPid();
	            }
		    }
		    ware.setSkuList(skuList);
        	wareList.add(ware);
		    //System.out.println(WareSkuList);  
		  
		    for(WareDTO w:wareList){
		    	System.out.println(w.toString());
		    	/*for(WareSkuDTO s:w.getSkuList()){
		    		System.out.println(s.toString());
		    	}*/
		    }
		   
		   
	    }
	   
		
	}
	 
}
