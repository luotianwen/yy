package com.shifeng.webapi.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.FreightService;

/**
 * 运费API接口
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/freight")
public class FreightController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "freightServiceImpl")
	protected FreightService freightService;
	
	
	/**
	 * 运费查询
	 * @param version
	 * @param ticket
	 * @param products 商品信息json串 示例：[{"sku":"3","pcount":"1"},{"sku":"63","pcount":"2"},{"sku":"47","pcount":"3"}]
	 * @param province
	 * @param sign (version+ticket+products+province)
	 * @return
	 */
	@RequestMapping(value = "/queryFreight")
	@ResponseBody
	public ReqResponse<List<MallShopWareFreight>> queryFreight(String version,String ticket,String products,String province,String sign){
		ReqResponse<List<MallShopWareFreight>> req = new ReqResponse<List<MallShopWareFreight>>();
		//登录验证
		if(!visitInspect(ticket, "freight/queryFreight", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+products+province,req)){

					List<OrderWareDTO>  orderWareList = JSON.parseArray(products, OrderWareDTO.class); 
					//计算运费
					List<MallShopWareFreight> shopWareFreights = freightService.getWareFreights(orderWareList,province);
				    req.setData(shopWareFreights);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
 
	 
	
	
}
