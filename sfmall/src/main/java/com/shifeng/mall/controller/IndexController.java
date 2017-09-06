package com.shifeng.mall.controller;

import com.shifeng.mall.homepage.service.AdService;
import com.shifeng.mall.homepage.service.BannerService;
import com.shifeng.mall.util.HttpRequestDeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 
*    
 */
@Controller
public class IndexController extends BaseController{
	@Resource(name="bannerServiceImpl")
	private BannerService bannerService;
	@Resource(name="adServiceImpl")
	private AdService adService;
	/**
	 * 跳转到网站首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="index")
	public ModelAndView index(HttpServletRequest request, ModelAndView mv)throws Exception {
		boolean isMobile= HttpRequestDeviceUtils.isMobileDevice(request);
		if(isMobile)
			return  new ModelAndView(new RedirectView("http://m.seebong.com"));
		//系统banner
		mv.addObject("banners",bannerService.getBannerList());
		//系统广告
		mv.addObject("ads",adService.getAdList());
		mv.setViewName("index.btl");

		return mv;
	}	

}
