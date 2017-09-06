package com.shifeng.seller.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.freight.Freight;
import com.shifeng.entity.freight.FreightDetail;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.shop.service.FreightService;

/** 
 * 运费模板管理(o_freight)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:40:52 
 */  
@Service("freightServiceImpl")
public class FreightServiceImpl implements FreightService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据店铺ID查询所有
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<Freight> findAllFreightByShopId(String shopId) throws Exception{
		return (List<Freight>) dao.findForList("freightMapper.findAllFreightByShopId", shopId);
	}
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Freight> findAllFreight(Page page) throws Exception{
		return (List<Freight>) dao.findForList("freightMapper.findAllFreightPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Freight findFreightById(String id) throws Exception{
		return (Freight) dao.findForObject("freightMapper.findFreightById", id);
	}
	
	/**
	 * 新增
	 * @param freight
	 * @throws Exception
	 */
	public void saveFreight(Freight freight) throws Exception{
		dao.save("freightMapper.saveFreight", freight);
		if(null!=freight.getDetails()&&freight.getDetails().size()>0) {
			saveFreightDetail(freight.getDetails(),freight.getId());
		}
	}
	/**
	 * 新增
	 * @param freightDetails
	 * @throws Exception
	 */
	public void saveFreightDetail(List<FreightDetail> freightDetails,int fid) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", freightDetails);
		map.put("fid", fid);
		dao.save("freightMapper.saveFreightDetail", map);
	}
	/**
	 * 修改
	 * @param freight
	 * @throws Exception
	 */
	public void updateFreight(Freight freight) throws Exception{
		deleteFreoghtDetailByFid(freight.getId()+"");
		if(null!=freight.getDetails()&&freight.getDetails().size()>0) {
			saveFreightDetail(freight.getDetails(),freight.getId());
		}
		dao.update("freightMapper.updateFreight", freight);
	}

	private void deleteFreoghtDetailByFid(String fid) throws Exception{
		dao.delete("freightMapper.deleteFreoghtDetailByFid", fid);
	}
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFreight(String id) throws Exception{
		deleteFreoghtDetailByFid(id);
		dao.delete("freightMapper.deleteFreight", id);
	}
	
}
