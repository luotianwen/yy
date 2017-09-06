package com.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.GroupParams;

import com.shifeng.dto.ware.WareDTO;
import com.shifeng.dto.ware.WareSkuDTO;
import com.shifeng.util.MapTurnBean;

public class SolrDemo2 {
	
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
	     
	     query.setQuery("sq:(休闲)");//黑色^100  (休闲 AND 白色)
	     //商品状态(1在售2下架3删除)
		 query.addFilterQuery("state:1");
		 //query.addFilterQuery("specName:40");
		 

		System.out.println("开启关键词高亮");
	    // 开启高亮组件  
	    query.setHighlight(true); 
	    // 字段开启了高亮
	    query.addHighlightField("highlightWareName"); 
	    // 以下两个方法主要是在高亮的关键字前后加上html代码 
	    query.setHighlightSimplePre("<font color='red'>"); 
	    query.setHighlightSimplePost("</font>");

		// 从多少条开始
		query.setStart(0);
		// 显示几条
		query.setRows(20);
	     
	     query.setParam(GroupParams.GROUP, "true");
	     query.setParam(GroupParams.GROUP_FIELD, "pid");
	     //query.setParam(GroupParams.GROUP_FIELD, "pName");
		 //query.setParam(GroupParams.GROUP_FIELD, "colorName");
		 //query.setParam(GroupParams.GROUP_FIELD, "specName");
		
		 query.setParam(GroupParams.GROUP_OFFSET, "0");
		 query.setParam(GroupParams.GROUP_LIMIT, "50");
		 query.setParam(GroupParams.GROUP_FORMAT, "grouped");
		 query.setParam(GroupParams.GROUP_TOTAL_COUNT, "true");
		 
		query.setFacet(true);// 设置facet=on
		query.addFacetField("brandid");// 设置需要facet的品牌字段
		query.addFacetField("pcid");// 设置需要facet的分类字段
		query.setFacetLimit(200);// 限制facet返回的数量
		query.setFacetMissing(false);// 不统计null的值
		query.setFacetMinCount(1);// 设置返回的数据中每个分组的数据最小值，比如设置为1，则统计数量最小为1，不然不显示
		// query.setFacetPrefix("1");//限制constaints的前缀
		query.setFacetSort("count");//排序的方式，根据count或者index
		
		// 查询并返回结果
		QueryResponse queryResponse = solrClient.query(query,METHOD.POST);
		GroupResponse groupResponse = queryResponse.getGroupResponse();
	    //获取所有高亮的字段  
	    Map<String,Map<String,List<String>>> highlightMap = queryResponse.getHighlighting();
	    System.out.println(highlightMap);
	    /*for(Product p:productList){
        	//获取高亮内容
            List<String> highlightList = highlightMap.get(""+p.getId()).get("highlightWareName");  
            if(highlightList!=null && highlightList.size()>0){ 
	           	 //赋值高亮字段
	           	 p.setHighlightName(highlightList.get(0));
	           	 System.out.println(highlightList.get(0));  
            }
	    }*/
	    
	    //总条数
		long numFound = 0;
		List<GroupCommand> groupList = groupResponse.getValues();
		List<WareDTO> wareList = new ArrayList<WareDTO>();
		for (GroupCommand groupCommand : groupList) {
			numFound = groupCommand.getNGroups();
            System.out.println("总组数（总条数）: " + numFound);  
			
			List<Group> groups = groupCommand.getValues();
			for (Group group : groups) {
				
				System.out.println("===================="+group.getGroupValue()+"=======================");
				 SolrDocumentList solrDocumentList = group.getResult();  
				 WareDTO ware = null;
				 List<WareSkuDTO> skuList = null;
				 for (SolrDocument doc : solrDocumentList) {
					 if(null == ware){
		            		ware = new WareDTO();
		            		ware.setpName(highlightMap.get(doc.get("id")).get("highlightWareName").get(0));
		            		skuList = new ArrayList<WareSkuDTO>();
		             }
					 skuList.add(MapTurnBean.mapToBean(doc, new WareSkuDTO()));
					 //System.out.println(skuList.toString());
					 //System.out.println(doc);
					 /*System.out.println("highlightWareName:"+highlightMap.get(doc.get("id")).get("highlightWareName"));
					 System.out.println(doc.get("pName"));
					 System.out.println(doc.get("colorName"));
					 System.out.println(doc.get("specName"));*/
					 //System.out.println(doc);
				 }
				 ware.setSkuList(skuList);
				 wareList.add(ware);
				 System.out.println("=====================end======================");
				//System.out.println(group.getGroupValue() + "----" + (int) group.getResult().getNumFound());
				//System.out.println(group.getResult());
			}
		}
		for(WareDTO w:wareList){
	    	System.out.println(w.toString());
	    	/*for(WareSkuDTO s:w.getSkuList()){
	    		System.out.println(s.toString());
	    	}*/
	    }
		
		FacetField brandFacetField = queryResponse.getFacetField("brandid");
		List<Count> counts = null;
		if (brandFacetField != null) {
			counts = brandFacetField.getValues();
			if (counts != null) {
				for (Count count : counts) {
					System.out.println("brandId:" + count.getName() + " " + count.getCount());
				}
			}
		}
		
	}
	 
}
