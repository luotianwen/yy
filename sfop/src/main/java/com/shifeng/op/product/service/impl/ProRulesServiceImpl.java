package com.shifeng.op.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProRules;
import com.shifeng.op.dto.coupons.ProductDTO;
import com.shifeng.op.product.service.ProRulesService;
import com.shifeng.plugin.page.Page;

/** 
 * SKU表(p_pro_rules)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
@Service("prorulesServiceImpl")
public class ProRulesServiceImpl implements ProRulesService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProRules> findAllProRules(Page page) throws Exception{
		return (List<ProRules>) dao.findForList("prorulesMapper.findAllProRulesPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ProRules findProRulesById(String id) throws Exception{
		return (ProRules) dao.findForObject("prorulesMapper.findProRulesById", id);
	}
	
	/**
	 * 新增
	 * @param prorules
	 * @throws Exception
	 */
	public void saveProRules(ProRules prorules) throws Exception{
		dao.save("prorulesMapper.saveProRules", prorules);
	}
	
	/**
	 * 修改
	 * @param prorules
	 * @throws Exception
	 */
	public void updateProRules(ProRules prorules) throws Exception{
		dao.update("prorulesMapper.updateProRules", prorules);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProRules(String id) throws Exception{
		dao.delete("prorulesMapper.deleteProRules", id);
	}
	
	/**
	 * 优惠券使用范围(指定参加/不参加商品)
	 * @param page
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public List<ProductDTO> findProductForCoupons(Page page) throws Exception{
		return (List<ProductDTO>) dao.findForList("prorulesMapper.findProductForCouponsPage", page);
	}
	
}
