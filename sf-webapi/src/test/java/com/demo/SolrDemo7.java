package com.demo;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrDemo7 {

	// solr 服务器地址
	public static final String solrUrl = "http://192.168.1.177:7777/sf-search";

	public static void main(String[] args) throws SolrServerException, IOException {

		HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl + "/product");
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

		SolrQuery query = new SolrQuery();

		query.setQuery("sq:*");// 黑色^100
		// 商品状态(1在售2下架3删除)
		query.addFilterQuery("state:1");

		query.setFacet(true);// 设置facet=on
		query.addFacetField("propertyValueId");// 设置需要facet的字段
		query.addFacetField("brandid");// 设置需要facet的品牌字段
		query.setFacetLimit(200);// 限制facet返回的数量
		query.setFacetMissing(false);// 不统计null的值
		query.setFacetMinCount(1);// 设置返回的数据中每个分组的数据最小值，比如设置为1，则统计数量最小为1，不然不显示
		query.setFacetSort("count");// 排序的方式，根据count或者index

		try {
			QueryResponse queryResponse = solrClient.query(query);
			
			FacetField facetField = queryResponse.getFacetField("brandid");
			System.out.println("brandId:" +getIds(facetField));
			facetField = queryResponse.getFacetField("propertyValueId");
			System.out.println("pvid:" +getIds(facetField));
			
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String getIds(FacetField facetField){
		StringBuffer pvid = null;
		List<Count> counts = null;
		if (facetField != null) {
			counts = facetField.getValues();
			if (counts != null) {
				for (Count count : counts) {
					if (pvid == null) {
						pvid = new StringBuffer();
						pvid.append(count.getName());
					} else {
						pvid.append(",");
						pvid.append(count.getName());
					}
				}
			}
		}
		if(pvid == null){
			return null;
		}
		return pvid.toString();
	}
	
	

}
