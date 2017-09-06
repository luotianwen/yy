package com.shifeng.op.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductProperty;
import com.shifeng.op.product.service.ProductPropertyService;
import com.shifeng.plugin.page.Page;

/** 
 * 产品属性表(p_product_property)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
@Service("productpropertyServiceImpl")
public class ProductPropertyServiceImpl implements ProductPropertyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductProperty> findAllProductProperty(Page page) throws Exception{
		return (List<ProductProperty>) dao.findForList("productpropertyMapper.findAllProductPropertyPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ProductProperty findProductPropertyById(String id) throws Exception{
		return (ProductProperty) dao.findForObject("productpropertyMapper.findProductPropertyById", id);
	}
	
	/**
	 * 新增
	 * @param productproperty
	 * @throws Exception
	 */
	public void saveProductProperty(ProductProperty productproperty) throws Exception{
		dao.save("productpropertyMapper.saveProductProperty", productproperty);
	}
	
	/**
	 * 修改
	 * @param productproperty
	 * @throws Exception
	 */
	public void updateProductProperty(ProductProperty productproperty) throws Exception{
		dao.update("productpropertyMapper.updateProductProperty", productproperty);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductProperty(String id) throws Exception{
		dao.delete("productpropertyMapper.deleteProductProperty", id);
	}
	
}
