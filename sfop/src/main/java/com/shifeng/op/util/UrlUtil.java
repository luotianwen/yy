package com.shifeng.op.util;

import com.shifeng.op.shiro.CustomizedPropertyConfigurer;

/**
 * Created by yongshi on 2017/2/21.
 */
public class UrlUtil {
    public static String getImgUrl(){
        return CustomizedPropertyConfigurer.getContextProperty("img.url").toString();
    }
    public static String getLogout(){
        return CustomizedPropertyConfigurer.getContextProperty("cas.logout").toString();
    }
}
