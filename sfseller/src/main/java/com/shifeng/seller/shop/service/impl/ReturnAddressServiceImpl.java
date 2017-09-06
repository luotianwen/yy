package com.shifeng.seller.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ReturnAddress;
import com.shifeng.seller.shop.service.ReturnAddressService;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺退货地址(s_return_address)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-05 17:22:45 
 */  
@Service("returnaddressServiceImpl")
public class ReturnAddressServiceImpl implements ReturnAddressService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ReturnAddress> findAllReturnAddress(Page page) throws Exception{
		return (List<ReturnAddress>) dao.findForList("returnaddressMapper.findAllReturnAddressPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ReturnAddress findReturnAddressById(String id) throws Exception{
		return (ReturnAddress) dao.findForObject("returnaddressMapper.findReturnAddressById", id);
	}
	
	/**
	 * 修改
	 * @param returnaddress
	 * @throws Exception
	 */
	public void returnAddressEdit(ReturnAddress returnaddress) throws Exception{
		if(returnaddress.getId()!=null){
			dao.update("returnaddressMapper.updateReturnAddress", returnaddress);
		}else{
			dao.save("returnaddressMapper.saveReturnAddress", returnaddress);
		}
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteReturnAddress(String id) throws Exception{
		dao.delete("returnaddressMapper.deleteReturnAddress", id);
	}
	
}
