package com.shifeng.webapi.service.user;

import java.util.List;

import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.entity.user.MallUserAddress;

/**
 * 收货地址
 * @author WinZhong
 *
 */
public interface AddressService {
	
	
	/**
	 * 添加用户收货地址
	 * @param address
	 * @return
	 */
	boolean addAddress(MallUserAddressDTO address);
	
	/**
	 * 设置默认收货地址
	 * @param user_id 用户id
	 * @param addressId	地址id
	 * @return
	 */
	boolean setAddressAllDefaultById(String user_id,int addressId);
	
	/**
	 * 删除收货地址
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	boolean deleteAddress(String user_id,int addressId);
	
	/**
	 * 根据地址ID获取地址详细信息
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	MallUserAddressDTO getAddressById(String user_id,int addressId);
	
	/**
	 * 根据用户ID获取收货地址列表
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	List<MallUserAddressDTO> getAddressList(String user_id);
	
	/**
	 * 修改用户收货地址
	 * @param address
	 * @return
	 */
	boolean updateAddress(MallUserAddressDTO address);

	
	/**
	 * 获取用户默认收货地址
	 * @param user_id
	 * @return
	 */
	MallUserAddressDTO getDefaultAddress(String user_id);
	
	

}
