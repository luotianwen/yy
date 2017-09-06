package com.shifeng.service.oldmall.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.SQLServerDao;
import com.shifeng.entity.ProductImgs;
import com.shifeng.entity.mall.Product;
import com.shifeng.entity.oldmall.OldProduct;
import com.shifeng.plugin.page.Page;
import com.shifeng.service.oldmall.OldProductService;

/**
 * 
 * @author WinZhong
 *
 */
@Service("oldProductServiceImpl")
public class OldProductServiceImpl implements OldProductService{

	@Resource(name = "SQLServerDaoImpl")
	private SQLServerDao dao;
	
	/**
	 * 根据sku查找商品
	 * @param sku
	 * @return
	 * @throws Exception
	 */
	public Product findBysku(String sku)throws Exception {
		System.out.println("*****"+sku);
		return (Product)dao.findForObject("oldProductMapper.findBysku", sku);
	}
	

	
	/**
	 * 获取商品
	 * @return
	 */
	 public List<OldProduct> getProduct(Page page) {
		 try {
			List<OldProduct> productList =  (List<OldProduct>)dao.findForList("oldProductMapper.getProductPage", page);
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
	}
	 

		
		/**
		 * 获取商品图片
		 * @return
		 */
		 public List<ProductImgs> getProductImages(Page page) {
			 try {
					List<ProductImgs> productList =  (List<ProductImgs>)dao.findForList("oldProductMapper.getProductImagesPage", page);
					return productList;
				} catch (Exception e) {
					e.printStackTrace();
				}
				 return null;
		}
	
}
