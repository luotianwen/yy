package com.shifeng.provide.solr;

/**
 * Solr搜索服务
 * @author Win
 *
 */
public interface SolrService {
	
	/**
	 * 数据全量导入
	 */
	void dataFullImport();
	
	/**
	 * 数据增量导入
	 */
	void dataDeltaImport();
	

}
