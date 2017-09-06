package com.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.GroupParams;

import com.shifeng.dto.ware.WareDTO;
import com.shifeng.dto.ware.WareSkuDTO;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.util.MapTurnBean;

import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrDemo9 {

	 //solr 服务器地址    
    public static final String solrUrl = "http://192.168.1.222:7777/sf-search";

	public static void main(String[] args) throws SolrServerException, IOException {

		 HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl+"/product");
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
		
		SearchParameter searchParameter = new SearchParameter();
		SolrPage page = new SolrPage();
		
		SolrQuery query = new SolrQuery();

		query.setQuery("sq:(" + searchParameter.getKeyword().replaceAll("\\s+", " AND ") + ")");//(休闲 AND 白色)
		 
			// 商品状态(1在售2下架3删除)
			query.addFilterQuery("state:1");
		 

		if(searchParameter.isHighlight()){
			System.out.println("开启关键词高亮");
			// 开启高亮组件
			query.setHighlight(true);
			// 字段开启了高亮
			query.addHighlightField("highlightWareName");
			// 以下两个方法主要是在高亮的关键字前后加上html代码
			query.setHighlightSimplePre("<font color='red'>");
			query.setHighlightSimplePost("</font>");
		}			
		
		/****设置排序 ****/
		//0：综合；1：销量；2：价格从低到高；3：价格从高到低
		switch (searchParameter.getSort()) {
			case 1:
				//按照销量排序
		   		//query.set("sort", "evaluate desc");  
				break;
			case 2:
				//按照价格从低到高排序
		   		query.set("sort", "price asc");
				break;
			case 3:
				//按照价格从高到低排序
		   		query.set("sort", "price desc");
				break;
			default:
				break;
		}
		
		/****设置过滤参数 Start****/
		
		StringBuffer filterQuery = new StringBuffer();
		boolean isFilterQuery = false;
		
		if(searchParameter.getFv() != null){
			//过滤参数id
			//query.addFilterQuery("propertyValueId:("+searchParameter.getFv().replaceAll(",", " AND ")+")");   
			filterQuery.append("propertyValueId:("+searchParameter.getFv().replaceAll(",", " AND ")+")");
			isFilterQuery = true;
		}
		
		/****设置品牌参数 Start****/
		
		if(searchParameter.getB() != null){
			//品牌id
			//query.addFilterQuery("brandid:("+searchParameter.getB().replaceAll(",", " OR ")+")");  
			if(isFilterQuery){
				filterQuery.append(" AND ");
			} 
			filterQuery.append("brandid:("+searchParameter.getB().replaceAll(",", " OR ")+")");  
			isFilterQuery = true;
		}
		
		 
		if(searchParameter.isCustomPrice()){
			if(isFilterQuery){
				filterQuery.append(" AND ");
			} 
			//商品价格
	        if(searchParameter.getStart_price() != 0.0 && searchParameter.getEnd_price() != 0.0){
		    	 //query.addFilterQuery("price:[ "+searchParameter.getStart_price()+" TO "+searchParameter.getEnd_price()+" ]");
	        	filterQuery.append("price:[ "+searchParameter.getStart_price()+" TO "+searchParameter.getEnd_price()+" ]");
		     }else if(searchParameter.getStart_price() == 0.0 && searchParameter.getEnd_price() != 0.0){
		    	 //query.addFilterQuery("price:{ * TO "+searchParameter.getEnd_price()+" ]");
		    	 filterQuery.append("price:{ * TO "+searchParameter.getEnd_price()+" ]");
		     }else if(searchParameter.getStart_price() != 0.0 && searchParameter.getEnd_price() == 0.0){
		    	 //query.addFilterQuery("price:["+searchParameter.getStart_price()+" TO * }");
		    	 filterQuery.append("price:["+searchParameter.getStart_price()+" TO * }");
		     }
	        isFilterQuery = true;
		}
		
		if(isFilterQuery){
			query.addFilterQuery(filterQuery.toString());   		
		}
		
		/************是否需要筛选属性property（1：需要；2：否）不传默认1*************/
		if(searchParameter.getP() == 1){
			query.setFacet(true);// 设置facet=on
			query.addFacetField("propertyValueId");// 设置需要facet的字段
			query.addFacetField("brandid");// 设置需要facet的品牌字段
			query.setFacetLimit(200);// 限制facet返回的数量
			query.setFacetMissing(false);// 不统计null的值
			query.setFacetMinCount(1);// 设置返回的数据中每个分组的数据最小值，比如设置为1，则统计数量最小为1，不然不显示
			query.setFacetSort("count");// 排序的方式，根据count或者index
		}

		// 从多少条开始
		query.setStart((page.getPageNow() - 1) * page.getPageSize());
		// 显示几条
		query.setRows(page.getPageSize());

		// 设为true，表示结果需要分组
		query.setParam(GroupParams.GROUP, "true");
		// 需要分组的字段
		query.setParam(GroupParams.GROUP_FIELD, "pid");
		// 指定每组结果开始位置/偏移量
		// query.setParam(GroupParams.GROUP_OFFSET, "0");
		// 每组返回多数条结果,默认1
		query.setParam(GroupParams.GROUP_LIMIT, "50");
		query.setParam(GroupParams.GROUP_FORMAT, "grouped");
		// 设为true时，Solr将返回分组数量，默认fasle
		query.setParam(GroupParams.GROUP_TOTAL_COUNT, "true");
		//指定文档结果中应返回的 Field 集
		query.set("fl", "id,pid,highlightWareName,pName,logo,marketprice,price,colorName,specName,colorPic");
        //覆盖schema.xml的defaultOperator（有空格时用"AND"还是用"OR"操作逻辑），一般默认指定。必须大写  
        //query.set("q.op","AND");  
		try {
			// 查询并返回结果
			QueryResponse queryResponse = solrClient.query(query, METHOD.POST);
			GroupResponse groupResponse = queryResponse.getGroupResponse();
			// 获取所有高亮的字段
			Map<String, Map<String, List<String>>> highlightMap = queryResponse.getHighlighting();
			System.out.println(highlightMap);
			 //总条数
			long numFound = 0;
			List<GroupCommand> groupList = groupResponse.getValues();
			List<WareDTO> wareList = new ArrayList<WareDTO>();
			for (GroupCommand groupCommand : groupList) {
				numFound = groupCommand.getNGroups();
				List<Group> groups = groupCommand.getValues();
				for (Group group : groups) {
					 SolrDocumentList solrDocumentList = group.getResult();  
					 WareDTO ware = null;
					 List<WareSkuDTO> skuList = null;
					 for (SolrDocument doc : solrDocumentList) {
						 if(null == ware){
			            		ware = new WareDTO();
			            		if(searchParameter.isHighlight()){
			            			List<String> highlightWareName =  highlightMap.get(doc.get("id")).get("highlightWareName");
			            			if(null == highlightWareName || highlightWareName.size() == 0){
			            				ware.setpName(doc.get("pName").toString());
			            			}else{
				            			ware.setpName(highlightWareName.get(0));
			            			}	
			            		}else{
			            			ware.setpName(doc.get("pName").toString());
			            		}
			            		skuList = new ArrayList<WareSkuDTO>();
			            		WareSkuDTO wareSku = new WareSkuDTO();
								skuList.add(MapTurnBean.mapToBean(doc, wareSku));
								if(null == wareSku.getColorName() || StringUtils.isBlank(wareSku.getColorName())){
									wareSku.setColorPic(doc.get("logo").toString());
								}
			             }else{
			            	 if(null != doc.get("colorName")){
				            	 WareSkuDTO wareSku = new WareSkuDTO();
								 skuList.add(MapTurnBean.mapToBean(doc, wareSku));
								 System.out.println("颜色："+wareSku.getColorName());
			            	 }
			             }
						 
					 }
					 ware.setSkuList(skuList);
					 wareList.add(ware);
				 
				}
			}
	} catch (SolrServerException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		
	}

}
