package com.shifeng.webapi.controller.ware;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.entity.search.SkuInfo;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.SpecialSaleSkuService;
import com.shifeng.webapi.service.search.SearchService;
import com.shifeng.webapi.service.ware.WareService;


/**
 * 商品API接口 Controller
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/ware")
public class WareController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "wareServiceImpl")
	protected WareService wareService;
	
	@Resource(name = "searchServiceImpl")
	protected SearchService searchService;
	
	@Resource(name = "specialSaleSkuService")
	protected SpecialSaleSkuService specialSaleSkuService;
	
	
	
	

	
	/**
	 * 获取商品详情
	 * @param version
	 * @param ticket
	 * @param sku
	 * @param sign (version+ticket+sku)
	 * @return
	 */
	@RequestMapping(value = "/detail")
	@ResponseBody
	public ReqResponse<WareSkuInfo> detail(String version,String ticket,String sku,String sign){
		ReqResponse<WareSkuInfo> req = new ReqResponse<WareSkuInfo>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"ware/detail", req)){
    		return req;
    	}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket+sku,req)){
					//WareSkuDTO wareSku = wareService.getWareSku(sku);
				     WareSkuInfo wareSkuInfo = searchService.getWareSkuInfo(sku);
					req.setData(wareSkuInfo);
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
	 * 获取商品SKU详情
	 * @param version
	 * @param ticket
	 * @param pid
	 * @param sign (version+ticket+pid)
	 * @return
	 */
	@RequestMapping(value = "/skuList")
	@ResponseBody
	public ReqResponse<List<SkuInfo>> skuList(String version,String ticket,String pid,String sign){
		ReqResponse<List<SkuInfo>> req = new ReqResponse<List<SkuInfo>>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"ware/skuList", req)){
    		return req;
    	}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				//if(this.verifySign(sign, version+ticket+pid,req)){
					//WareSkuDTO wareSku = wareService.getWareSku(sku);
					try {
						List<SkuInfo> skuInfoList = searchService.getSkuInfo(pid);
						req.setData(skuInfoList);
					} catch (NumberFormatException e) {
						 
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
	
	/**
	 * 获取特卖商品列表
	 * @param version
	 * @param ticket
	 * @param cid 分类ID
	 * @param sort 排序（0：综合；1：价格从低到高；2：价格从高到低；3：折扣从低到高；4：折扣从高到低）
	 * @param currentPage
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/getSpecialSaleWareList")
	@ResponseBody
	public ReqResponse<Page> getSpecialSaleWareList(String version,String ticket,String cid,String sort,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"ware/getSpecialSaleWareList", req)){
    		return req;
    	}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
					if(currentPage == null){
						currentPage = 1;
					}
					Page page  = specialSaleSkuService.getSpecialSaleWareList(cid,sort,currentPage);
					req.setData(page);
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}	
	

}
