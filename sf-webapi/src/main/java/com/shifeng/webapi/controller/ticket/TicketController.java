package com.shifeng.webapi.controller.ticket;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Objects;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.MD5Util;
import com.shifeng.util.UuidUtil;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ClientSecret;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;

@Controller
public class TicketController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());

	
	/**
	 * 获取当天的ticket 有效期至当天23:59.59
	 * @param secret  客户端秘钥
	 * @param version APP版本号
	 * @param type 1 为M端  2为微信端  3为安卓app  4为苹果app	
	 * @param sign  md5(secret + version + type)
	 * @return
	 */
	//@CrossOrigin
	@RequestMapping(value = "/getTicket")
	@ResponseBody
	public ReqResponse<String> getTicket(String secret,String version,Integer type,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			//验证客户端秘钥
			if(Objects.equal(secret, ClientSecret.getClientSecret(version, type))){
				//验证签名
				if(Objects.equal(sign, MD5Util.hex(secret+version+type))){
					//生成ticket
					String ticket = UuidUtil.get32UUID();
					String key = String.format(Constant.TICKET_KEY, ticket);
					//计算当天到24点还剩下多少秒+10800秒
					Long s = DateUtil.currentDayResidueTime()/1000+1*60*60*3;
					req.setCode(0);
					req.setData(ticket);
					//ticket写入redis缓存
					RedisTool.set(key, ticket);
					//设置过期时间
					RedisTool.expire(key, s.intValue());
				}else{
					req.setCode(ErrorMsg.INVALID_SIGN.getCode());
					req.setMsg(ErrorMsg.INVALID_SIGN.getMsg());
				}
			}else{
				req.setCode(ErrorMsg.INVALID_GET_PROGRAM.getCode());
				req.setMsg(ErrorMsg.INVALID_GET_PROGRAM.getMsg());
			}
			
		} catch (Exception e) {
			logger.info("获取当天的ticket 出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}
		return req;
	}
	
	
}
