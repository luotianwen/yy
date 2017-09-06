package com.shifeng.provide.express;

import java.util.List;

import com.shifeng.dto.express.ExpressTraceDTO;
import com.shifeng.response.ReqResponse;

/**
 * 快递查询接口
 * @author Win
 *
 */
public interface ExpressService {
	
	
	/**
	 * 查询快递跟踪信息
	 * @param expressCode 快递代码
	 * @param expressNumber	快递单号
	 * @return
	 */
	ReqResponse<List<ExpressTraceDTO>> getExpressTrace(String expressCode,String expressNumber);
}
