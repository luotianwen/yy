package com.shifeng.mall.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Token 拦截器
 * <p/>
 * Created by caobug on 14-8-15.
 */
public class FormTokenInterceptor extends HandlerInterceptorAdapter {

    public final static String TOKEN_NAME = "mallresubmitToken";

    /**
     * 方法处理前处理
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        FormToken formToken = method.getAnnotation(FormToken.class);
        if (null != formToken) {
            if ((formToken.produce() && formToken.remove()) || (!formToken.produce() && !formToken.remove())) {
                throw new RuntimeException("请不要在同一个方法上同时注解：@FormToken(remove = true/false, produce = true/false)");
            } else if (formToken.produce()) {
                request.getSession().setAttribute(TOKEN_NAME, UUID.randomUUID().toString());
            } else if (formToken.remove()) {
                String serverToken = (String) request.getSession().getAttribute(TOKEN_NAME);
                String clientToken = request.getParameter(TOKEN_NAME);
                request.getSession().removeAttribute(TOKEN_NAME); // remove token
                if (!StringUtils.equals(serverToken, clientToken)) {
                    if (null != method.getAnnotation(ResponseBody.class)) { // JSON
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        PrintWriter out = response.getWriter();
                        Map map=new HashMap();
                        map.put("code",500);
                        map.put("msg","重复提交");
                        String jsonText = JSON.toJSONString(map, true);
                        out.print(jsonText);
                        out.flush();
                        out.close();
                    } else { // 普通页面
                        request.getRequestDispatcher("500").forward(request, response);
                    }
                    return false;
                }
            }
        }
        return super.preHandle(request, response, handler);
    }
}
