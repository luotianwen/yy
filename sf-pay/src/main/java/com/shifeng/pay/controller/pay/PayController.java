package com.shifeng.pay.controller.pay;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.shifeng.common.PaymentType;
import com.shifeng.pay.controller.BaseController;
import com.shifeng.pay.dto.PayDTO;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.pay.sdk.weixin.protocol.PayResData;
import com.shifeng.pay.service.order.UnpaidOrderService;
import com.shifeng.pay.util.alipay.AliPayTool;
import com.shifeng.pay.util.tenpay.TenPayTool;
import com.shifeng.pay.util.weixinpay.WeiXinPayTool;
import com.shifeng.util.IdWorker;
import com.shifeng.util.redis.RedisTool;

/**
 * 统一支付入口
 * @author WinZhong
 *
 */
@Controller
public class PayController extends BaseController{
	
	/**
	 * 未支付订单Service
	 */
	 @Resource(name="unpaidOrderServiceImpl")
	 UnpaidOrderService unpaidOrderService;

	/**
	 * PC支付
	 * @param mv
	 * @param session
	 * @param request
	 * @param payDTO
	 * @return
	 */
	@RequestMapping(value="/pay")
	public ModelAndView pay(ModelAndView mv,HttpSession session,HttpServletResponse response,HttpServletRequest request,PayDTO payDTO){
		if(payDTO.isNotEmpty()){
			if(payDTO.checkSign()){
				/*UnpaidOrderInfo orderInfo = new UnpaidOrderInfo();
				orderInfo.setOrder_body("测试订单");
				orderInfo.setOrder_id(""+IdWorker.getId());
				orderInfo.setOrder_name("测试商品");
				orderInfo.setOrder_type("ware");
				orderInfo.setTotal_fee(0.01);
				System.out.println(payDTO.toString());*/
		
				//payDTO.setOrder_id("12345678");
				//payDTO.setOrder_type("ware");
				UnpaidOrderInfo orderInfo = unpaidOrderService.getUnpaidOrderInfo(payDTO.getOrder_id(), payDTO.getOrder_type());
				//orderInfo.setOrder_id(""+IdWorker.getId());
				if(orderInfo == null){
					mv.addObject("msg", "订单不存在或已经支付");
					mv.setViewName("error/result");
					return mv;
				}else{
					try {
						String key = payDTO.getOrder_type()+payDTO.getOrder_id();
						RedisTool.set(key, orderInfo.getOrder_name());
						RedisTool.expire(key, 1*60*30);
					} catch (Exception e) {
						logger.error("存储订单名字报错：订单id："+payDTO.getOrder_id(), e);
					}				
				}
				System.out.println(orderInfo.toString());
				 switch (payDTO.getPayment_type()) {
					case PaymentType.ALIPAY://支付宝支付
						
						String payHtml = AliPayTool.createPayReq(orderInfo);
						mv.addObject("payHtml", payHtml);
						mv.setViewName("alipay/alipay");
						break;
					case PaymentType.WEIXINPAY://微信支付
					 
						PayResData payResData = WeiXinPayTool.createPayReq(orderInfo,WeiXinPayTool.TRADETYPE_NATIVE,null);
						
						mv.addObject("payRes", payResData);
						mv.addObject("order_id", payDTO.getOrder_id());
						mv.addObject("order_type", payDTO.getOrder_type());
						mv.setViewName("weixinpay/weixinpay");
						break;
					case PaymentType.TENPAY://财付通支付
					 
						 String payHtmls = TenPayTool.createPayReq(orderInfo, response, request);
						
						mv.addObject("payHtml", payHtmls);
						mv.setViewName("tenpay/tenpay");
						break;

					default:
						mv.addObject("msg", "支付参数错误，不支持的支付方式");
						mv.setViewName("error/result");
						break;
				}
			}else{
				mv.addObject("msg", "支付信息被篡改");
				mv.setViewName("error/result");
			}
		}else{
			mv.addObject("msg", "支付参数错误");
			mv.setViewName("error/result");
		}
		return mv;
	}
	
