package com.shifeng.seller.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShippingAddress;
import com.shifeng.seller.shop.service.ShippingAddressService;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺发货地址(s_shipping_address)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:22:45 
 */  
@Service("shippingaddressServiceImpl")
public class ShippingAddressServiceImpl implements ShippingAddressService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShippingAddress> findAllShippingAddress(Page page) throws Exception{
		return (List<ShippingAddress>) dao.findForList("shippingaddressMapper.findAllShippingAddressPage", page);
	}
	
	/**
	 * 根据店铺ID查询
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<ShippingAddress> findShippingAddressByShopId(String shopid) throws Exception{
		return (List<ShippingAddress>) dao.findForList("shippingaddressMapper.findShippingAddressByShopId", shopid);
	}
	
	/**
	 * 根据ID查询
	 */
	public ShippingAddress findShippingAddressById(String id) throws Exception{
		return (ShippingAddress) dao.findForObject("shippingaddressMapper.findShippingAddressById", id);
	}
	
	/**
	 * 修改
	 * @param shippingaddress
	 * @throws Exception
	 */
	public void shippingAddressEdit(ShippingAddress shippingaddress) throws Exception{
		if(shippingaddress.getIsdefault()==1){
			dao.update("shippingaddressMapper.updateShippingAddressDefault", shippingaddress.getShopid());
		}
		
		if(shippingaddress.getId()==null){
			dao.save("shippingaddressMapper.saveShippingAddress", shippingaddress);
		}else{
			dao.update("shippingaddressMapper.updateShippingAddress", shippingaddress);
		}
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShippingAddress(String id) throws Exception{
		dao.delete("shippingaddressMapper.deleteShippingAddress", id);
	}
	
}
