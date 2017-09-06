package com.shifeng.webapi.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;
import com.shifeng.entity.user.SysUser;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Common;
import com.shifeng.util.MD5Util;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;

 
/**
 * 
 * @author WinZhong
 *
 */
public class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	 /**用户id*/
	protected String user_id;
	
	/**
     * 把request中的参数封装到指定的bean中
     *
     * @param request
     * @param obj
     * @return Object
     * @author WinZhong
     */
    public Object packReturnByRequest(HttpServletRequest request,Object obj) {
        Map<String, Object> keyMap = findKeyMapByRequest(request);
        Field field = null;
        Set<String> keys = keyMap.keySet();
        for (String key : keys) {
            try {
                field = obj.getClass().getDeclaredField(key);
                Class<?> beanType = field.getType();
                Object value = keyMap.get(key);
                String setMethodName = "set"+ key.substring(0, 1).toUpperCase() + key.substring(1);
                Method m;
                m = obj.getClass().getMethod(setMethodName, beanType);
                m.invoke(obj, value);
            } catch (Exception e1) {
                continue;
            }
        }
        return obj;
    }

    /**
     * 把request里面的参数转化成map
     *
     * @param request
     * @return Map<String,Object>
     * @author WinZhong
     */
    public Map<String, Object> findKeyMapByRequest(HttpServletRequest request) {
        Map<String, Object> keyMap = new HashMap<String, Object>();
        Enumeration<String> enu = request.getParameterNames();
        String[] item ;
        while (enu.hasMoreElements()) {
            String paramname = enu.nextElement();
            item = request.getParameterValues(paramname);
            if(item.length == 1){
                //String paramvalue = request.getParameter(paramname);
                keyMap.put(paramname, item[0]);
            }else{
            	keyMap.put(paramname, item);
            }

        }
        return keyMap;
    }
	
	/**
	 * 获取页面传递的某一个参数值,
	 */
	public String getParameter(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		
		return request.getParameter(key);
	}

	/**
	 * 获取页面传递的某一个数组值,
	 */
	public String[] getParameterValues(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request.getParameterValues(key);
	}
	
	/**
	 * 验证ticket
	 * @param ticket 需要验证的ticket
	 * @deprecated Use {@link #visitInspect(String,String,com.shifeng.response.ReqResponse)}
	 * @return
	 */
	@Deprecated
	public boolean checkTicket(String ticket,ReqResponse<?> req){
		String key = String.format(Constant.TICKET_KEY, ticket);
		String rTicket = RedisTool.get(key);
		if(Objects.equal(ticket, rTicket)){
			return true;
		}else{
			req.setCode(ErrorMsg.INVALID_GET_PROGRAM.getCode());
			req.setMsg(ErrorMsg.INVALID_GET_PROGRAM.getMsg());
			return false;
		}
	}
	
	/**
	 * 访问检查  验证ticket有效性以及接口调用频次
	 * @param ticket
	 * @param method
	 * @param req
	 * @return
	 */
	public boolean visitInspect(String ticket,String method,ReqResponse<?> req){
		if(checkTicket(ticket, req)){
			if(isGoOnVisit(ticket, method, req)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 根据token获取用户id
	 * @param token 用户登录token
	 * @param req
	 * @return 用户id
	 */
	public String getUserId(String token,ReqResponse<?> req){
		String key = String.format(Constant.USER_ID_TOKEN_KEY, token);
		String userId = RedisTool.get(key);
		if(StringUtils.isNotBlank(userId)){
			logger.info("登录用户ID："+userId);
			return userId;
		}else{
			req.setCode(ErrorMsg.USER_NO_LOGIN.getCode());
			req.setMsg(ErrorMsg.USER_NO_LOGIN.getMsg());
			return null;
		}
	}
	
	/**
	 * 根据token获取用户登录信息
	 * @param token 用户登录token
	 * @param req
	 * @return 用户登录信息
	 */
	public SysUser getUser(String token,ReqResponse<?> req){
		String key = String.format(Constant.USER_TOKEN_KEY, token);
		String data = RedisTool.get(key);
		System.out.println("========="+data);
		if(StringUtils.isNotBlank(data)){
			SysUser user= JSON.parseObject(data, SysUser.class);
			return user;
		}else{
			req.setCode(ErrorMsg.USER_NO_LOGIN.getCode());
			req.setMsg(ErrorMsg.USER_NO_LOGIN.getMsg());
			return null;
		}
	}
	

	
	/**
	 * 验证签名
	 * @param sign 签名
	 * @param content 待签名数据
	 * @param req
	 * @return
	 */
	public boolean verifySign(String sign,String content,ReqResponse<?> req){
		String sysSign = MD5Util.hex(content);
		logger.info("待签名内容："+content);
		logger.info("客户端签名："+sign);
		logger.info("服务端端签名："+sysSign);
		//验证签名
		if(Objects.equal(sign, sysSign)){
			return true;
		}else{
			req.setCode(ErrorMsg.INVALID_SIGN.getCode());
			req.setMsg(ErrorMsg.INVALID_SIGN.getMsg());
			return false;
		}
	}
	
	/**
	 * 是否能继续获取访问
	 * @param ticket
	 * @param method	方法名
	 * @deprecated Use {@link #visitInspect(String,String,com.shifeng.response.ReqResponse)}
	 * @return
	 */
	@Deprecated
	public boolean isGoOnVisit(String ticket,String method){//getVisitFrequency
		String key = String.format(Constant.VISIT_COUNT_KEY, ticket,method);
		String val = RedisTool.get(key);
		int count =0;
		try {
			count = Integer.valueOf(val);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		if(count>=Constant.MINUTE_MAX_VISIT_COUNT){
			return false;
		}else{
			RedisTool.incrBy(key, 1);
			//设置过期时间 单位：秒
			RedisTool.expire(key, 60);
			return true;
		}
		
	}
	/**
	 * 是否能继续获取访问
	 * @param ticket
	 * @param method	方法名
	 * @param req
	 * @deprecated Use {@link #visitInspect(String,String,com.shifeng.response.ReqResponse)}
	 * @return
	 */
	@Deprecated
	public boolean isGoOnVisit(String ticket,String method,ReqResponse<?> req){//getVisitFrequency
		//验证ticket是否为空
		if(!StringUtils.isNotBlank(ticket)){
			req.setCode(ErrorMsg.INVALID_GET_PROGRAM.getCode());
			req.setMsg(ErrorMsg.INVALID_GET_PROGRAM.getMsg());
			return false;
		}
		if(isGoOnVisit(ticket, method)){
			return true;
		}else{
			req.setCode(ErrorMsg.APP_CALL_LIMITED.getCode());
			req.setMsg(ErrorMsg.APP_CALL_LIMITED.getMsg());
			return false;
		}
	}
	
	
	/**
	 * 登录检验
	 * @param token
	 * @param method
	 * @param req
	 * @return
	 */
	public boolean checkLogin(String token, String method, ReqResponse<?> req){
		boolean bl = false;
		//是否能继续获取访问
		if(isGoOnVisit(token, method, req)){
			bl = true;
		}
		user_id = getUserId(token, req);
		if(user_id == null){//用户未登录
			bl = false;
		}else{
			bl = true;
		}
		return bl;
	}
	

	
	
	/**
	 * 登录检验
	 * @param token
	 * @return
	 */
	public boolean checkLogin(String token){
		boolean bl = false;
		if(!StringUtils.isNotBlank(token)){
			return bl;
		}
		String key = String.format(Constant.USER_ID_TOKEN_KEY, token);
		String userId = RedisTool.get(key);
		if(StringUtils.isNotBlank(userId)){
			user_id =  userId;
			bl = true;
		}
		return bl;
	}
	
	@ModelAttribute
	public void init(HttpServletRequest request,HttpServletResponse response) {
		logger.info("请求url："+request.getServletPath());
		logger.info("请求ip："+Common.getRemoteAddrIp(request));
		logger.info("请求参数："+findKeyMapByRequest(request)/*request.getParameterMap()*/);
	}
	 

}