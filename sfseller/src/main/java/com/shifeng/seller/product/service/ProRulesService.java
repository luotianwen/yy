package com.shifeng.seller.product.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.product.ProRules;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.product.dto.ProRulesDTO;
import com.shifeng.seller.product.dto.SkuImagesDTO;

/** 
 * SKU表(p_pro_rules)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
public interface ProRulesService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProRules> findAllProRules(Page page) throws Exception;
	
	/**
	 * 根据产品ID查询所有
	 * @param id 产品ID
	 * @return
	 * @throws Exception
	 */
	public List<ProRules> findAllProRulesByPid(String id) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ProRules findProRulesById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param prorules
	 * @throws Exception
	 */
	public void updateProRules(List<ProRulesDTO> prorules,List<SkuImagesDTO> skuimages,String userName,int pid) throws Exception;
	
	/**
	 * 修改库存
	 * @param sku
	 * @param stocks 库存
	 * @param user
	 * @throws Exception
	 */
	public void updateProRulesStocks(String sku,String stocks,Users user,Map<String,Object> map) throws Exception;
	
	/**
	 * 新增
	 * @param prorules sku集合
	 * @param userId 用户ID
	 * @param pid 商品ID
	 * @throws Exception
	 */
	public void saveProRules(List<ProRulesDTO> prorules,List<SkuImagesDTO> skuimages,String userName,int pid) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProRules(String id) throws Exception;
	
}
