package com.shifeng.op.dictionary.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.op.dictionary.entity.Dictionary;
import com.shifeng.op.dictionary.service.DictionaryService;
import com.shifeng.plugin.page.Page; 

/** 
 * 字典词库(Dictionary)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-12-15 15:51:09 
 */  
@Service("dictionaryServiceImpl")
public class DictionaryServiceImpl implements DictionaryService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;


	/**
	 * 获取词典列表
	 * @param page
	 * @return
	 */
    public List<Dictionary> getDictionaryList(Page<Dictionary> page) {
    	try {
			List<Dictionary> list = (List<Dictionary>)dao.findForList("DictionaryMapper.getDictionaryListPage", page);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    


    /**
     * 检查词是否存在
     * @param word
     * @param id
     * @return
     */
	public boolean checkWord(String word,Integer id) {
		try {
			if(StringUtils.isEmpty(id)){
				int count = (int)dao.findForObject("DictionaryMapper.checkWord", word);
				return count==0?true:false;
			}else{
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", id);
				map.put("word", word);
				int count = (int)dao.findForObject("DictionaryMapper.checkWords", map);
				return count==0?true:false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	


	/**
	 * 保存词
	 * @param dictionary
	 */
	public boolean saveWord(Dictionary dictionary) {
		try {
			dictionary.setUpdate_time(new Date());
			if(dictionary.getId() == 0){
				dao.save("DictionaryMapper.saveWord", dictionary);
			}else{
				dao.update("DictionaryMapper.updateWord", dictionary);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据id查询词
	 * @param id
	 * @return
	 */
	public Dictionary selectWord(int id) {
		try {
			Dictionary dictionary = (Dictionary)dao.findForObject("DictionaryMapper.selectWordById", id);
			return dictionary;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
    
}
