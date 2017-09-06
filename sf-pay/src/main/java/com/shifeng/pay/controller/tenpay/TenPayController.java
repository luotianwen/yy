package com.shifeng.pay.controller.tenpay;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.shifeng.pay.controller.BaseController;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.pay.entity.pay.TenpayPaymentRecord;
import com.shifeng.pay.entity.pay.WeixinPaymentRecord;
import com.shifeng.pay.sdk.weixin.common.Util;
import com.shifeng.pay.service.order.OrderService;
import com.shifeng.pay.service.pay.TenpayPaymentRecordService;
import com.shifeng.util.IdWorker;
import com.shifeng.util.Tools;
import com.tenpay.RequestHandler;
import com.tenpay.ResponseHandler;
import com.tenpay.client.ClientResponseHandler;
import com.tenpay.client.TenpayHttpClient;
import com.tenpay.config.TenPayConfig;
import com.tenpay.util.TenpayUtil;
/**
 * 财付通支付接口
 * @author Win Zhong
 *
 */
@Controller
@RequestMapping(value="/tenPay")
public class TenPayController extends BaseController {
 
	 @Resource(name="tenpayPaymentRecordServiceImpl")
	 TenpayPaymentRecordService tenpayPaymentRecordService;
	
	 @Resource(name="orderServiceImpl")
	 OrderService orderService;
	
	/**
	 * 跳转至财付通支付页面
	 * @param page
	 * @return
	 * @throws Exception
	 */
/*	@RequestMapping("/goPay")
	public ModelAndView getDeliveryAddressList(ModelAndView mv,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws Exception{
	 
		//pd = this.getPageData();
		//---------------------------------------------------------
		//财付通网关支付请求示例，商户按照此文档进行开发即可
		//---------------------------------------------------------
		request.setCharacterEncoding("UTF-8");

	 
		
		 商品价格（包含运费），以分为单位 
		double total_fee = 1;// (pay.getOrderPrice() * 100);
		int fee = (int)total_fee;
		  
		String desc = "支付订单";

		//获取提交的订单号
		String out_trade_no= "";//pay.getOrderNo();  

		//支付方式  1:即时到帐  2:中介担保 3:后台选择
		String trade_mode= "1";//request.getParameter("trade_mode"); 

		//---------------生成订单号 开始------------------------
		//当前时间 yyyyMMddHHmmss
		//String currTime = TenpayUtil.getCurrTime();
		//8位日期
		//String strTime = currTime.substring(8, currTime.length());
		//四位随机数
		//String strRandom = TenpayUtil.buildRandom(4) + "";
		//10位序列号,可以自行调整。
		//String strReq = strTime + strRandom;
		//订单号，此处用时间加随机数生成，商户根据自己情况调整，只要保持全局唯一就行
		//String out_trade_no = strReq;
		//---------------生成订单号 结束------------------------


		String currTime = TenpayUtil.getCurrTime();
		//创建支付请求对象
		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init();
		//设置密钥
		reqHandler.setKey(TenPayConfig.key);
		//设置支付网关
		reqHandler.setGateUrl("https://gw.tenpay.com/gateway/pay.htm");

		//-----------------------------
		//设置支付参数
		//-----------------------------
		reqHandler.setParameter("partner", TenPayConfig.partner);		        //商户号
		reqHandler.setParameter("out_trade_no", out_trade_no);		//商家订单号
		reqHandler.setParameter("total_fee", String.valueOf(fee));			        //商品金额,以分为单位
		reqHandler.setParameter("return_url", TenPayConfig.return_url);		    //交易完成后跳转的URL
		reqHandler.setParameter("notify_url", TenPayConfig.notify_url);		    //接收财付通通知的URL
		reqHandler.setParameter("body", desc);	                    //商品描述
		reqHandler.setParameter("bank_type", "CIB_D");		    //银行类型(中介担保时此参数无效)
		reqHandler.setParameter("spbill_create_ip",request.getRemoteAddr());   //用户的公网ip，不是商户服务器IP
		reqHandler.setParameter("fee_type", "1");                    //币种，1人民币
		reqHandler.setParameter("subject", desc);              //商品名称(中介交易时必填)

		//系统可选参数
		reqHandler.setParameter("sign_type", "MD5");                //签名类型,默认：MD5
		reqHandler.setParameter("service_version", "1.0");			//版本号，默认为1.0
		reqHandler.setParameter("input_charset", "UTF-8");            //字符编码
		reqHandler.setParameter("sign_key_index", "1");             //密钥序号


		//业务可选参数
		reqHandler.setParameter("attach", "");                      //附加数据，原样返回
		reqHandler.setParameter("product_fee", "");                 //商品费用，必须保证transport_fee + product_fee=total_fee
		reqHandler.setParameter("transport_fee", "0");               //物流费用，必须保证transport_fee + product_fee=total_fee
		reqHandler.setParameter("time_start", currTime);            //订单生成时间，格式为yyyymmddhhmmss
		reqHandler.setParameter("time_expire", "");                 //订单失效时间，格式为yyyymmddhhmmss
		reqHandler.setParameter("buyer_id", "");                    //买方财付通账号
		reqHandler.setParameter("goods_tag", "");                   //商品标记
		reqHandler.setParameter("trade_mode", trade_mode);                 //交易模式，1即时到账(默认)，2中介担保，3后台选择（买家进支付中心列表选择）
		reqHandler.setParameter("transport_desc", "");              //物流说明
		reqHandler.setParameter("trans_type", "1");                  //交易类型，1实物交易，2虚拟交易
		reqHandler.setParameter("agentid", "");                     //平台ID
		reqHandler.setParameter("agent_type", "");                  //代理模式，0无代理(默认)，1表示卡易售模式，2表示网店模式
		reqHandler.setParameter("seller_id", "");                   //卖家商户号，为空则等同于partner

		//请求的url
		String requestUrl = reqHandler.getRequestURL();

		//获取debug信息,建议把请求和debug信息写入日志，方便定位问题
		String debuginfo = reqHandler.getDebugInfo();
		System.out.println("requestUrl:  " + requestUrl);
		System.out.println("sign_String:  " + debuginfo);
 

	 
		mv.addObject("requestUrl",requestUrl);
		mv.setViewName("tenpay/payRequest");
		return mv;
	}	*/
	
