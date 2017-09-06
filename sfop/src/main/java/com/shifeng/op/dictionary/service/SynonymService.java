package com.shifeng.op.dictionary.service;

import java.util.List;

import com.shifeng.op.dictionary.entity.Synonym;
import com.shifeng.plugin.page.Page;
/** 
 * 同义词字典表(dic_synonym)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-12-15 15:51:09 
 */  
public interface SynonymService {

	/**
	 * 获取同义词词典列表
	 * @param page
	 * @return
	 */
    List<Synonym> getSynonymList(Page<Synonym> page);

    /**
     * 检查同义词是否存在
     * @param word
     * @param id
     * @return
     */
	boolean checkWord(String word, Integer id);
	
	/**
	 * 根据id查询同义词
	 * @param id
	 * @return
	 */
	Synonym selectWord(int id);

	/**
	 * 保存词
	 * @param synonym
	 * @return
	 */
	boolean saveWord(Synonym synonym);

	
}
