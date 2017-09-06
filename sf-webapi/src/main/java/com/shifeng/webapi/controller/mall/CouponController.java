package com.shifeng.webapi.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.entity.coupon.Coupons;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.CouponsService;

/**
 * 优惠券
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/coupon")
public class CouponController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "couponsServiceImpl")
	protected CouponsService couponsService;
	
	
	/**
	 * 获取可用的优惠券列表
	 * @param version
	 * @param ticket
	 * @param sku 
	 * @param shopid	店铺ID
	 * @param categoryid	分类ID
	 * @param sign (version+sku)
	 * @return
	 */
	@RequestMapping(value = "/getCoupons")
	@ResponseBody
	public ReqResponse<List<Coupons>> getCoupons(String version,String ticket,String sku, String shopid, String categoryid,String sign){
		ReqResponse<List<Coupons>> req = new ReqResponse<List<Coupons>>();
		//ticket验证
		if(!visitInspect(ticket, "coupon/getCoupons", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				//if(this.verifySign(sign, version+ticket+sku+shopid+categoryid,req)){
					List<Coupons> wareList = couponsService.getALLCoupons(sku,shopid,categoryid); 
				    req.setData(wareList);
				//}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
 
	
}
