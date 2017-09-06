package com.shifeng.util;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
/**
 * 
 * @author WinZhong
 *
 */
public class Common {
	
	
	/**
	 * 获取用户真实IP 通过Nginx转发
	 * @param request
	 * @return
	 */
	public static String getRemoteAddrIp(HttpServletRequest request) {
		
        String ipFromNginx = getHeader(request, "X-Real-IP");
        //System.out.println("ipFromNginx:" + ipFromNginx);
        //System.out.println("HTTP_X_FORWARDED_FOR:" + request.getHeader("HTTP_X_FORWARDED_FOR"));
        //System.out.println("getRemoteAddr:" + request.getRemoteAddr());
        return org.apache.commons.lang.StringUtils.isEmpty(ipFromNginx) ? request.getRemoteAddr() : ipFromNginx;
    }
    private static String getHeader(HttpServletRequest request, String headName) {
        String value = request.getHeader(headName);
        return !StringUtils.isBlank(value) && !"unknown".equalsIgnoreCase(value) ? value : "";
    }
}
