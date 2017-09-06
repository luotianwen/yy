package com.shifeng.pay.sdk.weixin;

import com.shifeng.pay.sdk.weixin.common.Configure;
import com.shifeng.pay.sdk.weixin.protocol.PayReqData;
import com.shifeng.pay.sdk.weixin.service.PayService;

public class WXPay {

	public static void main(String[] args) {

	}
	   /**
     * 初始化SDK依赖的几个关键配置
     * @param key 签名算法需要用到的秘钥
     * @param appID 公众账号ID
     * @param mchID 商户ID
     * @param sdbMchID 子商户ID，受理模式必填
     * @param certLocalPath HTTP证书在服务器中的路径，用来加载证书用
     * @param certPassword HTTP证书的密码，默认等于MCHID
     */
    public static void initSDKConfiguration(String key,String appID,String mchID,String sdbMchID,String certLocalPath,String certPassword){
        Configure.setKey(key);
        Configure.setAppID(appID);
        Configure.setMchID(mchID);
        Configure.setSubMchID(sdbMchID);
        Configure.setCertLocalPath(certLocalPath);
        Configure.setCertPassword(certPassword);
    }
    
    /**
     * 请求支付服务
     * @param PayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public static String requestPayService(PayReqData payReqData) throws Exception{
        return new PayService().request(payReqData);
    }
	
	
	
	
}
