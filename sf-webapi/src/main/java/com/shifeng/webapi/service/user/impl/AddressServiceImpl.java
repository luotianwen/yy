package com.shifeng.webapi.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.entity.user.MallUserAddress;
import com.shifeng.provide.usercenter.service.BuyAddressService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.user.AddressService;

/**
 * 收货地址
 * @author WinZhong
 *
 */
@Service("addressServiceImpl")
public class AddressServiceImpl implements AddressService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "buyAddressService")
	protected BuyAddressService buyAddressService;


	
	
	/**
	 * 添加用户收货地址
	 * @param address
	 * @return
	 */
	public boolean addAddress(MallUserAddressDTO address) {
		try {
			ReqResponse<String> req = buyAddressService.addAddress(address);
			if(req.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【添加用户收货地址】出错：", e);
		}
		return false;
	}
	
	/**
	 * 设置默认收货地址
	 * @param user_id 用户id
	 * @param addressId	地址id
	 * @return
	 */
	public boolean setAddressAllDefaultById(String user_id,int addressId) {
		try {
			ReqResponse<String> req = buyAddressService.setAddressAllDefaultById(user_id, addressId);
			if(req.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【设置默认收货地址】出错：", e);
		}
		return false;
	}
	
	/**
	 * 删除收货地址
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	public boolean deleteAddress(String user_id,int addressId) {
		try {
			ReqResponse<String> req = buyAddressService.deleteAddress(user_id, addressId);
			if(req.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【删除收货地址】出错：", e);
		}
		return false;
	}
	
	/**
	 * 根据地址ID获取地址详细信息
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	public MallUserAddressDTO getAddressById(String user_id,int addressId) {
		try {
			ReqResponse<MallUserAddressDTO> req = buyAddressService.getAddressById(user_id, addressId);
			if(req.getCode() == 0){
				return req.getData();
			}
		} catch (Exception e) {
			logger.error("【根据地址ID获取地址详细信息】出错：", e);
		}
		return null;
	}
	
	/**
	 * 根据用户ID获取收货地址列表
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	public List<MallUserAddressDTO> getAddressList(String user_id) {
		try {
			ReqResponse<List<MallUserAddressDTO>> req = buyAddressService.getAddressList(user_id);
			if(req.getCode() == 0){
				return req.getData();
			}
		} catch (Exception e) {
			logger.error("【根据用户ID获取收货地址列表】出错：", e);
		}
		return null;
	}
	
	/**
	 * 修改用户收货地址
	 * @param address
	 * @return
	 */
	public boolean updateAddress(MallUserAddressDTO address) {
		try {
			ReqResponse<String> req = buyAddressService.updateAddress(address);
			if(req.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【修改用户收货地址】出错：", e);
		}
		return false;
	}
	


	
	/**
	 * 获取用户默认收货地址
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	public MallUserAddressDTO getDefaultAddress(String user_id) {
		try {
			ReqResponse<MallUserAddressDTO> req = buyAddressService.getDefaultAddress(user_id);
			if(req.getCode() == 0){
				return req.getData();
			}
		} catch (Exception e) {
			logger.error("【获取用户默认收货地址】出错：", e);
		}
		return null;
	}
	
	
}
