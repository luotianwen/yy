package com.shifeng.op.category.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Category;
import com.shifeng.op.category.service.CategoryService;
import com.shifeng.op.dto.category.CategoryDTO;
import com.shifeng.plugin.page.Page;

/** 
 * 分类表(c_category)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-13 11:33:30 
 */  
@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllCategory(Page page) throws Exception{
		return (List<Category>) dao.findForList("categoryMapper.findAllCategoryPage", page);
	}
	
	/**
	 * 查询所有父分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllParentCategory() throws Exception{
		return (List<Category>) dao.findForList("categoryMapper.findAllParentCategory");
	}
	
	/**
	 * 根据父类ID查询
	 */
	public List<Category> findCategoryByPid(String id) throws Exception{
		return (List<Category>) dao.findForList("categoryMapper.findCategoryByPid", id);
	}
	
	/**
	 * 根据ID查询分类
	 */
	public Category findCategoryById(String id) throws Exception{
		return (Category) dao.findForObject("categoryMapper.findCategoryById", id);
	}
	
	/**
	 * 新增分类
	 * @param dto
	 * @throws Exception
	 */
	public void saveCategory(Category category) throws Exception{
		Category parent = findCategoryById(category.getParentid()+"");
		if(parent!=null){
			category.setParentname(parent.getDescript());
		}
		
		dao.save("categoryMapper.saveCategory", category);
	}
	
	/**
	 * 修改分类
	 * @param category
	 * @throws Exception
	 */
	public void updateCategory(Category category) throws Exception{
		dao.update("categoryMapper.updateCategory", category);
	}
	
	/**
	 * 删除分类
	 * @param id
	 * @param tp
	 * @param map
	 * @throws Exception
	 */
	public void deleteCategory(String id,String uname) throws Exception{
		// 判断该菜单是否绑定角色
//		int roleNum = (int) dao.findForObject("authorizationMapper.checkMenusForRoleByMid", mId);
//		if(roleNum > 0){
//			map.put(Const.ERROR_INFO, "该菜单已经关联了角色，请前往[组织管理菜单]解除角色的菜单关联，再进行删除菜单操作!");
//			return;
//		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("uname", uname);
		dao.delete("categoryMapper.deleteCategory", map);
	}
	
	/**
	 * 查询所有分类
	 * @return
	 * @throws Exception
	 */
	public List<CategoryDTO> findAllCategoryForNavigation(String id) throws Exception{
		//查询所有分类
		List<CategoryDTO> category = (List<CategoryDTO>) dao.findForList("categoryMapper.findAllCategoryForNavigation");
		//查询该导航已关联分类
		List<String> navigationCategory = (List<String>) dao.findForList("navigationcategoryMapper.findCIdByNid", id);
		
		if(category!=null){
			Collections.reverse(category);
			
			for(int i=0,len=category.size();i<len;i++){
				CategoryDTO categoryDTO = category.get(i);
				for(int j=0,jlen=navigationCategory.size();j<jlen;j++){
					if((categoryDTO.getId()+"").equals(navigationCategory.get(j))){
						categoryDTO.setChecked(true);
					}
				}
				if(category.get(i).getNodes()!=null){
					Collections.reverse(category.get(i).getNodes());
					for(int k=0,klen=category.get(i).getNodes().size();k<klen;k++){
						CategoryDTO kcategoryDTO = category.get(i).getNodes().get(k);
						for(int j=0,jlen=navigationCategory.size();j<jlen;j++){
							if((kcategoryDTO.getId()+"").equals(navigationCategory.get(j))){
								kcategoryDTO.setChecked(true);
							}
						}
					}
				}
			}
		}
		
		return category;
	}

	@Override
	public List<CategoryDTO> findAllCategoryState() throws Exception {
		return (List<CategoryDTO>) dao.findForList("categoryMapper.findAllCategoryForNavigation");
	}

}
