package com.shifeng.webapi.interceptor;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSONObject;
import com.shifeng.response.ReqResponse;
/**
 * ResponseBody 返回数据拦截打印
 * @author WinZhong
 *
 */
@ControllerAdvice
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<Object> {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		logger.info("-----------------------ResponseBody 返回结果-----------------------");
		//System.out.println("-----------------------ResponseBody 返回-----------------------");
		if (null != body) {
			if(body instanceof ReqResponse){
				logger.info(JSONObject.toJSONString(body));
				//System.out.println(JSONObject.toJSONString(body));
			}else{
				logger.info(body.toString());
			}
		}
		logger.info("--------------------------------------------------------------");
		return body;
	}

}