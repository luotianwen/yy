package com.shifeng.provide.usercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.provide.usercenter.dao.BuyAddressDao;
import com.shifeng.provide.usercenter.service.BuyAddressService;
import com.shifeng.response.ReqResponse;

/**
 * 用户购物收货地址
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class BuyAddressServiceImpl implements BuyAddressService{

	@Resource(name = "buyAddressDao")
	private BuyAddressDao buyAddressDao;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 添加用户收货地址
	 * @param address
	 * @return
	 */
	public ReqResponse<String> addAddress(MallUserAddressDTO address) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			buyAddressDao.addAddress(address, req);
		} catch (Exception e) {
			logger.error("【添加用户收货地址】出错：", e);
			req.setCode(1);
			req.setMsg("添加用户收货地址异常");
		}
		return req;
	}
	
	/**
	 * 设置默认收货地址
	 * @param user_id 用户id
	 * @param addressId	地址id
	 * @return
	 */
	public ReqResponse<String> setAddressAllDefaultById(String user_id,int addressId) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			buyAddressDao.updateAddressAllDefaultById(user_id,addressId, req);
		} catch (Exception e) {
			logger.error("【设置默认收货地址】出错：", e);
			req.setCode(1);
			req.setMsg("设置默认收货地址异常");
		}
		return req;
	}
	
	/**
	 * 删除收货地址
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	public ReqResponse<String> deleteAddress(String user_id,int addressId) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			buyAddressDao.deleteAddress(user_id,addressId, req);
		} catch (Exception e) {
			logger.error("【删除收货地址】出错：", e);
			req.setCode(1);
			req.setMsg("删除收货地址异常");
		}
		return req;
	}
	
	/**
	 * 根据地址ID获取地址详细信息
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	public ReqResponse<MallUserAddressDTO> getAddressById(String user_id,int addressId) {
		ReqResponse<MallUserAddressDTO> req = new ReqResponse<MallUserAddressDTO>();
		try {
			buyAddressDao.getAddressById(user_id,addressId, req);
		} catch (Exception e) {
			logger.error("【根据地址ID获取地址详细信息】出错：", e);
			req.setCode(1);
			req.setMsg("根据地址ID获取地址详细信息异常");
		}
		return req;
	}
	
	/**
	 * 根据用户ID获取收货地址列表
	 * @param user_id
	 * @param addressId
	 * @return
	 */
	public ReqResponse<List<MallUserAddressDTO>> getAddressList(String user_id) {
		ReqResponse<List<MallUserAddressDTO>> req = new ReqResponse<List<MallUserAddressDTO>>();
		try {
			buyAddressDao.getAddressList(user_id, req);
		} catch (Exception e) {
			logger.error("【根据用户ID获取收货地址列表】出错：", e);
			req.setCode(1);
			req.setMsg("根据用户ID获取收货地址列表异常");
		}
		return req;
	}
	
	/**
	 * 修改用户收货地址
	 * @param address
	 * @return
	 */
	public ReqResponse<String> updateAddress(MallUserAddressDTO address) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			buyAddressDao.updateAddress(address, req);
		} catch (Exception e) {
			logger.error("【修改用户收货地址】出错：", e);
			req.setCode(1);
			req.setMsg("修改用户收货地址异常");
		}
		return req;
	}
	


	/**
	 * 获取用户默认收货地址
	 * @param user_id
	 * @return
	 */
	public ReqResponse<MallUserAddressDTO> getDefaultAddress(String user_id) {
		ReqResponse<MallUserAddressDTO> req = new ReqResponse<MallUserAddressDTO>();
		try {
			buyAddressDao.getDefaultAddress(user_id, req);
		} catch (Exception e) {
			logger.error("【获取用户默认收货地址】出错：", e);
			req.setCode(1);
			req.setMsg("获取用户默认收货地址异常");
		}
		return req;
	}

	/**
	 * 获取用户收货地址数量
	 * @param user_id
	 * @return
	 */
	public ReqResponse<String> getAddressCount(String user_id){
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			buyAddressDao.getAddressCount(user_id, req);
		} catch (Exception e) {
			logger.error("【获取用户收货地址数量】出错：", e);
			req.setCode(1);
			req.setMsg("获取用户收货地址数量异常");
		}
		return req;
	}
	
}
