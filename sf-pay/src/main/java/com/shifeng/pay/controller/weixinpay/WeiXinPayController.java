package com.shifeng.pay.controller.weixinpay;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.google.common.base.Objects;
import com.shifeng.pay.controller.BaseController;
import com.shifeng.pay.dto.PayDTO;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.pay.entity.pay.WeixinPaymentRecord;
import com.shifeng.pay.sdk.weixin.common.Configure;
import com.shifeng.pay.sdk.weixin.common.RandomStringGenerator;
import com.shifeng.pay.sdk.weixin.common.Signature;
import com.shifeng.pay.sdk.weixin.common.Util;
import com.shifeng.pay.sdk.weixin.config.WxPayConfig;
import com.shifeng.pay.sdk.weixin.protocol.NotifyResData;
import com.shifeng.pay.sdk.weixin.protocol.PayResData;
import com.shifeng.pay.sdk.weixin.protocol.ReturnData;
import com.shifeng.pay.service.order.OrderService;
import com.shifeng.pay.service.order.UnpaidOrderService;
import com.shifeng.pay.service.pay.WeixinPaymentRecordService;
import com.shifeng.pay.util.weixinpay.WeiXinPayTool;
import com.shifeng.util.IdWorker;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * 微信支付
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value="/weixinpay")
public class WeiXinPayController extends BaseController{

	
	 @Resource(name="weixinPaymentRecordServiceImpl")
	 WeixinPaymentRecordService weixinPaymentRecordService;
	
	 @Resource(name="orderServiceImpl")
	 OrderService orderService;
		
	/**
	 * 未支付订单Service
	 */
	 @Resource(name="unpaidOrderServiceImpl")
	 UnpaidOrderService unpaidOrderService;
	 
	 /**
	  * 创建微信jsapi支付请求
	  * @param session
	  * @param request
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/create")
	 @ResponseBody
	 public Map<String,Object> create(HttpSession session,HttpServletRequest request,PayDTO payDTO) throws Exception{
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("code",0);
		 if(payDTO.isWxJSAPINotEmpty()){
				if(payDTO.checkWxJSAPISign()){
					UnpaidOrderInfo orderInfo = unpaidOrderService.getUnpaidOrderInfo(payDTO.getOrder_id(), payDTO.getOrder_type());
					if(orderInfo == null){
						map.put("msg", "订单不存在或已经支付");
						map.put("code",15000);
					}else{
						PayResData payResData = WeiXinPayTool.createPayReq(orderInfo,WeiXinPayTool.TRADETYPE_JSAPI,payDTO.getOpenid());
						if(payResData != null && "SUCCESS".equals(payResData.getReturn_code()) && "SUCCESS".equals(payResData.getResult_code())){
							//列表中参数名区分大小，大小写错误签名验证会失败。 
							Map<String,Object> data = new HashMap<String,Object>();
			                data.put("appId", Configure.getAppid());
			                data.put("timeStamp", new Date().getTime()/1000);
			                data.put("nonceStr", RandomStringGenerator.getRandomStringByLength(32));
			                data.put("package", "prepay_id="+payResData.getPrepay_id());
			                data.put("signType", "MD5");
			                String sign = Signature.getSign(data);
			                data.put("sign", sign);
			                map.put("data",data);
			                System.out.println(data);
			            }else{
							map.put("msg", "支付创建失败");
							map.put("code",15000);
			            }
					}

				}else{
					map.put("msg", "支付信息被篡改");
					map.put("code",15000);
				}
			}else{
				map.put("msg", "支付参数错误");
				map.put("code",15000);
			}
		 return map;          
	 }
    
	/**
	 * 微信支付
	 * @param mv
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping("/pay")
	@ResponseBody
	public Object pay(ModelAndView mv,HttpSession session,HttpServletRequest request) throws Exception{
		
		//初始化配置信息        
		WXPay.initSDKConfiguration(KEY,APPID,MCHID,"","","");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date1 = new Date();
        long datetime = date1.getTime()+3600*1000;
        String generateTime = dateFormat.format(date1);//yyyyMMddHHmmss  订单生成时间
        String failureTime = dateFormat.format(new Date(datetime));//yyyyMMddHHmmss  失效时间
		PayReqData reqData = new PayReqData( 
				notifyUrl
				,"测试商品"
				,"原样返回信息"
				,""+IdWorker.getId()
				,1
				, "WEB"
				,"124.126.191.209"
				,generateTime
				,failureTime
				,"WXG"
                ,"JSAPI"); 
		String resdata= WXPay.requestPayService(reqData);
		 Map<String,Object> jsonmap = new HashMap<String,Object>();
		//签名验证
        Map<String,Object> map = XMLParser.getMapFromXML(resdata);
        if(Signature.checkIsSignValidFromResponseString(resdata)){
            
            if("SUCCESS".equals(map.get("return_code"))&&"SUCCESS".equals(map.get("result_code"))){
                jsonmap.put("appid", Configure.getAppid());
                jsonmap.put("prepayid", map.get("prepay_id").toString());
                jsonmap.put("package", "Sign=WXPay");
                jsonmap.put("partnerid", Configure.getMchid());
                jsonmap.put("noncestr", RandomStringGenerator.getRandomStringByLength(32));
                jsonmap.put("timestamp", new Date().getTime()/1000+"");
                jsonmap.put("sign", Signature.getSign(jsonmap));
            }
            
        }else{
            System.out.println("签名验证失败");
        }
		
        System.out.println(jsonmap);
        
        return jsonmap;

		                    
		                            
	}*/
	
