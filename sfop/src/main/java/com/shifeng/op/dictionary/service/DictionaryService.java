package com.shifeng.op.dictionary.service;

import java.util.List;

import com.shifeng.op.dictionary.entity.Dictionary;
import com.shifeng.plugin.page.Page;
/** 
 * 字典词库(Dictionary)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-12-15 15:51:09 
 */  
public interface DictionaryService {

	/**
	 * 获取词典列表
	 * @param page
	 * @return
	 */
    List<Dictionary> getDictionaryList(Page<Dictionary> page);

    /**
     * 检查词是否存在
     * @param word
     * @param id
     * @return
     */
	boolean checkWord(String word,Integer id);

	/**
	 * 保存词
	 * @param dictionary
	 * @return
	 */
	boolean saveWord(Dictionary dictionary);

	/**
	 * 根据id查询词
	 * @param id
	 * @return
	 */
	Dictionary selectWord(int id);
	
}
