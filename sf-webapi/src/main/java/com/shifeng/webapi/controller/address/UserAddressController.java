package com.shifeng.webapi.controller.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.user.AddressService;

/**
 * 用户地址
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/usercenter/address")
public class UserAddressController extends BaseController {
	
	@Resource(name = "addressServiceImpl")
	protected AddressService addressService;
	/**用户id*/
	private String user_id = null;
	
	//formatAddAddress
	/**
	 * 添加用户收货地址
	 * @param version
	 * @param token
	 * @param headimgurl
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/addAddress")
	@ResponseBody
	public ReqResponse<Integer> addAddress(String version,String token,MallUserAddressDTO address,String sign){
		ReqResponse<Integer> req = new ReqResponse<Integer>();
		
		if(!isAuth(token, "address/addAddress", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+address.getSignContent(),req)){
					address.setUid(user_id);
					boolean bl = addressService.addAddress(address); 
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
	 * 设置默认收货地址
	 * @param version
	 * @param token
	 * @param addressId 地址id
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/setAddressAllDefaultById")
	@ResponseBody
	public ReqResponse<Integer> setAddressAllDefaultById(String version,String token,int addressId,String sign){
		ReqResponse<Integer> req = new ReqResponse<Integer>();
		
		if(!isAuth(token, "address/setAddressAllDefaultById", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+addressId,req)){

					boolean bl = addressService.setAddressAllDefaultById(user_id,addressId); 
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
	 * 删除收货地址
	 * @param version
	 * @param token
	 * @param addressId 地址id
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/deleteAddress")
	@ResponseBody
	public ReqResponse<Integer> deleteAddress(String version,String token,int addressId,String sign){
		ReqResponse<Integer> req = new ReqResponse<Integer>();
		
		if(!isAuth(token, "address/deleteAddress", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+addressId,req)){

					boolean bl = addressService.deleteAddress(user_id,addressId); 
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
	 * 根据地址ID获取地址详细信息
	 * @param version
	 * @param token
	 * @param addressId 地址id
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/getAddressById")
	@ResponseBody
	public ReqResponse<MallUserAddressDTO> getAddressById(String version,String token,int addressId,String sign){
		ReqResponse<MallUserAddressDTO> req = new ReqResponse<MallUserAddressDTO>();
		
		if(!isAuth(token, "address/deleteAddress", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+addressId,req)){

					MallUserAddressDTO address = addressService.getAddressById(user_id,addressId); 
					if(address == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg(ErrorMsg.FAIL.getMsg());
					}else{
						req.setCode(0);
						req.setData(address);
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
	 * 根据用户ID获取收货地址列表
	 * @param version
	 * @param token
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/getAddressList")
	@ResponseBody
	public ReqResponse<List<MallUserAddressDTO>> getAddressList(String version,String token,String sign){
		ReqResponse<List<MallUserAddressDTO>> req = new ReqResponse<List<MallUserAddressDTO>>();
		
		if(!isAuth(token, "address/getAddressList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token,req)){

					List<MallUserAddressDTO> addressList = addressService.getAddressList(user_id); 
					if(addressList == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg(ErrorMsg.FAIL.getMsg());
					}else{
						req.setCode(0);
						req.setData(addressList);
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
	 * 修改用户收货地址
	 * @param version
	 * @param token
	 * @param address
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/updateAddress")
	@ResponseBody
	public ReqResponse<Integer> updateAddress(String version,String token,MallUserAddressDTO address,String sign){
		ReqResponse<Integer> req = new ReqResponse<Integer>();
		
		if(!isAuth(token, "address/updateAddress", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+address.getId()+address.getSignContent(),req)){
					address.setUid(user_id);
					boolean bl = addressService.updateAddress(address); 
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
	 * 获取用户默认收货地址
	 * @param version
	 * @param token
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/getDefaultAddress")
	@ResponseBody
	public ReqResponse<MallUserAddressDTO> getDefaultAddress(String version,String token,String sign){
		ReqResponse<MallUserAddressDTO> req = new ReqResponse<MallUserAddressDTO>();
		
		if(!isAuth(token, "address/getDefaultAddress", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token,req)){
					MallUserAddressDTO address = addressService.getDefaultAddress(user_id);
					if(address == null){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg(ErrorMsg.FAIL.getMsg());
					}else{
						req.setCode(0);
						req.setData(address);
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
	 * 权限验证
	 * @param token
	 * @param method
	 * @param req
	 * @return
	 */
	private boolean isAuth(String token, String method, ReqResponse<?> req){
		boolean bl = false;
		//是否能继续获取访问
		if(this.isGoOnVisit(token, method, req)){
			bl = true;
		}
		user_id = this.getUserId(token, req);
		if(user_id == null){//用户未登录
			bl = false;
		}else{
			bl = true;
		}
		return bl;
	}
	

}
