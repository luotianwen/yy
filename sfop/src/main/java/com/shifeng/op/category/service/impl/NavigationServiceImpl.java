package com.shifeng.op.category.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Navigation;
import com.shifeng.op.category.service.NavigationService;
import com.shifeng.plugin.page.Page;

/** 
 * 导航表(p_navigation)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-20 14:37:55 
 */  
@Service("navigationServiceImpl")
public class NavigationServiceImpl implements NavigationService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有品牌
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Navigation> findAllNavigation(Page page) throws Exception{
		return (List<Navigation>) dao.findForList("navigationMapper.findAllNavigation",page);
	}
	
	/**
	 * 根据ID查询品牌
	 */
	public Navigation findNavigationById(String id) throws Exception{
		return (Navigation) dao.findForObject("navigationMapper.findNavigationById", id);
	}
	
	/**
	 * 新增品牌
	 * @param dto
	 * @throws Exception
	 */
	public void saveNavigation(Navigation navigation) throws Exception{
		dao.save("navigationMapper.saveNavigation", navigation);
	}
	
	/**
	 * 修改品牌
	 * @param navigation
	 * @throws Exception
	 */
	public void updateNavigation(Navigation navigation) throws Exception{
		dao.update("navigationMapper.updateNavigation", navigation);
	}
	
	/**
	 * 删除
	 * @param id
	 * @param name
	 * @throws Exception
	 */
	public void deleteNavigation(String id,String name) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("name", name);
		dao.update("navigationMapper.deleteNavigation", map);
	}
	
}
