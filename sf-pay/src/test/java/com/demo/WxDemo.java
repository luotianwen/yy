package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.shifeng.pay.sdk.weixin.WXPay;
import com.shifeng.pay.sdk.weixin.common.Configure;
import com.shifeng.pay.sdk.weixin.common.RandomStringGenerator;
import com.shifeng.pay.sdk.weixin.common.Signature;
import com.shifeng.pay.sdk.weixin.common.Util;
import com.shifeng.pay.sdk.weixin.common.XMLParser;
import com.shifeng.pay.sdk.weixin.protocol.PayReqData;
import com.shifeng.pay.sdk.weixin.protocol.PayResData;
import com.shifeng.util.IdWorker;

public class WxDemo {
	
	public static String APPID = "wx2e1deda16bcced1d";
    public static String MCHID = "1323511701";
    public static String KEY = "S9FH2LLNK7SY8DF9G5Y1C3GX15F2SHOU";
    public static String APPSECRET = "2de82c85d4ec582a73414df915c4a6d1";


	public static void main(String[] args) throws Exception {

		//初始化配置信息        
		WXPay.initSDKConfiguration(KEY,APPID,MCHID,"","","");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date1 = new Date();
        long datetime = date1.getTime()+3600*1000;
        String generateTime = dateFormat.format(date1);//yyyyMMddHHmmss  订单生成时间
        String failureTime = dateFormat.format(new Date(datetime));//yyyyMMddHHmmss  失效时间
		PayReqData reqData = new PayReqData(
				"m.seebong.com"
				,"测试商品"
				,"原样返回信息"
				,""+IdWorker.getId()
				,1
				, "WEB"
				,"124.126.191.209"
				,generateTime
				,failureTime
				,"WXG"
                ,"JSAPI"
                ,"o6SDjs79lOvfp_i7r8s9OvVdGWAI"
            ); //
		System.out.println(reqData.toString());
		String resdata= WXPay.requestPayService(reqData);
		 Map<String,Object> jsonmap = new HashMap<String,Object>();
		//签名验证
        Map<String,Object> map = XMLParser.getMapFromXML(resdata);
        //将从API返回的XML数据映射到Java对象
        PayResData payResData = (PayResData) Util.getObjectFromXML(resdata, PayResData.class);
        System.out.println(payResData.toString());
        if(Signature.checkIsSignValidFromResponseString(resdata)){
            
            if("SUCCESS".equals(map.get("return_code"))&&"SUCCESS".equals(map.get("result_code"))){
                jsonmap.put("appid", Configure.getAppid());
                jsonmap.put("prepayid", map.get("prepay_id").toString());
                jsonmap.put("package", "Sign=WXPay");
                jsonmap.put("partnerid", Configure.getMchid());
                jsonmap.put("noncestr", RandomStringGenerator.getRandomStringByLength(32));
                jsonmap.put("timestamp", new Date().getTime()/1000+"");
                jsonmap.put("sign", Signature.getSign(jsonmap));
                System.out.println(jsonmap);
            }
            
        }else{
            System.out.println("签名验证失败");
        }
		//weixin://wxpay/bizpayurl?pr=enZgi47
        System.out.println(jsonmap);
         
	}

}
