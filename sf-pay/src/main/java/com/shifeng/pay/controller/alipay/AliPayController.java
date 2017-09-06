package com.shifeng.pay.controller.alipay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;
import com.shifeng.common.OrderType;
import com.shifeng.pay.config.PayReturnUrl;
import com.shifeng.pay.controller.BaseController;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.pay.entity.pay.AlipayPaymentRecord;
import com.shifeng.pay.service.order.OrderService;
import com.shifeng.pay.service.pay.AlipayPaymentRecordService;
import com.shifeng.util.IdWorker;
import com.shifeng.util.MD5Util;

/**
 * 支付宝支付
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value="/alipay")
public class AliPayController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	 @Resource(name="alipayPaymentRecordServiceImpl")
	 AlipayPaymentRecordService alipayPaymentRecordService;
	
	 @Resource(name="orderServiceImpl")
	 OrderService orderService;
	
	 
	/**
	 * 跳转到支付宝支付页面
	 * @param mv
	 * @return
	 */
	@RequestMapping("/pay")
	public ModelAndView pay(ModelAndView mv,HttpSession session,HttpServletRequest request){
		
		////////////////////////////////////请求参数//////////////////////////////////////

		System.out.println(this.findKeyMapByRequest(request));
		
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");

        //订单名称，必填
        String subject = request.getParameter("WIDsubject");

        //付款金额，必填
        String total_fee = request.getParameter("WIDtotal_fee");

        //商品描述，可空
        String body = request.getParameter("WIDbody");
		
		//自定义公用回传参数
		String extra_common_param = request.getParameter("extra_common_param");

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
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		System.out.println(sHtmlText);
		mv.setViewName("alipay");
		mv.addObject("payHtml", sHtmlText);
		return mv;
	}

	/**
	 * 跳转到支付宝支付页面
	 * @param mv
	 * @return
	 */
	/*@RequestMapping("/pay")
	public ModelAndView pay(ModelAndView mv,HttpSession session,HttpServletRequest request){
		////////////////////////////////////请求参数//////////////////////////////////////

		System.out.println(this.findKeyMapByRequest(request));
		
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");

        //订单名称，必填
        String subject = request.getParameter("WIDsubject");

        //付款金额，必填
        String total_fee = request.getParameter("WIDtotal_fee");

        //商品描述，可空
        String body = request.getParameter("WIDbody");
		
		//自定义公用回传参数
		String extra_common_param = request.getParameter("extra_common_param");

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
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		System.out.println(sHtmlText);
		mv.setViewName("alipay");
		mv.addObject("payHtml", sHtmlText);
		return mv;
	}*/
	


	/**
	 * wapPay支付
	 * 跳转到支付宝支付页面
	 * @param mv
	 * @return
	 */
	@RequestMapping("/wapPay")
	public ModelAndView wapPay(ModelAndView mv,HttpSession session,HttpServletRequest request){
		////////////////////////////////////请求参数//////////////////////////////////////

		System.out.println(this.findKeyMapByRequest(request));
		
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");

        //订单名称，必填
        String subject = request.getParameter("WIDsubject");

        //付款金额，必填
        String total_fee = request.getParameter("WIDtotal_fee");

        //商品描述，可空
        String body = request.getParameter("WIDbody");
		
		//自定义公用回传参数
		String extra_common_param = request.getParameter("extra_common_param");
		
		//收银台页面上，商品展示的超链接，必填
        String show_url = request.getParameter("WIDshow_url");

		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.appService);
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
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("app_pay","Y");//启用此参数可唤起钱包APP支付。
		//扫码支付参数
		//sParaTemp.put("qr_pay_mode", "0");
		//其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
        //如sParaTemp.put("参数名","参数值");
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		System.out.println(sHtmlText);
		mv.setViewName("alipay/alipay");
		mv.addObject("payHtml", sHtmlText);
		
		session.setAttribute("type", "wap");
		
		return mv;
	}
	
	
	/**
	 * 
	 * @Description: 支付宝返回支付结果 异步通知
	 * @param request
	 * @param response
	 * @throws Exception   
	 * @return void  
	 * @author WinZhong
	 * @date 2016年3月12日 下午2:58:02
	 */
	@RequestMapping("/notify")
	public void notify(HttpServletRequest request,HttpServletResponse response,AlipayPaymentRecord paymentRecord){
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = request.getParameter("out_trade_no");

		//支付宝交易号

		String trade_no = request.getParameter("trade_no");

		//交易状态
		String trade_status = request.getParameter("trade_status");

		//自定义公用回传参数
		String extra_common_param = request.getParameter("extra_common_param");
		
		String return_data = "success";

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		System.out.println(params);
		if(AlipayNotify.verify(params)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if("TRADE_FINISHED".equals(trade_status) || "TRADE_SUCCESS".equals(trade_status)){
				//TRADE_FINISHED（普通即时到账的交易成功状态）；
				//TRADE_SUCCESS（开通了高级即时到账或机票分销产品后的交易成功状态）
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
					//如果有做过处理，不执行商户的业务程序
					
				System.out.println("====================================================");
				System.out.println("======================= 支付成功 =======================");
				System.out.println("======================="+params+"=====================");
				System.out.println("====================================================");
				
				try {
					UnpaidOrderInfo order = orderService.isOrderNoDeal(paymentRecord.getOut_trade_no(), paymentRecord.getExtra_common_param());
					if(order != null){//订单未处理
						//生成支付流水号
						String serial_number = IdWorker.getSerialNumber();
						paymentRecord.setSerial_number(serial_number);
						//验证total_fee、seller_id
						if(Objects.equals(AlipayConfig.seller_id, paymentRecord.getSeller_id())
								&& Objects.equals(order.getTotal_fee(),paymentRecord.getTotal_fee())){
							//更新订单支付状态
							try {
								orderService.updateOrderState(paymentRecord.getOut_trade_no(), paymentRecord.getExtra_common_param(),paymentRecord);
								//out.print("success");	//请不要修改或删除
								logger.info("支付宝支付通知验证成功【success】"+paymentRecord.toString());
							} catch (Exception e) {
								return_data = "fail";
								//out.print("fail");
								logger.error("支付宝支付通知更新订单支付状态出错："+e);
							}
						}
						alipayPaymentRecordService.savePaymentRecord(paymentRecord);
					}else{
						logger.info(extra_common_param+"订单："+out_trade_no+"已处理或不存在");
					}
				} catch (Exception e) {
					return_data = "fail";
					//out.print("fail");
					logger.error("支付宝支付通知获取处理订单出错："+e);
				}
				
				
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else{
				return_data = "fail";
				//out.print("fail");
				logger.info("支付宝支付通知验证失败【fail】"+paymentRecord.toString());
			}
			
			
			
			/*else if (trade_status.equals("TRADE_SUCCESS")){//TRADE_SUCCESS（开通了高级即时到账或机票分销产品后的交易成功状态）
				//付款完成后，支付宝系统发送该交易状态通知
				
			}*/

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
				
			
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			return_data = "fail";
			//out.print("fail");
			logger.info("支付宝支付通知验证失败【fail】"+paymentRecord.toString());
		}
		out.print(return_data);
	}
	
	
	/**
	 * 支付宝返回支付结果 同步通知
	 * @param mv
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/return")
	public ModelAndView returns(HttpServletRequest request,HttpSession session,ModelAndView mv,AlipayPaymentRecord paymentRecord){
		
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = request.getParameter("out_trade_no");

		//支付宝交易号

		String trade_no = request.getParameter("trade_no");

		//交易状态
		String trade_status = request.getParameter("trade_status");
		
		//自定义公用回传参数
		String extra_common_param = request.getParameter("extra_common_param");
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		System.out.println(params);
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		//boolean payResult = false;
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			//if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
			if("TRADE_FINISHED".equals(trade_status) || "TRADE_SUCCESS".equals(trade_status)){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				

				
				System.out.println("====================================================");
				System.out.println("======================= 支付成功 =======================");
				System.out.println("======================="+params+"=====================");
				System.out.println("====================================================");
				
				try {
					UnpaidOrderInfo order = orderService.isOrderNoDeal(paymentRecord.getOut_trade_no(), paymentRecord.getExtra_common_param());
					if(order != null){//订单未处理
						//生成支付流水号
						String serial_number = IdWorker.getSerialNumber();
						paymentRecord.setSerial_number(serial_number);
						//验证total_fee、seller_id
						if(Objects.equals(AlipayConfig.seller_id, paymentRecord.getSeller_id())
								&& Objects.equals(order.getTotal_fee(),paymentRecord.getTotal_fee())){
							//更新订单支付状态
							try {
								orderService.updateOrderState(paymentRecord.getOut_trade_no(), paymentRecord.getExtra_common_param(),paymentRecord);
								logger.info("支付宝支付通知验证成功【success】"+paymentRecord.toString());
							} catch (Exception e) {
								logger.error("支付宝支付通知更新订单支付状态出错："+e);
							}
						}
						alipayPaymentRecordService.savePaymentRecord(paymentRecord);
					}else{
						logger.info(extra_common_param+"订单："+out_trade_no+"已处理或不存在");
					}
				} catch (Exception e) {
					//out.print("fail");
					logger.error("支付宝支付通知获取处理订单出错："+e);
				}
				
				
			}
			
			//该页面可做页面美工编辑
			System.out.println("验证成功<br />");
			mv.addObject("result", "验证成功<br />");
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//该页面可做页面美工编辑
			System.out.println("验证失败");
			mv.addObject("result", "验证失败");
		}
		mv.setViewName("alipay/result");
		/*if(Objects.equals("wap", session.getAttribute("type"))){
			//mv.setViewName("alipay/wapResult");
			String url = AlipayConfig.wap_return_url+"?orderId="+out_trade_no;
			System.out.println("返回URL："+url);
			mv = new ModelAndView(new RedirectView(url));
		}*/

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", out_trade_no);
		map.put("total_fee", paymentRecord.getTotal_fee());
		map.put("order_type", extra_common_param);
		map.put("token", MD5Util.hexSALT(out_trade_no+paymentRecord.getTotal_fee()+extra_common_param));
		 
		if(Objects.equals(OrderType.WARES, extra_common_param) || Objects.equals(OrderType.WARE, extra_common_param)){//商品订单
			mv = new ModelAndView(new RedirectView(PayReturnUrl.PC_PAY_RETURN_URL),map);
		}else if(Objects.equals(OrderType.SHOP, extra_common_param)){//商家店铺入驻续费订单
			mv = new ModelAndView(new RedirectView(PayReturnUrl.SHOP_RETURN_URL),map);
		}
	    
		
		return mv;
	}
	
	
	
	
	/**
	 * app支付异步通知
	 * @param request
	 * @param response
	 */
	@RequestMapping("/appPayNotify")
	public void appPayNotify(HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		    String name = (String) iter.next();
		    String[] values = (String[]) requestParams.get(name);
		    String valueStr = "";
		    for (int i = 0; i < values.length; i++) {
		        valueStr = (i == values.length - 1) ? valueStr + values[i]
		                    : valueStr + values[i] + ",";
		  }
		  //乱码解决，这段代码在出现乱码时使用。
		  //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		  params.put(name, valueStr);
		 }
		//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
		// boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String
		// publicKey, String charset, String sign_type)
		try {
			boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key,
					AlipayConfig.input_charset, "RSA2");
			if (flag) {// 验证成功
				// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
				// 商户订单号
				String out_trade_no = request.getParameter("out_trade_no");

				// 支付宝交易号
				String trade_no = request.getParameter("trade_no");

				// 交易状态
				String trade_status = request.getParameter("trade_status");

				// 自定义公用回传参数
				String extra_common_param = request.getParameter("extra_common_param");

				//////////////////////////////////////////////////////////////////////////////////////////
				// 请在这里加上商户的业务逻辑程序代码

				// ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
				if("TRADE_FINISHED".equals(trade_status) || "TRADE_SUCCESS".equals(trade_status)){
					
				}
				/*if (trade_status.equals("TRADE_FINISHED")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
					// 如果有做过处理，不执行商户的业务程序

					// 注意：
					// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
				} else if (trade_status.equals("TRADE_SUCCESS")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
					// 如果有做过处理，不执行商户的业务程序

					// 注意：
					// 付款完成后，支付宝系统发送该交易状态通知
				}*/

				// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

				out.print("success"); // 请不要修改或删除
				System.out.print("success");
				//////////////////////////////////////////////////////////////////////////////////////////
			} else {// 验证失败
				out.print("fail");
				System.out.print("fail");
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 支付宝返回支付结果 同步通知
	 * @param mv
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/wapReturn")
	public ModelAndView wapReturn(HttpServletRequest request,HttpSession session,AlipayPaymentRecord paymentRecord){
		
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = request.getParameter("out_trade_no");

		//支付宝交易号

		String trade_no = request.getParameter("trade_no");

		//交易状态
		String trade_status = request.getParameter("trade_status");
		
		//自定义公用回传参数
		String extra_common_param = request.getParameter("extra_common_param");
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		System.out.println(params);
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		boolean payResult = true;
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			//if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
			if("TRADE_FINISHED".equals(trade_status) || "TRADE_SUCCESS".equals(trade_status)){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				

				
				System.out.println("====================================================");
				System.out.println("======================= 支付成功 =======================");
				System.out.println("======================="+params+"=====================");
				System.out.println("====================================================");
				
				try {
					UnpaidOrderInfo order = orderService.isOrderNoDeal(paymentRecord.getOut_trade_no(), paymentRecord.getExtra_common_param());
					if(order != null){//订单未处理
						//生成支付流水号
						String serial_number = IdWorker.getSerialNumber();
						paymentRecord.setSerial_number(serial_number);
						//验证total_fee、seller_id
						if(Objects.equals(AlipayConfig.seller_id, paymentRecord.getSeller_id())
								&& Objects.equals(order.getTotal_fee(),paymentRecord.getTotal_fee())){
							//更新订单支付状态
							try {
								orderService.updateOrderState(paymentRecord.getOut_trade_no(), paymentRecord.getExtra_common_param(),paymentRecord);
								logger.info("支付宝支付通知验证成功【success】"+paymentRecord.toString());
							} catch (Exception e) {
								logger.error("支付宝支付通知更新订单支付状态出错："+e);
							}
						}
						alipayPaymentRecordService.savePaymentRecord(paymentRecord);
					}else{
						logger.info(extra_common_param+"订单："+out_trade_no+"已处理或不存在");
					}
				} catch (Exception e) {
					//out.print("fail");
					logger.error("支付宝支付通知获取处理订单出错："+e);
				}
				
				
			}
			
			//该页面可做页面美工编辑
			System.out.println("验证成功<br />");
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//该页面可做页面美工编辑
			System.out.println("验证失败");
			payResult = false;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderId", out_trade_no);
		if(payResult){
			map.put("total_fee", paymentRecord.getTotal_fee()+"");
			map.put("pay_result", "success");
		}else{
			map.put("pay_result", "fail");
		}
		//String url = AlipayConfig.wap_app_return_url+"?orderId="+out_trade_no;
		//System.out.println("返回URL："+url);
		ModelAndView mv = new ModelAndView(new RedirectView(PayReturnUrl.WAP_PAY_RETURN_URL),map);
		 
		return mv;
	}
	
}
