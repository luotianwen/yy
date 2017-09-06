package com.shifeng.seller.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Color;
import com.shifeng.entity.product.ProRules;
import com.shifeng.entity.product.Spec;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.product.dto.ProRulesDTO;
import com.shifeng.seller.product.dto.SkuImagesDTO;
import com.shifeng.seller.product.service.ProRulesService;
import com.shifeng.seller.product.service.SkuImagesService;
import com.shifeng.util.Const;

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
	 * SKU图片
	 */
	@Resource(name="skuimagesServiceImpl")
	private SkuImagesService skuimagesServiceImpl;
	
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
	 * 根据产品ID查询所有
	 * @param id 产品ID
	 * @return
	 * @throws Exception
	 */
	public List<ProRules> findAllProRulesByPid(String id) throws Exception{
		return (List<ProRules>) dao.findForList("prorulesMapper.findAllProRulesByPid", id);
	}
	
	/**
	 * 根据ID查询
	 */
	public ProRules findProRulesById(String id) throws Exception{
		return (ProRules) dao.findForObject("prorulesMapper.findProRulesById", id);
	}
	
	/**
	 * 新增
	 * @param prorules sku集合
	 * @param userId 用户ID
	 * @param pid 商品ID
	 * @throws Exception
	 */
	public void saveProRules(List<ProRulesDTO> prorules,List<SkuImagesDTO> skuimages,String userName,int pid) throws Exception{
		if(prorules!=null){
			Map<Integer,Integer> mcolor = new HashMap<Integer,Integer>();
			Map<String,String> mspec = new HashMap<String,String>();
			for(int i=0,len=prorules.size();i<len;i++){
				ProRulesDTO pro = prorules.get(i);
				
				//新增sku颜色
				if(pro.getCategorycolorid()!=null){
					if(mcolor.get(pro.getCategorycolorid())==null){
						Color color = new Color();
						color.setPid(pid);
						color.setName(pro.getColorname());
						color.setCategorycolorid(pro.getCategorycolorid());
						dao.save("colorMapper.saveColor", color);
						pro.setColorid(color.getId());
						
						mcolor.put(pro.getCategorycolorid(), color.getId());
					}else{
						pro.setColorid(mcolor.get(pro.getCategorycolorid()));
					}
				}
				
				//新增sku规格
				if(!StringUtils.isEmpty(pro.getSpecname())){
					if(StringUtils.isEmpty(mspec.get(pro.getSpecname()))){
						Spec spec = new Spec();
						spec.setPid(pid);
						spec.setName(pro.getSpecname());
						spec.setCategoryspecid(pro.getCategoryspecid());
						dao.save("specMapper.saveSpec", spec);
						pro.setSpecid(spec.getId());
						
						mspec.put(pro.getSpecname(), spec.getId()+"");
					}else{
						pro.setSpecid(Integer.valueOf(mspec.get(pro.getSpecname())));
					}
				}
				
				pro.setUpdatename(userName);
				pro.setPid(pid);
			}
			dao.save("prorulesMapper.saveProRules", prorules);
			
			//新增SKU图片
			skuimagesServiceImpl.saveSkuImages(skuimages, userName, pid, mcolor);
		}
	}
	
	/**
	 * 修改
	 * @param prorules
	 * @throws Exception
	 */
	public void updateProRules(List<ProRulesDTO> prorules,List<SkuImagesDTO> skuimages,String userName,int pid) throws Exception{
		if(prorules!=null){
			String id = "";
			
			//删除所有sku颜色
			dao.delete("colorMapper.deleteColor", pid+"");
			//删除所有sku规格
			dao.delete("specMapper.deleteSpec", pid+"");
			
			Map<Integer,Integer> mcolor = new HashMap<Integer,Integer>();
			Map<String,String> mspec = new HashMap<String,String>();
			for(int i=0,len=prorules.size();i<len;i++){
				ProRulesDTO pro = prorules.get(i);
				if(pro!=null){
					//新增sku颜色
					if(pro.getCategorycolorid()!=null){
						if(mcolor.get(pro.getCategorycolorid())==null){
							Color color = new Color();
							color.setPid(pid);
							color.setName(pro.getColorname());
							color.setCategorycolorid(pro.getCategorycolorid());
							dao.save("colorMapper.saveColor", color);
							pro.setColorid(color.getId());
							
							mcolor.put(pro.getCategorycolorid(), color.getId());
						}else{
							pro.setColorid(mcolor.get(pro.getCategorycolorid()));
						}
					}
					
					//新增sku规格
					if(!StringUtils.isEmpty(pro.getSpecname())){
						if(StringUtils.isEmpty(mspec.get(pro.getSpecname()))){
							Spec spec = new Spec();
							spec.setPid(pid);
							spec.setName(pro.getSpecname());
							spec.setCategoryspecid(pro.getCategoryspecid());
							dao.save("specMapper.saveSpec", spec);
							pro.setSpecid(spec.getId());
							
							mspec.put(pro.getSpecname(), spec.getId()+"");
						}else{
							pro.setSpecid(Integer.valueOf(mspec.get(pro.getSpecname())));
						}
					}
					
					if(pro.getSku()!=null){
						pro.setUpdatename(userName);
						
						dao.update("prorulesMapper.updateProRules", pro);
					}else{
						pro.setUpdatename(userName);
						pro.setPid(pid);
						
						dao.save("prorulesMapper.saveProRule", pro);
					}
					
					if(StringUtils.isEmpty(id)){
						id += pro.getSku();
					}else{
						id += ","+pro.getSku();
					}
				}
			}
			
			if(!StringUtils.isEmpty(id)){
				Map<String,String> map = new HashMap<String,String>();
				map.put("id", id);
				map.put("pid", pid+"");
				dao.delete("prorulesMapper.deleteProRules", map);
			}
			
			//修改SKU图片
			skuimagesServiceImpl.updateSkuImages(skuimages,userName,pid,mcolor);
		}
	}
	
	/**
	 * 修改库存
	 * @param sku
	 * @param stocks 库存
	 * @param user
	 * @throws Exception
	 */
	public void updateProRulesStocks(String sku,String stocks,Users user,Map<String,Object> map) throws Exception{
		map.put("sku", sku.split(","));
		map.put("stocks", stocks.split(","));
		map.put("updatename", user.getuName());
		map.put("shopid", user.getShopid());
		
		dao.update("prorulesMapper.updateProRulesStocks", map);
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProRules(String id) throws Exception{
		dao.delete("prorulesMapper.deleteProRules", id);
	}
	
}