	/**
	 * WAP支付
	 * @param mv
	 * @param session
	 * @param request
	 * @param payDTO
	 * @return
	 */
	@RequestMapping(value="/wapPay")
	public ModelAndView wapPay(ModelAndView mv,HttpSession session,HttpServletResponse response,HttpServletRequest request,PayDTO payDTO){
			if(payDTO.isWapNotEmpty()){
				if(payDTO.checkWapSign()){
/*					UnpaidOrderInfo orderInfo = new UnpaidOrderInfo();
					orderInfo.setOrder_body("测试订单");
					orderInfo.setOrder_id(""+IdWorker.getId());
					orderInfo.setOrder_name("测试商品");
					orderInfo.setOrder_type("PT");
					orderInfo.setTotal_fee(0.01);
					System.out.println(payDTO.toString());*/
					/*session.setAttribute("type", "wap");*/
					UnpaidOrderInfo orderInfo = unpaidOrderService.getUnpaidOrderInfo(payDTO.getOrder_id(), payDTO.getOrder_type());
					logger.info(payDTO.toString());
					logger.info(orderInfo.toString());
					if(orderInfo == null){
						mv.addObject("msg", "订单不存在或已经支付");
						mv.setViewName("error/result");
						return mv;
					}else{
						try {
							String key = payDTO.getOrder_type()+payDTO.getOrder_id();
							RedisTool.set(key, orderInfo.getOrder_name());
							RedisTool.expire(key, 1*60*30);
						} catch (Exception e) {
							logger.error("存储订单名字报错：订单id："+payDTO.getOrder_id(), e);
						}
					}
					
					
					 switch (payDTO.getPayment_type()) {
						case PaymentType.ALIPAY://支付宝支付
							
							String payHtml = AliPayTool.createWapPayReq(orderInfo);
							mv.addObject("payHtml", payHtml);
							mv.setViewName("alipay/alipay");
							break;
						case PaymentType.WEIXINPAY://微信支付
						 
							PayResData payResData = WeiXinPayTool.createPayReq(orderInfo,WeiXinPayTool.TRADETYPE_JSAPI,payDTO.getOpenid());
							//mv = new ModelAndView(new MappingJackson2JsonView());  
							//mv.addObject("data", payResData);  
							mv.addObject("payRes", payResData);
							mv.setViewName("weixinpay/weixinpay");
							break;
						/*case PaymentType.TENPAY://财付通支付
						 
							String payHtmls = TenPayTool.createPayReq(orderInfo, response, request);
							mv.addObject("payHtml", payHtmls);
							mv.setViewName("tenpay/tenpay");
							break;*/
		
						default:
							mv.addObject("msg", "支付参数错误，不支持的支付方式");
							mv.setViewName("error/result");
							break;
					}
				}else{
					mv.addObject("msg", "支付信息被篡改");
					mv.setViewName("error/result");
				}
			}else{
				mv.addObject("msg", "支付参数错误");
				mv.setViewName("error/result");
			}
			return mv;
	}
	
	/**
	 * APP支付
	 * @param mv
	 * @param session
	 * @param request
	 * @param payDTO
	 * @return
	 */
	@RequestMapping(value="/appPay")
	@ResponseBody
	public Object appPay(HttpServletResponse response,HttpServletRequest request,PayDTO payDTO){
		String body = null;
		//if(payDTO.isWapNotEmpty()){
			//if(payDTO.checkWapSign()){
					UnpaidOrderInfo orderInfo = new UnpaidOrderInfo();
					orderInfo.setOrder_body("测试订单");
					orderInfo.setOrder_id(""+IdWorker.getId());
					orderInfo.setOrder_name("测试商品");
					orderInfo.setOrder_type("PT");
					orderInfo.setTotal_fee(0.01);
					System.out.println(payDTO.toString());
					 switch (payDTO.getPayment_type()) {
						case "alipay"://支付宝支付
							
							body = AliPayTool.createAppPayReq(orderInfo);
							break;
						case "weixinpay"://微信支付
						 
							PayResData payResData = WeiXinPayTool.createPayReq(orderInfo,WeiXinPayTool.TRADETYPE_JSAPI,null);
							
						/*	mv.addObject("payRes", payResData);
							mv.setViewName("weixinpay/weixinpay");*/
							break;
						case "tenpay"://财付通支付
						 
							 String payHtmls = TenPayTool.createPayReq(orderInfo, response, request);
							
							/*mv.addObject("payHtml", payHtmls);
							mv.setViewName("tenpay/tenpay");*/
							break;
		
						default:
							/*mv.addObject("msg", "支付参数错误");
							mv.setViewName("error/result");*/
							break;
					}
				/*}else{
					mv.addObject("msg", "支付信息被篡改");
					mv.setViewName("error/result");
				}
			}else{
				mv.addObject("msg", "支付参数错误");
				mv.setViewName("error/result");
			}*/
		
		
		
		return body;
	}
	
}
