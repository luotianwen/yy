package com.shifeng.seller.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductProperty;
import com.shifeng.seller.product.dto.ProductPropertyDTO;
import com.shifeng.seller.product.service.ProductPropertyService;

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
	public List<ProductProperty> findAllProductProperty(String id) throws Exception{
		return (List<ProductProperty>) dao.findForList("productpropertyMapper.findAllProductProperty", id);
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
	public void saveProductProperty(List<ProductPropertyDTO> productproperty,String userName,int pid,int cid) throws Exception{
		if(productproperty!=null){
			List<ProductPropertyDTO> list = new ArrayList<ProductPropertyDTO>();
			for(int i=0,len=productproperty.size();i<len;i++){
				ProductPropertyDTO dto = productproperty.get(i);
				dto.setPropertyValue(dto.getPropertyValue());
				if(!StringUtils.isEmpty(dto.getPropertyValue())){
					dto.setPropertyValues(dto.getPropertyValue().split(","));
					dto.setProductId(pid);
					dto.setCategoryId(cid);
					list.add(dto);
				}
			}
			
			if(list.size()>0){
				dao.save("productpropertyMapper.saveProductProperty", list);
			}
		}
	}
	
	/**
	 * 修改
	 * @param productproperty
	 * @throws Exception
	 */
	public void updateProductProperty(List<ProductPropertyDTO> productproperty,String userName,int pid,int cid) throws Exception{
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
