package com.shifeng.mall.search.controller;

import com.shifeng.entity.search.Suggest;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.search.service.SearchService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * 搜索API接口 Controller
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "searchServiceImpl")
	protected SearchService searchService;
	
	 
	
	/**
	 * 关键词提示
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value = "/suggest"/*,method = RequestMethod.POST*/)
	@ResponseBody
	public List<Suggest> suggest(String keyword){
		return searchService.suggest(keyword);
	}	
	

}
