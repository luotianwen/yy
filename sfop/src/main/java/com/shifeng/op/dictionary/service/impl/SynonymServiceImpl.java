package com.shifeng.op.dictionary.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.op.dictionary.entity.Synonym;
import com.shifeng.op.dictionary.service.SynonymService;
import com.shifeng.plugin.page.Page; 

/** 
 * 同义词字典表(synonym)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-12-15 15:51:09 
 */  
@Service("synonymServiceImpl")
public class SynonymServiceImpl implements SynonymService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 获取同义词词典列表
	 * @param page
	 * @return
	 */
    public List<Synonym> getSynonymList(Page<Synonym> page) {
    	try {
			List<Synonym> list = (List<Synonym>)dao.findForList("synonymMapper.getSynonymListPage", page);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
     * 检查同义词是否存在
     * @param word
     * @param id
     * @return
     */
	public boolean checkWord(String word, Integer id) {
		try {
			if(StringUtils.isEmpty(id)){
				int count = (int)dao.findForObject("synonymMapper.checkWord", word);
				return count==0?true:false;
			}else{
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", id);
				map.put("word", word);
				int count = (int)dao.findForObject("synonymMapper.checkWords", map);
				return count==0?true:false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据id查询同义词
	 * @param id
	 * @return
	 */
	public Synonym selectWord(int id) {
		try {
			Synonym synonym = (Synonym)dao.findForObject("synonymMapper.selectWordById", id);
			return synonym;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 保存词
	 * @param synonym
	 * @return
	 */
	public boolean saveWord(Synonym synonym) {

		try {
			synonym.setUpdate_time(new Date());
			if(!StringUtils.isEmpty(synonym.getEscape())){
				synonym.setWord(synonym.getSynonym()+" => "+synonym.getEscape());
			}
			if(synonym.getId() == 0){
				dao.save("synonymMapper.saveWord", synonym);
			}else{
				dao.update("synonymMapper.updateWord", synonym);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
