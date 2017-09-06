package com.shifeng.op.product.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Product;
import com.shifeng.op.dto.product.ProductDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.product.service.ProductService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * 产品表(p_product)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductDTO> findAllProduct(Page page) throws Exception{
		return (List<ProductDTO>) dao.findForList("productMapper.findAllProductPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Product findProductById(String id) throws Exception{
		return (Product) dao.findForObject("productMapper.findProductById", id);
	}
	
	/**
	 * 新增
	 * @param product
	 * @throws Exception
	 */
	public void saveProduct(Product product) throws Exception{
		dao.save("productMapper.saveProduct", product);
	}
	
	/**
	 * 修改
	 * @param product
	 * @throws Exception
	 */
	public void updateProduct(Product product) throws Exception{
		RedisTool.set(String.format(Const.PRODUCT_CACHE_FLAG,product.getId()),"0");
		dao.update("productMapper.updateProduct", product);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProduct(String id) throws Exception{
		dao.delete("productMapper.deleteProduct", id);
	}

    @Override
    public void updateDownProduct(int[] id, Users user) throws Exception {
		for (int i:id){
			RedisTool.set(String.format(Const.PRODUCT_CACHE_FLAG,i),"0");
		}
        Map map=new HashMap<>();
        map.put("state","2");
        map.put("ids",id);
        map.put("updatename",user.getuName());
        dao.update("productMapper.updateProductState",map);
    }
    @Override
    public void updateUpProduct(int[] id, Users user) throws Exception {
		for (int i:id){
			RedisTool.set(String.format(Const.PRODUCT_CACHE_FLAG,i),"0");
		}
        Map map=new HashMap<>();
        map.put("state","1");
        map.put("ids",id);
        map.put("updatename",user.getuName());
        dao.update("productMapper.updateProductState",map);
    }
    @Override
    public void updateDeleteProduct(int[] id, Users user) throws Exception {
		for (int i:id){
			RedisTool.set(String.format(Const.PRODUCT_CACHE_FLAG,i),"0");
		}
        Map map=new HashMap<>();
        map.put("state","3");
        map.put("ids",id);
        map.put("updatename",user.getuName());
        dao.update("productMapper.updateProductState",map);
    }
    @Override
    public void updateRecoveryProduct(int[] id, Users user) throws Exception {
		for (int i:id){
			RedisTool.set(String.format(Const.PRODUCT_CACHE_FLAG,i),"0");
		}
        Map map=new HashMap<>();
        map.put("state","2");
        map.put("ids",id);
        map.put("updatename",user.getuName());
        dao.update("productMapper.updateProductState",map);
    }
}
