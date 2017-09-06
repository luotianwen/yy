package com.shifeng.op.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.shifeng.op.authority.service.MenusService;
import com.shifeng.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.op.entity.menu.Menus;
import com.shifeng.op.entity.users.Users;

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
public class IndexController {

	@Resource(name = "menusServiceImpl")
	private MenusService menusServiceImpl;
	/**
	 * 跳转到后台管理首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="admin/index")
	public ModelAndView adminIndex(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
        List<Menus> menus = menusServiceImpl.getUserMenuList(user.getrId());
		mv.addObject("menus", menus);
		mv.setViewName("admin/index");
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
	

	
	
	/**
	 * 方法描述：记录访问的路径，登录过后进行跳转
	 * 返回类型：ModelAndView
	 * @param url
	 * @return
	 */
	@RequestMapping(value="/login")
	public ModelAndView goLogin(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
}
