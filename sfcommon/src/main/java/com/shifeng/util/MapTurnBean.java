package com.shifeng.util;

import java.util.Map;

import org.springframework.cglib.beans.BeanMap;

/**
 * 
 * @author WinZhong
 *
 */
public class MapTurnBean {
	

	/** 
	 * 将map装换为javabean对象 
	 * @param map 
	 * @param bean 
	 * @return 
	 */  
	public static <T> T mapToBean(Map<String, Object> map,T bean) {  
	    BeanMap beanMap = BeanMap.create(bean);  
	    beanMap.putAll(map);  
	    return bean;  
	}  


}
