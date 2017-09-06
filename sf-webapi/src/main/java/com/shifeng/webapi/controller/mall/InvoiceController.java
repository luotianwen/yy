package com.shifeng.webapi.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.dto.mall.MallUserInvoiceDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.CartService;
import com.shifeng.webapi.service.mall.InvoiceService;

/**
 * 发票
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/invoice")
public class InvoiceController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "invoiceServiceImpl")
	protected InvoiceService invoiceService;
	
	
	/**
	 * 获取发票列表
	 * @param version
	 * @param token
	 * @param sign (version+token)
	 * @return
	 */
	@RequestMapping(value = "/getInvoiceList")
	@ResponseBody
	public ReqResponse<List<MallUserInvoiceDTO>> getInvoiceList(String version,String token,String sign){
		ReqResponse<List<MallUserInvoiceDTO>> req = new ReqResponse<List<MallUserInvoiceDTO>>();
		//登录验证
		if(!checkLogin(token, "invoice/getInvoiceList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token,req)){
					List<MallUserInvoiceDTO> userInvoices =  invoiceService.getInvoiceList(user_id);
				    req.setData(userInvoices);
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
	 * 添加发票
	 * @param version
	 * @param token
	 * @param sku
	 * @param sign （version+token+sku）
	 * @return
	 */
	@RequestMapping(value = "/addInvoice")
	@ResponseBody
	public ReqResponse<String> addInvoice(String version,String token,MallUserInvoiceDTO userInvoice,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "invoice/addInvoice", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+userInvoice.getSignContent(),req)){
						userInvoice.setUserId(user_id);
						boolean bl = invoiceService.addInvoice(userInvoice); 
						if(!bl){
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg(ErrorMsg.FAIL.getMsg());
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

	
	 
	
	/**
	 * 删除发票
	 * @param version
	 * @param token
	 * @param invoiceId
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/deleteInvoice")
	@ResponseBody
	public ReqResponse<String> deleteInvoice(String version,String token,Integer invoiceId,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "invoice/deleteInvoice", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+invoiceId,req)){
					if(invoiceId == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg(ErrorMsg.FAIL.getMsg());
					}else{
						boolean bl = invoiceService.deleteInvoice(user_id, invoiceId); 
						if(!bl){
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg(ErrorMsg.FAIL.getMsg());
						}
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
	
	 
	
	/**
	 * 修改发票
	 * @param version
	 * @param token
	 * @param sku
	 * @param sign （version+token+sku+wareNumber）
	 * @return
	 */
	@RequestMapping(value = "/updateInvoice")
	@ResponseBody
	public ReqResponse<String> updateInvoice(String version,String token,MallUserInvoiceDTO invoice,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "invoice/updateInvoice", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+invoice.getSignContent() ,req)){
					invoice.setUserId(user_id);
					boolean bl = invoiceService.updateInvoice(invoice); 
					if(!bl){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg(ErrorMsg.FAIL.getMsg());
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
