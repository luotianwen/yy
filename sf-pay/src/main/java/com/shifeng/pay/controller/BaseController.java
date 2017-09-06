package com.shifeng.pay.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Objects;
import com.shifeng.pay.util.Constant;
import com.shifeng.pay.util.ErrorMsg;
import com.shifeng.util.Common;
import com.shifeng.util.redis.RedisTool;
 
/**
 * 
 * @author WinZhong
 *
 */
public class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	 
	
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
	 * 是否能继续获取访问
	 * @param ticket
	 * @param method	方法名
	 * @return
	 */
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
	 * @param map
	 * @return
	 */
	public boolean isGoOnVisit(String ticket,String method,Map<String,Object> map){//getVisitFrequency
		if(isGoOnVisit(ticket, method)){
			return true;
		}else{
			map.put("code ",ErrorMsg.APP_CALL_LIMITED.getCode());
			map.put("msg", ErrorMsg.APP_CALL_LIMITED.getMsg());
			return false;
		}
	}

	
	@ModelAttribute
	public void init(HttpServletRequest request,HttpServletResponse response) {
		logger.info("请求url："+request.getServletPath());
		logger.info("请求ip："+Common.getRemoteAddrIp(request));
		logger.info("请求参数："+findKeyMapByRequest(request)/*request.getParameterMap()*/);
	}
	 

}