package com.shifeng.op.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.op.shop.service.ShopinfoLogService;
import com.shifeng.plugin.page.Page;

/** 
 * 店铺审核日志(s_shopinfo_log)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
@Service("shopinfologServiceImpl")
public class ShopinfoLogServiceImpl implements ShopinfoLogService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoLog> findAllShopinfoLog(Page page) throws Exception{
		return (List<ShopinfoLog>) dao.findForList("shopinfologMapper.findAllShopinfoLogPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ShopinfoLog findShopinfoLogById(String id) throws Exception{
		return (ShopinfoLog) dao.findForObject("shopinfologMapper.findShopinfoLogById", id);
	}
	
	/**
	 * 新增
	 * @param shopinfolog
	 * @throws Exception
	 */
	public void saveShopinfoLog(ShopinfoLog shopinfolog) throws Exception{
		dao.save("shopinfologMapper.saveShopinfoLog", shopinfolog);
	}
	
	/**
	 * 修改
	 * @param shopinfolog
	 * @throws Exception
	 */
	public void updateShopinfoLog(ShopinfoLog shopinfolog) throws Exception{
		dao.update("shopinfologMapper.updateShopinfoLog", shopinfolog);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopinfoLog(String id) throws Exception{
		dao.delete("shopinfologMapper.deleteShopinfoLog", id);
	}
	
}
