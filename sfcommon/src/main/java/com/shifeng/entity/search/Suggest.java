package com.shifeng.entity.search;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.client.solrj.response.TermsResponse.Term;


/**
 * 搜索建议词
 * @author WinZhong
 *
 */
public class Suggest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//提示词
	@Field("keyword")
	private String key;
	//词频
	@Field("p_count")
	private long qre;
	/**
	 * 提示词
	 * @return
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 提示词
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 词频
	 * @return
	 */
	public long getQre() {
		return qre;
	}
	/**
	 * 词频
	 * @param qre
	 */
	public void setQre(long qre) {
		this.qre = qre;
	}
	
	public Suggest() {
	}
	
	public Suggest(Term term) {
		this.key = term.getTerm();
	    this.qre = term.getFrequency();
	}
	
	

}
