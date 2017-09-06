package com.shifeng.op.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShopinfoPay;
import com.shifeng.op.shop.service.ShopinfoPayService;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺续费表(s_shopinfo_pay)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:23 
 */  
@Service("shopinfopayServiceImpl")
public class ShopinfoPayServiceImpl implements ShopinfoPayService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoPay> findAllShopinfoPay(Page page) throws Exception{
		return (List<ShopinfoPay>) dao.findForList("shopinfopayMapper.findAllShopinfoPayPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ShopinfoPay findShopinfoPayById(String id) throws Exception{
		return (ShopinfoPay) dao.findForObject("shopinfopayMapper.findShopinfoPayById", id);
	}
	
	/**
	 * 新增
	 * @param shopinfopay
	 * @throws Exception
	 */
	public void saveShopinfoPay(ShopinfoPay shopinfopay) throws Exception{
		dao.save("shopinfopayMapper.saveShopinfoPay", shopinfopay);
	}
	
	/**
	 * 修改
	 * @param shopinfopay
	 * @throws Exception
	 */
	public void updateShopinfoPay(ShopinfoPay shopinfopay) throws Exception{
		ShopinfoPay old = (ShopinfoPay) dao.findForObject("shopinfopayMapper.findShopinfoPayById", shopinfopay.getOrderId());
		
		shopinfopay.setRemark("订单原金额：￥"+old.getPayAmount()+"元，修改金额：￥"+shopinfopay.getPayAmount()+"元，原因："+shopinfopay.getReason());
		dao.update("shopinfopayMapper.updateShopinfoPay", shopinfopay);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopinfoPay(String id) throws Exception{
		dao.delete("shopinfopayMapper.deleteShopinfoPay", id);
	}
	
}
