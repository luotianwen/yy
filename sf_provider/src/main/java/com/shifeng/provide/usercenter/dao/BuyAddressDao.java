package com.shifeng.provide.usercenter.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.response.ReqResponse;

/**
 * 用户购物收货地址
 * @author WinZhong
 *
 */
@Service("buyAddressDao")
public class BuyAddressDao{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 添加用户收货地址
	 * @param address
	 * @return
	 * @throws Exception 
	 */
	public void addAddress(MallUserAddressDTO address,ReqResponse<String> req) throws Exception {
		address.setId(null);
		if(null != address && address.getFirst() == 1){
			//取消之前的默认收货地址
			dao.update("malluseraddressMapper.updateAddressAllCancelDefaultById", address.getUid());
		}else{//判断是否有默认地址，没有设置当前地址为默认
			MallUserAddressDTO addres = (MallUserAddressDTO)dao.findForObject("malluseraddressMapper.getDefaultAddress",  address.getUid());
			if(addres == null){
				address.setFirst(1);
			}
		}
		dao.save("malluseraddressMapper.saveMallUserAddress", address);
		if(address.getId() > 0){
            req.setCode(0);
            req.setMsg("添加用户收货地址成功");
		}else{
            req.setCode(1);
            req.setMsg("添加用户收货地址失败");
		}
	}
	
	/**
	 * 设置默认收货地址
	 * @param user_id 用户id
	 * @param addressId	地址id
	 * @return
	 * @throws Exception 
	 */
	public void updateAddressAllDefaultById(String user_id,int addressId,ReqResponse<String> req) throws Exception {
		//取消之前的默认收货地址
		 dao.update("malluseraddressMapper.updateAddressAllCancelDefaultById", user_id);
    	 int rows = (int) dao.update("malluseraddressMapper.updateAddressAllDefaultById", new String[]{user_id,addressId+""});
    	 if (rows == 0) {
             req.setCode(1);
             req.setMsg("设置默认收货地址失败");
         } else {
             req.setCode(0);
             req.setMsg("设置默认收货地址成功");
         }
	}
	
	/**
	 * 删除收货地址
	 * @param user_id
	 * @param addressId
	 * @return
	 * @throws Exception 
	 */
	public void deleteAddress(String user_id,int addressId,ReqResponse<String> req) throws Exception {
		int rows = (int) dao.update("malluseraddressMapper.deleteAddress", new String[]{user_id,addressId+""});
         if (rows == 0) {
             req.setCode(1);
             req.setMsg("删除收货地址失败");
         } else {
             req.setCode(0);
             req.setMsg("删除收货地址成功");
         }
	}
	
	/**
	 * 根据地址ID获取地址详细信息
	 * @param user_id
	 * @param addressId
	 * @return
	 * @throws Exception 
	 */
	public void getAddressById(String user_id,int addressId,ReqResponse<MallUserAddressDTO> req) throws Exception {
		MallUserAddressDTO addres = (MallUserAddressDTO)dao.findForObject("malluseraddressMapper.getAddressById",  new String[]{user_id,addressId+""});
		req.setData(addres);
	}
	
	/**
	 * 根据用户ID获取收货地址列表
	 * @param user_id
	 * @param addressId
	 * @return
	 * @throws Exception 
	 */
	public void getAddressList(String user_id,ReqResponse<List<MallUserAddressDTO>> req) throws Exception {
		List<MallUserAddressDTO> addresList = (List<MallUserAddressDTO>)dao.findForList("malluseraddressMapper.getAddressByUserId", user_id);
		req.setData(addresList);
	}
	
	/**
	 * 修改用户收货地址
	 * @param address
	 * @return
	 * @throws Exception 
	 */
	public void updateAddress(MallUserAddressDTO address,ReqResponse<String> req) throws Exception {
		if(null != address && address.getFirst() == 1){
			//取消之前的默认收货地址
			dao.update("malluseraddressMapper.updateAddressAllCancelDefaultById", address.getUid());
		}
		int rows = (int) dao.update("malluseraddressMapper.updateMallUserAddress", address);
         if (rows == 0) {
             req.setCode(1);
             req.setMsg("设置默认收货地址失败");
         } else {
             req.setCode(0);
             req.setMsg("设置默认收货地址成功");
         }
	}

	/**
	 * 获取用户默认收货地址
	 * @param user_id
	 * @param req
	 * @throws Exception 
	 */
	public void getDefaultAddress(String user_id, ReqResponse<MallUserAddressDTO> req) throws Exception {
		MallUserAddressDTO addres = (MallUserAddressDTO)dao.findForObject("malluseraddressMapper.getDefaultAddress",  user_id);
		req.setData(addres);
		
	}

	/**
	 * 获取用户收货地址数量
	 * @param user_id
	 * @return
	 */
	public void getAddressCount(String user_id, ReqResponse<String> req) throws Exception {
		int rows = (int) dao.findForObject("malluseraddressMapper.getAddressCount", user_id);
		
		req.setData(rows+"");
		if(rows<20){
			req.setCode(0);
		}else{
			req.setCode(1);
			req.setMsg("收货地址数量已达上限");
		}
	}
	
}
