package com.shifeng.op.shop.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.dto.shop.ShopDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺表(s_shopinfo)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
public interface ShopinfoService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopDTO> findAllShopinfo(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Shopinfo findShopinfoById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param shopinfo
	 * @throws Exception
	 */
	public Map<String,Object> updateShopinfo(Shopinfo shopinfo,Map<String,Object> map) throws Exception;
	
	/**
	 * 新增
	 * @param shopinfo
	 * @throws Exception
	 */
	public void saveShopinfo(Shopinfo shopinfo) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopinfo(String id) throws Exception;
	
	/**
	 * 查询所有可用店铺
	 * @return
	 * @throws Exception
	 */
	public List<Shopinfo> findAllShopinfoByState() throws Exception;

	public void passShopinfo(int id, String note, Users user)throws Exception;

	public void backShopinfo(int id, String note, Users user)throws Exception;

	public  List<ShopDTO> findAllPassShopinfo(Page page)throws Exception;

	public int updateAccount(String id, Users user)throws Exception;
}
