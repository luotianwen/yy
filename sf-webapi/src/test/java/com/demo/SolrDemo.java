package com.demo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrDemo {
	
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
	     
	     query.setQuery("sq:休闲 黑色^100");
	     
         //覆盖schema.xml的defaultOperator（有空格时用"AND"还是用"OR"操作逻辑），一般默认指定。必须大写  
         //query.set("q.op","AND");  

		//加权
		query.set("defType","edismax");
		// 最小匹配
		query.set("mm", 100%50);
		/*设置需要查询的Field权重   
		 * 在Solr权重的设置中，所有权重标准为1，意思是当权重设置大于1时，
		 * 代表这个字段的权重变大，如果权重设置小于1并且大于0的时候，代表这个字段权重变小 。
		*/
		//query.set("qf","colorName^5");
		
	    
        QueryResponse response = solrClient.query(query);
        SolrDocumentList list = response.getResults();
        //solrClient.commit();
        System.out.println("匹配数量："+list.getNumFound());
        Iterator<SolrDocument> itr = list.iterator();
        while (itr.hasNext()) {
            SolrDocument solrDocument = itr.next();
            System.out.println(solrDocument.getFieldValue("pName"));
            System.out.println(solrDocument.getFieldValue("colorName"));
        }
		
	}
	/*
	
	fl: 是逗号分隔的列表，用来指定文档结果中应返回的 Field 集。默认为 “*”，指所有的字段。

	defType: 指定query parser，常用defType=lucene, defType=dismax, defType=edismax

	q: query。

	q.alt: 当q字段为空时，用于设置缺省的query，通常设置q.alt为*:*。

	qf: query fields，指定solr从哪些field中搜索。

	pf: 用于指定一组field，当query完全匹配pf指定的某一个field时，来进行boost。

	简言之pf的作用是boosting phrases over words。

	fq: filter query，过虑查询。

	mm: minimal should match。Solr支持三种查询clause，即“必须出现”， “不能出现”和“可以出现”，分别对应于AND, -, OR。

	在默认情况下，使用OR这个clause。mm用于设置在使用OR这个clause时，需要出现最少的满足条件的clause数量，详见这里。

	ps: Phrase Slop. Amount of slop on phrase queries built for "pf" fields (affects boosting). ps is about pf parameter. ps affects boosting, if you play with ps value, numFound and result set do not change. But the order of result set change. This is about the phrase query that is constructed out of the entire "q" param. ps is slop applied to the phrases created from the entire query for evaluating pf boosts. ps will only (potentially) change the ranked ordering of your result set, by loosening what a "phrase match" means to the pf boost.

	ps的例子：

	Lets say your query is apache solr. (without quotation marks) 

	Lets say these three documents contains all of these words and returned. 

	1-) solr is built on the top of apache lucene. 
	2-) apache solr is fast, mature and popular. 
	3-) solr is hosted under apache umbrella. 

	Even if you don't use pf and ps parameters, those documents will be in result set anyway. Lets say that they appear in this order 1,2,3. 

	Then we include pf and ps parameter, q=apache solr&pf=title^1.2&ps=1 
	Second document is boosted, lets say it comes first now. The order is changed. The documents - that have the all query words close each other - are boosted. Again the same three documents are returned.

	qs: Query Phrase Slop. Amount of slop on phrase queries explicitly included in the user's query string (in qf fields; affects matching). qs affects matching. If you play with qs, numFound changes. This parameter is about when you have explicit phrase query in your raw query. i.e. &q="apache lucene" . qs is slop applied to phrases explicitly in the &q with double quotes. qs will (potentially) change your result set.

	tie: tie breaker。

	bq: 对某个field的value进行boost，例如brand:IBM^5.0。

	bf: Function (with optional boosts) that will be included in the user's query to influence the score. Any function supported natively by Solr can be used, along with a boost value, e.g.: recip(rord(myfield),1,2,3)^1.5

	wt: writer type，指定输出格式，可以有 xml, json, php, phps。

	q.op: 覆盖schema.xml的defaultOperator（有空格时用"AND"还是用"OR"操作逻辑）。 
	df: 默认的查询字段。 
	qt: query type，指定那个类型来处理查询请求，一般不用指定，默认是standard。 
*/
}
