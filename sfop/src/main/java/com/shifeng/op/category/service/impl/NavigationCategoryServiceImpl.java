package com.shifeng.op.category.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.NavigationCategory;
import com.shifeng.op.category.service.NavigationCategoryService;
import com.shifeng.op.dto.category.NavigationCategoryDTO;
import com.shifeng.plugin.page.Page;

/** 
 * 分类导航关联表(p_navigation_category)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 14:37:55 
 */  
@Service("navigationcategoryServiceImpl")
public class NavigationCategoryServiceImpl implements NavigationCategoryService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有导航分类
	 * @return
	 * @throws Exception
	 */
	public List<NavigationCategoryDTO> findAllNavigationCategoryByNid(String id) throws Exception{
		return (List<NavigationCategoryDTO>) dao.findForList("navigationcategoryMapper.findAllNavigationCategoryByNid", id);
	}
	
	/**
	 * 根据父分类查询所有子分类
	 * @return
	 * @throws Exception
	 */
	public List<NavigationCategoryDTO> findAllNavigationCategoryByPid(String id,String nid) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("nid", nid);
		return (List<NavigationCategoryDTO>) dao.findForList("navigationcategoryMapper.findAllNavigationCategoryByPid", map);
	}
	
	/**
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<NavigationCategory> findAllNavigationCategory(Page page) throws Exception{
		return (List<NavigationCategory>) dao.findForList("navigationcategoryMapper.findAllNavigationCategoryPage", page);
	}
	
	/**
	 * 根据ID查询品牌
	 */
	public NavigationCategory findNavigationCategoryById(String id) throws Exception{
		return (NavigationCategory) dao.findForObject("navigationcategoryMapper.findNavigationCategoryById", id);
	}
	
	/**
	 * 新增品牌
	 * @param dto
	 * @throws Exception
	 */
	public void saveNavigationCategory(String id,String ids,String uName) throws Exception{
		//删除旧关联分类
		//dao.delete("navigationcategoryMapper.deleteNavigationCategoryByNid", id);
		
		//查询所有关联分类
		List<NavigationCategory> ncs = (List<NavigationCategory>) dao.findForList("navigationcategoryMapper.findAllNavigationCategoryListByNid", id);
		
		String[] cid = ids.split(",");
		String cids = "";
		for(int i=0,len=cid.length;i<len;i++){
			boolean bool = true;
			for (NavigationCategory nc : ncs) {
				if((nc.getCid()+"").equals(cid[i])){
					bool = false;
				}
			}
			if(bool){
				if(StringUtils.isEmpty(cids)){
					cids = cid[i];
				}else{
					cids += ","+cid[i];
				}
			}
		}
		
		for (NavigationCategory nc : ncs) {
			boolean bool = true;
			for(int i=0,len=cid.length;i<len;i++){
				if((nc.getCid()+"").equals(cid[i])){
					bool = false;
				}
			}
			if(bool){
				dao.delete("navigationcategoryMapper.deleteNavigationcategoryByCid", nc.getCid()+"");
			}
		}
		
		if(!StringUtils.isEmpty(cids)){
			//新增关联分类
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", id);
			map.put("ids", cids.split(","));
			map.put("uName", uName);
			dao.save("navigationcategoryMapper.saveNavigationCategory", map);
		}
	}
	
	/**
	 * 修改品牌
	 * @param navigationcategory
	 * @throws Exception
	 */
	public void updateNavigationCategory(NavigationCategory navigationcategory) throws Exception{
		dao.update("navigationcategoryMapper.updateNavigationCategory", navigationcategory);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteNavigationcategory(String id) throws Exception{
		NavigationCategory navigationCategory = (NavigationCategory) dao.findForObject("navigationcategoryMapper.findNavigationCategoryById", id);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("cid", navigationCategory.getCid()+"");
		dao.delete("navigationcategoryMapper.deleteNavigationcategory", map);
	}
	
}
