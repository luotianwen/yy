package com.shifeng.pay.controller.order;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.common.OrderType;
import com.shifeng.pay.config.PayReturnUrl;
import com.shifeng.pay.controller.BaseController;
import com.shifeng.pay.entity.order.OrderPayInfo;
import com.shifeng.pay.service.order.OrderService;
import com.shifeng.util.MD5Util;


@Controller
@RequestMapping(value="/order")
public class OrderController extends BaseController{
	
	 @Resource(name="orderServiceImpl")
	 OrderService orderService;
	
	
	/**
	 * 获取订单支付信息
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @return
	 */
	@RequestMapping(value="/payResult")
	@ResponseBody
	public OrderPayInfo payResult(String order_id,String order_type){
		if(StringUtils.isNotBlank(order_id) && StringUtils.isNotBlank(order_type)){
			try {
				OrderPayInfo orderPayInfo = orderService.getPayOrderInfo(order_id, order_type);
				if(orderPayInfo != null){
					/*Map<String,Object> map = new HashMap<String,Object>();
					map.put("orderId", orderPayInfo.getOrder_id() );
					map.put("total_fee", orderPayInfo.getTotal_fee());
					map.put("order_type", orderPayInfo.getOrder_type());
					map.put("token", MD5Util.hexSALT(orderPayInfo.getOrder_id()+orderPayInfo.getTotal_fee()+orderPayInfo.getOrder_type()));*/
					orderPayInfo.setToken(MD5Util.hexSALT(orderPayInfo.getOrder_id()+orderPayInfo.getTotal_fee()+orderPayInfo.getOrder_type()));
					if(Objects.equals(OrderType.WARES, orderPayInfo.getOrder_type()) || Objects.equals(OrderType.WARE, orderPayInfo.getOrder_type())){//商品订单
						//map.put("return_url", PayReturnUrl.PC_PAY_RETURN_URL);
						orderPayInfo.setReturn_url(PayReturnUrl.PC_PAY_RETURN_URL);
					}else if(Objects.equals(OrderType.SHOP, orderPayInfo.getOrder_type())){//商家店铺入驻续费订单
						//map.put("return_url", PayReturnUrl.SHOP_RETURN_URL);
						orderPayInfo.setReturn_url(PayReturnUrl.SHOP_RETURN_URL);
					}
					return orderPayInfo;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
