package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallSpecialSale;
import com.shifeng.op.mall.service.MallSpecialSaleService;
import com.shifeng.plugin.page.Page;

/** 
 * 特卖(mall_special_sale)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:47 
 */  
@Service("mallspecialsaleServiceImpl")
public class MallSpecialSaleServiceImpl implements MallSpecialSaleService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallSpecialSale> findAllMallSpecialSale(Page page) throws Exception{
		return (List<MallSpecialSale>) dao.findForList("mallspecialsaleMapper.findAllMallSpecialSalePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallSpecialSale findMallSpecialSaleById(String id) throws Exception{
		return (MallSpecialSale) dao.findForObject("mallspecialsaleMapper.findMallSpecialSaleById", id);
	}
	
	/**
	 * 新增
	 * @param mallspecialsale
	 * @throws Exception
	 */
	public void saveMallSpecialSale(MallSpecialSale mallspecialsale) throws Exception{
		dao.save("mallspecialsaleMapper.saveMallSpecialSale", mallspecialsale);
	}
	
	/**
	 * 修改
	 * @param mallspecialsale
	 * @throws Exception
	 */
	public void updateMallSpecialSale(MallSpecialSale mallspecialsale) throws Exception{
		dao.update("mallspecialsaleMapper.updateMallSpecialSale", mallspecialsale);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallSpecialSale(String id) throws Exception{
		dao.delete("mallspecialsaleMapper.deleteMallSpecialSale", id);
	}
	
}
