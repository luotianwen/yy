package com.shifeng.webapi.controller.shop;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.dto.mall.shop.ShopInfoDTO;
import com.shifeng.dto.ware.HotWareDTO;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.search.SearchService;
import com.shifeng.webapi.service.shop.ShopService;


/**
 * 店铺API接口 Controller
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "shopServiceImpl")
	protected ShopService shopService;
	
	@Resource(name = "searchServiceImpl")
	protected SearchService searchService;
	
	/**
	 * 获取店铺热销商品
	 * @param version
	 * @param ticket
	 * @param shopid	店铺ID
	 * @param sign (version+ticket+shopid)
	 * @return
	 */
	@RequestMapping(value = "/hotWare")
	@ResponseBody
	public ReqResponse<List<HotWareDTO>> hotWare(String version,String ticket,int shopid,String sign){
		ReqResponse<List<HotWareDTO>> req = new ReqResponse<List<HotWareDTO>>();
		//访问验证
		if(!visitInspect(ticket, "shop/hotWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+shopid,req)){
					List<HotWareDTO> wareList = searchService.getShopHotWare(shopid);
				    req.setData(wareList);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	/**
	 * 获取店铺基本信息
	 * @param version
	 * @param ticket
	 * @param shopid
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/getShopInfo")
	@ResponseBody
	public ReqResponse<ShopInfoDTO> getShopInfo(String version,String ticket,String shopid,String sign){
		ReqResponse<ShopInfoDTO> req = new ReqResponse<ShopInfoDTO>();
		//访问验证
		if(!visitInspect(ticket, "shop/getShopInfo", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+shopid,req)){
				  ShopInfoDTO shopInfo = shopService.getShopInfo(shopid);
				  req.setData(shopInfo);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	

	
	/**
	 * 获取店铺基本信息
	 * @param version
	 * @param ticket
	 * @param shopId
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/wares")
	@ResponseBody
	public ReqResponse<SolrPage> getShopWare(String version,String ticket,String shopId,SearchParameter searchParameter,SolrPage page,String sign){
		ReqResponse<SolrPage> req = new ReqResponse<SolrPage>();
		//访问验证
		if(!visitInspect(ticket, "shop/getShopWare", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				//if(this.verifySign(sign, version+ticket+shopid,req)){
				 if(StringUtils.isBlank(shopId)){
						return req;
				 }else{
					  page = shopService.searchShopWare(shopId,searchParameter,page);
					  req.setData(page); 
				 }
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
