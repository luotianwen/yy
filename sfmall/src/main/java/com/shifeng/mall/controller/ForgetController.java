package com.shifeng.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.mall.service.YzmService;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.StringReplaceUtil;

@Controller
public class ForgetController {
	public String basePath ="/WEB-INF/view/";
	
	@Resource(name = "sysUserService")
	private SysUserService sysUserService;
	
	@Resource(name = "yzmServiceImpl")
    private YzmService yzmServiceImpl;
	
	
	/**
	 * 跳转找回密码页面
	 */
	@RequestMapping(value="/forget")
	@ResponseBody
	public ModelAndView forget(ModelAndView mv){
		mv.setViewName(basePath+"forget.btl");
		return mv;
	}
	
	/**
	 * 验证图片验证码
	 */
	@RequestMapping(value="/forget/imgyzm")
	@ResponseBody
	public Map<String, String> imgyzm(String imgyzm,HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		
		if(StringUtils.isEmpty(imgyzm)){
			map.put(Const.ERROR_INFO, "请输入图片验证码!");
			return map;
		}
		if(!session.getAttribute("forget_verifyCode").equals(imgyzm)){
			map.put(Const.ERROR_INFO, "图片验证码不正确!");
			return map;
		}
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return map;
	}
	
	
	/**
	 * 方法描述：发送验证码 返回类型：Map<String,String>
	 * 
	 * @return
	 */
	@RequestMapping(value = "/forget/postYzm",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> postYzm(String phone,HttpSession session) {
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		
		if(StringUtils.isEmpty(phone)){
			map.put(Const.ERROR_INFO, "请输入手机号!");
			return map;
		}
		
		ReqResponse<String> req = sysUserService.checkAccountExists(phone);
		if(req.getCode()!=1){
			map.put(Const.ERROR_INFO, "手机号不存在！");
			return map;
		}
		
		yzmServiceImpl.postYzmTime(map, phone,2);
		return map;
	}
	
	/**
	 * 方法描述：验证手机验证码 返回类型：Map<String,String>
	 * 
	 * @return
	 */
	@RequestMapping(value = "/forget/verifyYzm",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> verifyYzm(String phone,String yzm,HttpSession session) {
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		
		if(StringUtils.isEmpty(yzm)){
			map.put(Const.ERROR_INFO, "请输入验证码!");
			return map;
		}
		
		boolean bool = yzmServiceImpl.postYzm(phone, yzm, 2);
		
		if(bool){
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.ERROR_INFO, "验证码不正确!");
		}
		
		return map;
	}
	
	
	/**
	 * 方法描述：修改用户密码 返回类型：ModelAndView
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forget/update",method=RequestMethod.POST)
	@ResponseBody
	public ReqResponse<String> update(String phone,String password) {
		ReqResponse<String> req = sysUserService.updatePasswordByPhone(phone, password);
		
		return req;
	}

	
	/**
	 * 获取邮箱后缀
	 * 判断邮箱url
	 * @param email
	 * @return
	 */
    public String emailUrl(String email){
    	String url = email.split("@")[1];
    	url = url.toLowerCase();
        if ("163.com".equals(url)) {
            return "http://mail.163.com";
        } else if ("vip.163.com".equals(url)) {
            return "http://vip.163.com";
        } else if ("126.com".equals(url)) {
            return "http://mail.126.com";
        } else if ("qq.com".equals(url) || "vip.qq.com".equals(url) || "foxmail.com".equals(url)) {
            return "http://mail.qq.com";
        } else if ("gmail.com".equals(url)) {
            return "http://mail.google.com";
        } else if ("sohu.com".equals(url)) {
            return "http://mail.sohu.com";
        } else if ("tom.com".equals(url)) {
            return "http://mail.tom.com";
        } else if ("vip.sina.com".equals(url)) {
            return "http://vip.sina.com";
        } else if ("sina.com.cn".equals(url) || "sina.com".equals(url)) {
            return "http://mail.sina.com.cn";
        } else if ("yahoo.com.cn".equals(url) || "yahoo.cn".equals(url)) {
            return "http://mail.cn.yahoo.com";
        } else if ("yeah.net".equals(url)) {
            return "http://www.yeah.net";
        } else if ("21cn.com".equals(url)) {
            return "http://mail.21cn.com";
        } else if ("hotmail.com".equals(url)) {
            return "http://www.hotmail.com";
        } else if ("sogou.com".equals(url)) {
            return "http://mail.sogou.com";
        } else if ("188.com".equals(url)) {
            return "http://www.188.com";
        } else if ("139.com".equals(url)) {
            return "http://mail.10086.cn";
        } else if ("189.cn".equals(url)) {
            return "http://webmail15.189.cn/webmail";
        } else if ("wo.com.cn".equals(url)) {
            return "http://mail.wo.com.cn/smsmail";
        } else {
            return "http://www."+url;
        }
    }
}
