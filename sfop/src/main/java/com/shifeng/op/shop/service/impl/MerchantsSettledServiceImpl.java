package com.shifeng.op.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.shop.service.ShopinfoLogService;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.MerchantsSettled;
import com.shifeng.op.shop.service.MerchantsSettledService;
import com.shifeng.plugin.page.Page;

/** 
 * 入驻基本信息填写(s_merchants_settled)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */  
@Service("merchantssettledServiceImpl")
public class MerchantsSettledServiceImpl implements MerchantsSettledService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	@Resource(name="shopinfologServiceImpl")
	private ShopinfoLogService shopinfologServiceImpl;
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MerchantsSettled> findAllMerchantsSettled(Page page) throws Exception{
		return (List<MerchantsSettled>) dao.findForList("merchantssettledMapper.findAllMerchantsSettledPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MerchantsSettled findMerchantsSettledById(String id) throws Exception{
		return (MerchantsSettled) dao.findForObject("merchantssettledMapper.findMerchantsSettledById", id);
	}
	
	/**
	 * 新增
	 * @param merchantssettled
	 * @throws Exception
	 */
	public void saveMerchantsSettled(MerchantsSettled merchantssettled) throws Exception{
		dao.save("merchantssettledMapper.saveMerchantsSettled", merchantssettled);
	}
	
	/**
	 * 修改
	 * @param merchantssettled
	 * @throws Exception
	 */
	public void updateMerchantsSettled(MerchantsSettled merchantssettled) throws Exception{
		dao.update("merchantssettledMapper.updateMerchantsSettled", merchantssettled);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMerchantsSettled(String id) throws Exception{
		dao.delete("merchantssettledMapper.deleteMerchantsSettled", id);
	}

	public void passMerchantsSettled(int id, String note, Users user) throws Exception {
		ShopinfoLog shopinfoLog=new ShopinfoLog();
		shopinfoLog.setNote(note);
		shopinfoLog.setUpdatename(user.getuName());
		shopinfoLog.setS_merchants_id(id);
		shopinfoLog.setState(1);
		shopinfoLog.setType(1);
		shopinfologServiceImpl.saveShopinfoLog(shopinfoLog);
		Map map=new HashMap();
		map.put("id",id);
		map.put("state","1");

		dao.update("merchantssettledMapper.updateMerchantsSettledState", map);
	}

	public void backMerchantsSettled(int id, String note, Users user) throws Exception {
		ShopinfoLog shopinfoLog=new ShopinfoLog();
		shopinfoLog.setNote(note);
		shopinfoLog.setUpdatename(user.getuName());
		shopinfoLog.setS_merchants_id(id);
		shopinfoLog.setState(2);
		shopinfoLog.setType(1);
		shopinfologServiceImpl.saveShopinfoLog(shopinfoLog);
		Map map=new HashMap();
		map.put("id",id);
		map.put("state","2");

		dao.update("merchantssettledMapper.updateMerchantsSettledState", map);
	}

}
