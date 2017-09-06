package com.shifeng.webapi.controller.search;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.entity.search.SearchParameter;
import com.shifeng.entity.search.Suggest;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.search.SearchService;


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
	 * 商品搜索
	 * @param version
	 * @param ticket
	 * @param searchParameter 搜索参数	
	 * @return
	 */
	@RequestMapping(value = "/ware")
	@ResponseBody
	public ReqResponse<SolrPage> ware(String version,String ticket,SearchParameter searchParameter, SolrPage page){
		ReqResponse<SolrPage> req = new ReqResponse<SolrPage>();
		//是否能继续获取访问
		if(!this.visitInspect(ticket, "search/ware", req)){
			return req;
		}
		
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				req.setData(searchService.searchWare(searchParameter,page));
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}	
	
	/**
	 * 关键词提示
	 * @param version
	 * @param ticket
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value = "/suggest")
	@ResponseBody
	public ReqResponse<List<Suggest>> suggest(String version,String ticket,String keyword){
		ReqResponse<List<Suggest>> req = new ReqResponse<List<Suggest>>();
		//是否能继续获取访问
		if(!this.visitInspect(ticket, "search/suggest", req)){
			return req;
		}
		
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				req.setData(searchService.suggest(keyword));
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}	
	

}
