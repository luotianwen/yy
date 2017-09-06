package com.shifeng.pay.util.alipay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.DocumentException;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipaySubmit;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.util.IdWorker;

/**
 * 支付宝支付工具类
 * @author WinZhong
 *
 */
public class AliPayTool {

	public static void main(String[] args) {
		UnpaidOrderInfo orderInfo = new UnpaidOrderInfo();
		orderInfo.setOrder_body("测试订单");
		orderInfo.setOrder_id(""+IdWorker.getId());
		orderInfo.setOrder_name("测试商品");
		orderInfo.setOrder_type("PT");
		orderInfo.setTotal_fee(0.01);
		//createPayReq(orderInfo);
		//createAppPayReq(orderInfo);
		createQrCodePayReq(orderInfo);
	}
	
	/**
	 * 创建支付宝支付请求
	 * @param orderInfo
	 * @return
	 */
	public static String createPayReq(UnpaidOrderInfo orderInfo){
	    //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderInfo.getOrder_id();

        //订单名称，必填
        String subject = orderInfo.getOrder_name();

        //付款金额，必填
        String total_fee = orderInfo.getTotal_fee()+"";

        //商品描述，可空
        String body = orderInfo.getOrder_body();
		
		//自定义公用回传参数
		String extra_common_param = orderInfo.getOrder_type();

        //防钓鱼时间戳
        try {
			AlipayConfig.anti_phishing_key = AlipaySubmit.query_timestamp();
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", AlipayConfig.payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.return_url);
		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("extra_common_param", extra_common_param);
		//扫码支付参数
		//sParaTemp.put("qr_pay_mode", "0");
		//其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
        //如sParaTemp.put("参数名","参数值");
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"post","确认");
		System.out.println(sHtmlText);
		return sHtmlText;
	}

	
	/**
	 * 创建wap支付宝支付请求
	 * @param orderInfo
	 * @return
	 */
	public static String createWapPayReq(UnpaidOrderInfo orderInfo){
	    //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderInfo.getOrder_id();

        //订单名称，必填
        String subject = orderInfo.getOrder_name();

        //付款金额，必填
        String total_fee = orderInfo.getTotal_fee()+"";

        //商品描述，可空
        String body = orderInfo.getOrder_body();
		
		//自定义公用回传参数
		String extra_common_param = orderInfo.getOrder_type();

        //防钓鱼时间戳
        try {
			AlipayConfig.anti_phishing_key = AlipaySubmit.query_timestamp();
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.appService);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", AlipayConfig.payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.wap_return_url);
		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("extra_common_param", extra_common_param);
		sParaTemp.put("app_pay","Y");//启用此参数可唤起钱包APP支付。
		//扫码支付参数
		//sParaTemp.put("qr_pay_mode", "0");
		//其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
        //如sParaTemp.put("参数名","参数值");
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		return sHtmlText;
	}
	
	/**
	 * 创建APP支付宝支付请求
	 * @param orderInfo
	 * @return
	 */
	public static String createAppPayReq(UnpaidOrderInfo orderInfo){
		String req = null;
		//实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.serverUrl, AlipayConfig.partner
				, AlipayConfig.private_key, AlipayConfig.format, AlipayConfig.input_charset, AlipayConfig.alipay_public_key, "RSA2");
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		//对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
		model.setBody(orderInfo.getOrder_body());
		//商品的标题/交易标题/订单标题/订单关键字等。
		model.setSubject(orderInfo.getOrder_name());
		//商户网站唯一订单号
		model.setOutTradeNo(orderInfo.getOrder_id());
		//该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
		model.setTimeoutExpress("24h");
		//订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
		model.setTotalAmount(orderInfo.getTotal_fee()+"");
		//销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		//访问的异步地址
		request.setNotifyUrl(AlipayConfig.notify_url);
		try {
		        //这里和普通的接口调用不同，使用的是sdkExecute
		        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
		        req = response.getBody();
		        System.out.println(req);//就是orderString 可以直接给客户端请求，无需再做处理。
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		}
		return req;
	}
	

	
	/**
	 * 创建支付宝二维码支付请求   【**暂不可用**】
	 * @param orderInfo
	 * @return
	 */
	public static String createQrCodePayReq(UnpaidOrderInfo orderInfo){
		String req = null;
		//实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.serverUrl, AlipayConfig.partner
				, AlipayConfig.private_key, AlipayConfig.format, AlipayConfig.input_charset, AlipayConfig.alipay_public_key, "RSA2");
		 
		
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		//对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
		model.setBody(orderInfo.getOrder_body());
		//商品的标题/交易标题/订单标题/订单关键字等。
		model.setSubject(orderInfo.getOrder_name());
		//商户网站唯一订单号 
		model.setOutTradeNo(orderInfo.getOrder_id());
		//该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
		model.setTimeoutExpress("24h");
		//订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
		model.setTotalAmount(orderInfo.getTotal_fee()+"");
		//销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		//访问的异步地址
		request.setNotifyUrl(AlipayConfig.notify_url);
		
		try {
		        //这里和普通的接口调用不同，使用的是sdkExecute
			    AlipayTradePrecreateResponse  response = alipayClient.execute(request);
		        req = response.getBody();
		        System.out.println(response.getMsg());
		        System.out.println("二维码串 = "+response.getQrCode());

		        System.out.println(req);//就是orderString 可以直接给客户端请求，无需再做处理。
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		}
		return req;
	}

}
