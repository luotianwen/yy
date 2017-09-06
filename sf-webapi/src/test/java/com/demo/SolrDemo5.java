package com.demo;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.shifeng.entity.search.WareSkuInfo;

public class SolrDemo5 {
	
	 //solr 服务器地址    
    public static final String solrUrl = "http://192.168.1.222:7777/sf-search"; 

	public static void main(String[] args) throws SolrServerException, IOException {

		 HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl+"/ware");
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
	     
	    
	     
	        String pName = "RealLife乐来福 RL-A02登山杖 折叠手杖 户外登山杖 徒步登山专用手杖";
			// 创建查询条件
			SolrQuery query = new SolrQuery();
			query.setQuery("q:"+pName/*+" AND -id:3"*/);
			//query.setQuery("id:3 AND shopid:1");
			//query.addFilterQuery("-id:1");
			query.addField("id,name");
			query.setStart(0);
			query.setRows(5);
			//在查询时，打开/关闭 MoreLikeThisComponent 的布尔值。真|假
			query.setParam("mlt", "true");
			//根据哪些字段判断相似度
			query.setParam("mlt.fl", "q");
			//最小分词频率，在单个文档中出现频率小于这个值的词将不用于相似判断
			query.setParam("mlt.mintf", "50");
			//最小文档频率，所在文档的个数小于这个值的词将不用于相似判断
			query.setParam("mlt.mindf", "50");
			//返回相似文章个数
			//query.setParam("mlt.count", "1");
			try {
				QueryResponse response = solrClient.query(query);
				SolrDocumentList docs = response.getResults();
				System.out.println("购买商品："+pName);
				System.out.println("【你可能需要以下商品】");
				for (SolrDocument doc : docs) {
					System.out.println(doc);
				}
			} catch (SolrServerException e) {
				e.printStackTrace();
			}
		}

	}
