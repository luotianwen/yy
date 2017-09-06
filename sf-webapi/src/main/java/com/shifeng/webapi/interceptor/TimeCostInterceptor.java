package com.shifeng.webapi.interceptor;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.util.DateUtil;

 

/**
 * 记录信息:</br> 访问时间</br>Controller路径</br>对应方法名</br>请求参数信息</br>请求相对路径</br>请求处理时长
 * 
 * @author WinZhong
 * 
 */
public class TimeCostInterceptor implements HandlerInterceptor {

    // 业务处理器处理请求之前被调用 
	//before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);

            sb.append("-----------------------").append(DateUtil.getTime());
            sb.append("-------------------------------------\n");
            HandlerMethod h = (HandlerMethod) handler;
            sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
            sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
            sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");
            sb.append("URI       : ").append(request.getRequestURI()).append("\n");
            System.out.println(sb.toString());
        }
        return true;
    }

    //业务处理器处理请求执行完成后,生成视图之前执行
    // after the handler is executed
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        if(handler instanceof HandlerMethod){
            StringBuilder sb = new StringBuilder(1000);
            sb.append("CostTime  : ").append(executeTime).append("ms").append("\n");
            //sb.append(modelAndView.);
            sb.append("-------------------------------------------------------------------------------");
            
            System.out.println(sb.toString());
        }
    }

    
    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for(Entry<String,String[]> e:map.entrySet()){
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if(value != null && value.length == 1){
                sb.append(value[0]).append("\t");
            }else{
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }

    //在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 
    public void afterCompletion(HttpServletRequest arg0,
            HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }
}