package com.shifeng.webapi.controller.homepage;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.dto.homepage.AdDTO;
import com.shifeng.webapi.dto.homepage.BannerDTO;
import com.shifeng.webapi.dto.homepage.CategoryAdsDTO;
import com.shifeng.webapi.dto.homepage.HomePageDataDTO;
import com.shifeng.webapi.service.homepage.AdService;
import com.shifeng.webapi.service.homepage.BannerService;
import com.shifeng.webapi.service.homepage.CategoryAdsService;

@Controller
@RequestMapping(value = "/homepage")
public class HomePageController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "bannerServiceImpl")
	protected BannerService bannerService;
	
	@Resource(name = "adServiceImpl")
	protected AdService adService;
	
	@Resource(name = "categoryAdsServiceImpl")
	protected CategoryAdsService categoryAdsService;
	
	
	/**
	 * 装载首页数据
	 * @param version
	 * @param ticket
	 * @return
	 */
	@RequestMapping(value = "/init")
	@ResponseBody
	public ReqResponse<HomePageDataDTO> init(String version,String ticket){
		ReqResponse<HomePageDataDTO> req = new ReqResponse<HomePageDataDTO>();
		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "homepage/init", req)){
			return req;
		}
		//验证ticket
		if(!this.checkTicket(ticket,req)){
			return req;
		}
		
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				getHomePageData(req);
				/*
				HomePageDataDTO hpd = new HomePageDataDTO();
				//获取首页banner图列表
				List<BannerDTO> bannerList = bannerService.getBannerList();
				hpd.setBannerList(bannerList);
				//获取首页广告列表
				List<AdDTO> adList = adService.getAdList();
				hpd.setAdList(adList);
				req.setData(hpd);
				*/
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		//System.out.println(JSON.toJSONString(req));
		
		return req;
	}		
	
	/**
	 * 获取首页数据V1.0.0版本
	 * @param req
	 */
	private void getHomePageData(ReqResponse<HomePageDataDTO> req){
		//首页数据
		HomePageDataDTO hpd = null;
		
		String key = Constant.APP_HOMEPAGE_DATA_KEY;
		try {
			String data = RedisTool.get(key);
			if(StringUtils.isNotBlank(data)){
				hpd = JSON.parseObject(data, HomePageDataDTO.class);
			}
		} catch (Exception e) {
			logger.error("从redis获取首页缓存数据出错：", e);
		}
		if(hpd == null){
			hpd = new HomePageDataDTO();
			//获取首页banner图列表
			List<BannerDTO> bannerList = bannerService.getBannerList();
			//获取首页广告列表
			List<AdDTO> adList = adService.getAdList();
			hpd.setAdList(adList);
			hpd.setBannerList(bannerList);
			
			try {
				RedisTool.set(key, JSON.toJSONString(hpd));
				RedisTool.expire(key, 1*60);
			} catch (Exception e) {
				logger.error("首页数据缓存至redis出错：", e);
			}
		}
		

		req.setData(hpd);
	}
	
	
	/**
	 * 获取首页分类广告数据
	 * @param version
	 * @param ticket
	 * @return
	 */
	@RequestMapping(value = "/categoryAds")
	@ResponseBody
	public ReqResponse<List<CategoryAdsDTO>> categoryAds(String version,String ticket){
		ReqResponse<List<CategoryAdsDTO>> req = new ReqResponse<List<CategoryAdsDTO>>();
		
		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "homepage/categoryAds", req)){
			return req;
		}
		//验证ticket
		if(!this.checkTicket(ticket,req)){
			return req;
		}
		
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				getCategoryAdsData(req);
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}		
	
	
	/**
	 * 获取首页分类广告数据V1.0.0版本
	 * @param req
	 */
	private void getCategoryAdsData(ReqResponse<List<CategoryAdsDTO>> req){
		List<CategoryAdsDTO> cadList = null;
		
		String key = Constant.APP_HOMEPAGE_CATEGORY_AD_DATA_KEY;
		try {
			String data = RedisTool.get(key);
			if(StringUtils.isNotBlank(data)){
				cadList = JSON.parseArray(data, CategoryAdsDTO.class);
			}
		} catch (Exception e) {
			logger.error("从redis获取首页缓存数据出错：", e);
		}
		if(cadList == null){
			//cadList = new ArrayList<CategoryAdsDTO>();
			//获取首页分类广告数据
			cadList = categoryAdsService.getAdsList();
			try {
				if(cadList != null && cadList.size() > 0){
					RedisTool.set(key, JSON.toJSONString(cadList));
					RedisTool.expire(key, 1*60*30);	
				}
			} catch (Exception e) {
				logger.error("首页数据缓存至redis出错：", e);
			}
		}
		
		req.setData(cadList);
		
	}
	

}
