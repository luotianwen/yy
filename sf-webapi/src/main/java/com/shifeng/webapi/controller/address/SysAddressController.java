package com.shifeng.webapi.controller.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.provide.system.service.SystemService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;

/**
 * 系统地址
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/address")
public class SysAddressController extends BaseController {
    @Resource(name="systemService")
    private SystemService systemServiceImpl;
	 
    /**
     *获取所有省份
     */
    @RequestMapping(value = "/getAllProvince")
    @ResponseBody
    public ReqResponse<List> getAllProvince(String version,String ticket) throws Exception {
    	ReqResponse<List> req = new ReqResponse<List>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}
		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "address/getAllProvince", req)){
			return req;
		}
    	try {
			//验证版本号
			switch (version) {
				case ApiVersion.V_1_0_0:
					req.setData(systemServiceImpl.getAllProvince());
					break;
				default:
					req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
					req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
					break;
			}
			
		} catch (Exception e) {
			logger.info("获取所有省份出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}
         return req;
    }
    /**
     *通过省份id获取市
     */
    @RequestMapping(value = "/getAllCityByPid")
    @ResponseBody
    public ReqResponse<List> getAllCityByPid(String version,String ticket,String pid) throws Exception {
    	ReqResponse<List> req = new ReqResponse<List>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}
		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "address/getAllCityByPid", req)){
			return req;
		}
    	try {
			//验证版本号
			switch (version) {
				case ApiVersion.V_1_0_0:
					req.setData(systemServiceImpl.getAllCityByPid(pid));
					break;
				default:
					req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
					req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
					break;
			}
		} catch (Exception e) {
			logger.info("通过省份id获取市出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}
         return req;
    }
    /**
     *通过市id获取区
     */
    @RequestMapping(value = "/getAllDistrictByCid")
    @ResponseBody
    public ReqResponse<List> getAllDistrictByCid(String version,String ticket,String cid) throws Exception {
    	ReqResponse<List> req = new ReqResponse<List>();
    	//验证ticket
    	if(!this.checkTicket(ticket, req)){
    		return req;
    	}
		//是否能继续获取访问
		if(!this.isGoOnVisit(ticket, "address/getAllDistrictByCid", req)){
			return req;
		}
    	try {
			//验证版本号
			switch (version) {
				case ApiVersion.V_1_0_0:
					req.setData(systemServiceImpl.getAllAreaByCid(cid));
					break;
				default:
					req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
					req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
					break;
			}
			
		} catch (Exception e) {
			logger.info("通过市id获取区出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}
         return req;
    }
	
	

}
