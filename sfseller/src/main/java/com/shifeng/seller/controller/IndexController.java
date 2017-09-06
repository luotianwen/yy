package com.shifeng.seller.controller;


import com.shifeng.seller.entity.users.Users;
import com.shifeng.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 
*    
* 项目名称：compass-data   
* 类名称：IndexController   
* 类描述：  登录成功跳转控制
* @version    
*
 */
@Controller
public class IndexController extends BaseController{

	/**
	 * 跳转到后台管理首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/index")
	public ModelAndView adminIndex(HttpSession session)throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		ModelAndView mv = new ModelAndView();
		if(user==null){
			return new ModelAndView("redirect:/login/logout");
		}
		mv.setViewName("index");
		return mv;
	}/**
	 * 跳转到后台管理首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/indexContent")
	public ModelAndView indexContent(HttpSession session)throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		ModelAndView mv = new ModelAndView();
		if(user==null){
			return new ModelAndView("redirect:/login/logout");
		}
		mv.setViewName("indexContent");
		return mv;
	}


	/**
	 * 方法描述：goRegister
	 * 返回类型：ModelAndView
	 * @return
	 */
	@RequestMapping(value="/register")
	public ModelAndView goRegister(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	
	/**
	 * 方法描述：记录访问的路径，登录过后进行跳转
	 * 返回类型：ModelAndView
	 * @param url
	 * @return
	 */
	@RequestMapping(value="/loginSaveUrl")
	public ModelAndView goLogin(String url,HttpSession session){
		session.setAttribute(Const.SAVE_URL, url);
		ModelAndView mv = new ModelAndView("redirect:/login.html");
		return mv;
	}
	

	
	

	
	
}
