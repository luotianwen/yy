package com.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.GroupParams;

import com.shifeng.dto.mall.property.PropertyDTO;
import com.shifeng.dto.mall.property.PropertyValueDTO;
import com.shifeng.util.MapTurnBean;

public class SolrDemo6 {
	
	 //solr 服务器地址    
    public static final String solrUrl = "http://192.168.1.177:7777/sf-search"; 

	public static void main(String[] args) throws SolrServerException, IOException {

		 HttpSolrClient.Builder builder = new HttpSolrClient.Builder(solrUrl+"/property");
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
	     
	    
	     
	        String ids = "3343,3372,14393,14407,14408,14410,14411,14414,14418,14422,14460,14461,14600,14697,14949";
			// 创建查询条件
			SolrQuery query = new SolrQuery();
			query.setQuery("id:(" + ids.replaceAll(",", " OR ") + ")");
			query.setStart(0);
			query.setRows(10);
			// 设为true，表示结果需要分组
			query.setParam(GroupParams.GROUP, "true");
			// 需要分组的字段
			query.setParam(GroupParams.GROUP_FIELD, "propertyName");
			// 分组内部排序
			query.setParam(GroupParams.GROUP_SORT, "propertyValueSort ASC");
			// 每组返回多数条结果,默认1
			query.setParam(GroupParams.GROUP_LIMIT, "10");
			query.setParam(GroupParams.GROUP_FORMAT, "grouped");
			// 设为true时，Solr将返回分组数量，默认fasle
			query.setParam(GroupParams.GROUP_TOTAL_COUNT, "true");
			query.addSort("propertySort", ORDER.asc);
			// 指定文档结果中应返回的 Field 集
			query.set("fl", "id,propertyName,content");
			try {
				QueryResponse queryResponse = solrClient.query(query);
				GroupResponse groupResponse = queryResponse.getGroupResponse();
				List<GroupCommand> groupList = groupResponse.getValues();
				List<PropertyDTO> propertyList = new ArrayList<PropertyDTO>();
				for (GroupCommand groupCommand : groupList) {
					List<Group> groups = groupCommand.getValues();
					for (Group group : groups) {
						 SolrDocumentList solrDocumentList = group.getResult();
						// System.out.println(group.getGroupValue());
						 PropertyDTO p = new PropertyDTO();
						 p.setPropertyName(group.getGroupValue());
						 List<PropertyValueDTO> propertyValueList = new ArrayList<PropertyValueDTO>();
						 for (SolrDocument doc : solrDocumentList) {
							 //System.out.println(doc.get("id")+":"+doc.get("content"));
							 PropertyValueDTO pv = new PropertyValueDTO();
							 propertyValueList.add(MapTurnBean.mapToBean(doc, pv));
							 
						 }
						 p.setPropertyValueList(propertyValueList);
						 propertyList.add(p);
					}
				}
				
				System.out.println(propertyList);
				
				
			} catch (SolrServerException e) {
				e.printStackTrace();
			}
		}

	}