	/**
	 *通知验证支付
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkPay")
	public void checkPay(HttpServletResponse response,HttpServletRequest request) throws Exception{
		
		//---------------------------------------------------------
		//财付通支付通知（后台通知）示例，商户按照此文档进行开发即可
		//---------------------------------------------------------

		System.out.println("---------------------------通知验证支付--------------------------------------");
		
		
		ResponseHandler resHandler = new ResponseHandler(request, response);
		resHandler.setKey(TenPayConfig.key);

		System.out.println("后台回调返回参数:"+resHandler.getAllParameters());

		//判断签名
		if(resHandler.isTenpaySign()) {
			
			//通知id
			String notify_id = resHandler.getParameter("notify_id");
			//创建请求对象
			RequestHandler queryReq = new RequestHandler(null, null);
			//通信对象
			TenpayHttpClient httpClient = new TenpayHttpClient();
			//应答对象
			ClientResponseHandler queryRes = new ClientResponseHandler();
			//通过通知ID查询，确保通知来至财付通
			queryReq.init();
			queryReq.setKey(TenPayConfig.key);
			queryReq.setGateUrl("https://gw.tenpay.com/gateway/simpleverifynotifyid.xml");
			queryReq.setParameter("partner", TenPayConfig.partner);
			queryReq.setParameter("notify_id", notify_id);
			
			//通信对象
			httpClient.setTimeOut(5);
			//设置请求内容
			httpClient.setReqContent(queryReq.getRequestURL());
			System.out.println("验证ID请求字符串:" + queryReq.getRequestURL());
			
			//后台调用
			if(httpClient.call()) {
				//设置结果参数
				queryRes.setContent(httpClient.getResContent());
				System.out.println("验证ID返回字符串:" + httpClient.getResContent());
				queryRes.setKey(TenPayConfig.key);
					
					
				//获取id验证返回状态码，0表示此通知id是财付通发起
				String retcode = queryRes.getParameter("retcode");
				
				//商户订单号
				String out_trade_no = resHandler.getParameter("out_trade_no");
				//财付通订单号
				String transaction_id = resHandler.getParameter("transaction_id");
				//金额,以分为单位
				//String total_fee = resHandler.getParameter("total_fee");
				//如果有使用折扣券，discount有值，total_fee+discount=原请求的total_fee
				String discount = resHandler.getParameter("discount");
				//支付结果
				String trade_state = resHandler.getParameter("trade_state");
				//交易模式，1即时到账，2中介担保
				String trade_mode = resHandler.getParameter("trade_mode");
			 
				//判断签名及结果
				if(queryRes.isTenpaySign()&& "0".equals(retcode)){ 
					System.out.println("id验证成功");
					
					if("1".equals(trade_mode)){       //即时到账 
						if( "0".equals(trade_state)){
							
							TenpayPaymentRecord paymentRecord = new TenpayPaymentRecord();
							Tools.transMap2Bean2(resHandler.getAllParameters(),paymentRecord);
							
							
							try {
								UnpaidOrderInfo order = orderService.isOrderNoDeal(paymentRecord.getOut_trade_no(), paymentRecord.getAttach());
								if(order != null){//订单未处理
									//生成支付流水号
									String serial_number = IdWorker.getSerialNumber();
									paymentRecord.setSerial_number(serial_number);
									/* 商品价格（包含运费），以元为单位 */
									double total_fee = (double)paymentRecord.getTotal_fee() / 100;
									System.out.println(order.getTotal_fee()+"-----------"+total_fee);
									System.out.println(Objects.equal(TenPayConfig.partner, paymentRecord.getPartner()) && Objects.equal(order.getTotal_fee(),total_fee));
									//验证total_fee、partner
									if(Objects.equal(TenPayConfig.partner, paymentRecord.getPartner()) && Objects.equal(order.getTotal_fee(),total_fee)){
										//更新订单支付状态
										try {
											orderService.updateOrderState(paymentRecord.getOut_trade_no(),  paymentRecord.getAttach(),paymentRecord);
											logger.info("财付通支付异步通知验证成功【success】"+paymentRecord.toString());
											//给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
											resHandler.sendToCFT("success");
										} catch (Exception e) {
											resHandler.sendToCFT("fail");
											logger.error("财付通支付异步通知更新订单支付状态出错："+e);
										}
									}
									System.out.println(paymentRecord.toString());
									tenpayPaymentRecordService.savePaymentRecord(paymentRecord);
								}else{
									logger.info(paymentRecord.getOut_trade_no()+"订单："+paymentRecord.getAttach()+"已处理或不存在");
									resHandler.sendToCFT("success");
								}
							} catch (Exception e) {
								resHandler.sendToCFT("fail");
								logger.error("财付通支付异步通知获取处理订单出错："+e);
							}
							
							
							
							System.out.println("==============================");
							System.out.println(paymentRecord.toString());
							System.out.println("==============================");
							
					        //------------------------------
							//即时到账处理业务开始
							//------------------------------
							
							//处理数据库逻辑
							//注意交易单不要重复处理
							//注意判断返回金额
							
							//------------------------------
							//即时到账处理业务完毕
							//------------------------------
							
							//System.out.println("即时到账支付成功");
							//给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
							//resHandler.sendToCFT("success");
							
						}else{
							System.out.println("即时到账支付失败");
							resHandler.sendToCFT("fail");
						}
					}else if("2".equals(trade_mode)){    //中介担保
						//------------------------------
						//中介担保处理业务开始
						//------------------------------
						
						//处理数据库逻辑
						//注意交易单不要重复处理
						//注意判断返回金额
						
						int iStatus = TenpayUtil.toInt(trade_state);
						switch(iStatus) {
							case 0:		//付款成功
							
								break;
							case 1:		//交易创建
							
								break;
							case 2:		//收获地址填写完毕
							
								break;
							case 4:		//卖家发货成功
							
								break;
							case 5:		//买家收货确认，交易成功
							
								break;
							case 6:		//交易关闭，未完成超时关闭
							
								break;
							case 7:		//修改交易价格成功
							
								break;
							case 8:		//买家发起退款
							
								break;
							case 9:		//退款成功
							
								break;
							case 10:	//退款关闭
							
								break;
							default:
						}
						
						//------------------------------
						//中介担保处理业务完毕
						//------------------------------
						
						System.out.println("trade_state = " + trade_state);
						//给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
						resHandler.sendToCFT("success");
					}
				}else{
					//错误时，返回结果未签名，记录retcode、retmsg看失败详情。
					System.out.println("查询验证签名失败或id验证失败"+",retcode:" + queryRes.getParameter("retcode"));
				}
			} else {
				System.out.println("后台调用通信失败");
				System.out.println(httpClient.getResponseCode());
				System.out.println(httpClient.getErrInfo());
				//有可能因为网络原因，请求已经处理，但未收到应答。
			}
		}else{
			System.out.println("通知签名验证失败");
		}
	}	
	
	/**
	 *支付结果
	 * @throws Exception 
	 */
	@RequestMapping(value="/payResult")
	public ModelAndView payResult(ModelAndView mv,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws Exception{
	 
		//pd = this.getPageData();
		//---------------------------------------------------------
		//财付通网关支付请求示例，商户按照此文档进行开发即可
		//---------------------------------------------------------
		request.setCharacterEncoding("UTF-8");

	 
		
		/* 商品价格（包含运费），以分为单位 */
		double orderPrice = 0;//(pay.getOrderPrice() * 100);
		//---------------------------------------------------------
		//财付通支付应答（处理回调）示例，商户按照此文档进行开发即可
		//---------------------------------------------------------
		System.out.println("---------------------------通知支付结果--------------------------------------");
		//创建支付应答对象
		ResponseHandler resHandler = new ResponseHandler(request, response);
		resHandler.setKey(TenPayConfig.key);
		
		System.out.println("前台回调返回参数:"+resHandler.getAllParameters());
		
		//判断签名
		if(resHandler.isTenpaySign()) {
		
		    //通知id
			String notify_id = resHandler.getParameter("notify_id");
			//商户订单号
			String out_trade_no = resHandler.getParameter("out_trade_no");
			//财付通订单号
			String transaction_id = resHandler.getParameter("transaction_id");
			//金额,以分为单位
			//String total_fee = resHandler.getParameter("total_fee");
			//如果有使用折扣券，discount有值，total_fee+discount=原请求的total_fee
			String discount = resHandler.getParameter("discount");
			//支付结果
			String trade_state = resHandler.getParameter("trade_state");
			//交易模式，1即时到账，2中介担保
			String trade_mode = resHandler.getParameter("trade_mode");
			//double payOrderPrice = Double.parseDouble(total_fee);
			if("1".equals(trade_mode)){       //即时到账 
				if( "0".equals(trade_state)){
			        //------------------------------
					//即时到账处理业务开始
					//------------------------------

					TenpayPaymentRecord paymentRecord = new TenpayPaymentRecord();
					Tools.transMap2Bean2(resHandler.getAllParameters(),paymentRecord);
					
					
					try {
						UnpaidOrderInfo order = orderService.isOrderNoDeal(paymentRecord.getOut_trade_no(), paymentRecord.getAttach());
						if(order != null){//订单未处理
							//生成支付流水号
							String serial_number = IdWorker.getSerialNumber();
							paymentRecord.setSerial_number(serial_number);
							/* 商品价格（包含运费），以元为单位 */
							double total_fee = (double)paymentRecord.getTotal_fee() / 100;
							System.out.println(order.getTotal_fee()+"-----------"+total_fee);
							System.out.println(Objects.equal(TenPayConfig.partner, paymentRecord.getPartner()) && Objects.equal(order.getTotal_fee(),total_fee));
							//验证total_fee、partner
							if(Objects.equal(TenPayConfig.partner, paymentRecord.getPartner()) && Objects.equal(order.getTotal_fee(),total_fee)){
								//更新订单支付状态
								try {
									orderService.updateOrderState(paymentRecord.getOut_trade_no(),  paymentRecord.getAttach(),paymentRecord);
									logger.info("财付通支付异步通知验证成功【success】"+paymentRecord.toString());
									//给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
									resHandler.sendToCFT("success");
								} catch (Exception e) {
									resHandler.sendToCFT("fail");
									logger.error("财付通支付异步通知更新订单支付状态出错："+e);
								}
							}
							System.out.println(paymentRecord.toString());
							tenpayPaymentRecordService.savePaymentRecord(paymentRecord);
						}else{
							logger.info(paymentRecord.getOut_trade_no()+"订单："+paymentRecord.getAttach()+"已处理或不存在");
							resHandler.sendToCFT("success");
						}
					} catch (Exception e) {
						resHandler.sendToCFT("fail");
						logger.error("财付通支付异步通知获取处理订单出错："+e);
					}
					
					
					
					System.out.println("==============================");
					System.out.println(paymentRecord.toString());
					System.out.println("==============================");
		
					//注意交易单不要重复处理
					//注意判断返回金额
					/*if(payOrderPrice == orderPrice){
						String[] orderIds = pay.getOrderNo().split(",");
						OrderServiceImpl.updatePayType(orderIds);
						mv.addObject("orderPrice", pay.getOrderPrice());
						mv.addObject("orderId", orderIds[0]);
						mv.setViewName("distribution/payResult");
					}else{
						System.out.println("支付失败");

						mv.setViewName("distribution/payFailed");
					}*/
					//------------------------------
					//即时到账处理业务完毕
					//------------------------------
					
					System.out.println("即时到帐付款成功");
				}else{
					System.out.println("即时到帐付款失败");
					//mv.setViewName("distribution/payFailed");
				}
			}else if("2".equals(trade_mode)){    //中介担保
				if( "0".equals(trade_state)){
					//------------------------------
					//中介担保处理业务开始
					//------------------------------
					
		
					//注意交易单不要重复处理
					//注意判断返回金额
				
					//------------------------------
					//中介担保处理业务完毕
					//------------------------------
					
					System.out.println("中介担保付款成功");
				}else{
					System.out.println("trade_state=" + trade_state);
				}
			}
		} else {
			System.out.println("认证签名失败");
			//mv.setViewName("distribution/payFailed");
		}
		
		//获取debug信息,建议把debug信息写入日志，方便定位问题
		String debuginfo = resHandler.getDebugInfo();
		System.out.println("debuginfo:" + debuginfo);
		//out.print("sign_String:  " + debuginfo + "<br><br>");
		
		return mv;
	}		
	
	
}
