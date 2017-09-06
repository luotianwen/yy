package com.shifeng.webapi.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shifeng.common.OrderType;
import com.shifeng.common.PaymentMethod;
import com.shifeng.common.PaymentType;
import com.shifeng.dto.express.ExpressTraceDTO;
import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.OrderExpressDetailDTO;
import com.shifeng.dto.mall.order.OrderInfoDTO;
import com.shifeng.dto.mall.order.OrderPayConfirmDTO;
import com.shifeng.dto.mall.order.OrderPreviewInfoDTO;
import com.shifeng.dto.mall.order.OrderServiceDetailDTO;
import com.shifeng.dto.mall.order.OrderSettlementDTO;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.dto.mall.order.ServiceApplyDTO;
import com.shifeng.entity.mall.UnpaidOrderInfo;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.MD5Util;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.FreightService;
import com.shifeng.webapi.service.order.OrderService;
import com.shifeng.webapi.service.user.AddressService;

/**
 * 订单API接口 Controller
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "orderServiceImpl")
	protected OrderService orderService;
	
	@Resource(name = "addressServiceImpl")
	protected AddressService addressService;
	
	@Resource(name = "freightServiceImpl")
	protected FreightService freightService;
	
	
	
	/**
	 * 确认订单
	 * @param version
	 * @param token
	 * @param products 购买商品信息json串 示例：[{"sku":"3","pcount":"1"},{"sku":"63","pcount":"2"},{"sku":"47","pcount":"3"}]
	 * @param sign (version+token+products)
	 * @return
	 */
	@RequestMapping(value = "/confirm_order")
	@ResponseBody
	public ReqResponse<Map<String,Object>> confirm_order(String version,String token,String products,String sign){
		ReqResponse<Map<String,Object>> req = new ReqResponse<Map<String,Object>>();
    	//登录验证
		if(!checkLogin(token, "order/confirm_order", req)){
		//	return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+products,req)){
					//OrderPreloadingDTO
					//user_id = "23";
					List<OrderWareDTO>  orderWareList = JSON.parseArray(products, OrderWareDTO.class); 
					System.out.println(orderWareList);
					List<OrderPreviewInfoDTO> productList = orderService.getOrderPreviewInfo(orderWareList);
					//获取默认收货地址
					MallUserAddressDTO address = addressService.getDefaultAddress(user_id);

					//计算运费
					List<MallShopWareFreight> shopWareFreights  = null;
					if(address != null){
						//计算运费
						shopWareFreights = freightService.getWareFreights(orderWareList, address.getProvince()+""); 
						
					}
					
					Map<String,Object> map = new HashMap<String,Object>();
					
					map.put("address", address);
					map.put("products", productList);
					map.put("shopWareFreights", shopWareFreights);
					req.setData(map);
					/*String key = String.format(Constant.ORDER_STAY_SETTLEMENT, token);
					//token写入redis缓存
					RedisTool.set(key, JSON.toJSONString(o));
					//设置过期时间 单位：秒
					RedisTool.expire(key, 1*60*30);*/
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	/**
	 * 订单结算
	 * @param version
	 * @param token
	 * @param orderInfo
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/settlement")
	@ResponseBody
	public ReqResponse<OrderPayConfirmDTO> settlement(String version,String token,String orderInfo,String sign){
		ReqResponse<OrderPayConfirmDTO> req = new ReqResponse<OrderPayConfirmDTO>();
    	//登录验证
		if(!checkLogin(token, "order/settlement", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+orderInfo,req)){
					OrderSettlementDTO  orderSettlementInfo = JSON.parseObject(orderInfo, OrderSettlementDTO.class); 
					System.out.println(orderSettlementInfo);
					if(orderSettlementInfo.getAddressId() == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("请选择收货地址");
					}else{
						OrderPayConfirmDTO orderPayConfirm = orderService.settlement(user_id,orderSettlementInfo,req);
						if(orderPayConfirm == null){
							req.setCode(ErrorMsg.FAIL.getCode());
						}else{
							req.setData(orderPayConfirm);
						}
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	
	/**
	 * 订单支付请求
	 * @param version
	 * @param token
	 * @param orderId 订单号	
	 * @param type 订单类型（1：父订单；2：子订单） 不传默认1
	 * @param sign  md5(version + token + orderId+type)
	 * @return
	 */
	@RequestMapping(value = "/reqPay")
	@ResponseBody
	public ReqResponse<Map<String,Object>> reqPay(String version,String token,String orderId,Integer type,String sign){
		ReqResponse<Map<String,Object>> req = new ReqResponse<Map<String,Object>>();
    	//登录验证
		if(!checkLogin(token, "order/reqPay", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				String c = version+token+orderId;
				//订单类型
				String order_type = OrderType.WARES;
				if(type == null){
					type = 1;
				}else if( type == 2){
					c = c+type;
					order_type = OrderType.WARE;
			    }else{
			    	c = c+type;
			    }
				//验证签名
				if(this.verifySign(sign, c,req)){
					UnpaidOrderInfo unpaidOrderInfo = orderService.getUnpaidOrderInfo(user_id, orderId,type);
					if(unpaidOrderInfo == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("订单不存在或已支付");
					}else{
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("total_fee", unpaidOrderInfo.getTotal_fee());
						String alipaySign = MD5Util.hexSALT(PaymentType.ALIPAY+PaymentMethod.DEFAULT+order_type+orderId);
						map.put("aliPayUrl", Constant.pay_system_url+"/wapPay?payment_type="+PaymentType.ALIPAY+"&payment_method="+PaymentMethod.DEFAULT+"&order_id="+orderId+"&order_type="+order_type+"&sign="+alipaySign);
						

						String openid_key = String.format(Constant.WX_OPENID_TOKEN_KEY, token);
						String openid = RedisTool.get(openid_key);//"o6SDjs79lOvfp_i7r8s9OvVdGWAI";//RedisTool.get(openid_key);
						if(StringUtils.isNotBlank(openid)){
							String weixinpaySign = MD5Util.hexSALT(PaymentType.WEIXINPAY+PaymentMethod.DEFAULT+order_type+orderId+openid);
							map.put("weChatPayUrl", Constant.pay_system_url+"/weixinpay/create?payment_type="+PaymentType.WEIXINPAY+"&payment_method="+PaymentMethod.DEFAULT+"&order_id="+orderId+"&order_type="+order_type+"&openid="+openid+"&sign="+weixinpaySign);
						}
						
						
						req.setData(map);
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}
	
	
	/**
	 * 订单列表
	 * @param version
	 * @param token
	 * @param order_id	订单id【可为空】
	 * @param state	订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；）【可为空】
	 * @param comment 查看未评价订单(2未评价)【可为空】
	 * @param currentPage 当前页
	 * @param sign  md5(version + token + ...)
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public ReqResponse<Page> list(String version,String token, String order_id,Integer state,Integer comment,int currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
    	//登录验证
		if(!checkLogin(token, "order/list", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				StringBuffer content = new StringBuffer();
				content.append(version+ token);
				if(!StringUtils.isBlank(order_id)){
					content.append(order_id);
				}
				if(state != null){
					content.append(state);
					//System.out.println("*********************"+state);
				}
				if(comment != null){
					content.append(comment);
					//System.out.println("*********************"+comment);
				}
				content.append(currentPage);
				//验证签名
				if(this.verifySign(sign, content.toString(),req)){
					Page page = orderService.getOrderList(user_id, order_id, state,comment, currentPage);
					req.setData(page);
				}
				
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}	
	
	/**
	 * 售后订单列表
	 * @param version
	 * @param token
	 * @param order_id	订单id【可为空】
	 * @param currentPage 当前页
	 * @param sign  md5(version + token + ...)
	 * @return
	 */
	@RequestMapping(value = "/repairList")
	@ResponseBody
	public ReqResponse<Page> repairList(String version,String token, String order_id,int currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
    	//登录验证
		if(!checkLogin(token, "order/repairList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				StringBuffer content = new StringBuffer();
				content.append(version+ token);
				if(!StringUtils.isBlank(order_id)){
					content.append(order_id);
				}
				content.append(currentPage);
				//验证签名
				if(this.verifySign(sign, content.toString(),req)){
					Page page = orderService.getRepairOrderList(user_id,currentPage);
					req.setData(page);
				}
				
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}	
	
	
	
	/**
	 * 售后商品列表
	 * @param version
	 * @param token
	 * @param currentPage 当前页
	 * @param sign  md5(version + token + currentPage)
	 * @return
	 */
	@RequestMapping(value = "/repairWareList")
	@ResponseBody
	public ReqResponse<Page> repairWareList(String version,String token,int currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
    	//登录验证
		if(!checkLogin(token, "order/repairWareList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				StringBuffer content = new StringBuffer();
				content.append(version+ token);
				content.append(currentPage);
				//验证签名
				if(this.verifySign(sign, content.toString(),req)){
					Page page = orderService.getRepairOrderWareList(user_id,currentPage);
					req.setData(page);
				}
				
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}
	
	
	/**
	 * 订单明细
	 * @param version
	 * @param token
	 * @param order_id 	订单id 	
	 * @param sign  md5(version + token + order_id)
	 * @return
	 */
	@RequestMapping(value = "/details")
	@ResponseBody
	public ReqResponse<OrderInfoDTO> details(String version,String token,String order_id,String sign){
		ReqResponse<OrderInfoDTO> req = new ReqResponse<OrderInfoDTO>();
    	//登录验证
		if(!checkLogin(token, "order/details", req)){
			return req;
		}
		
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+order_id,req)){
					OrderInfoDTO orderInfo = orderService.getOrderInfo(user_id, order_id);
					if(orderInfo == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("订单不存在");
					}else{ 
						req.setData(orderInfo);
					}
				}
				 
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}	
	
	
	
	/**
	 * 订单取消
	 * @param version
	 * @param token
	 * @param order_id 	订单id 	
	 * @param reason	取消订单原因ID
	 * @param sign  md5(version + token + order_id+reason)
	 * @return
	 */
	@RequestMapping(value = "/cancel")
	@ResponseBody
	public ReqResponse<String> cancel(String version,String token,String order_id,int reason,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//登录验证
		if(!checkLogin(token, "order/cancel", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+order_id+reason,req)){
					boolean bl = orderService.cancelOrder(user_id, order_id,reason);
					if(!bl){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("订单取消失败");
						req.setData("订单取消失败");
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}	
	
	
	
	
	
	/**
	 * 订单售后申请
	 * @param version
	 * @param token
	 * @param order_id 	订单id 	
	 * @param wareId 商品ID（sku）
	 * @param applyType	服务类型(1换货 2退款3退款退货 4维修 )
	 * @param questionDesc	问题描述
	 * @param sign  md5(version + token + applyInfo)
	 * @return
	 */
	@RequestMapping(value = "service/apply")//repair
	@ResponseBody
	public ReqResponse<String> serviceApply(String version,String token,String applyInfo,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//登录验证
		if(!checkLogin(token, "order/serviceApply", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+applyInfo,req)){
					ServiceApplyDTO serviceApply = JSON.parseObject(applyInfo, ServiceApplyDTO.class); 
					serviceApply.setUserId(user_id);
					boolean bl = orderService.serviceApply(serviceApply);
					if(!bl){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("订单售后申请失败");
						req.setData("订单售后申请失败");
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}		
	
	/**
	 * 订单退款
	 * @param version
	 * @param token
	 * @param order_id 	订单id 	
	 * @param reason	订单退款原因ID
	 * @param sign  md5(version + token + order_id+reason)
	 * @return
	 */
	@RequestMapping(value = "/refund")
	@ResponseBody
	public ReqResponse<String> refund(String version,String token,String order_id,int reason,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//登录验证
		if(!checkLogin(token, "order/refund", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+order_id+reason,req)){
					boolean bl = orderService.orderRefund(user_id, order_id,reason);
					if(!bl){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("订单退款失败");
						req.setData("订单退款失败");
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	
	/**
	 * 订单确认收货
	 * @param version
	 * @param token
	 * @param order_id 	订单id 	
	 * @param sign  md5(version + token + order_id)
	 * @return
	 */
	@RequestMapping(value = "/confirm")
	@ResponseBody
	public ReqResponse<String> confirm(String version,String token,String order_id,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
    	//登录验证
		if(!checkLogin(token, "order/confirm", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+order_id,req)){
					boolean bl = orderService.orderConfirm(user_id, order_id);
					if(!bl){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("确认收货失败");
						req.setData("确认收货失败");
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	/**
	 * 订单物流跟踪
	 * @param version
	 * @param token
	 * @param order_id 	订单id 	
	 * @param expressCode 快递代码
	 * @param expressNumber	快递单号
	 * @param sign  md5(version + token + order_id + expressCode + expressNumber)
	 * @return
	 */
	@RequestMapping(value = "/expressTrace")
	@ResponseBody
	public ReqResponse<List<ExpressTraceDTO>> expressTrace(String version,String token,String order_id,String expressCode,String expressNumber,String sign){
		ReqResponse<List<ExpressTraceDTO>> req = new ReqResponse<List<ExpressTraceDTO>>();
    	//登录验证
		if(!checkLogin(token, "order/expressTrace", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+order_id,req)){
					List<ExpressTraceDTO> expressTraceList = orderService.getExpressTrace(expressCode, expressNumber);
					req.setData(expressTraceList);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	

	
	/**
	 * 根据订单号获取订单物流信息
	 * @param version
	 * @param token
	 * @param order_id 	订单id 	
	 * @param sign  md5(version + token + order_id)
	 * @return
	 */
	@RequestMapping(value = "/getOrderExpress")
	@ResponseBody
	public ReqResponse<List<OrderExpressDetailDTO>> getOrderExpress(String version,String token,String order_id,String sign){
		ReqResponse<List<OrderExpressDetailDTO>> req = new ReqResponse<List<OrderExpressDetailDTO>>();
    	//登录验证
		if(!checkLogin(token, "order/getOrderExpress", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+order_id,req)){
					List<OrderExpressDetailDTO> expressList = orderService.getOrderExpress(user_id,order_id);
					req.setData(expressList);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	/**
	 * 售后单明细
	 * @param version
	 * @param token
	 * @param serviceNumber 售后服务单号
	 * @param sign  md5(version + token + serviceNumber)
	 * @return
	 */
	@RequestMapping(value = "/repairDetail")
	@ResponseBody
	public ReqResponse<OrderServiceDetailDTO> repairDetail(String version,String token,String serviceNumber,String sign){
		ReqResponse<OrderServiceDetailDTO> req = new ReqResponse<OrderServiceDetailDTO>();
    	//登录验证
		if(!checkLogin(token, "order/repairDetail", req)){
			return req;
		}
		
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+serviceNumber,req)){
					OrderServiceDetailDTO orderInfo = orderService.getRepairOrderDetail(user_id, serviceNumber);
					if(orderInfo == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("售后单不存在");
					}else{ 
						System.out.println(orderInfo.toString());
						req.setData(orderInfo);
					}
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
