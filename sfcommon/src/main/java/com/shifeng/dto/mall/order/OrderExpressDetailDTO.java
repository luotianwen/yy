package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.List;

import com.shifeng.dto.express.ExpressTraceDTO;
/** 
 * 订单快递明细DTO
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:31 
 */  
public class OrderExpressDetailDTO extends OrderExpressDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 物流跟踪信息
	 */
    private List<ExpressTraceDTO> expressTraceList;


	public List<ExpressTraceDTO> getExpressTraceList() {
		return expressTraceList;
	}


	public void setExpressTraceList(List<ExpressTraceDTO> expressTraceList) {
		this.expressTraceList = expressTraceList;
	}
    
    
     
	
}
