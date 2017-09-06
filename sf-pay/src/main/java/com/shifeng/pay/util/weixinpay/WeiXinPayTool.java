package com.shifeng.pay.util.weixinpay;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.pay.sdk.weixin.WXPay;
import com.shifeng.pay.sdk.weixin.common.Signature;
import com.shifeng.pay.sdk.weixin.common.Util;
import com.shifeng.pay.sdk.weixin.config.WxPayConfig;
import com.shifeng.pay.sdk.weixin.protocol.PayReqData;
import com.shifeng.pay.sdk.weixin.protocol.PayResData;

/**
 * 微信支付工具类
 * @author WinZhong
 *
 */
public class WeiXinPayTool {
 
    
    /**
     * 交易类型  公众号支付
     */
    public static final String TRADETYPE_JSAPI = "JSAPI";
    
    /**
     * 交易类型  APP支付
     */
    public static final String TRADETYPE_APP = "APP";
    
    /**
     * 交易类型  PC支付
     */
    public static final String TRADETYPE_NATIVE = "NATIVE";
    
	public static void main(String[] args) {
		 

	}
	
	/**
	 * 创建微信支付请求
	 * @param orderInfo	订单信息
	 * @param tradeType 	交易类型 取值如下：JSAPI，NATIVE，APP等
	 * @return
	 */
	public static PayResData createPayReq(UnpaidOrderInfo orderInfo,String tradeType,String openid){
		//初始化配置信息        
		WXPay.initSDKConfiguration(WxPayConfig.KEY,WxPayConfig.APPID,WxPayConfig.MCHID,"","","");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date1 = new Date();
        long datetime = date1.getTime()+3600*1000;
        String generateTime = dateFormat.format(date1);//yyyyMMddHHmmss  订单生成时间
        String failureTime = dateFormat.format(new Date(datetime));//yyyyMMddHHmmss  失效时间
		/* 商品价格（包含运费），以分为单位 */
		double total_fee = (orderInfo.getTotal_fee() * 100);
		int fee = (int)total_fee;
		PayReqData reqData = null; /*= new PayReqData( 
				WxPayConfig.notifyUrl
				,orderInfo.getOrder_name()
				,orderInfo.getOrder_type()
				,orderInfo.getOrder_id()
				,fee
				, "WEB"
				,"124.126.191.209"
				,generateTime
				,failureTime
				,"WXG"
                ,tradeType); //,"o6SDjswFKhDCwK5rz5GJnq8SmyAY"
*/		
		if(Objects.equals(TRADETYPE_JSAPI, tradeType)){
			reqData = new PayReqData( 
					WxPayConfig.notifyUrl
					,orderInfo.getOrder_name()
					,orderInfo.getOrder_type()
					,orderInfo.getOrder_id()
					,fee
					, "WEB"
					,"124.126.191.209"
					,generateTime
					,failureTime
					,"WXG"
	                ,tradeType
	                ,openid
					);
		}else{
			reqData = new PayReqData( 
					WxPayConfig.notifyUrl
					,orderInfo.getOrder_name()
					,orderInfo.getOrder_type()
					,orderInfo.getOrder_id()
					,fee
					, "WEB"
					,"124.126.191.209"
					,generateTime
					,failureTime
					,"WXG"
	                ,tradeType);
		}
		
		
		
		System.out.println(reqData.toString());
		PayResData payResData = null;
		try {
			String resdata= WXPay.requestPayService(reqData);
			//检验API返回的数据里面的签名是否合法
			if(Signature.checkIsSignValidFromResponseString(resdata)){
				//将从API返回的XML数据映射到Java对象
				payResData = (PayResData) Util.getObjectFromXML(resdata, PayResData.class);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payResData;
	}

	 

}
