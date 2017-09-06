package com.shifeng.seller.product.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Images;
import com.shifeng.entity.product.Product;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.product.dto.ProRulesDTO;
import com.shifeng.seller.product.dto.ProductDTO;
import com.shifeng.seller.product.dto.ProductListDTO;
import com.shifeng.seller.product.service.ImagesService;
import com.shifeng.seller.product.service.ProRulesService;
import com.shifeng.seller.product.service.ProductPropertyService;
import com.shifeng.seller.product.service.ProductService;
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
	 * 商品图片
	 */
	@Resource(name="imagesServiceImpl")
	private ImagesService imagesServiceImpl;
	/**
	 * 商品属性
	 */
	@Resource(name="productpropertyServiceImpl")
	private ProductPropertyService productpropertyServiceImpl;
	
	/**
	 * SKU
	 */
	@Resource(name="prorulesServiceImpl")
	private ProRulesService prorulesServiceImpl;
	
	/**
	 * 产品列表
	 */
	public List<ProductListDTO> findAllProduct(Page page) throws Exception{
		return (List<ProductListDTO>) dao.findForList("productMapper.findAllProductPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Product findProductById(String id,String shopId) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("shopId", shopId);
		return (Product) dao.findForObject("productMapper.findProductById", map);
	}
	
	/**
	 * 新增
	 * @param product
	 * @throws Exception
	 */
	public void saveProduct(ProductDTO product,Users user) throws Exception{
		if(product.getImages()!=null){
			for(int i=0,len=product.getImages().size();i<len;i++){
				Images image = product.getImages().get(i);
				if(image!=null){
					product.setLogo(image.getIpath());
					break;
				}
			}
		}
		dao.save("productMapper.saveProduct", product);
		
		//新增商品图片
		imagesServiceImpl.saveImages(product.getImages(),user.getuName(),product.getId());
		//新增商品属性
		productpropertyServiceImpl.saveProductProperty(product.getProductPropertys(),user.getuName(),product.getId(),product.getCid());
		//新增SKU
		prorulesServiceImpl.saveProRules(product.getProrules(),product.getSkuimages(),user.getuName(),product.getId());
		
	}
	
	/**
	 * 修改
	 * @param product
	 * @throws Exception
	 */
	public void updateProduct(ProductDTO product,Users user) throws Exception{
		for(ProRulesDTO p:product.getProrules()) {
			RedisTool.set(String.format(Const.SKU_CACHE_FLAG, p.getSku()), "0");
		}
		product.setUpdatename(user.getuName());
		dao.update("productMapper.updateProduct", product);
		
		//修改商品图片
		imagesServiceImpl.updateImages(product.getImages(),user.getuName(),product.getId());
		//删除商品属性
		productpropertyServiceImpl.deleteProductProperty(product.getId()+"");
		//新增商品属性
		productpropertyServiceImpl.saveProductProperty(product.getProductPropertys(),user.getuName(),product.getId(),product.getCid());
		//修改SKU
		prorulesServiceImpl.updateProRules(product.getProrules(),product.getSkuimages(),user.getuName(),product.getId());
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProduct(String id) throws Exception{
		dao.delete("productMapper.deleteProduct", id);
	}

	/**
	 * 产品上架
	 * @param id 产品ID
	 * @param user
	 * @throws Exception
	 */
	public void updateProductState(String id,Users user,String state) throws Exception{
		RedisTool.set(String.format(Const.PRODUCT_CACHE_FLAG,id),"0");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("state", state);
		map.put("shopid", user.getShopid());
		map.put("username", user.getuName());
		dao.update("productMapper.updateProductState", map);
		
		dao.update("prorulesMapper.updateSkuLasttime", id);
	}
	
}
