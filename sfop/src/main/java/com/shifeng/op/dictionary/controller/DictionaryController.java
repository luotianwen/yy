package com.shifeng.op.dictionary.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.caucho.hessian.client.HessianProxyFactory;
import com.shifeng.analyzer.server.DicUpdateServer;
import com.shifeng.op.dictionary.entity.Dictionary;
import com.shifeng.op.dictionary.service.DictionaryService;
import com.shifeng.op.util.PinYinUtil;
import com.shifeng.plugin.page.Page;

@Controller
@RequestMapping(value="/dic")
public class DictionaryController {
	
	/**
	 * 字典词库(Dictionary)接口
	 */
	@Resource(name = "dictionaryServiceImpl")
	DictionaryService dictionaryService;

	//
	@Value("#{properties['solr.productUrl']}")
	private String solrProductUrl;

	//
	@Value("#{properties['solr.suggestUrl']}")
	private String solrSuggestUrl;

	//
	@Value("#{properties['solr.hessianUrl']}")
	private String solrHessianUrl;
	
	/**
	 * 跳转词典列表页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/goDictionary")
	public ModelAndView goDictionary(ModelAndView mv){
		mv.setViewName("dictionary/dictionary");
		return mv;
	}
	
	/**
	 * 词典列表
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView quartz(ModelAndView mv,Page<Dictionary> page,Dictionary dictionary){
		page.setT(dictionary);
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryList(page);
		mv.addObject("dictionaryList", dictionaryList);
		mv.addObject("page", page);
		mv.setViewName("dictionary/dictionaryList");
		return mv;
	}

	/**
	 * 添加词
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/add")
	public ModelAndView add(ModelAndView mv){
		mv.setViewName("dictionary/addDictionary");
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
		boolean bl = dictionaryService.checkWord(word,id);
		return bl;
	}
	
	/**
	 * 检查词是否存在
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pinyin")
	public Map<String,String> pinyin(String word){
		Map<String,String> map = new HashMap<String,String>();
		map.put("qp", PinYinUtil.getFullSpell(word));
		map.put("jp", PinYinUtil.getFirstSpell(word));
		return map;
	}

	/**
	 * 检查词是否存在
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveWord")
	public boolean saveWord(Dictionary dictionary){
		boolean bl = dictionaryService.saveWord(dictionary);
		return bl;
	}

	/**
	 * 修改加词
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(ModelAndView mv,@PathVariable("id") int id){
		Dictionary dictionary = dictionaryService.selectWord(id);
		mv.addObject("dictionary", dictionary);
		mv.setViewName("dictionary/editDictionary");
		return mv;
	}

	/**
	 * 同步词库到搜索引擎
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/syncSearchDic")
	public boolean syncSearchDic(){
		boolean bl = false;
		//创建HessianProxyFactory实例
		 HessianProxyFactory factory = new HessianProxyFactory();
		try {
			//获得Hessian服务的远程引用
			DicUpdateServer DicUpdateServer = (DicUpdateServer)factory.create(DicUpdateServer.class,solrHessianUrl);
		    System.out.println(DicUpdateServer.testServer());
		    DicUpdateServer.updateDictionary();
		    bl = true;
		} catch (MalformedURLException e) {
		  e.printStackTrace();
		}
		return bl;
	}

	/**
	 * 刷新搜索引擎索引
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/syncSearchIndex")
	public boolean syncSearchIndex(){
		boolean bl = false;

		//创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		//HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		//HttpGet httpGet = new HttpGet(solrSuggestUrl+"/dataimport?command=delta-import&clean=false&commit=true");
		HttpGet httpGet = new HttpGet(solrSuggestUrl+"/dataimport?command=full-import&clean=true&commit=true");
		//HttpGet httpGet = new HttpGet("http://10.44.11.221:7979/search/app/dataimport?command=delta-import&clean=false&commit=true");
		System.out.println(httpGet.getRequestLine());
		try {
			//执行get请求
			//HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			closeableHttpClient.execute(httpGet);
		   /*//获取响应消息实体 
		   HttpEntity entity = httpResponse.getEntity(); 
		   //响应状态
		   System.out.println("status:" + httpResponse.getStatusLine());
		   //判断响应实体是否为空 
		   if (entity != null) {
			   System.out.println("contentEncoding:" +entity.getContentEncoding()); System.out.println("response content:" + EntityUtils.toString(entity));
		   }*/
		   httpGet = new HttpGet(solrProductUrl+"/dataimport?command=delta-import&clean=false&commit=true");
		   //httpResponse = closeableHttpClient.execute(httpGet);
		   closeableHttpClient.execute(httpGet);
			bl = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭流并释放资源
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bl;
	}
	
}
