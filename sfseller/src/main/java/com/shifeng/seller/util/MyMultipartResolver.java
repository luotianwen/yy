package com.shifeng.seller.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
 
public class MyMultipartResolver extends CommonsMultipartResolver {
 
    @Override
    public boolean isMultipart(HttpServletRequest request) {
    	//String dir = request.getParameter("dir");
    	/* if(dir!=null){  // 上传图片的时候 不进行request 的转换
            return false;
        }
         return super.isMultipart(request);
    	 */
    	String url = request.getRequestURI();
    	if (url!=null && url.contains("/upload/ue")) {
    		return false;
    	} else {
    		return super.isMultipart(request);
    	}
    	
    }
 
}
