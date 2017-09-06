package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.Color;
import com.shifeng.plugin.page.Page;

/** 
 * 颜色表(p_color)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
public interface ColorService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Color> findAllColor(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Color findColorById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param color
	 * @throws Exception
	 */
	public void updateColor(Color color) throws Exception;
	
	/**
	 * 新增
	 * @param color
	 * @throws Exception
	 */
	public void saveColor(Color color) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteColor(String id) throws Exception;
	
}
