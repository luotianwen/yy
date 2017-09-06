package com.shifeng.op.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.PorderInfo;
import com.shifeng.op.order.service.PorderInfoService;
import com.shifeng.plugin.page.Page;

/** 
 * 订单父表(o_porderInfo)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
@Service("porderInfoServiceImpl")
public class PorderInfoServiceImpl implements PorderInfoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PorderInfo> findAllPorderInfo(Page page) throws Exception{
		return (List<PorderInfo>) dao.findForList("porderInfoMapper.findAllPorderInfoPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public PorderInfo findPorderInfoById(String id) throws Exception{
		return (PorderInfo) dao.findForObject("porderInfoMapper.findPorderInfoById", id);
	}
	
	/**
	 * 新增
	 * @param porderInfo
	 * @throws Exception
	 */
	public void savePorderInfo(PorderInfo porderInfo) throws Exception{
		dao.save("porderInfoMapper.savePorderInfo", porderInfo);
	}
	
	/**
	 * 修改
	 * @param porderInfo
	 * @throws Exception
	 */
	public void updatePorderInfo(PorderInfo porderInfo) throws Exception{
		dao.update("porderInfoMapper.updatePorderInfo", porderInfo);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePorderInfo(String id) throws Exception{
		dao.delete("porderInfoMapper.deletePorderInfo", id);
	}
	
}
