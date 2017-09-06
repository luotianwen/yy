package com.shifeng.seller.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Color;
import com.shifeng.seller.product.service.ColorService;

/** 
 * 颜色表(p_color)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
@Service("colorServiceImpl")
public class ColorServiceImpl implements ColorService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Color> findAllColor(String id) throws Exception{
		return (List<Color>) dao.findForList("colorMapper.findAllColor", id);
	}
	
	/**
	 * 根据ID查询
	 */
	public Color findColorById(String id) throws Exception{
		return (Color) dao.findForObject("colorMapper.findColorById", id);
	}
	
	/**
	 * 新增
	 * @param color
	 * @throws Exception
	 */
	public void saveColor(Color color) throws Exception{
		dao.save("colorMapper.saveColor", color);
	}
	
	/**
	 * 修改
	 * @param color
	 * @throws Exception
	 */
	public void updateColor(Color color) throws Exception{
		dao.update("colorMapper.updateColor", color);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteColor(String id) throws Exception{
		dao.delete("colorMapper.deleteColor", id);
	}
	
}