	/**
	 * 微信支付异步通知
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws DocumentException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	@RequestMapping("/notify")
	public void notify(HttpServletRequest request,HttpServletResponse response) throws IOException, DocumentException, ParserConfigurationException, SAXException{
		 
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document =reader.read(inputStream);  
        //微信通知信息实体类
        NotifyResData notifyResData = null;
        //同步返回数据
        String resdata = document.asXML();
        System.out.println(resdata);
        ReturnData rd = new ReturnData();
      //检验API返回的数据里面的签名是否合法
		if(Signature.checkIsSignValidFromResponseString(resdata)){
			//将从API返回的XML数据映射到Java对象
			notifyResData = (NotifyResData) Util.getObjectFromXML(resdata, NotifyResData.class);
			if(Objects.equal("SUCCESS", notifyResData.getReturn_code()) && Objects.equal("SUCCESS", notifyResData.getResult_code())){
				
				try {
					UnpaidOrderInfo order = orderService.isOrderNoDeal(notifyResData.getOut_trade_no(), notifyResData.getAttach());
					if(order != null){//订单未处理
						WeixinPaymentRecord paymentRecord = (WeixinPaymentRecord) Util.getObjectFromXML(resdata, WeixinPaymentRecord.class);
						//生成支付流水号
						String serial_number = IdWorker.getSerialNumber();
						paymentRecord.setSerial_number(serial_number);
						/* 商品价格（包含运费），以元为单位 */
						double total_fee = (Double.parseDouble(notifyResData.getTotal_fee()) / 100);
						System.out.println(order.getTotal_fee()+"-----------"+total_fee);
						System.out.println(Objects.equal(WxPayConfig.APPID, notifyResData.getAppid()) && Objects.equal(order.getTotal_fee(),total_fee));
						//验证total_fee、appid
						if(Objects.equal(WxPayConfig.APPID, notifyResData.getAppid()) && Objects.equal(order.getTotal_fee(),total_fee)){
							//更新订单支付状态
							try {
								orderService.updateOrderState(notifyResData.getOut_trade_no(),  notifyResData.getAttach(),paymentRecord);
								logger.info("微信支付异步通知验证成功【success】"+notifyResData.toString());
								rd.setReturn_code("SUCCESS");//设置返回状态码
							} catch (Exception e) {
								rd.setReturn_code("FAIL");//设置返回状态码
								logger.error("微信支付异步通知更新订单支付状态出错："+e);
							}
						}
						System.out.println(paymentRecord.toString());
						weixinPaymentRecordService.savePaymentRecord(paymentRecord);
					}else{
						logger.info(notifyResData.getOut_trade_no()+"订单："+notifyResData.getAttach()+"已处理或不存在");
						rd.setReturn_code("SUCCESS");//设置返回状态码
					}
				} catch (Exception e) {
					rd.setReturn_code("FAIL");//设置返回状态码
					rd.setReturn_msg("系统处理错误");//设置返回信息
					logger.error("微信支付异步通知获取处理订单出错："+e);
				}
				
				
			}
			
			System.out.println("==============================");
			System.out.println(notifyResData.toString());
			
			System.out.println("==============================");
			
		}else{//签名验证失败
			rd.setReturn_code("FAIL");//设置返回状态码
			rd.setReturn_msg("签名失败");//设置返回信息
		}
       /* // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
        List<Element> list = root.elements();  
        // 遍历所有子节点  
        for (Element e : list){  
            map.put(e.getName(), e.getText());  
        }  
        inputStream.close();  
        if("SUCCESS".equals(map.get("result_code"))){  
        	
        }
		System.out.println("==============="+map);*/
		//==============={transaction_id=4002442001201703082627562999, nonce_str=4svhuxqak90ookxh4wdyob4cx5qch9wi, bank_type=CFT, openid=o6SDjswFKhDCwK5rz5GJnq8SmyAY, sign=B45E2B59B94C14362D1C5B3DA06D539F, fee_type=CNY, mch_id=1323511701, cash_fee=1, device_info=WEB, out_trade_no=7777777, appid=wx2e1deda16bcced1d, total_fee=1, trade_type=NATIVE, result_code=SUCCESS, attach=ware, time_end=20170308102455, is_subscribe=N, return_code=SUCCESS}

		//解决XStream对出现双下划线的bug
        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        //数据对象转换成XML格式数据
        String returnDataXML = xStreamForRequestPostData.toXML(rd);
        response.getWriter().write(returnDataXML);
	}
	 
	
}
