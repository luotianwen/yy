package com.shifeng.webapi.controller.wechat;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.wechat.WeChatService;


/**
 * 微信操作相关接口API
 * @author Win
 *
 */
@Controller
@RequestMapping(value = "/wechat")
public class WeChatController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "weChatServiceImpl")
	protected WeChatService weChatService;
	
	
	/**
	 * 获取微信分享签名
	 * @param version
	 * @param ticket
	 * @param url 分享链接
	 * @param sign （version+ticket+url）
	 * @return
	 */
	@RequestMapping(value = "/getShareSignature")
	@ResponseBody
	public ReqResponse<Map<String,String>> getShareSignature(String version,String ticket,String url,String sign){
		ReqResponse<Map<String,String>> req = new ReqResponse<Map<String,String>>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"wechat/getShareSignature", req)){
    		return req;
    	}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+url,req)){
					Map<String,String> map =  weChatService.getShareSignature(url);
					if(map == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("签名失败");
					}else{
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
	
	
	
	

}
