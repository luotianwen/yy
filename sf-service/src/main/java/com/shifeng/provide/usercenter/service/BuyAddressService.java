package com.shifeng.provide.usercenter.service;

import java.util.List;

import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.entity.user.MallUserAddress;
import com.shifeng.response.ReqResponse;

/**
 * 用户购物收货地址
 * @author WinZhong
 *
 */
public interface BuyAddressService {
	
	/**
	 * 添加用户收货地址
	 * @param address
	 * @return
	 */
	ReqResponse<String> addAddress(MallUserAddressDTO address);
	
	/**
	 * 设置默认收货地址
	 * @param user_id 用户id
	 * @param addressId	地址id
	 * @return
	 */
	ReqResponse<String> setAddressAllDefaultById(String user_id,int addressId);
	
	/**
	 * 删除收货地址
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	ReqResponse<String> deleteAddress(String user_id,int addressId);
	
	/**
	 * 根据地址ID获取地址详细信息
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	ReqResponse<MallUserAddressDTO> getAddressById(String user_id,int addressId);
	
	/**
	 * 根据用户ID获取收货地址列表
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	ReqResponse<List<MallUserAddressDTO>> getAddressList(String user_id);
	
	/**
	 * 修改用户收货地址
	 * @param address
	 * @return
	 */
	ReqResponse<String> updateAddress(MallUserAddressDTO address);

	/**
	 * 获取用户默认收货地址
	 * @param user_id
	 * @return
	 */
	ReqResponse<MallUserAddressDTO> getDefaultAddress(String user_id);

	/**
	 * 获取用户收货地址数量
	 * @param user_id
	 * @return
	 */
	ReqResponse<String> getAddressCount(String user_id);
	
}
