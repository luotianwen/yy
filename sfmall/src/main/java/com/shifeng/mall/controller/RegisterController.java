package com.shifeng.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.entity.user.SysUser;
import com.shifeng.mall.service.YzmService;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;

@Controller
public class RegisterController {
	public String basePath ="/WEB-INF/view/";
	
	@Resource(name = "sysUserService")
	private SysUserService sysUserService;
	
	@Resource(name = "yzmServiceImpl")
    private YzmService yzmServiceImpl;
	
	/**
	 * 跳转注册页面
	 */
	@RequestMapping(value="/register")
	@ResponseBody
	public ModelAndView register(ModelAndView mv){
		mv.setViewName(basePath+"register.btl");
		return mv;
	}
	
	/**
	 * 发送验证码
	 * @param phone
	 */
	@RequestMapping(value="/register/postYzm",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> sendSMS(String phone,String imgyzm,HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		
		if(StringUtils.isEmpty(imgyzm)){
			map.put(Const.ERROR_INFO, "请输入图片验证码!");
			return map;
		}
		if(!session.getAttribute("register_verifyCode").equals(imgyzm)){
			map.put(Const.ERROR_INFO, "图片验证码不正确!");
			return map;
		}
		
		yzmServiceImpl.postYzmTime(map, phone,1);
		return map;
	}
	
	/**
	 * 注册
	 */
	@RequestMapping(value = "/register/save")
	@ResponseBody
	public Map<String, String> save(SysUser sysUser,String yzm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		
		boolean bool = yzmServiceImpl.postYzm(sysUser.getPhone(), yzm,1);
		
		if(bool){
			sysUser.setName(sysUser.getPhone().substring(0, 3)+"****"+sysUser.getPhone().substring(7, 11));
			ReqResponse<Integer> req = sysUserService.addUser(sysUser);
			
			if(req.getCode()==0){
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			}else{
				map.put(Const.ERROR_INFO, req.getMsg());
			}
		}else{
			map.put(Const.ERROR_INFO, "验证码错误！");
		}
		
		return map;
	}
	
}
