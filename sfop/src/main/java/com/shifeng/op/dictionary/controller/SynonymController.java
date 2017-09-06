package com.shifeng.op.dictionary.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.op.dictionary.entity.Synonym;
import com.shifeng.op.dictionary.service.SynonymService;
import com.shifeng.plugin.page.Page;

/** 
 * 同义词字典表(synonym)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-12-15 15:51:09 
 */ 
@Controller
@RequestMapping(value="/synonym")
public class SynonymController{
	
	@Resource(name="synonymServiceImpl")
	private SynonymService synonymService;

	
	/**
	 * 词典列表
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView quartz(ModelAndView mv,Page<Synonym> page,Synonym synonym){
		page.setT(synonym);
		List<Synonym> synonymList = synonymService.getSynonymList(page);
		mv.addObject("synonymList", synonymList);
		mv.setViewName("dictionary/synonymList");
		return mv;
	}
	
	/**
	 * 添加词
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/add")
	public ModelAndView add(ModelAndView mv){
		mv.setViewName("dictionary/addSynonym");
		return mv;
	}

	/**
	 * 检查词是否存在
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkWord")
	public boolean checkWord(String word,Integer id){
		boolean bl = synonymService.checkWord(word,id);
		return bl;
	}

	/**
	 * 修改加词
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(ModelAndView mv,@PathVariable("id") int id){
		Synonym synonym = synonymService.selectWord(id);
		mv.addObject("synonym", synonym);
		mv.setViewName("dictionary/editSynonym");
		return mv;
	}
 
	/**
	 * 检查词是否存在
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveWord")
	public boolean saveWord(Synonym synonym){
		boolean bl = synonymService.saveWord(synonym);
		return bl;
	}
}
